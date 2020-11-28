package cn.nju.edu.hacker.vo;


import lombok.Data;

@Data
public class DishVO {

    private String name;

    private String description;

    private String price;

    private int isSoldOut;

    private String period;

}
