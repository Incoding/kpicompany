package com.kpicompany.report.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fruit")
public class KpiDomain {
    private Double id;
    private String kpi;
    private String name;

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
