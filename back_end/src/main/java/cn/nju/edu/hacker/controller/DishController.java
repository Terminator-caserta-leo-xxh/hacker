package cn.nju.edu.hacker.controller;

import cn.nju.edu.hacker.form.DishForm;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.service.DishService;
import cn.nju.edu.hacker.service.OrderService;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class DishController {
    @Autowired
    DishService dishService;
    @Autowired
    OrderService orderService;

    /**
     * 查询该商家的所有餐品
     *
     * @param id 商家的ID
     * @return
     */
    @GetMapping("/dishes/{id}")
    public ResponseVO getVendorDishes(@PathVariable(value = "id") int id) {
        return dishService.showVendorsDish(id);
    }

    /**
     * 查询某餐品的详细信息
     *
     * @param id 餐品的ID
     * @return
     */
    @GetMapping("/{id}")
    public ResponseVO getDishDetail(@PathVariable(value = "id") int id) {
        return dishService.showDish(id);
    }

    /**
     * 查询所有餐品
     *
     * @return
     */
    @GetMapping("/dishes")
    public ResponseVO getAllDishes() {
        return dishService.showAllDish();
    }

    /**
     * 增加新的餐品
     *
     * @param dishForm 需要携带商家ID
     * @return
     */
    @PostMapping("/add")
    public ResponseVO addDish(@RequestBody DishForm dishForm) {
        return dishService.addDish(dishForm);
    }

    /**
     * 购买餐品，生成订单
     *
     * @param orderForm
     * @return
     */
    @PostMapping("/buy")
    public ResponseVO buyDish(@RequestBody OrderForm orderForm) {
        return orderService.buyDish(orderForm);
    }

    /**
     * 支付完成，改变订单状态
     *
     * @param orderId
     * @return
     */
    @PostMapping("/{id}/pay")
    public ResponseVO finishOrder(@PathVariable(value = "id") int orderId) {
        return orderService.finishOrder(orderId);
    }
}
