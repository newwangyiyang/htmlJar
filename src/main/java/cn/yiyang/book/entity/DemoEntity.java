package cn.yiyang.book.entity;

import cn.yiyang.common.validate.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName DemoEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2018/11/30 12:48
 * @Version 1.0
 **/
@Data
@JsonIgnoreProperties(value = {"demoAge"}, allowGetters = true)
public class DemoEntity {
    private String demoName;

    private Integer demoAge;
}
