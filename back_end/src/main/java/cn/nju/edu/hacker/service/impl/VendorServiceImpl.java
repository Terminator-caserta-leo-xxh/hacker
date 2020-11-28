package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.VendorMapper;
import cn.nju.edu.hacker.entity.VendorEntity;
import cn.nju.edu.hacker.service.VendorService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorMapper vendorMapper;

    @Override
    public ResponseVO register(String name, String passwd,
                               String cellphone, String address,
                               Date beginTime, Date endTime,
                               String description, String photoUrl) {
        if (vendorMapper.findByUsername(name) != null) return ResponseVO.buildFailed("用户名已存在", -1);
        if (vendorMapper.findByCellphone(cellphone) != null) return ResponseVO.buildFailed("该手机号已被绑定", -1);
        if (vendorMapper.findByAddress(address) != null) return ResponseVO.buildFailed("该地址已经注册", -1);

        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setUsername(name);
        vendorEntity.setAddress(address);
        vendorEntity.setPasswd(passwd);
        vendorEntity.setCellphone(cellphone);
        vendorEntity.setDescription(description);
        vendorEntity.setLocationUrl(photoUrl);
        /**
         * 0表示invalid，1表示valid
         */
        vendorEntity.setIsValid(0);
        vendorEntity.setIsOpen(0);
        VendorEntity vendor = vendorMapper.save(vendorEntity);

        return ResponseVO.buildSucceed("注册申请提交成功，请等待管理员审核！", 0, vendor);
    }

    @Override
    public ResponseVO login(String name, String passwd) {
        VendorEntity vendorEntity = vendorMapper.findByUsernameAndPasswd(name, passwd);
        if (vendorEntity == null) return ResponseVO.buildFailed("未注册或密码不正确！", -1);
        return ResponseVO.buildSucceed("登录成功！", 0, vendorEntity);
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
