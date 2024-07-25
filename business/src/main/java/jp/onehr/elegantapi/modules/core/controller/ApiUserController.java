package jp.onehr.elegantapi.modules.core.controller;

import jp.onehr.elegantapi.business.AuthBusiness;
import jp.onehr.elegantapi.modules.core.enums.LoginUserTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class ApiUserController {

    private final AuthBusiness authBusiness;

    @PostMapping("logout")
    public void logout() {
        authBusiness.logout(LoginUserTypeEnum.USER);
    }

    @GetMapping("1")
    public void test1() {

    }

}
