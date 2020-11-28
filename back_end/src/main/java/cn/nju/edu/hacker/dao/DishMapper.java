package cn.nju.edu.hacker.dao;

import cn.nju.edu.hacker.entity.DishEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishMapper extends CrudRepository<DishEntity, Integer> {
    List<DishEntity> findByUid(int uid);
}
