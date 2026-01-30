-- 코드를 작성해주세요
SELECT Count(*) as FISH_COUNT from fish_info where fish_Type in(
SELECT FISH_TYPE FROM fish_name_info where Fish_name = "BASS" OR Fish_name = "SNAPPER");