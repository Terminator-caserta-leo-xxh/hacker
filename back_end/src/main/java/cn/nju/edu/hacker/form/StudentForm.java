package cn.nju.edu.hacker.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentForm {
    private int id;
    private String username;
    private String passwd;
    private String cellphone;
    private String email;
    private int privilege;
}
