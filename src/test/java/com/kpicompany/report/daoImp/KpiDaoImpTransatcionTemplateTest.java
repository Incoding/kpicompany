package com.kpicompany.report.daoImp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.kpicompany.report.daoImp.dao.KpiDao;
import com.kpicompany.report.domain.KpiDomain;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class KpiDaoImpTransatcionTemplateTest {
	@Autowired
	private KpiDao kpi;
	@Autowired
	private TransactionTemplate transactionTemplate;
	@Test
	public void testSelectAll() {
		List<KpiDomain> allKpi = kpi.getAllKpi();
		for (KpiDomain kpiDomain : allKpi) {
			String kpiCode = kpiDomain.getKpi();
			Map<String,String> root = new HashMap<>();
			long parseInt = Long.parseLong(kpiCode);
			if(0 < parseInt && parseInt <10) {
				root.put(kpiCode, kpiCode);
			}
			System.out.println(kpiDomain);
		}
	}
	@Test
	public void testInsertOne() {
		final KpiDomain kpiDomain = new KpiDomain();
		kpiDomain.setName("nihao");
		kpiDomain.setKpi("2.9");
		int insertKpi = kpi.insertKpi(kpiDomain);
		Assert.assertEquals(1, insertKpi);
	}
	/**
	 * 验证事务是否生效
	 */
	@Test
	public <T> void testTransaction() {
		final KpiDomain kpiDomain = new KpiDomain();
		kpiDomain.setName("nihao");
		transactionTemplate.execute(new TransactionCallback<Integer>() {
			@Override
			public Integer doInTransaction(TransactionStatus status) {
				int insertKpi = kpi.insertKpi(kpiDomain);
				Assert.assertEquals(1, insertKpi);
				KpiDomain selectOneKpi = kpi.selectOneKpi(kpiDomain);
				Assert.assertEquals(1, selectOneKpi == null ? 0:1);
				status.setRollbackOnly();
				return 0;
			}
		});
		KpiDomain selectOneKpi = kpi.selectOneKpi(kpiDomain);
		Assert.assertEquals(null, selectOneKpi);
	}
}