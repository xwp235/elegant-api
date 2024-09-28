package jp.onehr.elegantapi.modules.coupon.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;

import java.io.IOException;

/**
 * 用法：
 *     在CouponTemplate类上加入如下注解声明
 *     @JsonSerialize(using = CouponTemplateSerializer.class)
 */
public class CouponTemplateSerializer
extends JsonSerializer<CouponTemplate> {

    /**
     *
     * @param couponTemplate 序列化目标对象
     * @param jsonGenerator json生成器
     * @param serializerProvider 序列化工具类
     */
    @Override
    public void serialize(
            CouponTemplate couponTemplate,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {
         // 开始序列化对象
         jsonGenerator.writeStartObject();
         jsonGenerator.writeStringField("id",couponTemplate.getId().toString());
         // 。。。
         jsonGenerator.writeEndObject();
    }

}
