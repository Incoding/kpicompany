package com.kpicompany.report.daoImp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpicompany.report.daoImp.dao.KpiDao;
import com.kpicompany.report.domain.KpiDomain;

@Repository
public class KpiDaoImp implements KpiDao {
@Autowired
private SqlSessionTemplate template;
	@Override
	public List<KpiDomain> getAllKpi(){
		List<KpiDomain> kpiDomain = template.selectList("report.kpi.selectAllKpi");
		return kpiDomain;
	}
	public int insertKpi(KpiDomain kpiDomain) {
		 int insert = template.insert("report.kpi.insertOne",kpiDomain);
		return insert;
	}
	public KpiDomain selectOneKpi(KpiDomain kpiDomain) {
		kpiDomain = template.selectOne("report.kpi.selectOne",kpiDomain);
		return kpiDomain;
	}
}
