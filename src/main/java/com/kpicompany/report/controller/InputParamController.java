package com.kpicompany.report.controller;

import com.kpicompany.report.controller.param.FlightSearchParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * responsebody  响应
 */
@Controller
public class InputParamController {

    /**
     * 加了 requestbody responsebody 是使用messageconverter 处理读取参数,和输出响应
     * 1 并且请求头要带上 Content-Type: application/json
     * 2 而且参数是放在post的请求体 ,并且是json格式才能解析(不然fastjson会报错)
     *
     * @param flightSearchParam
     * @return
     */
    @RequestMapping("/fly_responsebody_fastjson")
    @ResponseBody
    public FlightSearchParam fly_responsebody_fastjson(@RequestBody FlightSearchParam flightSearchParam) {
        System.out.println("name = " + flightSearchParam.getName());
        System.out.println("date = " + flightSearchParam.getDate());
        return flightSearchParam;
    }

    /**
     * 没加 requestBody   则  请求是kv   可以放在get 参数里也可以放在post里
     */
    @RequestMapping("/fly_viewresolver_jackson")
    @ResponseBody
    public FlightSearchParam flight(FlightSearchParam flightSearchParam) {
        System.out.println("name = " + flightSearchParam.getName());
        System.out.println("date = " + flightSearchParam.getDate());
        return flightSearchParam;
    }

    /**
     * 没加ResponseBody 走 viewResolver
     * 1 如果想通过 ContentNegotiatingViewResolver 根据accept  响应json 则accept 要设置 application/json
     * 2 具体json处理的工具则是通过 ContentNegotiatingViewResolver 配置的
     *
     * @param flightSearchParam
     * @return
     */
    @RequestMapping("/fly_viewresolver")
    public FlightSearchParam flightView(FlightSearchParam flightSearchParam) {
        System.out.println("name = " + flightSearchParam.getName());
        System.out.println("date = " + flightSearchParam.getDate());
        return flightSearchParam;
    }

}
