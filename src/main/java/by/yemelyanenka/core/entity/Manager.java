package by.yemelyanenka.core.entity;

import java.math.BigDecimal;

public class Manager extends Worker{


    private String department;

    public Manager(String department,Integer id, String post, String name, Double salary) {
        super(id, post, name, salary);
        this.department = department;
    }

    public Manager() {
        super();
        this.department = "";
    }

    @Override
    public String toString() {
        return
                this.getPost() + ", " + this.getId() +
                ", " + this.getName() +
                ", " + this.getSalary() + "\n";
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
