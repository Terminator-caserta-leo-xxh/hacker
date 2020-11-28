package cn.nju.edu.hacker.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dish")
public class DishEntity {

    private String dishName;
    private String price;
    /**
     * price: [double单价]+[0/1]
     * [0]-元/斤
     * [1]-元/份
     */
    private Integer cumulativeSales;
    private Integer orderNums;
    private int timeType;
    private Date startTime;
    private Date endTime;
    private Integer uid;
    private int id;
    private int isValid;
    private Integer maxSupply;

    @Basic
    @Column(name = "dishName")
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "cumulativeSales")
    public Integer getCumulativeSales() {
        return cumulativeSales;
    }

    public void setCumulativeSales(Integer cumulativeSales) {
        this.cumulativeSales = cumulativeSales;
    }

    @Basic
    @Column(name = "orderNums")
    public Integer getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(Integer orderNums) {
        this.orderNums = orderNums;
    }

    @Basic
    @Column(name = "timeType")
    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    @Basic
    @Column(name = "startTime")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "UID")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isValid")
    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    @Basic
    @Column(name = "maxSupply")
    public Integer getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Integer maxSupply) {
        this.maxSupply = maxSupply;
    }

}
