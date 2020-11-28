package cn.nju.edu.hacker.service;


import cn.nju.edu.hacker.vo.VendorVO;

import java.sql.Date;

public interface VendorService {

    VendorVO register(String name, String passwd, String cellphone, String address, Date beginTime, Date endTime, String photoUrl);

    VendorVO login(String name, String passwd);

    VendorVO modifyInfo(int vendorId, String name, String cellphone, Date beginTime, Date endTime, String photoUrl);

    void changePasswd(int vendorId, String oldPasswd, String newPasswd);

   
}
