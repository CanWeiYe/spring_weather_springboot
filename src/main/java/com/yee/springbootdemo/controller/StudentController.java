package com.yee.springbootdemo.controller;

import com.yee.springbootdemo.entity.Student;
import com.yee.springbootdemo.service.StudentInfoService;
import com.yee.springbootdemo.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentInfoService infoService;

    @GetMapping("/query")
    public Response queryStudents(Student student) {
        List<Student> students= infoService.findStudentByFilter(student);
        return Response.success().setData("items",students);
    }

    @GetMapping("/test")
    public Response test(@RequestHeader("x-token") String token) {
        System.out.println(token);
        return  Response.success();
    }
}
