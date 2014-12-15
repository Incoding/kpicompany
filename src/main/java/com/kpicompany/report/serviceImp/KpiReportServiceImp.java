package com.kpicompany.report.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpicompany.report.daoImp.dao.KpiDao;
import com.kpicompany.report.domain.KpiDomain;
import com.kpicompany.report.serviceImp.service.KpiService;

@Service
public class KpiReportServiceImp implements KpiService {
	@Autowired
	private KpiDao kpiDao;
	@Override
	public List<KpiDomain> getAllKpi(){
		List<KpiDomain> allKpi = kpiDao.getAllKpi();
		return allKpi;
	}
	@Override
	public int insertKpi(KpiDomain kpiDomain){
		int allKpi = kpiDao.insertKpi(kpiDomain);
		return allKpi;
	}
	@Override
	public KpiDomain selectOneKpi(KpiDomain kpiDomain){
		KpiDomain allKpi = kpiDao.selectOneKpi(kpiDomain);
		return allKpi;
	}
}
