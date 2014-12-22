package com.kpicompany.report.vo;


public class KpiDomainVo {
	private Double id;
	private String kpi;
	private String name;
	
	public KpiDomainVo(Double id, String kpi, String name) {
        this.id = id;
        this.kpi = kpi;
        this.name = name;
    }
    public Double getId() {
		return id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
