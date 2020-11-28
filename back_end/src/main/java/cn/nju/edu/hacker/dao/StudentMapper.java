package cn.nju.edu.hacker.dao;

import cn.nju.edu.hacker.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentMapper extends CrudRepository<StudentEntity, Integer> {

    List<StudentEntity> findAllByUsername(String username);

    List<StudentEntity> findAllByCellphone(String cellphone);

    List<StudentEntity> findAll();

    StudentEntity findById(int id);

    StudentEntity findByUsername(String username);
}
