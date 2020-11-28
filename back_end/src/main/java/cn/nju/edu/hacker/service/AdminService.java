package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.vo.ResponseVO;

public interface AdminService {
    ResponseVO login(String name, String passwd);

    ResponseVO validate(int vendorId);

    ResponseVO updatePasswd(int id, String oldPwd, String newPwd);

    ResponseVO allRequests();
}
