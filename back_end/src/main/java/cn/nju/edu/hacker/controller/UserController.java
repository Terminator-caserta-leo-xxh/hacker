package cn.nju.edu.hacker.controller;

import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/studentRegister")
    public ResponseVO studentRegister(@RequestBody StudentVO studentVO) {
        return userService.studentRegister(studentVO);
    }

    @PostMapping("/api/studentLogin")
    public ResponseVO studentLogin(HttpSession httpSession, @RequestBody StudentVO studentVO) {
        if (httpSession.getAttribute(String.valueOf(studentVO.getUid())).equals(1))
            return ResponseVO.buildSucceed("ok",1);
        return userService.studentLogin(studentVO);
    }

    @PostMapping("/api/studentLogin")
    public ResponseVO studentExit(HttpSession httpSession, @RequestBody StudentVO studentVO) {
        httpSession.removeAttribute(String.valueOf(studentVO.getUid()));
        return ResponseVO.buildSucceed("ok",1);
    }

    @PostMapping("/api/student/{uid}")
    public ResponseVO studentLook(@PathVariable String uid) {
        return userService.studentLook(uid);
    }

    @PostMapping("/api/studentFix")
    public ResponseVO studentFix(@RequestBody StudentVO studentVO) {
        return userService.studentFix(studentVO);
    }

    @PostMapping("/api/vendor")
    public ResponseVO studentRegister(@RequestBody VendorVO vendorVO) {
        return userService.vendorRegister(vendorVO);
    }


}
