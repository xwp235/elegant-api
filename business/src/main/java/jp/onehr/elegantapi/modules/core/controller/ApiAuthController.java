package jp.onehr.elegantapi.modules.core.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jp.onehr.elegantapi.business.AuthBusiness;
import jp.onehr.elegantapi.common.utils.CryptoUtil;
import jp.onehr.elegantapi.modules.core.enums.LoginUserTypeEnum;
import jp.onehr.elegantapi.modules.core.req.BasicLoginReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua_parser.Parser;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class ApiAuthController {

    private final AuthBusiness authBusiness;

    @Value("${USER_PASSWORD_SALT:user}")
    private String userPasswordSalt;
    @Value("${USER_PASSWORD_SALT:member}")
    private String memberPasswordSalt;

    private final Parser uaParser = new Parser();

    @PostMapping("user/basic-login")
    public void userBasicLogin(@Valid @RequestBody BasicLoginReq req, HttpServletRequest request) {
        // todo 校验图片验证码
        var ua = uaParser.parse(request.getHeader(HttpHeaders.USER_AGENT));
        var device = ua.os.family;
        req.setPassword(CryptoUtil.sha256Hash(req.getPassword(),userPasswordSalt));
        authBusiness.basicLogin(req, device, LoginUserTypeEnum.USER);
    }

    @PostMapping("member/basic-login")
    public void memberBasicLogin(@Valid @RequestBody BasicLoginReq req, HttpServletRequest request) {
        // todo 校验图片验证码
        var ua = uaParser.parse(request.getHeader(HttpHeaders.USER_AGENT));
        var device = ua.os.family;
        req.setPassword(CryptoUtil.sha256Hash(req.getPassword(),memberPasswordSalt));
        authBusiness.basicLogin(req, device, LoginUserTypeEnum.MEMBER);
    }

}
