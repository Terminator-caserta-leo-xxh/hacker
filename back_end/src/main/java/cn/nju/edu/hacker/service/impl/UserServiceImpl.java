package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.DishMapper;
import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.dao.StudentMapper;
import cn.nju.edu.hacker.entity.StudentEntity;
import cn.nju.edu.hacker.form.StudentForm;
import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    DishMapper dishMapper;

    @Override
    public ResponseVO studentRegister(StudentForm studentForm) {
        List<StudentEntity> usernameList = studentMapper.findAllByUsername(studentForm.getUsername());
        if (usernameList.size() != 0)
            return ResponseVO.buildFailed("该用户名已存在", -1);
        List<StudentEntity> cellphoneList = studentMapper.findAllByCellphone(studentForm.getCellphone());
        if (cellphoneList.size() != 0)
            return ResponseVO.buildFailed("该手机号已被绑定", -1);

        StudentEntity student = new StudentEntity();
        student.setPasswd(studentForm.getPasswd());
        student.setUsername(studentForm.getUsername());
        student.setEmail(studentForm.getEmail());
        studentMapper.save(student);
        student = studentMapper.findByUsername(studentForm.getUsername());
        return ResponseVO.buildSucceed("注册成功", 0, new StudentVO(student));

    }

    @Override
    public ResponseVO studentFix(StudentForm studentForm) {
        StudentEntity student = studentMapper.findById(studentForm.getId());
        boolean flag = false;
        if (studentForm.getUsername() != null) {
            student.setUsername(studentForm.getUsername());
            flag = true;
        }
        if (studentForm.getPasswd() != null) {
            student.setPasswd(studentForm.getPasswd());
            flag = true;
        }
        if (studentForm.getEmail() != null) {
            student.setEmail(studentForm.getEmail());
            flag = true;
        }
        if (flag) {
            studentMapper.save(student);
            return ResponseVO.buildSucceed("修改成功", 0);
        } else
            return ResponseVO.buildFailed("修改失败", -1);
    }

    @Override
    public ResponseVO studentLogin(HttpSession httpSession, StudentForm studentForm) {
        StudentEntity student = studentMapper.findByUsername(studentForm.getUsername());
        if (student.getPasswd().equals(studentForm.getPasswd())) {
            httpSession.setAttribute(String.valueOf(student.getUsername()), 1);
            httpSession.setAttribute(String.valueOf(student.getId()), 1);
            return ResponseVO.buildSucceed("登陆成功", 0, new StudentVO(student));
        } else
            return ResponseVO.buildFailed("密码错误", -1);
    }

    @Override
    public ResponseVO studentLook(int id) {
        StudentEntity student = studentMapper.findById(id);
        StudentVO studentVO = new StudentVO(student);
        return ResponseVO.buildSucceed("" + studentVO, 0);
    }

    //TODO 发送邮件等待验证
    @Override
    public ResponseVO verifyEmail(String email) {
        return null;
    }

    @Override
    public ResponseVO studentExit(HttpSession httpSession, int id) {
        StudentEntity student = studentMapper.findById(id);
        httpSession.removeAttribute(String.valueOf(id));
        httpSession.removeAttribute(String.valueOf(student.getUsername()));
        if (httpSession.getAttribute(String.valueOf(id)) != null || httpSession.getAttribute(String.valueOf(student.getUsername())) != null)
            return ResponseVO.buildFailed("登出失败", -1);
        else
            return ResponseVO.buildFailed("登出成功", 0);
    }


}
