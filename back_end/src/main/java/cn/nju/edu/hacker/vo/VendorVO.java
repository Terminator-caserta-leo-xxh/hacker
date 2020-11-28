package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.VendorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendorVO {

    private int id;

    private String username;

    private String passwd;

    private String cellphone;

    private String email;

    private int isValid;

    private int isOpen;

    private String description;

    private String address;

    private Date beginTime;

    private Date endTime;

    public VendorVO(VendorEntity entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.passwd = entity.getPasswd();
        this.cellphone = entity.getCellphone();
        this.email = entity.getEmail();
        this.isValid = entity.getIsValid();
        this.description = entity.getDescription();
        this.address = entity.getDescription();
        this.beginTime = entity.getBeginTime();
        this.endTime = entity.getEndTime();
    }
}
