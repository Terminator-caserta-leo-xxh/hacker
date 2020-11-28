package cn.nju.edu.hacker.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dish")
public class DishEntity {

    private String dishName;
    private Double price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishEntity that = (DishEntity) o;

        if (timeType != that.timeType) return false;
        if (id != that.id) return false;
        if (isValid != that.isValid) return false;
        if (dishName != null ? !dishName.equals(that.dishName) : that.dishName != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (cumulativeSales != null ? !cumulativeSales.equals(that.cumulativeSales) : that.cumulativeSales != null)
            return false;
        if (orderNums != null ? !orderNums.equals(that.orderNums) : that.orderNums != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (maxSupply != null ? !maxSupply.equals(that.maxSupply) : that.maxSupply != null) return false;

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
        result = 31 * result + isValid;
        result = 31 * result + (maxSupply != null ? maxSupply.hashCode() : 0);
        return result;
    }
}
