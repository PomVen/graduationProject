package com.hallth.interceptor;

import com.hallth.domain.UserLoginInfo;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器，用于拦截前台的登录
 * @author hallth
 * 要在spring-mvc中配置拦截器<mvc:interceptor>
 **/
public class LoginInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(LoginInterceptor.class.getName());

    /**
     * 先执行的方法
     * return false表示拦截，不向下执行
     * return true表示放行
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        boolean flag = true;
        logger.info("进入了preHandle。。。。。。");
        logger.info("在这里进行判断是否程序继续进行，或者做其他的操作。。。。。。");
        logger.info("getServletPath = "+request.getServletPath());

        //从session中获取对象
        UserLoginInfo userLoginInfo = (UserLoginInfo) request.getSession().getAttribute("loginUserInfo");
        if (userLoginInfo != null)
            System.out.println("输出对象==========="+ userLoginInfo.toString());
        else
            System.out.println("没有登陆对象");
        //获取请求资源
        String requestURI = request.getRequestURI();
        logger.info("requestURI========="+requestURI);

        //穿透地址
        final String[] IGNORE_URI ={"/login","/index","/dengmi"};

        //判断是否是登陆或注册请求
        for (String preURI : IGNORE_URI) {
            //设定前台需要拦截登录的相反结果集
            if(requestURI.startsWith(preURI)){
                logger.info("不拦截的页面******************"+preURI);
                flag =false;
            }
        }
        if(flag){
            if(userLoginInfo==null){
                //重定向
                String loginUrl = "/login/login";
                logger.info("用户尚未登陆，已经将请求["+requestURI+"]进行拦截");
                response.sendRedirect(request.getContextPath() + loginUrl);
                logger.info("重定向========="+request.getContextPath() + loginUrl);
                return false;
            }
        }
        return true;
    }

    //返回ModelAndView之前执行的方法，面向切面编程中的体现，已经进入了controller
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("进入了postHandle。。。。。。");
    }

    //执行Handle完成之后执行的方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("进入了afterHandle。。。。。。");
    }
}
