# Write your MySQL query statement below
select distinct employee_id, department_id
from Employee where employee_id not in (
select distinct e1.employee_id
from Employee e1 join Employee e2 
on e1.employee_id = e2.employee_id and e1.primary_flag = "Y"
)
union

select distinct e1.employee_id, e1.department_id
from Employee e1 join Employee e2 
on e1.employee_id = e2.employee_id and e1.primary_flag = "Y"

