insert into "curator" (id, curatorname, dateofbirth, workexperience, universitygroup_id)
values ('434a3c78-ed5f-11ec-8ea0-0242ac120002', 'Curator-1', '1991-04-04', '7', '434a3aca-ed5f-11ec-8ea0-0242ac120002');
update universitygroup set curator_id = '434a3c78-ed5f-11ec-8ea0-0242ac120002'
where universitygroup.id='434a3aca-ed5f-11ec-8ea0-0242ac120002';
insert into "curator" (id, curatorname, dateofbirth, workexperience, universitygroup_id)
values ('434a41fa-ed5f-11ec-8ea0-0242ac120002', 'Curator-2', '1996-04-11', '4', '434a3f66-ed5f-11ec-8ea0-0242ac120002');
update universitygroup set curator_id = '434a41fa-ed5f-11ec-8ea0-0242ac120002'
where universitygroup.id='434a3f66-ed5f-11ec-8ea0-0242ac120002';