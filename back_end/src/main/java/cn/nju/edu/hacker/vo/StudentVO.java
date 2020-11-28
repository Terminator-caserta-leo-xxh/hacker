package cn.nju.edu.hacker.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentVO {
    private int id;
    private String username;
    private String passwd;
    private String cellphone;
    private String email;
    private int uid;
    private int privilege;
}
