package jp.onehr.elegantapi.common.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="token")
public class UserSession {

    private String token;
    private LoginUser user;

}
