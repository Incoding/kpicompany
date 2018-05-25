package com.kpicompany.report.controller.param.multi;

/**
 * Created by user on 2018/5/25
 */
public class FlightSearchMultiSecond {
    private String name;
    private String second;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightSearchMultiSecond{");
        sb.append("name='").append(name).append('\'');
        sb.append(", second='").append(second).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
