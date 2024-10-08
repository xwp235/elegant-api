package jp.onehr.elegantapi.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class MessageUtil {

    public static String getMessage(String key,String ...values) {
        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
        Locale locale = LocaleContextHolder.getLocale();
        if (values.length > 0) {
            return messageSource.getMessage(key,values, locale);
        }
        return messageSource.getMessage(key,null, locale);
    }

    public static String getLocale() {
        String localeStr =  LocaleContextHolder.getLocale().toString();
        if (StringUtils.isNotBlank(localeStr)) {
            return "en";
        }
        return localeStr.split("_")[0];
    }

}
