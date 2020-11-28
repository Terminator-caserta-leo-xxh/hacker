package cn.nju.edu.hacker.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 学生的具体的某个订单
 */
@Entity
@Table(name = "order", schema = "hackthon")
public class OrderEntity {

    private Date getMealTime;
    private int studentId;
    private int vendorId;
    /**
     * format: [id1],[id2]...
     */
    private String sequence;
    private Double money;
    /**
     * 备注 额外要求
     */
    private String remarks;
    /**
     * id自增长
     */
    private int id;
    /**
     * format: [id1]:[num1],[id2]:[num2]...
     */
    private String description;
    /**
     * isValid:
     * 0 - 暂未付款
     * 1 - 已付款且没做好
     * 2 - 已付款，做好而未取货
     * -1 - 已付款且取货-失效
     */
    private int isValid;
    private int number;


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
    @Column(name = "getMealTime")
    public Date getGetMealTime() {
        return getMealTime;
    }

    public void setGetMealTime(Date getMealTime) {
        this.getMealTime = getMealTime;
    }

    @Basic
    @Column(name = "sequence")
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
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

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isValid")
    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
