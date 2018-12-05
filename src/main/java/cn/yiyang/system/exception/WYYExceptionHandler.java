package cn.yiyang.system.exception;

import cn.yiyang.common.utils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Administrator
 * @Date: 2018/10/13 14:13
 * @Description:
 */

@ControllerAdvice
public class WYYExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(WYYException.class)
    @ResponseBody
    public ResultBean handleBDException(WYYException e) {
        logger.error(e.getMessage(), e);
        return ResultBean.exception(500, e.getMsg());
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
        logger.error(e.getMessage(), e);
        logger.error("出错请求地址: {}", request.getRequestURL());
        return ResultBean.exception(500, e.getMessage());
    }
}
