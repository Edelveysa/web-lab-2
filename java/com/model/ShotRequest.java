package com.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ShotRequest {

    private final double x;
    private final double y;
    private final double r;

    private ShotRequest(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public static ShotRequest fromHttpRequest(HttpServletRequest request) {
        String x_s = request.getParameter("x");
        String y_s = request.getParameter("y");
        String r_s = request.getParameter("r");
        try {
            double x = Double.parseDouble(x_s);
            double y = Double.parseDouble(y_s);
            double r = Double.parseDouble(r_s);
            return new ShotRequest(x, y, r);
        } catch (Exception ex) {
            return null;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "ShotRequest{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }
}