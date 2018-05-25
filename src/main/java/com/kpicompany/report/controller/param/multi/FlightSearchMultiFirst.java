package com.kpicompany.report.controller.param.multi;

/**
 * Created by user on 2018/5/25
 */
public class FlightSearchMultiFirst {
    private String name;
    private String first;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightSearchMultiFirst{");
        sb.append("name='").append(name).append('\'');
        sb.append(", first='").append(first).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
