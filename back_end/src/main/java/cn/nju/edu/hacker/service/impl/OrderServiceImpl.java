package cn.nju.edu.hacker.service.impl;


import cn.nju.edu.hacker.dao.DishMapper;
import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.entity.DishEntity;
import cn.nju.edu.hacker.entity.OrderEntity;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.service.OrderService;
import cn.nju.edu.hacker.service.impl.comparator.getMealTimeComparator;
import cn.nju.edu.hacker.vo.CurrentOrderVO;
import cn.nju.edu.hacker.vo.HistoryOrderVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    DishMapper dishMapper;

    @Override
    public ResponseVO changeOrder(OrderForm orderForm) {
        OrderEntity entity = orderMapper.findById(orderForm.getId());
        entity.setMoney(orderForm.getMoney());
        entity.setSequence(orderForm.getSequence());
        entity.setRemarks(orderForm.getRemarks());
        entity.setDescription(orderForm.getDescription());
        orderMapper.save(entity);
        return ResponseVO.buildSucceed("修改完成", 0);
    }

    @Override
    public ResponseVO getShopHistory(int studentId) {
        List<OrderEntity> orders = orderMapper.findByStudentIdAndIsValid(studentId, 0);
        List<HistoryOrderVO> historyOrderVOs = new ArrayList<>();
        for (OrderEntity each : orders
        ) {
            HistoryOrderVO historyOrderVO = new HistoryOrderVO();
            historyOrderVO.setDescription(each.getDescription());
            historyOrderVO.setMoney(each.getMoney());
            historyOrderVO.setRemarks(each.getRemarks());
            List<Integer> dishIds = new ArrayList<>();
            int index;
            String sequence = ',' + each.getSequence();
            while ((index = sequence.lastIndexOf(",")) != -1) {
                DishEntity dish = dishMapper.findById(Integer.parseInt(sequence.substring(index + 1)));
                dishIds.add(dish.getId());
                sequence = sequence.substring(0, index);
            }
            historyOrderVO.setDishId(dishIds);
        }
        Collections.reverse(historyOrderVOs);
        return ResponseVO.buildSucceed("这是历史订单", 0, historyOrderVOs);
    }

    @Override
    public ResponseVO getCurrentOrder(int studentId) {
        List<OrderEntity> isnPayedOrders = orderMapper.findByStudentIdAndIsValid(studentId, 0);
        List<OrderEntity> isnCookedOrders = orderMapper.findByStudentIdAndIsValid(studentId, 1);
        List<OrderEntity> isnGetOrders = orderMapper.findByStudentIdAndIsValid(studentId, 2);

        isnPayedOrders.addAll(isnCookedOrders);
        isnPayedOrders.addAll(isnGetOrders);

        List<CurrentOrderVO> currentOrderVOS = new ArrayList<>();
        for (OrderEntity each : isnPayedOrders) {
            currentOrderVOS.add(new CurrentOrderVO(each));
        }
        return ResponseVO.buildSucceed("已获得当前订单", 0, currentOrderVOS);
    }

    /**
     * 提交订单状态，暂未付款
     * 前端进行付款操作
     *
     * @param orderForm
     * @return
     */
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
        return ResponseVO.buildSucceed("订单已提交", 0, Oid);
    }

    /**
     * 付完款，进入付款结束 而 未取餐 状态
     *
     * @param oid
     * @return
     */
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

        return ResponseVO.buildSucceed("订单+1", 1);
    }

    /**
     * 查找商家当前的订单
     *
     * @param vendorId
     * @return
     */
    //TODO 算法
    @Override
    public ResponseVO getVendorOrders(int vendorId) {
        List<OrderEntity> orders = orderMapper.findByVendorIdAndIsValid(vendorId, 2);
        orders.sort(Comparator.comparing(OrderEntity::getGetMealTime));
        orders.sort(new getMealTimeComparator(1));
        return null;
    }
}
