package jp.onehr.elegantapi.common.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class LogbackFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        // 获取日志记录器的名称
        var loggerName = event.getLoggerName();
        // 获取当前线程的调用堆栈
        var stackTrace = Thread.currentThread().getStackTrace();

        // 检查是否在特定的类中调用了 mapper 的方法
        for (var element : stackTrace) {
            if (element.getClassName().equals("jp.onehr.elegantapi.common.config.BeanConfig")) {
                // 如果在 BeanConfig 类中调用了 mapper 方法，则过滤掉 SQL 日志
                if (loggerName.startsWith("jp.onehr.elegantapi.modules.core.mapper")) {
                    return FilterReply.DENY;
                }
            }
        }

        // 默认情况是接受日志
        return FilterReply.NEUTRAL;
    }

}
