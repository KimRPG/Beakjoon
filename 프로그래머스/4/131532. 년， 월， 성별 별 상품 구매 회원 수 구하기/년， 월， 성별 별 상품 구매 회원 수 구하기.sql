-- 코드를 입력하세요
SELECT 
    year(sales_date) as YEAR, 
    month(sales_date) as MONTH, 
    gender as GENDER,  
    count(DISTINCT online_sale.user_id) as USERS 
from user_info 
join online_sale on online_sale.user_id = user_info.user_id
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year(sales_date), month(sales_date), gender
;
