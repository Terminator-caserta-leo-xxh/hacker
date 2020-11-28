package cn.nju.edu.hacker.vo;

import cn.nju.edu.hacker.entity.AdminEntity;
import lombok.Data;

@Data
public class AdminVO {

    private int id;

    private String name;

    private String passwd;

    public AdminVO(AdminEntity adminEntity) {
        this.id = adminEntity.getId();
        this.name = adminEntity.getName();
        this.passwd = adminEntity.getPasswd();
    }

}
