# Write your MySQL query statement below
select Sales.product_id, Sales.year as first_year, Sales.quantity, Sales.price
from Sales inner join (
    select product_id, min(year) as year 
    from Sales
    group by product_id
) as s on Sales.product_id = s.product_id and Sales.year = s.year

    