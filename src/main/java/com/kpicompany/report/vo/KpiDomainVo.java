package com.kpicompany.report.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fruit")
public class KpiDomainVo {
	private Double id;
	private String kpi;
	private String name;
	
	public KpiDomainVo() {

	}
	public KpiDomainVo(Double id, String kpi, String name) {
        this.id = id;
        this.kpi = kpi;
        this.name = name;
    }
    public Double getId() {
		return id;
	}
    @XmlElement
	public void setId(Double id) {
		this.id = id;
	}
	public String getKpi() {
		return kpi;
	}
	   @XmlElement
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public String getName() {
		return name;
	}
	   @XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
}
