package cn.nju.edu.hacker.service;

import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.form.StudentForm;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public interface UserService {

    ResponseVO studentRegister(StudentForm studentForm);

    ResponseVO studentFix(StudentForm studentForm);

    ResponseVO studentLogin(HttpSession httpSession, StudentForm studentForm);

    ResponseVO studentLook(int id);

    ResponseVO verifyEmail(String email);


    ResponseVO studentExit(HttpSession httpSession, int id);
}
