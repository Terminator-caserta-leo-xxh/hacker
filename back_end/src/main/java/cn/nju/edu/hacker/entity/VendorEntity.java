package cn.nju.edu.hacker.entity;

import lombok.Data;

import javax.persistence.*;


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
    @Column(name = "UID")
    private Integer uid;

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

}
