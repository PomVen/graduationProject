package com.hallth.controller;

import com.hallth.domain.Student;
import com.hallth.domain.UserLoginInfo;
import com.hallth.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());
    @Resource
    private StudentServiceImpl studentService;

    @RequestMapping("/login")
    public String loginPage(){
//        return "newLogin";
        return "loginPage";
    }
    @RequestMapping("/regit")
    public String regit(){
        return "regit";
    }


    @RequestMapping("/foundPassword")
    private String foundPassword(@RequestParam("loginUserName") String loginUserName, HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("进入foundPassword，param：【loginUserName=" + loginUserName + "】");
        if(loginUserName.trim().isEmpty()){
            loginUserName = "";
        }
        model.addAttribute("loginUserName",loginUserName);
        return "foundPassword";
    }


    /**
     * 登录的用户名密码校验
     * */
    @RequestMapping("/userCheck")
    public String userLoginCheck(@RequestParam("loginUserName")String loginUserName, @RequestParam("loginPassword")String loginPassword, HttpServletResponse response, HttpServletRequest request, Model model){
        logger.info("进入userCheck，开始对登录的用户进行密码校验，param:【loginUserName=" + loginUserName + "; loginPassword=" + loginPassword + "】");
        if(loginUserName.trim().isEmpty()){
            logger.info("用户名为空");
            model.addAttribute("errMsg","用户名不能为空！");
            return "redirect:starLogin";
        }
        if(loginPassword.trim().isEmpty()){
            logger.info("密码为空");
            model.addAttribute("errMsg","密码不能为空！");
            return "redirect:starLogin";
        }
        /**
         * 测试用逻辑
         * */
        if(!loginPassword.trim().isEmpty() && !loginUserName.trim().isEmpty()){
            return "func";
        }
        Student student = new Student();
        student.setStuName(loginUserName);
        student.setStuPassword(loginPassword);
        student = studentService.userCheck(student);
        if(student == null){
            logger.info("用户不存在或密码错误！");
            model.addAttribute("errMsg","用户不存在或密码错误！");
            return "redirect:starLogin";
        }
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setLoginUserName(loginUserName);
        request.getSession().setAttribute("loginUserInfo",userLoginInfo);
        return "func";
    }

    @RequestMapping("/userRegit")
    public String userRegit(@RequestParam("regitUserName")String regitUserName, @RequestParam("regitPassword")String regitPassword,@RequestParam("regitPasswordCheck")String regitPasswordCheck, Model model){
        logger.info("进入userRegit，开始注册用户，param:【loginUserName=" + regitUserName + "; loginPassword=" + regitPassword + "】");
        if(regitUserName.trim().isEmpty()){
            logger.info("用户名为空");
            model.addAttribute("errMsg","用户名不能为空！");
            return "regit";
        }
        if(regitPassword.trim().isEmpty()){
            logger.info("密码为空");
            model.addAttribute("errMsg","密码不能为空！");
            return "regit";
        }
        if(regitPasswordCheck.trim().isEmpty()){
            logger.info("密码为空");
            model.addAttribute("errMsg","密码不能为空！");
            return "regit";
        }

        return "starLogin";
    }
}
