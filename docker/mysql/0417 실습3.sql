-- 실습3

-- 1
select  upper(last_name)
from employees;

-- 2
select SUBSTR(first_name, 1, 1)
from employees;

-- 3
select length(last_name) - length(last_name, 'a' '')
from employees;

-- 4 이메일 컬럼에 도메인이 없음...
select substr(email,instr(email,'@')+1)
from employees;

-- 5
select first_name,last_name
from employees;

-- 6
select substr(first_name,3,3)
from employees;

-- 7
select concat(last_name,', ', first_name)
from employees;

-- 8
select length(first_name)
from employees;

-- 9
select *
from employees
where lower(last_name) = 'King';

-- 10
select count(*)
from employees
where last_name like 'M%';
