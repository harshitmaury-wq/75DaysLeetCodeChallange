CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        select if(N > (select count(distinct salary) from Employee) or N <= 0, null, min(salary))  from
        (select distinct salary
        from Employee
        order by salary desc 
        limit N ) as t
  );
END