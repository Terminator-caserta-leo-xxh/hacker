package cn.nju.edu.hacker.form;

import lombok.Data;

import java.sql.Date;

@Data
public class DishForm {

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

    private Integer uid;

    private int id;

    /**
     * 是否售罄
     */
    private Integer isValid;

    private Integer maxSupply;

}
