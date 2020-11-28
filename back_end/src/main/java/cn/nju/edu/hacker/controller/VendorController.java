package cn.nju.edu.hacker.controller;


import cn.nju.edu.hacker.entity.VendorEntity;
import cn.nju.edu.hacker.form.VendorForm;
import cn.nju.edu.hacker.service.VendorService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/register")
    public ResponseVO register(@RequestBody VendorForm vendorForm) {

        String name = vendorForm.getName();
        String passwd = vendorForm.getPasswd();
        String cellphone = vendorForm.getCellphone();
        String address = vendorForm.getAddress();
        Date beginTime = vendorForm.getBeginTime();
        Date endTime = vendorForm.getEndTime();
        String description = vendorForm.getDescription();
        String localPhotoUrl = vendorForm.getLocationPhotoUrl();
        /**
         * 如果失败了不会加入数据库，成功了则会
         */
        return vendorService.register(name, passwd, cellphone, address, beginTime, endTime, description, localPhotoUrl);
    }

    @PostMapping("/login")
    public ResponseVO login(HttpSession httpSession, @RequestParam(value = "name") String name, @RequestParam(value = "passwd") String passwd) {
        if (httpSession.getAttribute("userName").equals(name)) return ResponseVO.buildSucceed("您已登录！", 1);
        ResponseVO responseVO = vendorService.login(name, passwd);
        if (!responseVO.isSuccess()) return responseVO;
        VendorVO vendorVO = new VendorVO((VendorEntity) responseVO.getData());
        httpSession.setAttribute("userName", vendorVO.getUsername());
        return responseVO;
    }

}
