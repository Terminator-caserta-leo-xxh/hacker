package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.service.AdminService;
import cn.nju.edu.hacker.vo.AdminVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public AdminVO login(String name, String passwd) {
        return null;
    }

    @Override
    public ResponseVO validate(VendorVO vendor) {
        return null;
    }
}
