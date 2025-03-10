package com.admin.interceptor;

import com.admin.common.CommonResult;
import com.admin.util.JWTUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在处理Handler之前执行
        // 返回true可以执行对应Handler   返回false则执行不到handler
        //return true/false是springmvc中的运行路线需求   不是回应给浏览器的

        //验证每个请求是否是登陆状态
        //token在http的header中   叫Authorization
        System.out.println("请求方式:"+request.getMethod());
        System.out.println("请求路径:"+request.getRequestURI());
        String token = request.getHeader("Authorization");
        if (token != null && JWTUtil.verifyToken(token)) {
            //有token token有效 有登陆状态
            System.out.println("token有效，放行");
            return true;
        } else {
            System.out.println("无token，或token无效，拦截");
            //要回应的数据
            CommonResult result = CommonResult.fail(400, "未登录");
            //将数据解析成json
            String json = JSON.toJSONString(result);
            System.out.println("转换为json后的响应内容:"+json);
            //将数据回应
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
