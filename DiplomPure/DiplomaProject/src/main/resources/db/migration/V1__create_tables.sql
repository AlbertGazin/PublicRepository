drop table if exists captcha_codes;
drop table if exists global_settings;
drop table if exists post_comments;
drop table if exists post_votes;
drop table if exists posts;
drop table if exists users;
drop table if exists tags;
drop table if exists tags_to_post;

create table tags_to_post
(
id integer not null auto_increment,
post_id integer not null,
tag_id integer not null,
primary key (id)
);

create table users
(
id integer not null auto_increment,
code varchar(255),
email varchar(255) not null,
is_moderator integer not null,
name varchar(255) not null,
password varchar(255) not null,
photo varchar(255),
reg_time datetime(6) not null,
primary key (id)
);

create table posts
(
id integer not null auto_increment,
is_active smallint not null,
moderation_status varchar(255),
text longtext not null,
time datetime(6) not null,
title varchar(255) not null,
view_count integer not null,
moderator_id integer,
user_id integer not null,
primary key (id)
);

alter table posts add constraint posts_user_fk foreign key (moderator_id) references users (id);
alter table posts add constraint posts_moder_fk foreign key (user_id) references users (id);

create table captcha_codes
(
id integer not null auto_increment,
code varchar(4000) not null,
secret_code varchar(4000) not null,
time datetime(6) not null,
primary key (id)
);

create table global_settings
(
id integer not null auto_increment,
code varchar(255) not null,
name varchar(255) not null,
value varchar(255) not null,
primary key (id)
);

create table post_comments
(
id integer not null auto_increment,
parent_id integer,
text longtext not null,
time datetime(6) not null,
post_id integer not null,
user_id integer not null,
primary key (id)
);

alter table post_comments add constraint post_comm_post_fk foreign key (post_id) references posts (id);
alter table post_comments add constraint post_comm_user_fk foreign key (user_id) references users (id);

create table post_votes
(
id integer not null auto_increment,
time datetime(6) not null,
value smallint not null,
post_id integer not null,
user_id integer not null,
primary key (id)
);

alter table post_votes add constraint post_v_post_fk foreign key (post_id) references posts (id);
alter table post_votes add constraint post_v_user_fk foreign key (user_id) references users (id);

create table tags
(
id integer not null auto_increment,
name varchar(255) not null,
primary key (id)
);

alter table tags_to_post add constraint fk_posts_tags_to_tag foreign key (tag_id) references tags (id);
alter table tags_to_post add constraint fk_posts_tags_to_post foreign key (post_id) references posts (id);
alter table tags_to_post add unique un_tag_post (post_id, tag_id);