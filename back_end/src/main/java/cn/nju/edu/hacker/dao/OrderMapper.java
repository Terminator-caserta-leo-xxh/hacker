package cn.nju.edu.hacker.dao;

import cn.nju.edu.hacker.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderMapper extends CrudRepository<OrderEntity, Integer> {
    
    List<OrderEntity> findByVendorId(int vendorId);

    List<OrderEntity> findByStudentId(int studentId);

    List<OrderEntity> findByStudentIdAndIsValid(int studentId, Integer isValid);
}
