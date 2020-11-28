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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorEntity that = (VendorEntity) o;
        if (id != that.id) return false;
        if (isValid != that.isValid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (passwd != null ? !passwd.equals(that.passwd) : that.passwd != null) return false;
        if (cellphone != null ? !cellphone.equals(that.cellphone) : that.cellphone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passwd != null ? passwd.hashCode() : 0);
        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + isValid;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
