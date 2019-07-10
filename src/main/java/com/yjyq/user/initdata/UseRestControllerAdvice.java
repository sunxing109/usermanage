package com.yjyq.user.initdata;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/** RestControllerAdvice注解的三种使用场景
 * @author sunxingba
 * @version 1.0 $
 */
@RestControllerAdvice
public class UseRestControllerAdvice {

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler
    public static ModelAndView customExecption(Exception e) {
        ModelAndView mView = new ModelAndView();
        mView.addObject("message", e.getMessage());
        mView.setViewName("myerror");
        System.out.println(mView);
        return mView;
    }

    /**
     * 全局数据绑定
     * @return
     */
    @ModelAttribute(name = "md")
    public Map<String, Object> mydata() {
        Map<String, Object> map =  new HashMap<>();
        map.put("age", 90);
        map.put("gender", "女");
        return map;
    }

    /**
     * 全局数据预处理
     * @param binder
     */
    @InitBinder("b")
    public void B(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }

    /**
     * 全局数据预处理
     * @param binder
     */
    @InitBinder("c")
    public void U(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("c.");
    }
}
