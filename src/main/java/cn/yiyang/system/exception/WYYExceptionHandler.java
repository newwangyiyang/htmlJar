package cn.yiyang.system.exception;

import cn.yiyang.common.utils.ResultBean;
import cn.yiyang.common.utils.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 14:13
 * @Description: 全局捕获异常处理
 */
@RestControllerAdvice
@Slf4j
public class WYYExceptionHandler {

    /**
     * 自定义异常处理 WYYException
     * @param e
     * @return
     */
    @ExceptionHandler(WYYException.class)
    public ResultBean handleWYYException(WYYException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.ERROR.getCode(), e.getMsg(), request.getRequestURI());
    }


    /**
     * 接口未找到
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultBean handleNoHandlerFoundException(NoHandlerFoundException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.NOTFOUND, request.getRequestURI());
    }

    /**
     * 不支持请求方法GET/POST
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultBean<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.NOTALLOW, request.getRequestURI());
    }

    /**
     * 请求参数错误 application/json
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultBean<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.ERRORPARAMATERS.getCode(), e.getBindingResult().getFieldError().getDefaultMessage(), request.getRequestURI());
    }
    /**
     * 请求参数错误 form表单形式
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultBean<String> handleBindException(ConstraintViolationException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.ERRORPARAMATERS.getCode(), e.getMessage(), request.getRequestURI());
    }

    /**
     * 捕获token shiro异常处理
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(ShiroException.class)
    public ResultBean handleShiroException(ShiroException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.NOTTOKEN, request.getRequestURI());
    }


    /**
     * 请求参数错误
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResultBean handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.ERRORPARAMATERS, request.getRequestURI());
    }

    /**
     * ServletException 异常处理
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(ServletException.class)
    public ResultBean handleServletException(ServletException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.EXCEPTION, request.getRequestURI());
    }


    /**
     * @Author Administrator
     * @Description 处理全局异常，统一返回json格式的数据
     * @Date 14:16 2018/11/30
     * @Param
     * @return
     **/
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultBean handleException(Exception e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResultBean.error(ResultEnum.EXCEPTION, request.getRequestURI());
    }
}