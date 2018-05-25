package com.kpicompany.report.controller.param.nest;

/**
 * Created by user on 2018/5/25
 */
public class FlightSearchRouter {
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
        final StringBuilder sb = new StringBuilder("FlightSearchRouter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", innerName='").append(innerName).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
