package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.VendorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Integer uid;

    private int isValid;

    private int isOpen;

    private String description;

    private String address;

    public VendorVO(VendorEntity entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.passwd = entity.getPasswd();
        this.cellphone = entity.getCellphone();
        this.email = entity.getEmail();
        this.uid = entity.getUid();
        this.isValid = entity.getIsValid();
        this.description = entity.getDescription();
        this.address = entity.getDescription();
    }
}
