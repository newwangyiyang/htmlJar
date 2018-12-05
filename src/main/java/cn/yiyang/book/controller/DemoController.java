package cn.yiyang.book.controller;

import cn.yiyang.book.entity.DemoEntity;
import cn.yiyang.common.utils.ResultBean;
import cn.yiyang.system.exception.WYYException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/30 12:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @RequestMapping(value = "/getDemo", method = RequestMethod.GET)
    private ResultBean getDemo() {
        DemoEntity entity = new DemoEntity();
        return ResultBean.success(entity);
    }
    @RequestMapping(value = "/saveDemo", method = { RequestMethod.POST })
    private ResultBean saveDemo(@RequestBody DemoEntity demo) {
        log.info(demo.toString());
        throw new WYYException("服务器错误");
//        return ResultBean.success(demo);
    }
}
