package cn.nju.edu.hacker.service;

import cn.nju.edu.hacker.form.StudentForm;
import cn.nju.edu.hacker.vo.ResponseVO;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseVO studentRegister(StudentForm studentForm);

    ResponseVO studentFix(StudentForm studentForm);

    ResponseVO studentLogin(StudentForm studentForm);

    ResponseVO studentLook(int id);

    ResponseVO verifyEmail(String email);

    /**
     * @param id 用户的ID
     * @return
     */

    ResponseVO getShopHistory(int id);

    ResponseVO getCurrentOrder(int id);

}
