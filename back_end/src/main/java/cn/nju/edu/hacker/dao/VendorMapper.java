package cn.nju.edu.hacker.dao;

import cn.nju.edu.hacker.entity.VendorEntity;
import org.springframework.data.repository.CrudRepository;

public interface VendorMapper extends CrudRepository<VendorEntity, Integer> {

    VendorEntity findById(int id);

    VendorEntity findByUsername(String username);

    VendorEntity findByCellphone(String cellphone);

    VendorEntity findByAddress(String address);

    VendorEntity findByUsernameAndPasswd(String name, String passwd);
}