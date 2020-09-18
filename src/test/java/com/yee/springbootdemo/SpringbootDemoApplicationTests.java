package com.yee.springbootdemo;

import com.yee.springbootdemo.service.StudentInfoService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.yee.springbootdemo.dao")
@EnableCaching
@SpringBootTest
class SpringbootDemoApplicationTests {

    private static final Logger logger= LoggerFactory.getLogger(SpringbootDemoApplicationTests.class);

    @Autowired
    private StudentInfoService infoService;

    @Test
    void contextLoads() {

    }
    @Test
    void testFindAllStudent(){

    }

    @Test
    public void testCache(){

       infoService.insertStudent();
    }
}
