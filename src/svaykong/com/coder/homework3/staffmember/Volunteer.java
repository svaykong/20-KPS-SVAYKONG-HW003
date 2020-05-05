package svaykong.com.coder.homework3.staffmember;

public class Volunteer extends StaffMember {

    public Volunteer() {
        super();
    }

    public Volunteer(String name, String address) {
        super(name, address);
    }

    @Override
    public Double pay() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Volunteer vol) {
//        int compare = name.compareTo(vol.name);
//        if(compare == 0) {
//            compare = Integer.compare(id, vol.id);
//        }
//        return compare;
//    }
}
