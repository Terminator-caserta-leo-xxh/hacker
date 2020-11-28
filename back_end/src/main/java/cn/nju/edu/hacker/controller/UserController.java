package cn.nju.edu.hacker.controller;

import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/student")
    public ResponseVO studentRegister(StudentVO studentVO){
        return userService.studentRegister(studentVO);
    }

    @PostMapping("/api/vendor")
    public ResponseVO studentRegister(VendorVO vendorVO){
        return userService.vendorRegister(vendorVO);
    }
}
