package jp.onehr.elegantapi.common;

public interface ErrorConstants {

    /// 系统异常
    // 未知异常
    int ERR_500 = 500;
    // SseEmitter连接异常
    int ERR_1000 = 1000;

    /// 业务异常
    // 请求参数不合法。
    int ERR_10000 = 10000;
    // 将对象序列化为json对象失败！
    int ERR_10001 = 10001;
    // 将JSON字符串反序列化为对象失败！
    int ERR_10002 = 10002;
    // 深拷贝对象时发生错误！
    int ERR_10003 = 10003;
    //
    int ERR_10004 = 10004;

}
