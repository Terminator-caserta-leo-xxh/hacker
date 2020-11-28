package cn.nju.edu.hacker.service;

import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseVO studentRegister(StudentVO studentVO);

    ResponseVO studentFix(StudentVO studentVO);

    ResponseVO studentLogin(StudentVO studentVO);

    ResponseVO studentLook(String uid);

    ResponseVO vendorRegister(VendorVO vendorVO);

    ResponseVO verifyEmail(String email);

}
