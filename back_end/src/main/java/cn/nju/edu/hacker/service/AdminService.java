package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.vo.AdminVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorVO;

public interface AdminService {
    AdminVO login(String name, String passwd);

    ResponseVO validate(VendorVO vendor);
}
