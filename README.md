# User

#1
select u.* from tUser u join (
select UserId, max(Actiontype) ActionType from tAudit 
group by UserId) t
on u.UserId = t.UserId
where t.ActionType < 2;

#2
select * from tUser u join tAccessToken t
on u.UserId = t.UserId
where t.Expiredate < current_timestamp;
#3

select u.* from tUser u join (
select UserId, max(Actiontype) ActionType from tAudit 
group by UserId) t
on u.UserId = t.UserId
where t.ActionType < 3;
#4

select u.* from tUser u join (
select UserId,  count(*) countFaild from tAudit 
where ActionType = 5 
group by UserId) t
on u.UserId = t.UserId
order by t.countFaild desc
fetch first 4 rows only
;
