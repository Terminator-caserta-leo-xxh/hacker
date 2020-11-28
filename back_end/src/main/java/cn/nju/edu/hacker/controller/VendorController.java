package cn.nju.edu.hacker.controller;


import cn.nju.edu.hacker.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    public VendorService vendorService;

}
