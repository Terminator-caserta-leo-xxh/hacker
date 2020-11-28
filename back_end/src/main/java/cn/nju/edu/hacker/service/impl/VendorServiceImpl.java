package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.service.VendorService;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class VendorServiceImpl implements VendorService {

    @Override
    public VendorVO register(String name, String passwd,
                             String cellphone, String address,
                             Date beginTime, Date endTime,
                             String photoUrl) {
        return null;
    }

    @Override
    public VendorVO login(String name, String passwd) {
        return null;
    }

    @Override
    public VendorVO modifyInfo(int vendorId, String name,
                               String cellphone, Date beginTime, Date endTime,
                               String photoUrl) {
        return null;
    }

    @Override
    public void changePasswd(int vendorId, String oldPasswd, String newPasswd) {

    }

}
