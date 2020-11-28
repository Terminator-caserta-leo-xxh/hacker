package cn.nju.edu.hacker.controller;


import cn.nju.edu.hacker.entity.VendorEntity;
import cn.nju.edu.hacker.form.VendorForm;
import cn.nju.edu.hacker.service.DishService;
import cn.nju.edu.hacker.service.OrderService;
import cn.nju.edu.hacker.service.VendorService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@RestController
@RequestMapping("/vendorList")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseVO register(@RequestBody VendorForm vendorForm) {

        String name = vendorForm.getName();
        String passwd = vendorForm.getPasswd();
        String cellphone = vendorForm.getCellphone();
        String address = vendorForm.getAddress();
        Date beginTime = vendorForm.getBeginTime();
        Date endTime = vendorForm.getEndTime();
        String description = vendorForm.getDescription();
        String localPhotoUrl = vendorForm.getLocationPhotoUrl();
        String email = vendorForm.getEmail();
        /**
         * 如果失败了不会加入数据库，成功了则会
         */
        return vendorService.register(name, passwd, cellphone, address, email, beginTime, endTime, description, localPhotoUrl);
    }

    @PostMapping("/login")
    public ResponseVO login(HttpSession httpSession, @RequestParam(value = "name") String name, @RequestParam(value = "passwd") String passwd) {
        if (httpSession.getAttribute("userName").equals(name)) return ResponseVO.buildSucceed("您已登录！", 1);
        ResponseVO responseVO = vendorService.login(name, passwd);
        if (!responseVO.isSuccess()) return responseVO;
        VendorVO vendorVO = new VendorVO((VendorEntity) responseVO.getData());
        httpSession.setAttribute("userName", vendorVO.getUsername());
        httpSession.setAttribute("userId", vendorVO.getId());
        return responseVO;
    }

    @PostMapping("/update")
    public ResponseVO update(HttpSession httpSession, @RequestBody VendorForm vendorForm) {
        if (httpSession.getAttribute("userName") == null) return ResponseVO.buildFailed("请先登录！", -1);
        int userId = (Integer) httpSession.getAttribute("userId");

        String name = vendorForm.getName();
        String cellphone = vendorForm.getCellphone();
        Date beginTime = vendorForm.getBeginTime();
        Date endTime = vendorForm.getEndTime();
        String description = vendorForm.getDescription();
        String localPhotoUrl = vendorForm.getLocationPhotoUrl();
        String email = vendorForm.getEmail();

        return vendorService.modifyInfo(userId, name, cellphone, email, beginTime, endTime, description, localPhotoUrl);

    }

    @PostMapping("/{id}/del")
    public ResponseVO delete(@PathVariable("id") int id) {
        return vendorService.delete(id);
    }

    @GetMapping("/list")
    public ResponseVO getList() {
        return vendorService.list();
    }

    @GetMapping("/detail")
    public ResponseVO getSpecified(@RequestParam(value = "vendorID") int id) {
        return vendorService.find(id);
    }

    @GetMapping("/vendorName/detail")
    public ResponseVO getSpecified(@RequestParam(value = "vendorName") String name) {
        return vendorService.find(name);
    }

    @PostMapping("/open")
    public ResponseVO open(HttpSession httpSession) {
        if (httpSession.getAttribute("userName") == null) return ResponseVO.buildFailed("请先登录！", -1);
        int vendorId = (Integer) httpSession.getAttribute("userId");
        return vendorService.openOrClose(vendorId);
    }

    @PostMapping("/close")
    public ResponseVO close(HttpSession httpSession) {
        if (httpSession.getAttribute("userName") == null) return ResponseVO.buildFailed("请先登录！", -1);
        int vendorId = (Integer) httpSession.getAttribute("userId");
        return vendorService.openOrClose(vendorId);
    }

    /**
     * 查找商家当前的订单
     * @param httpSession
     * @param id
     * @return
     */
    @GetMapping("/{id}/orders")
    public ResponseVO showOrders(HttpSession httpSession, @PathVariable int id) {
        if (httpSession.getAttribute(String.valueOf(id)) == null)
            return ResponseVO.buildFailed("请先登录！", -1);
        else
            return orderService.getVendorOrders(id);
    }

}
