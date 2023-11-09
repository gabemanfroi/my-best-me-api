create table `learner`
(
    `id`       bigint       not null auto_increment,
    `email`    varchar(255) not null,
    `name`     varchar(255) not null,
    `password` varchar(255) not null,
    primary key (`id`)
) engine = InnoDB;

create table `learner_learning_resource`
(
    `learner_id`           bigint not null,
    `learning_resource_id` bigint not null
) engine = InnoDB;

create table `learning_resource`
(
    `id`          bigint       not null auto_increment,
    `description` varchar(255),
    `title`       varchar(255) not null,
    `url`         varchar(255) not null,
    primary key (`id`)
) engine = InnoDB;

alter table `learner_learning_resource`
    add constraint `FK9eqmasqc4b42kthq7ki8s8px9` foreign key (`learning_resource_id`) references `learning_resource` (`id`);

alter table `learner_learning_resource`
    add constraint `FKhsbpa4q9u9ir987ah5qjib70l` foreign key (`learner_id`) references `learner` (`id`);
