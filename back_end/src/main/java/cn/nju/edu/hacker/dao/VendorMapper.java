package cn.nju.edu.hacker.dao;

import cn.nju.edu.hacker.entity.VendorEntity;
import org.springframework.data.repository.CrudRepository;

public interface VendorMapper extends CrudRepository<VendorEntity, Integer> {

    VendorEntity findByUid(int uid);

    VendorEntity findByUsername(String username);

    VendorEntity findByCellphone(String cellphone);

    VendorEntity findByAddress(String address);
}