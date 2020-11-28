package cn.nju.edu.hacker.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Dish {
    private String dishName;
    private Double price;
    private Integer cumulativeSales;
    private Integer orderNums;
    private int timeType;
    private Date startTime;
    private Date endTime;
    private Integer uid;
    private int id;
    private Integer isValid;
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
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (timeType != dish.timeType) return false;
        if (id != dish.id) return false;
        if (dishName != null ? !dishName.equals(dish.dishName) : dish.dishName != null) return false;
        if (price != null ? !price.equals(dish.price) : dish.price != null) return false;
        if (cumulativeSales != null ? !cumulativeSales.equals(dish.cumulativeSales) : dish.cumulativeSales != null)
            return false;
        if (orderNums != null ? !orderNums.equals(dish.orderNums) : dish.orderNums != null) return false;
        if (startTime != null ? !startTime.equals(dish.startTime) : dish.startTime != null) return false;
        if (endTime != null ? !endTime.equals(dish.endTime) : dish.endTime != null) return false;
        if (uid != null ? !uid.equals(dish.uid) : dish.uid != null) return false;
        if (isValid != null ? !isValid.equals(dish.isValid) : dish.isValid != null) return false;
        if (maxSupply != null ? !maxSupply.equals(dish.maxSupply) : dish.maxSupply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dishName != null ? dishName.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cumulativeSales != null ? cumulativeSales.hashCode() : 0);
        result = 31 * result + (orderNums != null ? orderNums.hashCode() : 0);
        result = 31 * result + timeType;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (isValid != null ? isValid.hashCode() : 0);
        result = 31 * result + (maxSupply != null ? maxSupply.hashCode() : 0);
        return result;
    }
}