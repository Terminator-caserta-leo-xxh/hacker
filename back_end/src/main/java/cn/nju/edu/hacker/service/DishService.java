package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.form.DishForm;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.vo.DishVO;
import cn.nju.edu.hacker.vo.ResponseVO;

public interface DishService {

    ResponseVO addDish(DishForm dishForm);

    ResponseVO modifyDish(DishForm dishForm);

    ResponseVO showVendorsDish(int id);

    ResponseVO buyDish(OrderForm orderVO);

    ResponseVO finishOrder(int oid);

    ResponseVO showAllDish();

    ResponseVO showDish(int id);
}
