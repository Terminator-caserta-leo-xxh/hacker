package cn.nju.edu.hacker.service;

import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.vo.ResponseVO;

public interface OrderService {

    ResponseVO modifyOrder(OrderForm orderForm);
}
