INSERT INTO users (id, createdAt,lastModifiedAt,status,statusDate,statusReason,address,birthDate,email,imageName,isTokenExpired,mobile,name,password,userType,username,createdBy_id,lastModifiedBy_id,userDetails_id) VALUES 
(1, '2021-12-09 19:04:36','2021-12-09 19:04:36',1,NULL,NULL,NULL,NULL,'admin@yahoo.com',NULL,0,'01065373918',NULL,'$2a$10$HI0xuB9bJVbO.c92S9RTpOGM3bawYSQhmAos19pvgUNLahI50sHpy','EMPLOYEE','admin',NULL,NULL,NULL);


INSERT INTO  roles (id, `name` ,createdAt,lastModifiedAt,createdBy_id,lastModifiedBy_id) VALUES (1, 'مدير',NULL,'2021-06-18 18:56:14',1,1);

INSERT INTO  users_roles (userId,roleId) VALUES (1,1);


INSERT INTO  permissions (id, code,`name`,parent_id,isModule,isScreen,`path`,icon) VALUES 
(1, 'user_management','إداره الموظفين',NULL,1,0,NULL,'fa-users')
,(2, 'roles','الادوار',1,0,1,'/user-man/roles','fa-universal-access')
,(3, 'roles_add','اضافه الادوار',2,0,0,NULL,NULL)
,(4, 'roles_edit','تعديل الادوار',2,0,0,NULL,NULL)
,(5, 'roles_audit','تتبع الادوار',2,0,0,NULL,NULL)
,(6, 'employees','الموظفين',1,0,1,'/user-man/employees','fa-briefcase')
,(7, 'employees_add','اضافه الموظفين',6,0,0,NULL,NULL)
,(8, 'employees_edit','تعديل الموظفين',6,0,0,NULL,NULL)
,(9, 'employees_details','تفاصيل الموظفين',6,0,0,NULL,NULL)
,(10, 'employees_audit','تتبع الموظفين',6,0,0,NULL,NULL);


INSERT INTO  permissions (id, code, `name`,parent_id,isModule,isScreen,`path`,icon) VALUES 
(11, 'employees_change_status','تغيير حاله الموظفين',6,0,0,NULL,NULL)
,(12, 'subscriptions_managemnt','إداره الاشتراكات',NULL,1,0,NULL,'fa-users')
,(13, 'plans','خطط الدفع',12,0,1,'/subscriptions/plans','fa-cc-visa')
,(14, 'plans_add','اضفه خطط الدفع',13,0,0,NULL,NULL)
,(15, 'plans_edit','تعديل خطط الدفع',13,0,0,NULL,NULL)
,(16, 'plans_details','تفاصل خطط الدفع',13,0,0,NULL,NULL)
,(17, 'plans_change_status','تغيير حاله خطط الدفع',13,0,0,NULL,NULL)
,(18, 'audit_audit','تتبع خطط الدفع',13,0,0,NULL,NULL)
,(19, 'players','اللاعبين',12,0,1,'/subscriptions/players','fa-running')
,(20, 'players_add','اضافه اللاعبين',19,0,0,'',NULL);


INSERT INTO  permissions (id, code, `name`,parent_id,isModule,isScreen,`path`,icon) VALUES 
(21, 'players_edit','تعديل اللاعبين',19,0,0,'',NULL)
,(22, 'players_details','تفاصيل اللاعبين',19,0,0,'',NULL)
,(23, 'players_change_status','تغير حاله اللاعبين',19,0,0,'',NULL)
,(24, 'players_audit','تتبع اللاعبين',19,0,0,'',NULL)
,(25, 'players_attendance','حضور اللاعبين',19,0,0,'',NULL)
,(26, 'players_remain','دفع الباقى على اللاعبين',19,0,0,'',NULL)
,(27, 'subscriptions','الاشتراكات',12,0,1,'/subscriptions/subscriptions','fa-users')
,(28, 'subscriptions_add','اضافه الاشتراكات',27,0,0,'',NULL)
,(29, 'subscriptions_audit','تتبع الاشتراكات',27,0,0,'',NULL)
,(30, 'subscriptions_change_dates','تغيير تاريخ الاشتراكات',27,0,0,'',NULL);


INSERT INTO  permissions (id, code, `name`,parent_id,isModule,isScreen,`path`,icon) VALUES 
(31, 'subscriptions_change_status','تغيير حاله الاشتراكات',27,0,0,'',NULL)
,(32, 'exercise_management','إداره التمارين',NULL,1,0,'',NULL)
,(33, 'excercise_category','انواع التمارين',32,0,1,'/exercises/excercises-category','fa-dumbbell')
,(34, 'excercise_category_add','اضافه انواع التمارين',33,0,0,'',NULL)
,(35, 'excercise_category_edit','تعديل انواع التمارين',33,0,0,'',NULL)
,(36, 'excercise_category_audit','تتبع انواع التمارين',33,0,0,'',NULL)
,(37, 'equipment','الاجهزه',32,0,1,'/exercises/equipment','fa-cash-register')
,(38, 'equipment_add','اضافه الاجهزه',37,0,0,'',NULL)
,(39, 'equipment_edit','تعديل الاجهزه',37,0,0,'',NULL)
,(40, 'equipment_audit','تتبع الاجهزه',37,0,0,'',NULL);


INSERT INTO  permissions (id, code, `name`, parent_id,isModule,isScreen,`path`,icon) VALUES 
(41, 'equipment_change_status','تغيير حاله الاجهزه',37,0,0,'',NULL)
,(42, 'exercise','التمارين',32,0,1,'/exercises/exercise','fa-dumbbell')
,(43, 'exercise_add','اضافه تمارين',42,0,0,'',NULL)
,(44, 'exercise_edit','تعديل تمارين',42,0,0,'',NULL)
,(45, 'exercise_audit','تتبع التمارين',42,0,0,'',NULL);



INSERT INTO  roles_permissions (roleId,permissionId) VALUES 
(1,3)
,(1,4)
,(1,5)
,(1,7)
,(1,8)
,(1,9)
,(1,10)
,(1,11)
,(1,14)
,(1,15);


INSERT INTO  roles_permissions (roleId,permissionId) VALUES 
(1,16)
,(1,17)
,(1,18)
,(1,20)
,(1,21)
,(1,22)
,(1,23)
,(1,24)
,(1,25)
,(1,26);



INSERT INTO  roles_permissions (roleId,permissionId) VALUES 
(1,28)
,(1,29)
,(1,30)
,(1,31)
,(1,34)
,(1,35)
,(1,36)
,(1,38)
,(1,39)
,(1,40);


INSERT INTO  roles_permissions (roleId,permissionId) VALUES 
(1,41)
,(1,43)
,(1,44)
,(1,45);


INSERT INTO  statustype (code,`name`) VALUES 
('PUBLIC_STATUS','PUBLIC_STATUS')
,('SUBSCRIPTION_STATUS','SUBSCRIPTION_STATUS')
,('USER_STATUS','USER_STATUS');


INSERT INTO  status (`name`,value) VALUES 
('معطل',0)
,('مفعل',1)
,('محذوق',2)
,('جارى',3)
,('جديد',4)
,('مسوده',5)
,('موقوف',6)
,('متجدد',7)
,('منتهى',8);


INSERT INTO statustypestatus (isDefault,sortRank,status_id,statusType_id) VALUES 
(1,1,1,1)
,(0,2,2,1)
,(1,1,4,2)
,(0,2,5,2)
,(0,3,6,2)
,(0,4,7,2)
,(0,5,8,2)
,(0,6,9,2)
,(1,1,2,3)
,(0,2,7,3);


INSERT INTO statustypestatus (isDefault,sortRank,status_id,statusType_id) VALUES (0,3,8,3);


INSERT INTO settings (id, createdAt,lastModifiedAt,code,description,name,value,createdBy_id,lastModifiedBy_id) VALUES 
(1, NULL,NULL,'PROFILES_IMAGES_PATH',NULL,'Profile Path','D:/gym/uploads/profile',NULL,NULL)
,(2, NULL,NULL,'EXERCISE_VEDIOS_PATH',NULL,'Exercise Vedeos Path','D:/gym/uploads/exercise/videos/',NULL,NULL)
,(3, NULL,NULL,'EXERCISE_IMAGES_PATH',NULL,'Exercise Imgs Path','D:/gym/uploads/exercise/imgs/',NULL,NULL);
