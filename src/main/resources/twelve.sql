/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/4/20 15:32:07                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists album;

drop table if exists articl_img;

drop table if exists article;

drop table if exists artilce_topic;

drop table if exists chat_record;

drop table if exists collection;

drop table if exists comment;

drop table if exists image;

drop table if exists relationship;

drop table if exists reply;

drop table if exists report;

drop table if exists topic;

drop table if exists transmit;

drop table if exists user_topic;

drop table if exists users;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   admin_id             varchar(32) not null,
   username             varchar(32) not null comment '用户名',
   password             varchar(32) not null comment '密码',
   power                int not null default 0 comment '用数字表示权限
            0-普通
            1-高级',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '这条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '这条记录的更新时间',
   primary key (admin_id)
);

alter table admin comment '管理员表';

/*==============================================================*/
/* Table: album                                                 */
/*==============================================================*/
create table album
(
   album_id             varchar(32) not null,
   user_id              varchar(32) comment '所属用户id',
   album_name           varchar(32) not null comment '相册名称',
   album_describe       varchar(512) comment '相册描述',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '相册创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '该条记录的更新时间',
   primary key (album_id)
);

alter table album comment '相册';

/*==============================================================*/
/* Table: articl_img                                            */
/*==============================================================*/
create table articl_img
(
   ai_id                varchar(32) not null,
   article_id           varchar(32) not null comment '动态的id',
   img_id               varchar(32) not null comment '该动态下的图片id',
   primary key (ai_id)
);

alter table articl_img comment '动态图片表

动态相册，如果是动态中的图片，则要存入该表中，表示这张图片是哪个动态的';

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   article_id           varchar(32) not null,
   user_id              varchar(32) comment '表示这条动态所属用户的id',
   content              text not null comment '动态内容的文字部分',
   is_haveImg           tinyint not null default 0 comment '是否带图，0-带图，1-不带
            默认为0',
   like_number          int not null default 0 comment '点赞数量，初始值为0',
   collect_number       int not null default 0 comment '收藏数量，初始值为0，',
   transmit_number      int not null default 0 comment '转发数量，初始值 默认为0',
   is_report            tinyint not null default 1 comment '是否被举报
            0-被举报
            1-没有被举报
            默认为1',
   report_number        int not null default 0 comment '被举报的数量，初始值默认为0',
   type                 varchar(512) comment '动态话题分类，表示该条动态参与的话题标签，以字符串形式保存在数据库中，中间以  _  做分隔符
            如：人像_黑白_摄影',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '这条动态的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '这条记录的修改时间',
   primary key (article_id)
);

alter table article comment '用户动态表';

/*==============================================================*/
/* Table: artilce_topic                                         */
/*==============================================================*/
create table artilce_topic
(
   at_id                varchar(32) not null,
   article_id           varchar(32) not null comment '动态id',
   topic_id             varchar(32) not null comment '该条动态参与的话题id',
   primary key (at_id)
);

alter table artilce_topic comment '动态话题表,表示参与了该话题的动态
当用户 发表带有话题的动态时，即向该表中插入一条数据';

/*==============================================================*/
/* Table: chat_record                                           */
/*==============================================================*/
create table chat_record
(
   cr_id                varchar(32) not null,
   user_id              varchar(32) comment '这条消息 的发送者id',
   to_user              varchar(32) not null comment '这条消息的接收者id',
   content              varchar(2048) not null comment '这条消息的消息内容',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '这条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '这条消息的更新时间',
   primary key (cr_id)
);

alter table chat_record comment '聊天记录表';

/*==============================================================*/
/* Table: collection                                            */
/*==============================================================*/
create table collection
(
   collection_id        varchar(32) not null,
   user_id              varchar(32) comment '收藏者id',
   type                 int not null default 0 comment '收藏内容的类型
            0-动态
            1-图片
            默认值为 0
            具体数据由前端判断之后发送到后台',
   content_id           varchar(32) not null comment 'type为0时，表示动态id
            type为1时，表示图片id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '该条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '该条记录的更新时间',
   primary key (collection_id)
);

alter table collection comment '收藏表';

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   comment_id           varchar(32) not null,
   user_id              varchar(32) comment '发出这条评论的用户id',
   comment_content      varchar(256) not null comment '评论内容',
   object_type          int not null default 0 comment '被评论的类型
            0-动态
            1-图片
            默认为0
            具体数据由前端判断之后发送给后台',
   object_id            varchar(32) not null comment 'type为0时，表示为动态id
            type为1时，表示为图片id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建这条记录时的id',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新这条记录时的id',
   primary key (comment_id)
);

alter table comment comment '评论表';

/*==============================================================*/
/* Table: image                                                 */
/*==============================================================*/
create table image
(
   img_id               varchar(32) not null,
   album_id             varchar(32) comment '所属相册id',
   img_path             varchar(256) not null comment '图片的存储路径，可以存放在七牛上，也可以自己保存其路径',
   img_describe         varchar(256) comment '该图片的描述',
   like_number          int not null default 0 comment '图片的点赞数，默认为0',
   collect_number       int not null default 0 comment '图片的收藏数，默认为0',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '该条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '该条记录的更新时间',
   primary key (img_id)
);

alter table image comment '图片表';

/*==============================================================*/
/* Table: relationship                                          */
/*==============================================================*/
create table relationship
(
   relationship_id      varchar(32) not null,
   user_id              varchar(32) comment '外键，表示所属用户id',
   friend_id            varchar(32) not null comment '外键，好友或者被拉黑的人的id',
   is_friend            tinyint not null default 0 comment '是否是好友，用数字表示 0-好友，1-拉黑
            默认为0',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '这条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '这条记录的更新时间',
   primary key (relationship_id)
);

alter table relationship comment '好友关系表';

/*==============================================================*/
/* Table: reply                                                 */
/*==============================================================*/
create table reply
(
   reply_id             varchar(32) not null,
   user_id              varchar(32) comment '发出这条回复的用户id',
   comment_id           varchar(32) comment '对应的评论id
            表明这条回复是哪个评论下的',
   reply_content        varchar(1024) not null comment '回复内容',
   to_user              varchar(32) not null comment '接收这条回复的用户id',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建这条记录的时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新这条记录的时间',
   primary key (reply_id)
);

alter table reply comment '回复表';

/*==============================================================*/
/* Table: report                                                */
/*==============================================================*/
create table report
(
   report_id            varchar(32) not null,
   user_id              varchar(32) comment '举报用户的id',
   type                 int not null default 0 comment '举报内容的类型，表示图片还是动态
            0-动态
            1-图片
            默认为0
            具体数据由前端判断之后发送到后台',
   content_id           varchar(32) not null comment '被举报内容的id
            type为0，表示为动态id
            type为1，表示为图片id',
   report_describe      varchar(512) not null comment '举报内容',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '该条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '该条记录的更新时间',
   primary key (report_id)
);

alter table report comment '举报表';

/*==============================================================*/
/* Table: topic                                                 */
/*==============================================================*/
create table topic
(
   topic_id             varchar(32) not null,
   title                varchar(128) not null comment '话题标题',
   descirbe             varchar(512) comment '话题的相关描述，数据库中可以为空',
   fan_number           int not null default 0 comment '该话题的被关注数量，初始值为0',
   discussion_number    int not null default 0 comment '该话题下的动态数量，初始值为0',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '该条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '该条记录的更新时间',
   primary key (topic_id)
);

alter table topic comment '话题表';

/*==============================================================*/
/* Table: transmit                                              */
/*==============================================================*/
create table transmit
(
   transmit_id          varchar(32) not null,
   user_id              varchar(32) comment '转发这条动态的用户id',
   type                 int not null default 0 comment '0-动态
            1-图片',
   content_id           varchar(32) not null comment 'type为0时表示动态id
            type为1时表示图片id',
   comment              varchar(512) default NULL comment '转发时发表的评论，可以为空',
   like_number          int not null default 0 comment '这条转发的点赞数，初始值默认为0',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '这条记录的创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '这条记录的更新时间',
   primary key (transmit_id)
);

alter table transmit comment '转发表';

/*==============================================================*/
/* Table: user_topic                                            */
/*==============================================================*/
create table user_topic
(
   up_id                varchar(32) not null comment '主键',
   user_id              varchar(32) not null comment '用户id',
   topic_id             varchar(32) not null comment '话题id',
   primary key (up_id)
);

alter table user_topic comment '用户参与话题关联表

表示关注了该话题的动态';

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   user_id              varchar(32) not null,
   username             varchar(32) not null comment '用户名',
   password             varchar(32) not null comment '密码',
   nickname             varchar(32) not null comment '用户昵称',
   userSex              varchar(2) default '0' comment '用户性别
            0-女
            1-男
            默认值为0
            字段可以为空',
   birthday             timestamp comment '用户生日
            yyyy-MM-dd
            
            可以为空',
   userinfo             varchar(256) comment '这个字段可以用做个性签名或者个人简介
            
            可以为空',
   phonenumber          varchar(11) comment '用户手机号码',
   usermail             varchar(64) comment '用户邮箱',
   userlike             varchar(128) comment '用户喜好，就是用户注册之后会选择的感兴趣的那几个东西
            数据库中以字符串形式保存，以 _  做分隔符
            如用户选择了运动，摄影，男神，女神这几个类别，则传过来的数据应是：运动_摄影_男神_女神    ',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '该用户的注册时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '该用户上一次更新个人信息的时间',
   primary key (user_id)
);

alter table users comment '用户信息表';

alter table album add constraint FK_Relationship_2 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table articl_img add constraint FK_articl_img foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table articl_img add constraint FK_articl_img2 foreign key (img_id)
      references image (img_id) on delete restrict on update restrict;

alter table article add constraint FK_Relationship_1 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table artilce_topic add constraint FK_artilce_topic foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

alter table artilce_topic add constraint FK_artilce_topic2 foreign key (topic_id)
      references topic (topic_id) on delete restrict on update restrict;

alter table chat_record add constraint FK_Relationship_7 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table collection add constraint FK_Relationship_3 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table comment add constraint FK_Relationship_4 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table image add constraint FK_Relationship_12 foreign key (album_id)
      references album (album_id) on delete restrict on update restrict;

alter table relationship add constraint FK_Relationship_8 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table reply add constraint FK_Relationship_14 foreign key (comment_id)
      references comment (comment_id) on delete restrict on update restrict;

alter table reply add constraint FK_Relationship_5 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table report add constraint FK_Relationship_10 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table transmit add constraint FK_Relationship_6 foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table user_topic add constraint FK_user_topic foreign key (user_id)
      references users (user_id) on delete restrict on update restrict;

alter table user_topic add constraint FK_user_topic2 foreign key (topic_id)
      references topic (topic_id) on delete restrict on update restrict;

