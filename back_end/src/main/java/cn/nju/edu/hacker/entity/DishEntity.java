package cn.nju.edu.hacker.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "dish")
public class DishEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "dishName")
    private String dishName;

    @Basic
    @Column(name = "price")
    private String price;
    /**
     * price: [double单价]+[0/1]
     * [0]-元/斤
     * [1]-元/份
     */
    @Basic
    @Column(name = "cumulativeSales")
    private Integer cumulativeSales;

    @Basic
    @Column(name = "orderNums")
    private Integer orderNums;

    @Basic
    @Column(name = "timeType")
    private int timeType;

    @Basic
    @Column(name = "startTime")
    private Date startTime;

    @Basic
    @Column(name = "endTime")
    private Date endTime;

    @Basic
    @Column(name = "UID")
    private Integer uid;


    @Basic
    @Column(name = "isValid")
    private int isValid;

    @Basic
    @Column(name = "maxSupply")
    private Integer maxSupply;

    @Basic
    @Column(name = "url")
    private String url;

    @Basic
    @Column(name = "period")
    private String period;


}
