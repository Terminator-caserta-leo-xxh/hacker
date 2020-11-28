package cn.nju.edu.hacker.service;

import cn.nju.edu.hacker.dao.StudentMapper;
import cn.nju.edu.hacker.dao.VendorMapper;
import cn.nju.edu.hacker.entity.StudentEntity;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final StudentMapper studentMapper;

    private final VendorMapper vendorMapper;

    @Autowired
    public UserService( StudentMapper studentMapper, VendorMapper vendorMapper) {
        this.studentMapper = studentMapper;
        this.vendorMapper = vendorMapper;
    }

    public ResponseVO studentRegister(StudentVO studentVO){
        List<StudentEntity> usernameList=studentMapper.findAllByUsername(studentVO.getUsername());
        if (usernameList.size()!=0)
            return ResponseVO.buildFailed("该用户名已存在");
        List<StudentEntity> cellphoneList=studentMapper.findAllByCellphone(studentVO.getCellphone());
        if (cellphoneList.size()!=0)
            return ResponseVO.buildFailed("该手机号已被绑定");
        return null;
    }

    public ResponseVO vendorRegister(VendorVO vendorVO) {
        return null;
    }
}
