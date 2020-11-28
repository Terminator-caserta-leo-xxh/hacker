package cn.nju.edu.hacker.controller;

import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.form.StudentForm;
import cn.nju.edu.hacker.service.OrderService;
import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    private final UserService userService;

    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping("/user/add")
    public ResponseVO studentRegister(@RequestBody StudentForm studentForm) {
        return userService.studentRegister(studentForm);
    }

    /**
     * 学生用户登陆
     *
     * @param httpSession
     * @param studentForm
     * @return
     */
    @PostMapping("/user/login/status")
    public ResponseVO studentLogin(HttpSession httpSession, @RequestBody StudentForm studentForm) {
        if (httpSession.getAttribute(String.valueOf(studentForm.getUsername())).equals(1))
            return ResponseVO.buildSucceed("ok", 1);
        return userService.studentLogin(httpSession, studentForm);
    }

    /**
     * 学生用户退出登陆
     *
     * @param httpSession
     * @param id
     * @return
     */
    @PostMapping("/user/{id}/delete")
    public ResponseVO studentExit(HttpSession httpSession, @PathVariable int id) {
        return userService.studentExit(httpSession, id);
    }

    /**
     * 查看学生用户的个人信息
     *
     * @param id
     * @return
     */
    @GetMapping("/user/detail/{id}")
    public ResponseVO studentLook(HttpSession httpSession, @PathVariable int id) {
        if (httpSession.getAttribute(String.valueOf(id)) == null)
            return ResponseVO.buildFailed("请先登录！", -1);
        return userService.studentLook(id);
    }

    /**
     * 修改学生用户的个人信息
     *
     * @param studentForm
     * @return
     */
    @PostMapping("/user/update")
    public ResponseVO studentFix(HttpSession httpSession, @RequestBody StudentForm studentForm) {
        if (httpSession.getAttribute(String.valueOf(studentForm.getId())) == null)
            return ResponseVO.buildFailed("请先登录！", -1);
        return userService.studentFix(studentForm);
    }

    /**
     * 查看历史订单
     *
     * @param id
     * @return
     */
    @GetMapping("/user/shopHistory/{id}")
    public ResponseVO getShopHistory(HttpSession httpSession, @PathVariable int id) {
        if (httpSession.getAttribute(String.valueOf(id)) == null)
            return ResponseVO.buildFailed("请先登录！", -1);
        return orderService.getShopHistory(id);
    }

    /**
     * 查看当前订单
     *
     * @param id
     * @return
     */
    @GetMapping("/user/order/{id}")
    public ResponseVO getCurrentOrder(HttpSession httpSession, @PathVariable int id) {
        if (httpSession.getAttribute(String.valueOf(id)) == null)
            return ResponseVO.buildFailed("请先登录！", -1);
        return orderService.getCurrentOrder(id);
    }

    /**
     * 修改订单、
     * 应建立在查看当前订单的前提上
     *
     * @param orderForm
     * @return
     */
    @PostMapping("/user/changeOrder")
    public ResponseVO changeOrder(@RequestBody OrderForm orderForm) {
        return orderService.changeOrder(orderForm);
    }

    @PostMapping("/logout/status")
    public ResponseVO logout(HttpSession httpSession) {
        httpSession.invalidate();
        return ResponseVO.buildSucceed("退出成功！", 0);
    }

}
