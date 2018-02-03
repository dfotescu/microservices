insert into user (id, birth_date, name) values (1001, sysdate(), 'Ana');
insert into user (id, birth_date, name) values (2001, sysdate(), 'Bob');
insert into user (id, birth_date, name) values (3001, sysdate(), 'Mosu');

insert into post (id, message) values (101, 'post1');
insert into post (id, message) values (201, 'post2');
insert into post (id, message) values (301, 'post3');
insert into post (id, message) values (401, 'post4');
insert into post (id, message) values (501, 'post5');
insert into post (id, message) values (601, 'post6');

insert into user_posts values (1001, 101);
insert into user_posts values (1001, 201);
insert into user_posts values (2001, 301);
insert into user_posts values (2001, 401);
insert into user_posts values (3001, 501);
insert into user_posts values (3001, 601);