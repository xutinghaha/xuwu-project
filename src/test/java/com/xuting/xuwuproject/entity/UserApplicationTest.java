package com.xuting.xuwuproject.entity;

import com.xuting.xuwuproject.XuwuProjectApplicationTests;
import com.xuting.xuwuproject.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @Description 单侧
 * @Author xuting
 * @Date 2019/1/4
 **/

public class UserApplicationTest extends XuwuProjectApplicationTests{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOneTest() {
        Optional<User> optional = userRepository.findById(1L);
        if(optional != null ) {
            User user = optional.get();
            Assert.assertEquals("wali",user.getName());
        }
    }
}
