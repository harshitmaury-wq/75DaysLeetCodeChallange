# Write your MySQL query statement below
select round(count(distinct t.player_id)/(select count(distinct player_id) from Activity),2) as fraction
from
(select player_id, min(event_date) as event_date
from Activity
group by player_id) as t join Activity a on datediff(a.event_date, t.event_date) = 1 and t.player_id = a.player_id