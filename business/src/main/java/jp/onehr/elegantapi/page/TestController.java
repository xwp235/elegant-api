package jp.onehr.elegantapi.page;

import jp.onehr.elegantapi.common.limiter.annotation.RateLimit;
import jp.onehr.elegantapi.modules.core.domain.entity.MastUser;
import jp.onehr.elegantapi.modules.core.mapper.MastUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
public class TestController {

//    private final MastUserMapper mastUserMapper;

    @RateLimit(interval = "PT4S",count=1)
    @GetMapping("1")
    public void test1() {
//        System.out.println(LoginSessionHolder.getClientsBySessionId(AuthUtil.getSessionId()));
    }

    @GetMapping("2")
    public List<MastUser> test2() {
//        return mastUserMapper.selectList(null);
        return null;
    }

    @GetMapping("3")
    public void test3() {
        var entity = new MastUser();
        entity.setUsername("manager2");
        entity.setPassword("af22899bc8c5f727e0e4e917cf5098ebdadebe1c3487bafd73d29c5ccc18a2a1");
//        mastUserMapper.insert(entity);
        System.out.println("+++---");
    }

}
