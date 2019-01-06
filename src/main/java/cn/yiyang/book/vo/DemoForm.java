package cn.yiyang.book.vo;

import cn.yiyang.common.validate.Phone;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/1/6 12:50
 * @Description:
 */
@Data
public class DemoForm implements Serializable {
    private static final long serialVersionUID = 5811757295364058113L;

    @NotEmpty
    @Length(min = 2, max = 6)
    private String name;

    @Phone(message = "手机号格式错误")
    private String age;
}
