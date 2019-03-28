package com.hallth.controller;

import com.hallth.domain.*;
import com.hallth.service.impl.GraduationThemeServiceImpl;
import com.hallth.service.impl.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());
    @Resource
    private StudentServiceImpl studentService;
    @Resource
    private GraduationThemeServiceImpl graduationThemeService;
    @RequestMapping("/login")
    public String loginPage(){
        return "loginPage";
    }
    @RequestMapping("/regit")
    public String regit(){
        return "regit";
    }


    @RequestMapping("/foundPassword")
    public String foundPassword(){
        return "foundPassword";
    }

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("loginUserInfo");//用户退出登录，删除登录信息
        return "logout";
    }

    @RequestMapping("/teacherIntroduce")
    public String teacherIntroduce(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("loginUserInfo");
        String userName = userLoginInfo.getLoginUserName();
        Student student = new Student();
        student.setStuName(userName);
        student = studentService.quetyByUserName(student);
        String theme = student.getTheme();
//        Teacher teacher = null;
//        if(theme == null || theme.isEmpty()){
//            model.addAttribute("teacherInfo",teacher);
//        } else {
//            GraduationTheme graduationTheme = new GraduationTheme();
//            graduationTheme.setthemeTitle(theme);
//            teacher = graduationThemeService.getTeacherByTheme(graduationTheme);
//            model.addAttribute("teacherInfo",teacher);
//        }
        return "teacherIntroduce";
    }

    @RequestMapping("/themeChose")
    public String themeChose(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("loginUserInfo");
        PageBean<GraduationTheme> pageBean = new PageBean<>();
        pageBean.setLists(null);
        pageBean.setTotalCount(0);
        pageBean.setPageSize(10);
        pageBean.setTotalPage(0);
        pageBean.setCurrPage(1);
        model.addAttribute("pagemsg", pageBean);
        model.addAttribute("count", 0);
        int role = (int)session.getAttribute("role");
        model.addAttribute("role",role);
        return "themeChose";
    }

    @RequestMapping("/themeDescription")
    public String themeDescription(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("loginUserInfo");
        String userName = userLoginInfo.getLoginUserName();
        Student student = new Student();
        student.setStuName(userName);
        student = studentService.quetyByUserName(student);
        String theme = student.getTheme();
        if(null == theme || "".equals(theme)){
            model.addAttribute("theme",null);
        } else {
            GraduationTheme graduationTheme = new GraduationTheme();
            graduationTheme.setthemeTitle(theme);
            graduationTheme = graduationThemeService.queryThemeByTitle(graduationTheme);
//            graduationTheme.setTeacherName(teacherService.selectBySeq(graduationTheme.getthemeTeacher()).getteacherName());
            model.addAttribute("theme",graduationTheme);
        }
        return "themeDescription";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(){
        return "fileUpload";
    }

    @RequestMapping("/themeProgress")
    public String themeProgress(){
        return "themeProgress";
    }

    @RequestMapping("/themeResults")
    public String themeResults(){
        return "themeResults";
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
            return "loginPage";
        }
        if(loginPassword.trim().isEmpty()){
            logger.info("密码为空");
            model.addAttribute("errMsg","密码不能为空！");
            return "loginPage";
        }
        /**
         * 测试用逻辑
         * */
        if(!loginPassword.trim().isEmpty() && !loginUserName.trim().isEmpty()){
            model.addAttribute("loginUser",loginUserName);
            UserLoginInfo userLoginInfo = new UserLoginInfo();
            userLoginInfo.setLoginUserName(loginUserName);
            request.getSession().setAttribute("loginUserInfo",userLoginInfo);
            request.getSession().setAttribute("role",1);
            return "func";
        }
        Student student = new Student();
        student.setStuName(loginUserName);
        student.setStuPassword(loginPassword);
        student = studentService.userCheck(student);
        if(student == null){
//            Teacher teacher = new Teacher();
//            teacher.setteacherId(loginUserName);
//            teacher.setTeacherPassword(loginPassword);
//            teacher = teacherService.userCheck(teacher);
//            if(teacher == null) {
//                logger.info("用户不存在或密码错误！");
//                model.addAttribute("errMsg", "用户不存在或密码错误！");
//                return "loginPage";
//            } else {
//                request.getSession().setAttribute("role",1);
//            }
        } else {
            request.getSession().setAttribute("role",2);
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
        if(!regitPasswordCheck.trim().equals(regitPassword.trim())){
            logger.info("两次密码输入不一致，请重新输入");
            model.addAttribute("errMsg","两次密码输入不一致，请重新输入！");
            return "regit";
        }
        Student student = new Student();
        student.setStuName(regitUserName);
        student = studentService.userCheck(student);
        if(student != null){
            model.addAttribute("errMsg","用户已存在");
            return "regit";
        }
        student = null;
        student.setStuName(regitUserName);
        student.setStuPassword(regitPassword);
        int result = studentService.insert(student);
        if(result == 1){
            return "success";
        } else {
            model.addAttribute("errMsg","注册用户失败，请稍后再试。");
            return "regit";
        }
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(@RequestParam("resetUserName")String resetUserName, @RequestParam("resetPassword")String resetPassword,
                                @RequestParam("resetPasswordCheck")String resetPasswordCheck, @RequestParam("regcode")String regcode,
                                HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("开始重置用户的密码；param:[resetUserName="+ resetUserName +", resetPassword="+ resetPassword + "]");
        if(resetUserName.trim().isEmpty()){
            logger.error("重置密码时用户名为空");
            model.addAttribute("errMsg","用户名不能为空");
            return "foundPassword";
        }
        if(resetPassword.trim().isEmpty()){
            logger.error("重置密码时新密码为空");
            model.addAttribute("errMsg","新密码不能为空");
            return "foundPassword";
        }
        if(resetPasswordCheck.trim().isEmpty()){
            logger.error("重置密码时新密码为空");
            model.addAttribute("errMsg","新密码不能为空");
            return "foundPassword";
        }
        if(resetPasswordCheck.trim().equals(resetPassword.trim())){
            logger.error("两次密码输入不一致");
            model.addAttribute("errMsg","两次密码输入不一致，请重新输入");
            return "foundPassword";
        }
        Student student = new Student();
        student.setStuName(resetUserName);
        student = studentService.userCheck(student);
        if(student == null){
            model.addAttribute("errMsg","该用户不存在");
            return "foundPassword";
        }
        student.setStuPassword(resetPassword);
        int result = studentService.updateStudent(student);
        if(result == 1){
            return "loginPage";
        } else {
            model.addAttribute("errMsg","重置密码时发生异常，请重试");
            return "foundPassword";
        }
    }

    @RequestMapping("/queryTheme")
    @ResponseBody
    public Map queryTheme(@RequestParam("teacherName")String teacherName, @RequestParam("themeTitle")String themeTitle,
                          HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("查询课题");
        GraduationTheme graduationTheme = new GraduationTheme();
        List<Integer> teacherSeqList = new ArrayList<Integer>();
        if(null != teacherName && !"".equals(teacherName.trim())){
//            teacherSeqList = teacherService.selectByNameFuzzyQuery(teacherName);
        }
        if(null != themeTitle && !"".equals(themeTitle.trim())){
            graduationTheme.setthemeTitle(themeTitle);
        }
        String seqStr = "";
        if(teacherSeqList.size() > 0){
            for(Integer seq : teacherSeqList){
                seqStr = seqStr + seq + ",";
            }
            seqStr = seqStr + "";
            graduationTheme.setTeacherName(seqStr);
        }
        PageBean<GraduationTheme> pageBean = graduationThemeService.selectByTeacherAndTitle(graduationTheme);
        pageBean.setCurrPage(1);
        pageBean.setTotalPage(1);
        pageBean.setPageSize(10);
        List<GraduationTheme> data = pageBean.getLists();
        Map map = new HashMap();
        map.put("rows",data);
        map.put("total",20);
        return map;
    }

    @RequestMapping("choseTheme")
    public boolean choseTheme(@RequestParam("themeTitle")String title, HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("loginUserInfo");
        String userName = userLoginInfo.getLoginUserName();
        Student student = new Student();
        student.setStuName(userName);
        student.setTheme(title);
        boolean bool = studentService.updateByStudentName(student);
        return bool;
    }

}
