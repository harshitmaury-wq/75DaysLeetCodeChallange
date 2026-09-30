# Write your MySQL query statement below

select query_name, round(sum(q.rating/q.position) / count(q.rating),2) as quality, round(count(if(rating<3 ,1, null))/ count(q.rating) * 100, 2) as poor_query_percentage
from Queries q 
group by query_name
