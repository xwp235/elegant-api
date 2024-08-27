DROP TABLE IF EXISTS "public"."flw_process";
CREATE TABLE "public"."flw_process" (
                                        "id" int8 PRIMARY KEY,
                                        "tenant_id" varchar(50),
                                        "create_id" varchar(50) NOT NULL,
                                        "create_by" varchar(50) NOT NULL,
                                        "create_time" timestamp(6) NOT NULL,
                                        "process_key" varchar(100) NOT NULL,
                                        "process_name" varchar(100) NOT NULL,
                                        "process_icon" varchar(255),
                                        "process_type" varchar(100),
                                        "process_version" int4 NOT NULL DEFAULT 1,
                                        "instance_url" varchar(200),
                                        "remark" varchar(255),
                                        "use_scope" int2 NOT NULL DEFAULT 0,
                                        "process_state" int2 NOT NULL DEFAULT 1,
                                        "model_content" text,
                                        "sort" int2,
                                        CONSTRAINT unq_process_version UNIQUE (process_key, process_version)
);

CREATE INDEX "idx_process_name" ON "public"."flw_process" USING btree (
    "process_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );
COMMENT ON COLUMN "public"."flw_process"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_process"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_process"."create_id" IS '作成者ID';
COMMENT ON COLUMN "public"."flw_process"."create_by" IS '作成者名称';
COMMENT ON COLUMN "public"."flw_process"."create_time" IS '作成時間';
COMMENT ON COLUMN "public"."flw_process"."process_key" IS 'プロセス定義キーの一意識別子';
COMMENT ON COLUMN "public"."flw_process"."process_name" IS 'プロセス定義名称';
COMMENT ON COLUMN "public"."flw_process"."process_icon" IS 'プロセスアイコンアドレス';
COMMENT ON COLUMN "public"."flw_process"."process_type" IS 'プロセスタイプ';
COMMENT ON COLUMN "public"."flw_process"."process_version" IS 'プロセスバージョン，デフォルト 1';
COMMENT ON COLUMN "public"."flw_process"."instance_url" IS 'インスタンスアドレス';
COMMENT ON COLUMN "public"."flw_process"."remark" IS '備考';
COMMENT ON COLUMN "public"."flw_process"."use_scope" IS '利用スコープ 0=全員 1=指定された人員(業務関連者) 2=いずれも提出できません';
COMMENT ON COLUMN "public"."flw_process"."process_state" IS 'プロセスの状態 0=利用不可 1=利用可能 2=履歴バージョン';
COMMENT ON COLUMN "public"."flw_process"."model_content" IS 'プロセスモデル定義のJSONコンテンツ';
COMMENT ON COLUMN "public"."flw_process"."sort" IS 'ソート順';
COMMENT ON TABLE "public"."flw_process" IS 'プロセス定義テーブル';

DROP TABLE IF EXISTS "public"."flw_ext_instance";
CREATE TABLE "public"."flw_ext_instance" (
                                             "id" int8 PRIMARY KEY ,
                                             "tenant_id" varchar(50),
                                             "process_id" int8 NOT NULL,
                                             "process_type" varchar(100),
                                             "model_content" text
);
COMMENT ON COLUMN "public"."flw_ext_instance"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_ext_instance"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_ext_instance"."process_id" IS 'プロセスID';
COMMENT ON COLUMN "public"."flw_ext_instance"."process_type" IS 'プロセスタイプ';
COMMENT ON COLUMN "public"."flw_ext_instance"."model_content" IS 'プロセスモデル定義のJSONコンテンツ';
COMMENT ON TABLE "public"."flw_ext_instance" IS '拡張プロセスインスタンステーブル';

DROP TABLE IF EXISTS "public"."flw_instance";
CREATE TABLE "public"."flw_instance" (
                                         "id" int8 PRIMARY KEY,
                                         "tenant_id" varchar(50),
                                         "create_id" varchar(50) NOT NULL,
                                         "create_by" varchar(50) NOT NULL,
                                         "create_time" timestamp(6) NOT NULL,
                                         "process_id" int8 NOT NULL,
                                         "parent_instance_id" int8,
                                         "priority" int2,
                                         "instance_no" varchar(50),
                                         "business_key" varchar(100),
                                         "variable" text,
                                         "current_node_name" varchar(100) NOT NULL,
                                         "current_node_key" varchar(100) NOT NULL,
                                         "expire_time" timestamp(6),
                                         "last_update_by" varchar(50),
                                         "last_update_time" timestamp(6)
);

CREATE INDEX "idx_instance_process_id" ON "public"."flw_instance" USING btree (
    "process_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

COMMENT ON COLUMN "public"."flw_instance"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_instance"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_instance"."create_id" IS '作成者ID';
COMMENT ON COLUMN "public"."flw_instance"."create_by" IS '作成者名称';
COMMENT ON COLUMN "public"."flw_instance"."create_time" IS '作成時間';
COMMENT ON COLUMN "public"."flw_instance"."process_id" IS 'プロセス定義ID';
COMMENT ON COLUMN "public"."flw_instance"."parent_instance_id" IS '親プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_instance"."priority" IS '優先度';
COMMENT ON COLUMN "public"."flw_instance"."instance_no" IS 'プロセスインスタンス番号';
COMMENT ON COLUMN "public"."flw_instance"."business_key" IS '業務キー';
COMMENT ON COLUMN "public"."flw_instance"."variable" IS '変数json';
COMMENT ON COLUMN "public"."flw_instance"."current_node_name" IS '現在のノード名';
COMMENT ON COLUMN "public"."flw_instance"."current_node_key" IS '現在のノードキー';
COMMENT ON COLUMN "public"."flw_instance"."expire_time" IS '期待完了時間';
COMMENT ON COLUMN "public"."flw_instance"."last_update_by" IS '前回の更新者';
COMMENT ON COLUMN "public"."flw_instance"."last_update_time" IS '前回の更新時間';
COMMENT ON TABLE "public"."flw_instance" IS 'プロセスインスタンステーブル';

DROP TABLE IF EXISTS "public"."flw_task";
CREATE TABLE "public"."flw_task" (
                                     "id" int8 PRIMARY KEY,
                                     "tenant_id" varchar(50),
                                     "create_id" varchar(50) NOT NULL,
                                     "create_by" varchar(50) NOT NULL,
                                     "create_time" timestamp(6) NOT NULL,
                                     "instance_id" int8 NOT NULL,
                                     "parent_task_id" int8,
                                     "task_name" varchar(100) NOT NULL,
                                     "task_key"  varchar(100) NOT NULL,
                                     "task_type" int2 NOT NULL,
                                     "perform_type" int2,
                                     "action_url" varchar(200),
                                     "variable" text,
                                     "assignor_id" varchar(100),
                                     "assignor" varchar(255),
                                     "expire_time" timestamp(6),
                                     "remind_time" timestamp(6),
                                     "remind_repeat" int2 NOT NULL DEFAULT 0,
                                     "viewed" int2 NOT NULL DEFAULT 0
);

CREATE INDEX "idx_task_instance_id" ON "public"."flw_task" USING btree (
    "instance_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );
COMMENT ON COLUMN "public"."flw_task"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_task"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_task"."create_id" IS '作成者ID';
COMMENT ON COLUMN "public"."flw_task"."create_by" IS '作成者名称';
COMMENT ON COLUMN "public"."flw_task"."create_time" IS '作成時間';
COMMENT ON COLUMN "public"."flw_task"."instance_id" IS 'プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_task"."parent_task_id" IS '親タスクID';
COMMENT ON COLUMN "public"."flw_task"."task_name" IS 'タスク名称';
COMMENT ON COLUMN "public"."flw_task"."task_key" IS 'タスクキーの一意識別子';
COMMENT ON COLUMN "public"."flw_task"."task_type" IS 'タスクタイプ';
COMMENT ON COLUMN "public"."flw_task"."perform_type" IS '参与タイプ';
COMMENT ON COLUMN "public"."flw_task"."action_url" IS 'タスクプロセスurl';
COMMENT ON COLUMN "public"."flw_task"."variable" IS '変数json';
COMMENT ON COLUMN "public"."flw_task"."assignor_id" IS '委托人ID';
COMMENT ON COLUMN "public"."flw_task"."assignor" IS '委托人';
COMMENT ON COLUMN "public"."flw_task"."expire_time" IS 'タスク期待完了時間';
COMMENT ON COLUMN "public"."flw_task"."remind_time" IS 'リマインダー時間';
COMMENT ON COLUMN "public"."flw_task"."remind_repeat" IS 'リマインダー回数';
COMMENT ON COLUMN "public"."flw_task"."viewed" IS '既読 0 = 否 1 = はい';
COMMENT ON TABLE "public"."flw_task" IS 'タスクテーブル';

DROP TABLE IF EXISTS "public"."flw_task_actor";
CREATE TABLE "public"."flw_task_actor" (
                                           "id" int8 PRIMARY KEY,
                                           "tenant_id" varchar(50),
                                           "instance_id" int8 NOT NULL,
                                           "task_id" int8 NOT NULL,
                                           "actor_id" varchar(100) NOT NULL,
                                           "actor_name" varchar(100) NOT NULL,
                                           "actor_type" int4 NOT NULL,
                                           "weight" int4,
                                           "agent_id" varchar(100),
                                           "agent_type" int4,
                                           "extend" text
);

CREATE INDEX "idx_task_actor_task_id" ON "public"."flw_task_actor" USING btree (
    "task_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

COMMENT ON COLUMN "public"."flw_task_actor"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_task_actor"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_task_actor"."instance_id" IS 'プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_task_actor"."task_id" IS 'タスクID';
COMMENT ON COLUMN "public"."flw_task_actor"."actor_id" IS '参与者ID';
COMMENT ON COLUMN "public"."flw_task_actor"."actor_name" IS '参与者名称';
COMMENT ON COLUMN "public"."flw_task_actor"."actor_type" IS '参与者タイプ 0=ユーザー 1=役割 2=所属';
COMMENT ON COLUMN "public"."flw_task_actor"."weight" IS 'チケットタグ（同じ承認ノードに複数の人（例えばA、B、C）を設定し、それぞれに異なる重みを定義します。投票の重みの割合が50％を超えると、次のノードに進むことができます。）の重み';
COMMENT ON COLUMN "public"."flw_task_actor"."agent_id" IS '代理ユーザーID';
COMMENT ON COLUMN "public"."flw_task_actor"."agent_type" IS '代理ユーザータイプ 0=代理側 1=代理される側 2=役割の引き受け 3=所属の引き受け';
COMMENT ON COLUMN "public"."flw_task_actor"."extend" IS '予備JSONフィールド';
COMMENT ON TABLE "public"."flw_task_actor" IS 'タスク参加者テーブル';

DROP TABLE IF EXISTS "public"."flw_his_instance";
CREATE TABLE "public"."flw_his_instance" (
                                             "id" int8 PRIMARY KEY,
                                             "tenant_id" varchar(50),
                                             "create_id" varchar(50) NOT NULL,
                                             "create_by" varchar(50) NOT NULL,
                                             "create_time" timestamp(6) NOT NULL,
                                             "process_id" int8 NOT NULL,
                                             "parent_instance_id" int8,
                                             "priority" int2,
                                             "instance_no" varchar(50),
                                             "business_key" varchar(100),
                                             "variable" text,
                                             "current_node_name" varchar(100),
                                             "current_node_key" varchar(100),
                                             "expire_time" timestamp(6),
                                             "last_update_by" varchar(50),
                                             "last_update_time" timestamp(6),
                                             "instance_state" int2 NOT NULL DEFAULT 0,
                                             "end_time" timestamp(6),
                                             "duration" int8
);

CREATE INDEX "idx_his_instance_process_id" ON "public"."flw_his_instance" USING btree (
    "process_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

COMMENT ON COLUMN "public"."flw_his_instance"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_his_instance"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_his_instance"."create_id" IS '作成者ID';
COMMENT ON COLUMN "public"."flw_his_instance"."create_by" IS '作成者名称';
COMMENT ON COLUMN "public"."flw_his_instance"."create_time" IS '作成時間';
COMMENT ON COLUMN "public"."flw_his_instance"."process_id" IS 'プロセス定義ID';
COMMENT ON COLUMN "public"."flw_his_instance"."parent_instance_id" IS '親プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_his_instance"."priority" IS '優先度';
COMMENT ON COLUMN "public"."flw_his_instance"."instance_no" IS 'プロセスインスタンス番号';
COMMENT ON COLUMN "public"."flw_his_instance"."business_key" IS '業務キー';
COMMENT ON COLUMN "public"."flw_his_instance"."variable" IS '変数json';
COMMENT ON COLUMN "public"."flw_his_instance"."current_node_name" IS '現在のノード名';
COMMENT ON COLUMN "public"."flw_his_instance"."current_node_key" IS '現在のノードキー';
COMMENT ON COLUMN "public"."flw_his_instance"."expire_time" IS '期待完了時間';
COMMENT ON COLUMN "public"."flw_his_instance"."last_update_by" IS '前回の更新者';
COMMENT ON COLUMN "public"."flw_his_instance"."last_update_time" IS '前回の更新時間';
COMMENT ON COLUMN "public"."flw_his_instance"."instance_state" IS '状態 0 = 未承認 1 = 承認中 2 = 承認済み 3 = 承認拒否 4 = 承認取り消し 5 = タイムアウト終了 6 = 強制終了';
COMMENT ON COLUMN "public"."flw_his_instance"."end_time" IS '終了時間';
COMMENT ON COLUMN "public"."flw_his_instance"."duration" IS '処理時間';
COMMENT ON TABLE "public"."flw_his_instance" IS '履歴プロセスインスタンステーブル';

DROP TABLE IF EXISTS "public"."flw_his_task";
CREATE TABLE "public"."flw_his_task" (
                                         "id" int8 PRIMARY KEY,
                                         "tenant_id" varchar(50),
                                         "create_id" varchar(50) NOT NULL,
                                         "create_by" varchar(50) NOT NULL,
                                         "create_time" timestamp(6) NOT NULL,
                                         "instance_id" int8 NOT NULL,
                                         "parent_task_id" int8,
                                         "call_process_id" int8,
                                         "call_instance_id" int8,
                                         "task_name" varchar(100) NOT NULL,
                                         "task_key"  varchar(100) NOT NULL,
                                         "task_type" int2 NOT NULL,
                                         "perform_type" int2,
                                         "action_url" varchar(200),
                                         "variable" text,
                                         "assignor_id" varchar(100),
                                         "assignor" varchar(255),
                                         "expire_time" timestamp(6),
                                         "remind_time" timestamp(6),
                                         "remind_repeat" int2 NOT NULL DEFAULT 0,
                                         "viewed" int2 NOT NULL DEFAULT 0,
                                         "finish_time" timestamp(6),
                                         "task_state" int2 NOT NULL DEFAULT 0,
                                         "duration" int8
);

CREATE INDEX "idx_his_task_instance_id" ON "public"."flw_his_task" USING btree (
    "instance_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );
CREATE INDEX "idx_his_task_parent_task_id" ON "public"."flw_his_task" USING btree (
    "parent_task_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

COMMENT ON COLUMN "public"."flw_his_task"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_his_task"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_his_task"."create_id" IS '作成者ID';
COMMENT ON COLUMN "public"."flw_his_task"."create_by" IS '作成者名称';
COMMENT ON COLUMN "public"."flw_his_task"."create_time" IS '作成時間';
COMMENT ON COLUMN "public"."flw_his_task"."instance_id" IS 'プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_his_task"."parent_task_id" IS '親タスクID';
COMMENT ON COLUMN "public"."flw_his_task"."call_process_id" IS '呼び出しされる外部プロセス定義のID';
COMMENT ON COLUMN "public"."flw_his_task"."call_instance_id" IS '呼び出しされる外部プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_his_task"."task_name" IS 'タスク名称';
COMMENT ON COLUMN "public"."flw_his_task"."task_key" IS 'タスクキーの一意識別子';
COMMENT ON COLUMN "public"."flw_his_task"."task_type" IS 'タスクタイプ';
COMMENT ON COLUMN "public"."flw_his_task"."perform_type" IS '参加タイプ';
COMMENT ON COLUMN "public"."flw_his_task"."action_url" IS 'タスクプロセスurl';
COMMENT ON COLUMN "public"."flw_his_task"."variable" IS '変数json';
COMMENT ON COLUMN "public"."flw_his_task"."assignor_id" IS '委托人ID';
COMMENT ON COLUMN "public"."flw_his_task"."assignor" IS '委托人';
COMMENT ON COLUMN "public"."flw_his_task"."expire_time" IS 'タスク期待完了時間';
COMMENT ON COLUMN "public"."flw_his_task"."remind_time" IS 'リマインダー時間';
COMMENT ON COLUMN "public"."flw_his_task"."remind_repeat" IS 'リマインダー回数';
COMMENT ON COLUMN "public"."flw_his_task"."viewed" IS '既読 0 = 否 1 = はい';
COMMENT ON COLUMN "public"."flw_his_task"."finish_time" IS 'タスク終了時間';
COMMENT ON COLUMN "public"."flw_his_task"."task_state" IS 'タスク状態 0 = アクティブ 1 = ジャンプ 2 = 完了 3 = 拒否 4 = 承認取り消し 5 = タイムアウト 6 = 終了 7 = 却下終了';
COMMENT ON COLUMN "public"."flw_his_task"."duration" IS '処理時間';
COMMENT ON TABLE "public"."flw_his_task" IS '履歴タスク表';

DROP TABLE IF EXISTS "public"."flw_his_task_actor";
CREATE TABLE "public"."flw_his_task_actor" (
                                               "id" int8 PRIMARY KEY,
                                               "tenant_id" varchar(50),
                                               "instance_id" int8 NOT NULL,
                                               "task_id" int8 NOT NULL,
                                               "actor_id" varchar(100) NOT NULL,
                                               "actor_name" varchar(100) NOT NULL,
                                               "actor_type" int4 NOT NULL,
                                               "weight" int4,
                                               "agent_id" varchar(100),
                                               "agent_type" int4,
                                               "extend" text
);

CREATE INDEX "idx_his_task_actor_task_id" ON "public"."flw_his_task_actor" USING btree (
    "task_id" "pg_catalog"."int8_ops" ASC NULLS LAST
    );

COMMENT ON COLUMN "public"."flw_his_task_actor"."id" IS '主キー';
COMMENT ON COLUMN "public"."flw_his_task_actor"."tenant_id" IS 'テナントID';
COMMENT ON COLUMN "public"."flw_his_task_actor"."instance_id" IS 'プロセスインスタンスID';
COMMENT ON COLUMN "public"."flw_his_task_actor"."task_id" IS 'タスクID';
COMMENT ON COLUMN "public"."flw_his_task_actor"."actor_id" IS '参加者ID';
COMMENT ON COLUMN "public"."flw_his_task_actor"."actor_name" IS '参与者名称';
COMMENT ON COLUMN "public"."flw_his_task_actor"."actor_type" IS '参与者タイプ 0=ユーザー 1=役割 2=所属';
COMMENT ON COLUMN "public"."flw_his_task_actor"."weight" IS 'チケットタグ（同じ承認ノードに複数の人（例えばA、B、C）を設定し、それぞれに異なる重みを定義します。投票の重みの割合が50％を超えると、次のノードに進むことができます。）の重み';
COMMENT ON COLUMN "public"."flw_his_task_actor"."agent_id" IS '代理ユーザーID';
COMMENT ON COLUMN "public"."flw_his_task_actor"."agent_type" IS '代理ユーザータイプ 0=代理側 1=代理される側 2=役割の引き受け 3=所属の引き受け';
COMMENT ON COLUMN "public"."flw_his_task_actor"."extend" IS '予備JSONフィールド';
COMMENT ON TABLE "public"."flw_his_task_actor" IS '履歴タスク参加者テーブル';

ALTER TABLE "public"."flw_ext_instance" ADD CONSTRAINT "fk_ext_instance_id" FOREIGN KEY ("id") REFERENCES "public"."flw_his_instance" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."flw_his_instance" ADD CONSTRAINT "flw_his_instance_process_id_fkey" FOREIGN KEY ("process_id") REFERENCES "public"."flw_process" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."flw_his_task" ADD CONSTRAINT "flw_his_task_instance_id_fkey" FOREIGN KEY ("instance_id") REFERENCES "public"."flw_his_instance" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."flw_his_task_actor" ADD CONSTRAINT "flw_his_task_actor_task_id_fkey" FOREIGN KEY ("task_id") REFERENCES "public"."flw_his_task" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."flw_instance" ADD CONSTRAINT "flw_instance_process_id_fkey" FOREIGN KEY ("process_id") REFERENCES "public"."flw_process" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."flw_task" ADD CONSTRAINT "flw_task_instance_id_fkey" FOREIGN KEY ("instance_id") REFERENCES "public"."flw_instance" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."flw_task_actor" ADD CONSTRAINT "flw_task_actor_task_id_fkey" FOREIGN KEY ("task_id") REFERENCES "public"."flw_task" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
