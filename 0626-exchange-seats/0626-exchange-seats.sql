# Write your MySQL query statement below

select s1.id as id, s2.student as student
from Seat s1 join Seat s2 on s2.id = s1.id+1
and s1.id % 2 = 1 and s2.id % 2 = 0
union
select s2.id as id, s1.student as student
from Seat s1 join Seat s2 on s2.id = s1.id+1
and s2.id % 2 = 0 and s1.id % 2 = 1
union
select id, student 
from Seat where
id = (select max(id) from Seat) and id % 2 = 1 
order by id



