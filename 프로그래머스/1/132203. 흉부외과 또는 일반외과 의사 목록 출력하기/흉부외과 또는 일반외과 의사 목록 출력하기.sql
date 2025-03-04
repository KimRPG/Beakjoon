-- 코드를 입력하세요
SELECT DR_NAME,DR_ID,MCDP_CD,DATE_format(HIRE_YMD,"%Y-%m-%d") from DOCTOR
where MCDP_CD IN ('CS','GS')
order by HIRE_YMD desc, DR_NAME asc