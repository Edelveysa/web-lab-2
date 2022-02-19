package com.model;

public class Shot {
    private final double x;
    private final double y;
    private final double r;
    private final boolean isHit;

    public Shot(double x, double y, double r, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = hit;
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

    public boolean getIsHit() {
        return isHit;
    }

    @Override
    public String toString() {
        return "Shot{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", isHit=" + isHit +
                '}';
    }
}