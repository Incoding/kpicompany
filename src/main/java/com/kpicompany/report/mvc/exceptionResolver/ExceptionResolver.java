package com.kpicompany.report.mvc.exceptionResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.kpicompany.report.mvc.httpresult.HttpError;
import com.kpicompany.report.mvc.httpresult.HttpResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;

/**
 * 处理json 500
 */

public class ExceptionResolver extends SimpleMappingExceptionResolver {
    private Charset charset = Charset.forName("UTF-8");
    private SerializerFeature[] features;

    public ExceptionResolver() {
        this.features = new SerializerFeature[]{SerializerFeature.WriteClassName};
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String viewName = this.determineViewName(ex, request);
        if (null == viewName) {
            return null;
        } else {
            Integer statusCode = this.determineStatusCode(request, viewName);
            return statusCode != null ? this.resolveStatusMessage(request, response, statusCode, HttpResult.error(HttpError.SYS_ERR)) : this.getModelAndView(viewName, ex, request);
        }
    }

    private ModelAndView resolveStatusMessage(HttpServletRequest request, HttpServletResponse response, Integer statusCode, HttpResult statusMessage) {
        if (null == statusMessage) {
            return null;
        } else {
            this.applyStatusCodeIfPossible(request, response, statusCode);
            FastJsonJsonView fastJsonJsonView = new FastJsonJsonView();
            fastJsonJsonView.setExtractValueFromSingleKeyModel(true);
            fastJsonJsonView.setCharset(this.getCharset());
            fastJsonJsonView.setFeatures(this.getFeatures());
            return (new ModelAndView(fastJsonJsonView)).addObject(statusMessage);
        }
    }

    public Charset getCharset() {
        return this.charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public SerializerFeature[] getFeatures() {
        return this.features;
    }

    public void setFeatures(SerializerFeature[] features) {
        this.features = features;
    }
}

