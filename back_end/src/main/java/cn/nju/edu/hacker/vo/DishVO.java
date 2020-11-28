package cn.nju.edu.hacker.vo;


import lombok.Data;

import java.sql.Date;

@Data
public class DishVO {

    private String dishName;

    private Double price;

    private Integer cumulativeSales;

    private Integer orderNums;

    /**
     * 早午饭
     */
    private int timeType;

    private Date startTime;

    private Date endTime;

    /**
     * 商家标签
     */
    private Integer uid;

    private int id;

    /**
     * 是否售罄
     */
    private Integer isValid;

    private Integer maxSupply;

}
