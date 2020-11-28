package cn.nju.edu.hacker.controller;

import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.form.StudentForm;
import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public ResponseVO studentRegister(@RequestBody StudentForm studentForm) {
            return userService.studentRegister(studentForm);
    }

    @PostMapping("/user/login/status")
    public ResponseVO studentLogin(HttpSession httpSession, @RequestBody StudentForm studentForm) {
        if (httpSession.getAttribute(String.valueOf(studentForm.getId())).equals(1))
            return ResponseVO.buildSucceed("ok",1);
        return userService.studentLogin(studentForm);
    }

    @PostMapping("/user/{id}/delete")
    public ResponseVO studentExit(HttpSession httpSession, @PathVariable int id) {
        httpSession.removeAttribute(String.valueOf(id));
        return ResponseVO.buildSucceed("ok",1);
    }

    @GetMapping("/user/detail/{id}")
    public ResponseVO studentLook(@PathVariable int id) {
        return userService.studentLook(id);
    }

    @PostMapping("/user/update")
    public ResponseVO studentFix(@RequestBody StudentForm studentForm) {
        return userService.studentFix(studentForm);
    }

    @GetMapping("/user/shopHistory/{id}")
    public ResponseVO getShopHistory(@PathVariable int id) {
        return userService.getShopHistory(id);
    }

    @GetMapping("/user/order/{id}")
    public ResponseVO getCurrentOrder(@PathVariable int id){return userService.getCurrentOrder(id);}

    @PostMapping("/user/changeOrder")
    public ResponseVO changeOrder(@RequestBody OrderForm orderForm){
        return userService.changeOrder(orderForm);
    }

}
