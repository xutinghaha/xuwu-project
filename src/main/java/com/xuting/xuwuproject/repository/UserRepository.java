package com.xuting.xuwuproject.repository;

import com.xuting.xuwuproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description TODO
 * @Author xuting
 * @Date 2019/1/4
 **/
public interface UserRepository  extends JpaRepository<User,Long>{


}
