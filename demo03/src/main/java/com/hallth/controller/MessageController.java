package com.hallth.controller;

import com.hallth.domain.Student;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/message")
public class MessageController {

    private static Logger logger = Logger.getLogger(MessageController.class.getName());

    @RequestMapping("/go")
    public String go(){
        logger.info("转向go.jsp");
        return "go";
    }

    @RequestMapping("/searchUserDetail/{data}")
    public String userDetail(Model model, @PathVariable("data")String data){
        Student student = new Student();
        student.setStuName("hanyu");
        student.setStuCode("hanyu's Code");
        student.setStuAge(23);
        student.setStuClassNum("hanyu's classNum");
        student.setStuGender("男");
        model.addAttribute("student",student);
        return "studentDetail";
    }
}
