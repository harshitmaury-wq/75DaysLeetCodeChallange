# Write your MySQL query statement below

SELECT res.name, res.bonus
FROM (
    SELECT Employee.name, Bonus.bonus
    FROM Employee
    LEFT JOIN Bonus
    ON Employee.empId = Bonus.empId
) AS res
WHERE res.bonus IS NULL OR res.bonus < 1000;