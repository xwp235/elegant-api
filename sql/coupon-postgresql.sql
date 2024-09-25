-- 优惠券模板表
DROP TABLE IF EXISTS "public"."coupon_template";
CREATE TABLE "public"."coupon_template" (
    id int8 primary key,
    tpl_key varchar(16) not null,
    available bool not null default false,
    expired bool not null default false,
    name varchar(16) not null,
    logo varchar(255) not null,
    intro varchar(255) not null,
    category varchar(16) not null,
    product_line int8 not null default 0,
    coupon_count int4 not null default 0,
    create_time timestamp(6) not null default current_timestamp,
    usage int4 not null default 0,
    rule text not null,
    CONSTRAINT unq_coupon_template_name UNIQUE (name),
);

CREATE INDEX "idx_coupon_template_category" ON "public"."coupon_template" USING btree (
    "category" "pg_catalog"."varchar_ops" ASC NULLS LAST
    );
CREATE INDEX "idx_coupon_template_user_id" ON "public"."coupon_template" USING btree (
    "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

-- (用户)优惠券
DROP TABLE IF EXISTS "public"."coupon";
CREATE TABLE "public"."coupon" (
                                            id int8 primary key,
                                            tpl_id int8 not null,
    user_id int8 not null,
    coupon_code varchar(64) not null,
    assign_time timestamp(6) not null default current_timestamp,
    status int2 not null default 0
);

CREATE INDEX "idx_coupon_user_id" ON "public"."coupon" USING btree (
    "user_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );
CREATE INDEX "idx_coupon_tpl_id" ON "public"."coupon" USING btree (
    "tpl_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );
