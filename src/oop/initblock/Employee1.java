package oop.initblock;

public class Employee1 {
    int id;
    String name = "Unknown";
    long year = 1901;
    long salary = 500;
    boolean vacation = false; // never, if I'm a BOSS :)

    {
        if (year == 1900)
            salary = -100;
        else {
            salary = 100;
        }
    }

    public Employee1(int i, long y, String n) {
        this.id = id;
        this.year = year;
        this.name = name;
    }


}
