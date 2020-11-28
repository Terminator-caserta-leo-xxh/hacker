package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.DishMapper;
import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.dao.VendorMapper;
import cn.nju.edu.hacker.entity.DishEntity;
import cn.nju.edu.hacker.entity.OrderEntity;
import cn.nju.edu.hacker.entity.VendorEntity;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.service.OrderService;
import cn.nju.edu.hacker.vo.CurrentOrderVO;
import cn.nju.edu.hacker.vo.HistoryOrderVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    DishMapper dishMapper;

    @Autowired
    VendorMapper vendorMapper;

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
            order.setStudentId(orderForm.getStudentId());
            order.setVendorId(orderForm.getVendorId());
            order.setDescription(orderForm.getDescription());
            order.setMoney(orderForm.getMoney());
            order.setRemarks(orderForm.getRemarks());
            order.setIsValid(0);
            order.setSequence(orderForm.getSequence());
            VendorEntity vendor = vendorMapper.findById(orderForm.getVendorId());
            vendor.setGetNumber(vendor.getGetNumber() + 1);
            order.setNumber(vendor.getGetNumber());
        }
        orderMapper.save(order);
        List<OrderEntity> orders = orderMapper.findByStudentIdAndVendorIdAndIsValid(order.getStudentId(), order.getVendorId(), 0);
        int orderGetNumber = order.getNumber();
        return ResponseVO.buildSucceed("订单已提交", 0, orderGetNumber);
    }

    /**
     * 付完款，进入付款结束 而 未取餐 状态
     *
     * @param oid
     * @return
     */
    @Override
    public ResponseVO payOrder(int oid) {
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
        List<OrderEntity> orders = orderMapper.findByVendorIdAndIsValid(vendorId, 1);
        orders.sort(Comparator.comparing(OrderEntity::getGetMealTime));
        List<List<OrderEntity>> lists = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < orders.size() - 1) {
            if (orders.get(end).getGetMealTime().equals(orders.get(end + 1).getGetMealTime())) {
                List<OrderEntity> temp = orders.subList(start, end + 1);
                if (new Date(System.currentTimeMillis()).compareTo(temp.get(0).getGetMealTime()) > 0)
                    temp.sort((o1, o2) -> o1.getNumber() > o2.getNumber() ? -1 : 0);
                else
                    temp.sort((o1, o2) -> o1.getNumber() >= o2.getNumber() ? 0 : -1);
                lists.add(temp);
                start = end + 1;
            }
            end++;
        }
        List<OrderEntity> results = new ArrayList<>();
        for (List<OrderEntity> each : lists)
            results.addAll(each);
        if (results.size() == 0)
            return ResponseVO.buildFailed("无订单", -1);
        //orders.sort(new getMealTimeComparator(1));
        return ResponseVO.buildSucceed("订单顺序", 0, results);
    }

    /**
     * 餐点制作完毕，订单完成
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVO finishOrder(int id) {
        OrderEntity order = orderMapper.findById(id);
        order.setIsValid(2);
        orderMapper.save(order);
        String sequence = order.getSequence();
        int index;
        sequence = ',' + sequence;
        while ((index = sequence.lastIndexOf(",")) != -1) {
            DishEntity dish = dishMapper.findById(Integer.parseInt(sequence.substring(index + 1)));
            dish.setOrderNums(dish.getOrderNums() - 1);
            sequence = sequence.substring(0, index);
        }
        return ResponseVO.buildSucceed("餐点制作完毕", 0);
    }

    /**
     * 确认拿走订单
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVO getOrder(int id) {
        OrderEntity entity = orderMapper.findById(id);
        entity.setIsValid(-1);
        orderMapper.save(entity);
        return ResponseVO.buildSucceed("餐点已取走", 0);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Override
    public ResponseVO delOrder(int id) {
        OrderEntity order = orderMapper.findById(id);
        orderMapper.delete(order);
        if (orderMapper.findById(id) != null)
            return ResponseVO.buildFailed("删除失败", -1);
        else
            return ResponseVO.buildSucceed("删除成功", 0);
    }

    /**
     * 自动将isValid为2的订单变为-1
     */
    @Scheduled(cron = "0 0 0 ? * *")
    private void clearOrder() {
        List<OrderEntity> orders = orderMapper.findByIsValid(2);
        for (OrderEntity each : orders) {
            each.setIsValid(-1);
            orderMapper.save(each);
        }
    }
}
