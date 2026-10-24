# Write your MySQL query statement below

select round(count(if(d.order_date = d.customer_pref_delivery_date,1,null))/count(*)*100, 2) as immediate_percentage from
(select customer_id, min(order_date) as first_order
from Delivery 
group by customer_id ) as t join Delivery d on d.customer_id = t.customer_id and t.first_order = d.order_date


