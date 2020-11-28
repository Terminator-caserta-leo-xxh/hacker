package cn.nju.edu.hacker.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
    private int studentId;
    private int vendorId;
    private int number;
    private Integer sequence;
    private Double money;
    private String remarks;
    private int timeStamp;
    private String description;

    @Basic
    @Column(name = "studentID")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "vendorID")
    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "sequence")
    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Basic
    @Column(name = "money")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Id
    @Column(name = "timeStamp")
    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String desrciption) {
        this.description = desrciption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (studentId != order.studentId) return false;
        if (vendorId != order.vendorId) return false;
        if (number != order.number) return false;
        if (timeStamp != order.timeStamp) return false;
        if (sequence != null ? !sequence.equals(order.sequence) : order.sequence != null) return false;
        if (money != null ? !money.equals(order.money) : order.money != null) return false;
        if (remarks != null ? !remarks.equals(order.remarks) : order.remarks != null) return false;
        if (description != null ? !description.equals(order.description) : order.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + vendorId;
        result = 31 * result + number;
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + timeStamp;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
