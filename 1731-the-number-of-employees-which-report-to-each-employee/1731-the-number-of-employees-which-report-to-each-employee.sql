# Write your MySQL query statement below

select e.employee_id, e.name, t.reports_count, t.average_age
from Employees as e inner join (
    select reports_to, count(*) as reports_count, round(avg(age)) as average_age
    from Employees
    group by reports_to having reports_to is not null
) as t on e.employee_id = t.reports_to
order by e.employee_id

