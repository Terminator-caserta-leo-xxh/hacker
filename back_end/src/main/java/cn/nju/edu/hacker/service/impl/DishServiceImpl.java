package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.DishMapper;
import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.entity.DishEntity;
import cn.nju.edu.hacker.form.DishForm;
import cn.nju.edu.hacker.service.DishService;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "dishService")
public class DishServiceImpl implements DishService {
    @Autowired
    DishMapper dishMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public ResponseVO addDish(DishForm dishForm) {
        
        return null;
    }

    @Override
    public ResponseVO modifyDish(DishForm dishForm) {
        return null;
    }

    @Override
    public ResponseVO showAllDish() {
        List<DishEntity> dish = dishMapper.findByIsValid(1);
        if (dish.size() == 0) return ResponseVO.buildFailed("无餐品", -1);
        return ResponseVO.buildSucceed(dish.size() + "", 1, dish);
    }

    @Override
    public ResponseVO showDish(int id) {
        return null;
    }

    @Override
    public ResponseVO showVendorsDish(int id) {
        List<DishEntity> dish = dishMapper.findByUid(id);
        if (dish.size() == 0) return ResponseVO.buildFailed("无餐品", -1);
        return ResponseVO.buildSucceed(dish.size() + "", 1, dish);
    }

}
