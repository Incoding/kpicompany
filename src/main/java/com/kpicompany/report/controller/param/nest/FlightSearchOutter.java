package com.kpicompany.report.controller.param.nest;

/**
 * Created by user on 2018/5/25
 */
public class FlightSearchOutter {

    private String name;

    private FlightSearchInner flightSearchInner;

    private FlightSearchRouter flightSearchRouter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlightSearchInner getFlightSearchInner() {
        return flightSearchInner;
    }

    public void setFlightSearchInner(FlightSearchInner flightSearchInner) {
        this.flightSearchInner = flightSearchInner;
    }

    public FlightSearchRouter getFlightSearchRouter() {
        return flightSearchRouter;
    }

    public void setFlightSearchRouter(FlightSearchRouter flightSearchRouter) {
        this.flightSearchRouter = flightSearchRouter;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlightSearchOutter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", flightSearchInner=").append(flightSearchInner);
        sb.append(", flightSearchRouter=").append(flightSearchRouter);
        sb.append('}');
        return sb.toString();
    }
}
