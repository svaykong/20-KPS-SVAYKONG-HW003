package svaykong.com.coder.homework3.staffmember;

public class HourlyEmployee extends StaffMember {
    private Integer hoursWorked;
    private Double rate;

    public HourlyEmployee(){
        super();
    }

    public HourlyEmployee(String name, String address, Integer hoursWorked, Double rate) {
        super(name, address);
        this.hoursWorked = hoursWorked;
        this.rate = rate;
    }

    @Override
    public Double pay() {
        if(hoursWorked == null || rate == null) {
            return  null;
        }
        else if(hoursWorked < 0 || rate < 0) {
            return 0.0;
        }
        return hoursWorked * rate;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hoursWorked=" + hoursWorked +
                ", rate=" + rate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
