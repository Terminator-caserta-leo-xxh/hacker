package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.AdminMapper;
import cn.nju.edu.hacker.dao.VendorMapper;
import cn.nju.edu.hacker.entity.AdminEntity;
import cn.nju.edu.hacker.entity.VendorEntity;
import cn.nju.edu.hacker.service.AdminService;
import cn.nju.edu.hacker.vo.AdminVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorListVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private VendorMapper vendorMapper;

    @Override

    public ResponseVO login(String name, String passwd) {
        AdminEntity adminEntity = adminMapper.findByNameAndPasswd(name, passwd);
        if (adminEntity == null) return ResponseVO.buildFailed("管理员用户不存在或密码不正确！", -1);
        return ResponseVO.buildSucceed("登录成功！", 0, new AdminVO(adminEntity));
    }

    @Override
    public ResponseVO validate(int vendorId) {
        VendorEntity vendorEntity = vendorMapper.findById(vendorId);
        vendorEntity.setIsValid(1);
        vendorMapper.save(vendorEntity);
        return ResponseVO.buildSucceed("验证通过！", 0);
    }

    @Override
    public ResponseVO updatePasswd(int id, String oldPwd, String newPwd) {
        AdminEntity adminEntity = adminMapper.findById(id);
        if (adminEntity == null) return ResponseVO.buildFailed("管理员用户不存在！", -1);
        if (!adminEntity.getPasswd().equals(oldPwd)) return ResponseVO.buildFailed("原密码错误！", -1);
        adminEntity.setPasswd(newPwd);
        adminMapper.save(adminEntity);
        return ResponseVO.buildSucceed("密码修改成功！", 0);
    }

    @Override
    public ResponseVO allRequests() {
        List<VendorVO> res = new ArrayList<>();
        IteratorUtils
                .toList(vendorMapper.findAll().iterator())
                .stream()
                .filter(a -> a.getIsOpen() == 0)
                .forEach(a -> res.add(new VendorVO(a)));
        VendorListVO vendorListVO = new VendorListVO();
        vendorListVO.setList(res);
        return ResponseVO.buildSucceed("查询成功！", 0, vendorListVO);
    }
}
