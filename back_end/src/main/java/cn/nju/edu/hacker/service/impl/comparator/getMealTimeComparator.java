package cn.nju.edu.hacker.service.impl.comparator;

import cn.nju.edu.hacker.entity.OrderEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Setter
@Getter
public class getMealTimeComparator implements Comparator<OrderEntity> {

    int isReverted = 1;

    public getMealTimeComparator(int isReverted){
        this.isReverted=isReverted;
    }
    @Override
    public int compare(OrderEntity o1, OrderEntity o2) {
        if (o1.getGetMealTime().compareTo(o2.getGetMealTime()) == 0) {
            return o1.getNumber() - o2.getNumber() > 0 ? -1 * isReverted : isReverted;
        } else {
            return o1.getGetMealTime().compareTo(o2.getGetMealTime());
        }
    }

    public static void main(String[] args) {
        List<OrderEntity> orderEntities = new ArrayList<>();
        OrderEntity o1 = new OrderEntity();
        Date date1 = new Date(1000);
        o1.setGetMealTime(date1);
        o1.setNumber(10);
        o1.setId(10);

        OrderEntity o2 = new OrderEntity();
        Date date2 = new Date(10000);
        o2.setGetMealTime(date2);
        o2.setNumber(31);
        o2.setId(15);

        OrderEntity o3 = new OrderEntity();
        Date date3 = new Date(10000);
        o3.setGetMealTime(date3);
        o3.setNumber(3);
        o3.setId(20);

        OrderEntity o4 = new OrderEntity();
        Date date4 = new Date(1000);
        o4.setGetMealTime(date4);
        o4.setNumber(9);
        o4.setId(25);

        orderEntities.add(o1);
        orderEntities.add(o2);
        orderEntities.add(o3);
        orderEntities.add(o4);

        orderEntities.sort(new getMealTimeComparator(1));
        for (OrderEntity each : orderEntities)
            System.out.println(each.getId());
    }
}
