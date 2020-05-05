package svaykong.com.coder.homework3.staffmember;

public class SalariedEmployee extends StaffMember {
    private Double salary;
    private Double bonus;

    public SalariedEmployee() {
        super();
    }

    public SalariedEmployee(String name, String address, Double salary, Double bonus) {
        super(name, address);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public Double pay() {
        if(salary == null || bonus == null) {
            return null;
        }
        else if(salary < 0 || bonus < 0) {
            return 0.0;
        }
        return salary + bonus;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "salary=" + salary +
                ", bonus=" + bonus +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
