package cn.nju.edu.hacker.form;

import lombok.Data;

@Data
public class DishForm {

    private String name;

    private String description;

    private String price;

    private int isSoldOut;

    private String period;
    
}
