package cn.nju.edu.hacker.form;

import lombok.Data;

@Data
public class AdminPasswdForm {
    
    private String oldPasswd;

    private String newPasswd;
}
