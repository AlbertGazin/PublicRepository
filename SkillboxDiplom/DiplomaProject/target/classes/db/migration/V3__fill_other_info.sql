insert into users (is_moderator, reg_time, name, email, password, code, photo)
     values (1, '2018-03-12 13:00:00', "Albert Gazin", "gazin.albert@mail.ru", "$2a$12$Fgz8DobnCWCNxmOptmaEiOfQoVFAIBCaV8YZXb1K5g2z/u9Uqv/Rq", "Restore", null);

insert into users (is_moderator, reg_time, name, email, password, code, photo)
     values (1, '2018-04-01 13:05:00', "Marat Safin", "marat.safin@mail.ru", "$2a$12$sEw1vEBU25gbYoIjmXTZCe8CSSF7CBXqyCHcc2CGRKNGDjzCVqpha", null, null);

insert into users (is_moderator, reg_time, name, email, password, code, photo)
     values (0, '2019-09-17 14:07:00', "Farid Gareev", "farid.gareev@gmail.com", "$2a$12$3Q8RPXxpXvKMz/iiyyQx6uHSSlaauXikVUCfVAZTwUBzAUXQw/Kmy", null, null);

insert into users (is_moderator, reg_time, name, email, password, code, photo)
     values (0, '2020-06-20 14:30:00', "Fanil Musin", "fanil.musin@gmail.com", "$2a$12$BrVRQzn8d8.NpdKKBJyMxOLDJobCBhCaalFWLckcp3t.8fC2NuPtu", null, null);

insert into users (is_moderator, reg_time, name, email, password, code, photo)
     values (0, '2021-07-03 10:18:00', "Igor Italov", "igor.italov@gmail.com", "$2a$12$E8jh/4TClOgSmmgasBkSC.0CKb6ChiSaqKXxhBABUwW4u0GMC/gwu", null, null);

insert into users (is_moderator, reg_time, name, email, password, code, photo)
     values (0, '2021-06-09 09:01:00', "Zagit Rubin", "zagit.rubin@gmail.com", "$2a$12$/vL5P3Uq0maAA7abcqO2PuSCorS45318UdvrzOzhtHN/VyRkL8..G", null, null);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 1, '2018-04-07 16:15:00', "Пост про Java", "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, разработанный компанией Sun Microsystems.", 3);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 2, 1, '2019-06-02 13:52:00', "Пост про Spring", "Spring Framework (или коротко Spring) — универсальный фреймворк с открытым исходным кодом для Java-платформы. Также существует форк для платформы .NET Framework, названный Spring.NET.", 2);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 2, 1, '2020-04-03 08:29:00', "Пост про ООП", "Объе́ктно-ориенти́рованное программи́рование (ООП) — методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из которых является экземпляром определённого класса, а классы образуют иерархию наследования.", 5);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 2, '2019-10-07 18:17:00', "Новости Нягани", "В Ханты-Мансийском автономном округе спасатели освободили лошадь, застрявшую копытом в металлической кровати, сообщает казенное учреждение Центроспас-Югория. Это произошло на улице Романтиков в городе Нягань. Каким образом лошадь оказалась в ловушке, в спасательном ведомстве не уточнили. Судя по фото, опубликованному региональным департаментом гражданской защиты, она угодила копытом в каркас кровати и не могла самостоятельно его вытащить.Хозяин тоже не мог помочь животному и обратился к сотрудникам Центроспаса. Те расширили щель в конструкции при помощи специального оборудования и освободили лошадь.", 1);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 2, '2018-11-14 21:20:00', "Hibernate", "Hibernate — библиотека для языка программирования Java, предназначенная для решения задач объектно-реляционного отображения (ORM), самая популярная реализация спецификации JPA. Распространяется свободно на условиях GNU Lesser General Public License.", 4);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 3, '2020-12-15 19:33:00', "Пост про JUnit", "JUnit — библиотека для модульного тестирования программного обеспечения на языке Java.", 2);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 4, '2021-08-03 14:15:00', "Пост про ReplaceAll", "Метод replaceAll() — заменяет каждую подстроку данной строки, которая соответствует заданному регулярному выражению, с данной заменой, другими словами — метод позволяет заменить слово в строке.", 6);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 2, 5, '2021-10-09 17:19:00', "Регулярные выражения", "Регуля́рные выраже́ния (англ. regular expressions) — формальный язык поиска и осуществления манипуляций с подстроками в тексте, основанный на использовании метасимволов (символов-джокеров, англ. wildcard characters). Для поиска используется строка-образец (англ. pattern, по-русски её часто называют «шаблоном», «маской»), состоящая из символов и метасимволов и задающая правило поиска. Для манипуляций с текстом дополнительно задаётся строка замены, которая также может содержать в себе специальные символы.", 3);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 6, '2021-10-03 22:12:00', "Пост про MySQL", "MySQL — свободная реляционная система управления базами данных. Разработку и поддержку MySQL осуществляет корпорация Oracle, получившая права на торговую марку вместе с поглощённой Sun Microsystems, которая ранее приобрела шведскую компанию MySQL AB.", 4);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 6, '2021-10-29 23:07:00', "Пост про Oracle", "Oracle (Oracle Corporation) — американская корпорация, второй по величине доходов производитель программного обеспечения (после Microsoft), крупнейший производитель программного обеспечения для организаций, крупный поставщик серверного оборудования.", 5);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 1, 4, '2020-12-09 19:42:00', "JPA", "Java Persistence API (JPA) — спецификация API Java EE, предоставляет возможность сохранять в удобном виде Java-объекты в базе данных.", 5);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "ACCEPTED", 2, 5, '2021-10-19 15:22:00', "Maven", "Apache Maven — фреймворк для автоматизации сборки проектов на основе описания их структуры в файлах на языке POM (англ. Project Object Model), являющемся подмножеством XML. Проект Maven издаётся сообществом Apache Software Foundation, где формально является частью Jakarta Project.", 6);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (0, "DECLINED", 1, 3, '2021-09-26 16:27:00', "Пост про крыс", "Кры́сы (лат. Rattus) — род грызунов семейства мышиных, включающий не менее 64 видов.", 1);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (0, "DECLINED", 2, 2, '2021-05-17 18:44:00', "Пост про меня", "Я изучаю Java.", 1);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "DECLINED", 1, 4, '2021-09-19 10:40:00', "Пост про кошечек и собачек", "Кошечки и собачки милые.", 1);

insert into posts (is_active, moderation_status, moderator_id, user_id, time, title, text, view_count)
     values (1, "NEW", 1, 4, '2021-10-01 04:42:00', "Пост про голубей", "Голуби любят семечки.", 1);

insert into tags (name)
     values ("news");

insert into tags (name)
     values ("java");

insert into tags (name)
     values ("IT");

insert into tags (name)
     values ("education");

insert into post_comments (post_id, user_id, time, text)
     values (1, 3, '2020-03-14 13:17:00', "Хорошая статья !");

insert into post_comments (parent_id, post_id, user_id, time, text)
     values (1, 1, 1, '2018-12-11 12:21:00', "Отлично !");

insert into post_comments (post_id, user_id, time, text)
     values (6, 3, '2021-07-09 06:15:00', "Good !");

insert into post_comments (parent_id, post_id, user_id, time, text)
     values (3, 1, 2, '2020-10-02 09:24:00', "Nice !");

insert into post_comments (post_id, user_id, time, text)
     values (6, 5, '2021-08-08 08:39:00', "Not Bad !");

insert into post_comments (post_id, user_id, time, text)
     values (1, 4, '2021-09-09 19:42:00', "Thanks !");

insert into post_comments (post_id, user_id, time, text)
     values (8, 2, '2021-10-07 22:19:00', "Too hard !");

insert into post_votes (user_id, post_id, time, value)
     values (1, 1, '2019-11-06 20:01:00', 1);

insert into post_votes (user_id, post_id, time, value)
     values (4, 1, '2021-10-10 13:17:00', 1);

insert into post_votes (user_id, post_id, time, value)
     values (1, 3, '2020-01-09 10:17:00', 1);

insert into post_votes (user_id, post_id, time, value)
     values (1, 6, '2019-02-11 09:02:00', 1);

insert into post_votes (user_id, post_id, time, value)
     values (1, 9, '2021-03-19 17:58:00', 1);

insert into tags_to_post (post_id, tag_id)
     values (3, 3);

insert into tags_to_post (post_id, tag_id)
     values (1, 1);

insert into tags_to_post (post_id, tag_id)
     values (1, 2);

insert into tags_to_post (post_id, tag_id)
     values (2, 3);

insert into tags_to_post (post_id, tag_id)
     values (1, 3);

insert into tags_to_post (post_id, tag_id)
     values (1, 4);

insert into tags_to_post (post_id, tag_id)
     values (4, 1);