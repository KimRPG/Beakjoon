-- 코드를 입력하세요
SELECT book_id, Date_Format(published_date,"%Y-%m-%d") as published_date FROM BOOK WHERE category = "인문" AND Year(published_date) = 2021
order by published_date 
;