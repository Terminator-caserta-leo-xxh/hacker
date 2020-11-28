package cn.nju.edu.hacker.dao;

import cn.nju.edu.hacker.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminMapper extends CrudRepository<AdminEntity, Integer> {
    AdminEntity findByNameAndPasswd(String name, String passwd);

    AdminEntity findById(int id);
}
