package jp.onehr.elegantapi.modules.core.controller;

import jp.onehr.elegantapi.business.AuthBusiness;
import jp.onehr.elegantapi.modules.core.enums.LoginUserTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class ApiMemberController {

    private final AuthBusiness authBusiness;

    @PostMapping("logout")
    public void logout() {
        authBusiness.logout(LoginUserTypeEnum.MEMBER);
    }

}
