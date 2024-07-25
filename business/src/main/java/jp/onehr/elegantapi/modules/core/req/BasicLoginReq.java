package jp.onehr.elegantapi.modules.core.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BasicLoginReq {

    /**
     * 账号
     * 【用户名/手机号/邮箱】不能为空。
     */
    @NotBlank(message = "{accountNotBlank}")
    private String account;
    /**
     * 密码
     * 【密码】不能为空。
     */
    @NotBlank(message = "{passwordNotBlank}")
    private String password;
    /**
     * 验证码
     * 【验证码】不能为空。
     */
    @NotBlank(message = "{imageCodeNotBlank}")
    private String imageCode;

    /**
     * 图片验证码token
     * 【图片验证码】参数非法
     */
    @NotBlank(message = "{imageCodeTokenNotBlank}")
    private String imageCodeToken;


}
