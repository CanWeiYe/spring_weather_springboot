package com.yee.springbootdemo.service;

import com.yee.springbootdemo.entity.Student;

import java.util.List;

public interface StudentInfoService {
    List<Student> findStudentByFilter(Student student);

    boolean insertStudent();
}
