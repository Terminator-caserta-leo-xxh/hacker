package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.StudentMapper;
import cn.nju.edu.hacker.entity.StudentEntity;
import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import cn.nju.edu.hacker.vo.VendorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public ResponseVO studentRegister(StudentVO studentVO) {
        List<StudentEntity> usernameList = studentMapper.findAllByUsername(studentVO.getUsername());
        if (usernameList.size() != 0)
            return ResponseVO.buildFailed("该用户名已存在");
        List<StudentEntity> cellphoneList = studentMapper.findAllByCellphone(studentVO.getCellphone());
        if (cellphoneList.size() != 0)
            return ResponseVO.buildFailed("该手机号已被绑定");

        StudentEntity student = new StudentEntity();
        int uid = studentMapper.findAll().get(studentMapper.findAll().size()).getUid() + 1;
        student.setUid(uid);
        student.setPasswd(studentVO.getPasswd());
        student.setUsername(studentVO.getUsername());
        student.setEmail(studentVO.getEmail());
        studentMapper.save(student);
        return ResponseVO.buildSucceed("UID:" + String.valueOf(uid));

    }

    @Override
    public ResponseVO studentFix(StudentVO studentVO) {
        StudentEntity student = studentMapper.findByUid(studentVO.getUid());
        boolean flag = false;
        if (studentVO.getUsername() != null) {
            student.setUsername(studentVO.getUsername());
            flag = true;
        }
        if (studentVO.getPasswd() != null) {
            student.setPasswd(studentVO.getPasswd());
            flag = true;
        }
        if (studentVO.getEmail() != null) {
            student.setEmail(studentVO.getEmail());
            flag = true;
        }
        if (flag) {
            studentMapper.save(student);
            return ResponseVO.buildSucceed("修改成功");
        } else
            return ResponseVO.buildFailed("修改失败");
    }

    @Override
    public ResponseVO studentLogin(StudentVO studentVO) {
        StudentEntity student = studentMapper.findByUid(studentVO.getUid());
        if (student.getPasswd().equals(studentVO.getPasswd()))
            return ResponseVO.buildSucceed("登陆成功", student);
        else
            return ResponseVO.buildFailed("密码错误");
    }

    @Override
    public ResponseVO studentLook(String uid) {
        int UID = Integer.parseInt(uid);
        StudentEntity student = studentMapper.findByUid(UID);
        return ResponseVO.buildSucceed("" + student);
    }

    @Override
    public ResponseVO verifyEmail(String email) {
        return null;
    }


    @Override
    public ResponseVO vendorRegister(VendorVO vendorVO) {
        return null;
    }


}
