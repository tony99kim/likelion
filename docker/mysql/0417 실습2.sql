-- 날짜형 함수 사용 (날짜 데이터 처리)

-- 1
select hire_date
from employees;

-- 2
SELECT
    employee_id,
    start_date,
    end_date,
    TIMESTAMPDIFF(MONTH, start_date, end_date) AS work_months
FROM job_history;

-- 3
SELECT
    first_name,
    last_name,
    hire_date
from employees
WHERE hire_date = DATE_SUB(CURDATE(), INTERVAL 30 YEAR );

-- 4
SELECT
    first_name,
    last_name,
    email
FROM employees
WHERE Month(hire_date) = MONTH(CURDATE());

-- 5
SELECT
    first_name,
    last_name,
    hire_date
from employees
WHERE hire_date >= date_sub(curdate(), interval 30 year);

-- 날짜를 조회하세요.

-- 6
SELECT
    employee_id,
    department_id,
    start_date,
    end_date,
    DATEDIFF(end_date,start_date) AS work_days
FROM job_history;


-- 7
SELECT
    first_name,
    last_name,
    hire_date
FROM employees
ORDER BY hire_date ASC
LIMIT 1;

-- 8
SELECT
    first_name,
    last_name,
    hire_date,
    DATEDIFF(CURDATE(), hire_date) AS days_worked
FROM employees;

-- 9
SELECT *
FROM job_history
WHERE start_date >= '1990-01-01' AND start_date < '2000-01-01';

-- 10
SELECT
    first_name,
    last_name,
    hire_date,
    DAYNAME(hire_date) AS hire_day
FROM employees;

-- 숫자형 함수 사용(수치 데이터 처리)

-- 1
SELECT
    first_name,
    last_name,
    salary,
    salary + salary * 0.1 AS increased_salary
FROM employees;

-- 2
SELECT
    job_id,
    job_title,
    min_salary,
    max_salary,
    max_salary - min_salary AS salary_diff
FROM jobs;

-- 3
SELECT
    first_name,
    last_name,
    salary,
    salary * 1200 AS KRW_salary
FROM employees;

-- 4
SELECT
    first_name,
    last_name,
    salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- 5
SELECT
    first_name,
    last_name,
    salary,
    salary - (SELECT AVG(salary) FROM employees) AS salary_diff
FROM employees;

-- 6
SELECT
    first_name,
    last_name,
    salary,
    POWER(salary - (SELECT AVG(salary) FROM employees), 2) AS squared_diff
FROM employees;

-- 7
SELECT
    first_name,
    last_name,
    salary,
    salary * 12 AS annual_salary
FROM employees
ORDER BY annual_salary DESC;

-- 8
SELECT
    employee_id,
    COUNT(*) AS department_change_count
FROM job_history
GROUP BY employee_id;

-- 9
SELECT
    first_name,
    last_name,
    salary
FROM employees
ORDER BY salary ASC;