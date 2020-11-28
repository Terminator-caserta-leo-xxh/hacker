package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.form.DishForm;
import cn.nju.edu.hacker.vo.DishVO;

public interface DishService {

    DishVO addDish(int vendorId, DishForm dishForm);

    DishVO modifyDish(int vendorId, String name, String description, String price, boolean isSoldOut, String period);

}
