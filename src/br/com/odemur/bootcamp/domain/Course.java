package br.com.odemur.bootcamp.domain;

public class Course extends Content {

    private int hours;

    @Override
    public double calculateXP() {
        return XP_DEFAULT * hours;
    }

    public Course() {
    }


    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", hours=" + hours +
                '}';
    }
}
