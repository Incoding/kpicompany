package com.kpicompany.report.daoImp.dao;

import java.util.List;

import com.kpicompany.report.domain.KpiDomain;

public interface KpiDao {

	public abstract List<KpiDomain> getAllKpi();

	int insertKpi(KpiDomain kpiDomain);

	KpiDomain selectOneKpi(KpiDomain kpiDomain);


}