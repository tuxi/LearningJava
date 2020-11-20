public class AbstractDemo {

    AbstractDemo() {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

        System.out.println("Call mailCheck using Salary refernce --");
        s.mailCheck();

        System.out.println("\n Call mailCheck using Employee reference--");
    }
}

class Employee {
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("Employee 构造函数");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public void mailCheck() {
        System.out.println("邮寄支票给： " + this.name
                + " " + this.address);
    }
    public String toString() {
        return name + " " + address + " " + number;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }
}

class Salary extends Employee {

    private double salary;
    public Salary(String name, String address, int number, double v) {
        super(name, address, number);
    }

    public void mailCheck() {
        System.out.println("Within mailCheck of Salary class");
        System.out.println("Mailling check to " + getName() + " with salary " + salary);
    }

    double getSalary() {
        return salary;
    }

    void  setSalary(double salary) {
        if (salary >= 0.0) {
            this.salary = salary;
        }
    }

    double computePay() {
        System.out.println("Computing salary pay for " + getName());
        return salary / 52;
    }
}

abstract class Emlpyee {
    private String name;
    private String address;
    private int number;
    abstract double computePay();
}

class Salary1 extends Emlpyee {

    @Override
    double computePay() {
        return 0;
    }
}
