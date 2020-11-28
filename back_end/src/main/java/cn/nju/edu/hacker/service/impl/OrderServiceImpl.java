package cn.nju.edu.hacker.service.impl;


import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

 
}
