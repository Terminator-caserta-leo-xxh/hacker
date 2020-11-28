package cn.nju.edu.hacker.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name = "vendor")
public class VendorEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "passwd")
    private String passwd;

    @Basic
    @Column(name = "cellphone")
    private String cellphone;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "isValid")
    private int isValid;

    @Basic
    @Column(name = "isOpen")
    private int isOpen;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "locationUrl")
    private String locationUrl;

    @Basic
    @Column(name = "beginTime")
    private Date beginTime;

    @Basic
    @Column(name = "endTime")
    private Date endTime;

}
