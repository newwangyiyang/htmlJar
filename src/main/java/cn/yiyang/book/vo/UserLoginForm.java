package cn.yiyang.book.vo;

import cn.yiyang.common.validate.Phone;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/1/6 15:04
 * @Description:
 */
@Data
public class UserLoginForm implements Serializable {
    private static final long serialVersionUID = -707593626103201931L;

    @NotEmpty
    @Phone
    private String user_phone;

    @NotEmpty
    @Length(min = 6, max = 30)
    private String password;
}
