package com.kpicompany.report.serviceImp.service;

import java.util.List;

import com.kpicompany.report.domain.KpiDomain;

public interface KpiService {

	public abstract List<KpiDomain> getAllKpi();

	KpiDomain selectOneKpi(KpiDomain kpiDomain);

	int addKpi(KpiDomain kpiDomain);

}