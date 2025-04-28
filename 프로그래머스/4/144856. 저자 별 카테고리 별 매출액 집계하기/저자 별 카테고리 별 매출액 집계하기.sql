-- 코드를 입력하세요
SELECT AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUm(price*sales)  from BOOK b
natural join book_sales
natural join author
where DATE(sales_date) BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY CATEGORY, AUTHOR_ID
ORDER BY AUTHOR_ID, CATEGORY DESC
;
