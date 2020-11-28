package cn.nju.edu.hacker.form;

import lombok.Data;

import java.sql.Date;

@Data
public class DishForm {


    private String dishName;

    private String price;

    private Integer cumulativeSales;

    private Integer orderNums;

    /**
     * 早午饭
     */
    private int id;

    private Date startTime;

    private Date endTime;

    /**
     * 表示店铺id
     */
    private Integer uid;

    /**
     * 是否售罄
     */
    private Integer isValid;

    private Integer maxSupply;

    private String url;

    private String period;

}
