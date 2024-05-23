package org.example;

public class Task {
    private int num;
    private int id;
    private double pi;
    private double percent;
    public Task(int num, int id) {
        pi = 0;
        percent = 0;
        this.num = num;
        this.id = id;
    }
    public double getPercent() {
        return percent;
    }
    public void setPercent(double percent) {
        this.percent = percent;
    }
    public double getPi() {
        return pi;
    }
    public void setPi(double pi) {
        this.pi = pi;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    public void Leibniz(int n) {
        pi += (4 * ((Math.pow(-1, n-1)) / (2 * n - 1)));
    }
}
