package com.kpicompany.report.controller.param.nest;

/**
 * Created by user on 2018/5/25
 */
public class FlightSearchInner {
    private String name;

    private String innerName;

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightSearchInner{");
        sb.append("name='").append(name).append('\'');
        sb.append(", innerName='").append(innerName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
