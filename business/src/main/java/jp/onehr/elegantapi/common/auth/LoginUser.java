package jp.onehr.elegantapi.common.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {

    private Long userId;
    private String account;
    private String device;
    private String loginType;

}
