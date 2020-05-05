package svaykong.com.coder.test;

import java.util.*;

public class Test {

    public static void main(String[] args) {

//        TreeMap<Student,Student> studentTreeMap = new TreeMap<>();
//        TreeMap<Worker,Worker> workerTreeMap = new TreeMap<>();
        TreeMap<Citizen,Citizen> listCitizen = new TreeMap<>();

        /*Student stu1 = new Student("Aa", "Phnom Penh");
        studentTreeMap.put(stu1, stu1);

        Student stu2 = new Student("Caca", "Stand Ford");
        studentTreeMap.put(stu2, stu2);

        Worker worker1 = new Worker("Bobo", "Kompong Cham", null, -20.0);
        workerTreeMap.put(worker1,worker1);

        Worker worker2 = new Worker("Dada", "Kompong Thom", 300.0, 20.0);
        workerTreeMap.put(worker2,worker2);

        for(Map.Entry<Student,Student> student : studentTreeMap.entrySet()) {
            listCitizen.put(student.getKey(), student.getValue());
        }

        for(Map.Entry<Worker,Worker> worker : workerTreeMap.entrySet()) {
            listCitizen.put(worker.getKey(), worker.getValue());
        }

        for(Map.Entry<Citizen ,Citizen> list : listCitizen.entrySet()) {
            Collection<Student> listStudent = studentTreeMap.values();
            Collection<Worker> listWorker = workerTreeMap.values();

            System.out.println("ID : " + list.getValue().id);
            System.out.println("Name : " + list.getValue().name);
            System.out.println("Address : " + list.getValue().address);

            listWorker.forEach(worker -> {
//                System.out.println(list.getValue().getClass());
                if(list.getKey().getClass().getName().equals("svaykong.com.coder.test.Worker")){
                    if(worker.name.equalsIgnoreCase(list.getValue().name)){
                        System.out.println("Salary ppp: " + worker.getSalary());
                        System.out.println("Bonus ppp: " + worker.getBonus());
                    }
                }
            });

            System.out.println("Payment : " + list.getValue().pay());
        }*/

    }

    static boolean isPositiveNumber(Double number) {
        if(number == null) {
            return false;
        }
        else if(number < 0) {
            return false;
        }
        return true;
    }

}

abstract class Citizen {
    private static int count = 1;
    protected int id;
    protected String name;
    protected String address;

    Citizen() {
        autoIncrement();
    }

    Citizen(String name, String address) {
        autoIncrement();
        this.name = name;
        this.address = address;
    }

    abstract Double pay();

    private void autoIncrement() {
        this.id = count++;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Student extends Citizen implements Comparable<Citizen> {

    Student(){
        super();
    }

    Student(String name, String address) {
        super(name, address);
    }

    @Override
    Double pay() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

//    @Override
//    public int compareTo(Student stu) {
//        int compare = name.compareTo(stu.name);
//        if(compare == 0) {
//            compare = Integer.compare(id, stu.id);
//        }
//        return compare;
//    }

    @Override
    public int compareTo(Citizen c) {
        int compare = name.compareTo(c.name);
        if(compare == 0) {
            compare = Integer.compare(id, c.id);
        }
        return compare;
    }
}

class Worker extends Citizen implements Comparable<Citizen> {

    private Double salary;
    private Double bonus;

    Worker() {
        super();
    }

    Worker(String name, String address, Double salary, Double bonus) {
        super(name, address);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    Double pay() {
        if(salary == null || bonus == null) {
            return null;
        }
        else if(salary < 0 || bonus < 0) {
            return 0.0;
        }
        else {
            return salary + bonus;
        }
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                '}';
    }

//    @Override
//    public int compareTo(Worker worker) {
//        int compare = name.compareTo(worker.name);
//        if(compare == 0) {
//            compare = Integer.compare(id, worker.id);
//        }
//        return compare;
//    }

    @Override
    public int compareTo(Citizen c) {
        int compare = name.compareTo(c.name);
        if(compare == 0) {
            compare = Integer.compare(id, c.id);
        }
        return compare;
    }
}

