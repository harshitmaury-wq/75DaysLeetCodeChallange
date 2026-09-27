# Write your MySQL query statement below

-- SELECT res.name, res.bonus
-- FROM (
--     SELECT Employee.name, Bonus.bonus
--     FROM Employee
--     LEFT JOIN Bonus
--     ON Employee.empId = Bonus.empId
-- ) AS res
-- WHERE res.bonus IS NULL OR res.bonus < 1000;


select name, bonus
from Employee left join Bonus on Employee.empId = Bonus.empId
where Bonus.bonus is null or Bonus.bonus < 1000


-- after joining use that table in which the attribute to compare belong
-- for eg, Bonus.bonus is null or Bonus.bonus < 1000. Bonus table is used here because bonus was in Bonus table 