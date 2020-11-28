package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CurrentOrderVO {
    
    private int id;

    private String description;

    private Double money;

    private String remarks;

    private String status;

    public CurrentOrderVO(OrderEntity entity) {
        id = entity.getId();
        description = entity.getDescription();
        money = entity.getMoney();
        remarks = entity.getRemarks();
        switch (entity.getIsValid()) {
            case 0:
                status = "尚未付款，若一日内未付款，订单将自动取消";
                break;
            case 1:
                status = "尚未做好，请耐心等待";
                break;
            case 2:
                status = "已做好，请尽快取餐";
                break;
        }
    }

}
