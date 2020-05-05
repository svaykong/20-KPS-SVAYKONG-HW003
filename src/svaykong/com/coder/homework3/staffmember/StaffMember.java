package svaykong.com.coder.homework3.staffmember;

public abstract class StaffMember {
    protected static Integer count = 1;
    protected Integer id;
    protected String name;
    protected String address;

    public StaffMember() {
        this.id = count++;
    }

    public StaffMember(String name, String address) {
        this.id = count++;
        this.name = name;
        this.address = address;
    }

    public abstract Double pay();

    public Integer getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
