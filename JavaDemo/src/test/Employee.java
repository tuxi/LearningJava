package test;

public class Employee {
    // 名称
    String name;
    // 年龄
    int age;
    // 职位
    String designation;
    // 薪水
    double salary;

    // 构造器
    public Employee(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String descripition() {
        return "name:" + name + "，age:" + age + ", designation: " + designation + ", salary: " + salary;
    }
}
