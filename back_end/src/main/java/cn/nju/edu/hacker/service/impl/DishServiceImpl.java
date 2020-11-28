package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.DishMapper;
import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.entity.DishEntity;
import cn.nju.edu.hacker.entity.OrderEntity;
import cn.nju.edu.hacker.form.DishForm;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.service.DishService;
import cn.nju.edu.hacker.vo.DishVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    DishMapper dishMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public DishVO addDish(int vendorId, DishForm dishForm) {
        return null;
    }

    @Override
    public DishVO modifyDish(int vendorId, String name, String description,
                             String price, boolean isSoldOut, String period) {
        return null;
    }

    @Override
    public ResponseVO showAllDish() {
        List<DishEntity> dish = dishMapper.findByIsValid(1);
        return ResponseVO.buildSucceed(String.valueOf(dish.size()),1, dish);
    }

    @Override
    public ResponseVO showVendorsDish(String uid) {
        int UID = Integer.parseInt(uid);
        List<DishEntity> dish = dishMapper.findByUid(UID);
        return ResponseVO.buildSucceed("",1,dish);
    }

    @Override
    public ResponseVO buyDish(OrderForm orderForm) {
        OrderEntity order = new OrderEntity();
        {
            order.setStudentId(order.getStudentId());
            order.setVendorId(order.getVendorId());
            order.setDescription(orderForm.getDescription());
            order.setMoney(orderForm.getMoney());
            order.setRemarks(orderForm.getRemarks());
            order.setIsValid(0);
            order.setSequence(orderForm.getSequence());
        }
        orderMapper.save(order);
        List<OrderEntity> orders = orderMapper.findByStudentIdAndVendorIdAndIsValid(order.getStudentId(), order.getVendorId(), 0);
        int Oid = orders.get(orders.size() - 1).getId();
        return ResponseVO.buildSucceed("订单已提交", Oid);
    }

    @Override
    public ResponseVO finishOrder(int oid) {
        OrderEntity order = orderMapper.findById(oid);
        order.setIsValid(1);
        orderMapper.save(order);
        String sequence = order.getSequence();
        /**
         * 解析餐品sequence
         * 实现预约数的变化
         */
        int index;
        sequence = ',' + sequence;
        while ((index = sequence.lastIndexOf(",")) != -1) {
            DishEntity dish = dishMapper.findById(Integer.parseInt(sequence.substring(index + 1)));
            dish.setCumulativeSales(dish.getCumulativeSales() + 1);
            dish.setOrderNums(dish.getOrderNums() + 1);
            sequence = sequence.substring(0, index);
        }

        return ResponseVO.buildSucceed("订单+1",1);
    }


}
