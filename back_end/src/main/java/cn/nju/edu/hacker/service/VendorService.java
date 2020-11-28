package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorVO;

import java.sql.Date;

public interface VendorService {

    ResponseVO register(String name, String passwd, String cellphone, String address, Date beginTime, Date endTime, String description, String photoUrl);

    ResponseVO login(String name, String passwd);

    VendorVO modifyInfo(int vendorId, String name, String cellphone, Date beginTime, Date endTime, String photoUrl);

    void changePasswd(int vendorId, String oldPasswd, String newPasswd);

}
