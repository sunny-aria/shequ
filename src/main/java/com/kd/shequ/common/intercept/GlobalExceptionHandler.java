package com.kd.shequ.common.intercept;

import com.kd.shequ.common.entity.ErrorInfo;
import com.kd.shequ.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 *
 * @author sunny
 * @create 2018/6/28 16:26
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW ="error";

    /**
     * 统一异常处理到错误页面
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e)throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 统一异常处理json格式
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,BusinessException e)throws Exception{
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("some data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }



}
