-- 코드를 작성해주세요
Select COUNT(ID) as FISH_COUNT,Month(time) as MONTH from fish_info group by  Month(time)
order by Month(time);