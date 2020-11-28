package cn.nju.edu.hacker.form;

import lombok.Data;

import java.sql.Date;

@Data
public class VendorForm {

    public String name;

    public String passwd;

    public String address;

    public String cellphone;

    public Date beginTime;

    public Date endTime;

    public String locationPhotoUrl;

}
