-- 코드를 입력하세요
SELECT user_id, product_id from ONLINE_SALE
Group by user_id, product_id
having count(user_id) >= 2
order by user_id, product_id DESC
;
