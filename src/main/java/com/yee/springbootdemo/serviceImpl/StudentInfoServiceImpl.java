package com.yee.springbootdemo.serviceImpl;

import com.yee.springbootdemo.dao.StudentMapper;
import com.yee.springbootdemo.entity.Student;
import com.yee.springbootdemo.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentMapper infoMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
   // @Cacheable(key = "'StudentInfoServiceImpl.'+'findAllStudent'",value = "MyCache_Expire_120",unless = "#result == null")
    public List<Student> findStudentByFilter(Student student) {
        return infoMapper.selectByFilter(student);
    }

  //  @CacheEvict(key = "'StudentInfoServiceImpl.'+'findAllStudent'",value = "MyCache_Expire_120")
    public boolean insertStudent(){
        return true;
    }
}
