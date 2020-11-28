package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.StudentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {
    private int id;
    private String username;
    //private String passwd;
    private String cellphone;
    private String email;

    public StudentVO(StudentEntity entity) {
        id = entity.getId();
        username = entity.getUsername();
        cellphone = entity.getCellphone();
        email = entity.getEmail();
    }
}
