package cn.nju.edu.hacker.service.impl;


import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.entity.OrderEntity;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.service.OrderService;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseVO modifyOrder(OrderForm orderForm) {
        int id = orderForm.getId();
        OrderEntity entity = orderMapper.findById(id);
        if (entity == null) return ResponseVO.buildFailed("没有这个订单！", -1);

        double money = orderForm.getMoney();
        String sequence = orderForm.getSequence();
        String remarks = orderForm.getRemarks();
        String description = orderForm.getDescription();

        if (money != 0.0) entity.setMoney(money);
        if (sequence != null) entity.setSequence(sequence);
        if (remarks != null) entity.setRemarks(remarks);
        if (description != null) entity.setDescription(description);
        orderMapper.save(entity);
        return ResponseVO.buildSucceed("修改完成", 0);
    }
}
