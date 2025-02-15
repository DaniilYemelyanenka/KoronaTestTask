package by.yemelyanenka.core.entity;

import java.math.BigDecimal;


public class Worker {

    public Worker(Integer id, String post, String name, Double salary) {
        this.id = id;
        this.post = post;
        this.name = name;
        this.salary = salary;
    }

    private String post;

    private Integer id;

    private String name;

    private Double salary;

    public Worker() {

    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Worker{" +
                "post='" + post + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
