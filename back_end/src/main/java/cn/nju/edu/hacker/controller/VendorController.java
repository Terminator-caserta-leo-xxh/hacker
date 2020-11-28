package cn.nju.edu.hacker.controller;


import cn.nju.edu.hacker.form.VendorForm;
import cn.nju.edu.hacker.service.VendorService;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    public VendorService vendorService;

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

        ResponseVO responseVO = vendorService.register(name, passwd, cellphone, address, beginTime, endTime, description, localPhotoUrl);
        if (!responseVO.isSuccess()) return responseVO;
        return null;
    }

}
