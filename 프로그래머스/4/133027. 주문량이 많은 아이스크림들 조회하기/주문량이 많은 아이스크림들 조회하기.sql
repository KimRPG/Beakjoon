-- 코드를 입력하세요
SELECT FIRST_HALF.FLAVOR from FIRST_HALF inner join JULY ON JULY.FLAVOR = FIRST_HALF.FLAVOR
GROUP BY FIRST_HALF.FLAVOR
order by SUM(FIRST_HALF.TOTAL_ORDER) + SUM(JULY.TOTAL_ORDER)  DESC limit 3









