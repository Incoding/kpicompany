package com.kpicompany.report.controller;

import com.kpicompany.report.controller.param.multi.FlightSearchMultiFirst;
import com.kpicompany.report.controller.param.multi.FlightSearchMultiSecond;
import com.kpicompany.report.controller.param.nest.FlightSearchOutter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 嵌套请求样例
 */
@Controller
public class ObjectParamController {


    /**
     * 请求样例
     * http://localhost:8080/nestParam?name=nihao&flightSearchInner.innerName=searchInner&flightSearchRouter.innerName=routerInner&flightSearchInner.name=innerName&flightSearchRouter.name=routerName
     * https://blog.csdn.net/eson_15/article/details/51718633
     * @param flightSearchParam
     * @return
     */
    @RequestMapping("/param/nest")
    @ResponseBody
    public FlightSearchOutter nestParam(FlightSearchOutter flightSearchParam) {
        System.out.println("name = " + flightSearchParam);
        return flightSearchParam;
    }


    /**
     * 俩个参数中 如果有相同的参数名字,是会都设置的
     * http://localhost:8080/param/multi?second=secondName&first=firstName&name=nihao2
     * @param flightSearchMultiFirst
     * @param flightSearchMultiSecond
     * @return
     */
    @RequestMapping("/param/multi")
    @ResponseBody
    public Map manyObject(FlightSearchMultiFirst flightSearchMultiFirst,FlightSearchMultiSecond flightSearchMultiSecond) {
        Map<Object, Object> map = new HashMap<>();
        map.put("first", flightSearchMultiFirst);
        map.put("second", flightSearchMultiSecond);
        return map;
    }

}
