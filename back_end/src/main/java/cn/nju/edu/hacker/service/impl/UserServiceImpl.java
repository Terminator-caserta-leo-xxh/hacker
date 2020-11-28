package cn.nju.edu.hacker.service.impl;

import cn.nju.edu.hacker.dao.DishMapper;
import cn.nju.edu.hacker.dao.OrderMapper;
import cn.nju.edu.hacker.dao.StudentMapper;
import cn.nju.edu.hacker.entity.DishEntity;
import cn.nju.edu.hacker.entity.OrderEntity;
import cn.nju.edu.hacker.entity.StudentEntity;
import cn.nju.edu.hacker.form.OrderForm;
import cn.nju.edu.hacker.form.StudentForm;
import cn.nju.edu.hacker.service.UserService;
import cn.nju.edu.hacker.vo.CurrentOrderVO;
import cn.nju.edu.hacker.vo.HistoryOrderVO;
import cn.nju.edu.hacker.vo.ResponseVO;
import cn.nju.edu.hacker.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
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
        return ResponseVO.buildSucceed("注册成功", 0);

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
    public ResponseVO studentLogin(StudentForm studentForm) {
        StudentEntity student = studentMapper.findById(studentForm.getId());
        if (student.getPasswd().equals(studentForm.getPasswd()))
            return ResponseVO.buildSucceed("登陆成功", 0, student);
        else
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
    public ResponseVO getShopHistory(int id) {
        List<OrderEntity> orders = orderMapper.findByStudentIdAndIsValid(id, 0);
        List<HistoryOrderVO> historyOrderVOs = new ArrayList<>();
        for (OrderEntity each : orders
        ) {
            HistoryOrderVO historyOrderVO = new HistoryOrderVO();
            historyOrderVO.setDescription(each.getDescription());
            historyOrderVO.setMoney(each.getMoney());
            historyOrderVO.setRemarks(each.getRemarks());
            List<Integer> dishIds = new ArrayList<>();
            int index;
            String sequence = ',' + each.getSequence();
            while ((index = sequence.lastIndexOf(",")) != -1) {
                DishEntity dish = dishMapper.findById(Integer.parseInt(sequence.substring(index + 1)));
                dishIds.add(dish.getId());
                sequence = sequence.substring(0, index);
            }
            historyOrderVO.setDishId(dishIds);
        }
        Collections.reverse(historyOrderVOs);
        return ResponseVO.buildSucceed("这是历史订单", 0, historyOrderVOs);
    }

    @Override
    public ResponseVO getCurrentOrder(int id) {
        List<OrderEntity> isnPayedOrders = orderMapper.findByStudentIdAndIsValid(id, 0);
        List<OrderEntity> isnCookedOrders = orderMapper.findByStudentIdAndIsValid(id, 1);
        List<OrderEntity> isnGetOrders = orderMapper.findByStudentIdAndIsValid(id, 2);

        isnPayedOrders.addAll(isnCookedOrders);
        isnPayedOrders.addAll(isnGetOrders);

        List<CurrentOrderVO> currentOrderVOS = new ArrayList<>();
        for (OrderEntity each : isnPayedOrders) {
            currentOrderVOS.add(new CurrentOrderVO(each));
        }
        return ResponseVO.buildSucceed("已获得当前订单", 0, currentOrderVOS);
    }

    @Override
    public ResponseVO changeOrder(OrderForm orderForm) {
        OrderEntity entity = orderMapper.findById(orderForm.getId());
        entity.setMoney(orderForm.getMoney());
        entity.setSequence(orderForm.getSequence());
        entity.setRemarks(orderForm.getRemarks());
        entity.setDescription(orderForm.getDescription());
        orderMapper.save(entity);
        return ResponseVO.buildSucceed("修改完成", 0);
    }

}
