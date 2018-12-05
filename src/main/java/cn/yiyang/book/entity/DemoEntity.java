package cn.yiyang.book.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    @JsonProperty("name")
    private String demoName;

    private Integer demoAge;
}
