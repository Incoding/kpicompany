package com.kpicompany.report.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpicompany.report.serviceImp.service.KpiService;

@Controller
public class ReportController {
	@Autowired
	private KpiService kpiService;
	
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
}
