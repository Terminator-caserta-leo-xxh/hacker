package cn.nju.edu.hacker.controller;

import cn.nju.edu.hacker.form.AdminForm;
import cn.nju.edu.hacker.form.AdminPasswdForm;
import cn.nju.edu.hacker.service.AdminService;
import cn.nju.edu.hacker.service.VendorService;
import cn.nju.edu.hacker.vo.AdminVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private VendorService vendorService;

    @PostMapping("/login/status")
    public ResponseVO login(HttpSession httpSession, @RequestBody AdminForm adminForm) {
        if (httpSession.getAttribute("adminName") != null) return ResponseVO.buildSucceed("您已登录！", 1);
        String name = adminForm.getName();
        String passwd = adminForm.getPasswd();
        ResponseVO responseVO = adminService.login(name, passwd);
        if (!responseVO.isSuccess()) return responseVO;
        AdminVO adminVO = (AdminVO) responseVO.getData();
        httpSession.setAttribute("adminName", name);
        httpSession.setAttribute("adminId", adminVO.getId());
        return responseVO;
    }

    @PostMapping("/passwd")
    public ResponseVO modifyAdminPwd(HttpSession httpSession, @RequestBody AdminPasswdForm adminPasswdForm) {
        if (httpSession.getAttribute("adminName") == null) return ResponseVO.buildFailed("请先登录！", -1);
        String oldPwd = adminPasswdForm.getOldPasswd();
        String newPwd = adminPasswdForm.getNewPasswd();
        return adminService.updatePasswd((int) httpSession.getAttribute("adminId"), oldPwd, newPwd);
    }

    @GetMapping("/registerRequests")
    public ResponseVO getRegister(HttpSession httpSession) {
        if (httpSession.getAttribute("adminName") == null) return ResponseVO.buildFailed("请先登录！", -1);
        return adminService.allRequests();
    }

    @PostMapping("/{id}/passRegister")
    public ResponseVO passRegister(HttpSession httpSession, @PathVariable(value = "id") int id) {
        if (httpSession.getAttribute("adminName") == null) return ResponseVO.buildFailed("请先登录！", -1);
        return adminService.validate(id);
    }
}
