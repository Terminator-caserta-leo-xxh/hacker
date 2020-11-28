package cn.nju.edu.hacker.form;

import lombok.Data;

import java.sql.Date;

@Data
public class VendorForm {

    private String name;

    private String passwd;

    private String address;

    private String cellphone;

    private Date beginTime;

    private Date endTime;

    private String locationPhotoUrl;

    private String description;

    private String email;

}
