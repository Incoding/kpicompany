package com.kpicompany.report.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kpicompany.report.serviceImp.service.KpiService;
import com.kpicompany.report.vo.KpiDomainVo;

@Controller
public class ReportController {
//    @Autowired
//    @Qualifier("kpiReportServiceImp")
//    private KpiService kpiService;

    @RequestMapping("velocity")
    public String reportVelocity(HttpServletRequest request) {
        request.setAttribute("nihao", "hello velocity");
        return "velocity/reportvm";
    }

    @RequestMapping("jsp")
    public String reportJsp(HttpServletRequest request) {
        request.setAttribute("nihao", "hello jsp");
        return "jsp/reportjsp";
    }

    @RequestMapping("jstl")
    public String reportJstl(HttpServletRequest request) {
        request.setAttribute("nihao", "hello jstl");
        return "jsp/reportjstl";
    }

    @RequestMapping("freemarker")
    public String reportFreeMarker(HttpServletRequest request) {
        request.setAttribute("nihao", "hello freemarker");
        return "freemarker/reportftl";
    }

    @RequestMapping(value = "{fruitName}", method = RequestMethod.GET)
    public String getFruit(@PathVariable String fruitName, ModelMap model) {
        KpiDomainVo kpiDomainVo = new KpiDomainVo(22.0, "2.9", fruitName);
        model.addAttribute("model", kpiDomainVo);
        return "list";
    }
}
