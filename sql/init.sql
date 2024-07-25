drop table if exists mast_user;
create table mast_user (
  id bigserial primary key,
  avatar varchar(50),
  nickname varchar(16),
  username varchar(16),
  mobile varchar(16),
  email varchar(40),
  password varchar(64),
  state int2,
  created_at timestamptz(6) NOT NULL,
  updated_at timestamptz(6) NOT NULL,
  CONSTRAINT unq_mast_user_nickname UNIQUE (nickname),
  CONSTRAINT unq_mast_user_username UNIQUE (username),
  CONSTRAINT unq_mast_user_username_mobile UNIQUE (username,mobile),
  CONSTRAINT unq_mast_user_username_email UNIQUE (username,email),
  CHECK (COALESCE(username,mobile,email) IS NOT NULL)
);

-- md5 e10adc3949ba59abbe56e057f20f883e 123456
insert into mast_user (username,password,state,created_at,updated_at) values ('admin','af22899bc8c5f727e0e4e917cf5098ebdadebe1c3487bafd73d29c5ccc18a2a1',1,current_timestamp,current_timestamp);
insert into mast_user (username,password,state,created_at,updated_at) values ('manager1','af22899bc8c5f727e0e4e917cf5098ebdadebe1c3487bafd73d29c5ccc18a2a1',1,current_timestamp,current_timestamp);

drop table if exists hist_client_login_log;
create table hist_client_login_log (
       id int8 primary key,
       user_id int8,
       account varchar(16),
       session_id varchar(64),
       device varchar(16),
       token varchar(64),
       login_type varchar(10),
       login_time timestamptz(6),
       logout_time timestamptz(6),
       is_offline bool default false
);

