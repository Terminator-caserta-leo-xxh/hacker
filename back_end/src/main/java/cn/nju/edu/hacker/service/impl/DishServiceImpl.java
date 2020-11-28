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

    /**
     * 添加餐品
     *
     * @param dishForm
     * @return
     */
    @Override
    public ResponseVO addDish(DishForm dishForm) {

        DishEntity dishEntity = new DishEntity();
        dishEntity.setOrderNums(0);
        dishEntity.setCumulativeSales(0);
        dishEntity.setDishName(dishForm.getDishName());
        dishEntity.setIsValid(1);
        dishEntity.setPrice(dishForm.getPrice());
        dishEntity.setStartTime(dishForm.getStartTime());
        dishEntity.setEndTime(dishForm.getEndTime());
        dishEntity.setUid(dishForm.getUid());
        dishEntity.setPeriod(dishForm.getPeriod());
        dishEntity.setTimeType(dishForm.getTimeType());

        dishMapper.save(dishEntity);
        return ResponseVO.buildSucceed("添加成功", 0);
    }

    /**
     * 修改菜品
     *
     * @param dishForm
     * @return
     */
    @Override
    public ResponseVO modifyDish(DishForm dishForm) {
        DishEntity dishEntity = dishMapper.findById(dishForm.getId());
        if (dishEntity == null)
            return ResponseVO.buildFailed("不存在的菜品", -1);
        dishEntity.setOrderNums(0);
        dishEntity.setCumulativeSales(0);
        if (dishForm.getDishName() != null) dishEntity.setDishName(dishForm.getDishName());
        dishEntity.setIsValid(1);
        if (dishForm.getPrice() != null) dishEntity.setPrice(dishForm.getPrice());
        if (dishForm.getStartTime() != null) dishEntity.setStartTime(dishForm.getStartTime());
        if (dishForm.getEndTime() != null) dishEntity.setEndTime(dishForm.getEndTime());
        if (dishForm.getPeriod() != null) dishEntity.setPeriod(dishForm.getPeriod());
        if (dishForm.getTimeType() != null) dishEntity.setTimeType(dishForm.getTimeType());
        dishMapper.save(dishEntity);
        return ResponseVO.buildSucceed("修改成功", 0);
    }

    @Override
    public ResponseVO showAllDish() {
        List<DishEntity> dish = dishMapper.findByIsValid(1);
        if (dish.size() == 0) return ResponseVO.buildFailed("无餐品", -1);
        return ResponseVO.buildSucceed(dish.size() + "", 1, dish);
    }

    @Override
    public ResponseVO showDish(int id) {
        DishEntity dish = dishMapper.findById(id);
        if (dish == null) return ResponseVO.buildFailed("无餐品", -1);
        return ResponseVO.buildSucceed("", 0, dish);
    }

    /**
     * 展示商家的所有餐品
     *
     * @param id vendorId
     * @return
     */
    @Override
    public ResponseVO showVendorsDish(int id) {
        List<DishEntity> dish = dishMapper.findByUid(id);
        if (dish.size() == 0) return ResponseVO.buildFailed("无餐品", -1);
        return ResponseVO.buildSucceed(dish.size() + "", 1, dish);
    }

}
