-- 모든 컬럼 조회
SELECT * FROM employees;

-- 특정 컬럼만 조회
SELECT first_name, last_name, salary 
FROM employees;

-- 컬럼에 별칭 부여
SELECT 
    first_name AS 이름,
    hire_date AS 입사일,
    salary AS 급여
FROM employees;