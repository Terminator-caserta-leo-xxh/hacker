package cn.nju.edu.hacker.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorVO {
    private int id;
    private String username;
    private String passwd;
    private String cellphone;
    private String email;
    private Integer uid;
    private int privilege;
    private int isValid;
    private String description;
    private String address;
}
