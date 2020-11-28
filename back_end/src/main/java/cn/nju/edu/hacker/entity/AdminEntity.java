package cn.nju.edu.hacker.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin")
public class AdminEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "passwd")
    private String passwd;
}
