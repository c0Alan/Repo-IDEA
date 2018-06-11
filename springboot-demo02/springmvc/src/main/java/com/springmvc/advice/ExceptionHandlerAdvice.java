package com.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义控制器建言
 * 通过@ControllerAdvice ，我们可以将对于控制器的全局配置放置在同一个位置
 * 
 * @author liuxilin
 * @date 2018/6/10 23:22
 */
@ControllerAdvice //1
public class ExceptionHandlerAdvice {

    /**
     * 配置异常处理器, 返回异常视图
     * @ExceptionHandler: 用于全局处理控制器里的异常。
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)//2
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");// error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * 配置 ModelAttribute, 给 Model 添加额外消息
     * 使用@ModelAttribute 注解将键值对添加到全局，
     * 所有注解的@RequestMapping的方法可获得此键值对。
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }

    /**
     * 配置WebDataBinder, 忽略 request 参数的id
     * @InitBinder: 用来设置 WebDataBinder ,
     * WebDataBinder 用来自动绑定前台请求参数到Model 中。
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.setDisallowedFields("id");
    }
}
