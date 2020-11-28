package cn.nju.edu.hacker.service;

import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    /**
     * 更改订单信息
     * @param orderForm
     * @return
     */
    ResponseVO changeOrder(OrderForm orderForm);

    /**
     * 展示用户的历史/当前订单
     * @param studentId 用户的ID
     * @return
     */
    ResponseVO getShopHistory(int studentId);

    ResponseVO getCurrentOrder(int studentId);

    /**
     * 购买餐品，生成订单
     * @param orderForm
     * @return
     */
    ResponseVO buyDish(OrderForm orderForm);

    /**
     * 支付完成，改变订单状态
     * @param oid
     * @return
     */
    ResponseVO finishOrder(int oid);

    /**
     * 查找商家当前的订单
     * @param id
     * @return
     */
    ResponseVO getVendorOrders(int id);
}
