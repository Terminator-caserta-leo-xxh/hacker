package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.form.DishForm;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.vo.DishVO;
import cn.nju.edu.hacker.vo.ResponseVO;

public interface DishService {

    DishVO addDish(int vendorId, DishForm dishForm);

    DishVO modifyDish(int vendorId, String name, String description, String price, boolean isSoldOut, String period);

    ResponseVO showVendorsDish(String uid);

    ResponseVO buyDish(OrderForm orderVO);

    ResponseVO finishOrder(int oid);

    ResponseVO showAllDish();
}
