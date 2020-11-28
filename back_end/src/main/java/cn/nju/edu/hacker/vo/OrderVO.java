package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class OrderVO {

    private int number;
    private String description;
    private Double money;
    private String remarks;
    private Date getMealTime;

    public OrderVO(OrderEntity entity) {
        number = entity.getNumber();
        description = entity.getDescription();
        money = entity.getMoney();
        remarks = entity.getRemarks();
        getMealTime = entity.getGetMealTime();
    }
}
