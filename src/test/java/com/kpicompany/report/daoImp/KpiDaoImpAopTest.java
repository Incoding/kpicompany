package com.kpicompany.report.daoImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kpicompany.report.domain.KpiDomain;
import com.kpicompany.report.serviceImp.service.KpiService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class KpiDaoImpAopTest {
	@Autowired
	@Qualifier("kpiReportServiceAopImp")
	private KpiService kpi;
	/**
	 * 验证注解事务是否生效
	 */
	@Test
	public void testTransaction() {
		
		final KpiDomain kpiDomain = new KpiDomain();
		kpiDomain.setName("nihao");
		int insertKpi = 0;
		try {
			insertKpi = kpi.insertKpi(kpiDomain);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(0, insertKpi);
	}
}