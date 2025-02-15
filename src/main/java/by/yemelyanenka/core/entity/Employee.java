package by.yemelyanenka.core.entity;

import java.math.BigDecimal;

public class Employee extends Worker{

    private Integer managerId;

    public Employee(Integer id, String post, String name, Double salary, Integer managerId) {
        super(id, post, name, salary);
        this.managerId = managerId;
    }

    public Employee() {
        super();
        this.managerId = 0;
    }


    public Integer getManagerId() {
        return managerId;
    }



    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return
                super.getPost()  +
                ", " + super.getId() +
                ", " + super.getName() +
                ", " + super.getSalary() +
                " " + managerId +
                '\n';
    }
}
