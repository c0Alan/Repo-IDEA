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
 * 自定义建言
 * 
 * @author liuxilin
 * @date 2018/6/10 23:22
 */
@ControllerAdvice //1
public class ExceptionHandlerAdvice {

    /**
     * 配置异常处理器, 返回异常视图
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
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }

    /**
     * 配置WebDataBinder, 屏蔽 id 字段
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }
}
