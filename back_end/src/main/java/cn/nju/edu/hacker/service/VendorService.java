package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.vo.ResponseVO;

import java.sql.Date;

public interface VendorService {

    ResponseVO register(String name, String passwd, String cellphone, String address, String email, Date beginTime, Date endTime, String description, String photoUrl);

    ResponseVO login(String name, String passwd);

    ResponseVO modifyInfo(int vendorId, String name, String cellphone, String email, Date beginTime, Date endTime, String description, String photoUrl);

    ResponseVO changePasswd(int vendorId, String oldPasswd, String newPasswd);

    ResponseVO delete(int vendorId);

    ResponseVO list();

    ResponseVO find(int id);

    ResponseVO find(String name);

    ResponseVO openOrClose(int id);

}
