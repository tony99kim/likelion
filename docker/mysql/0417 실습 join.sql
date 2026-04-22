-- 실습4

-- 1
select e.first_name, e.last_name,d.department_name
from employees e
join departments d ON e.department_id = d.department_id;

-- 2

select e.first_name, e.last_name, j.job_title
from employees e
join jobs j ON e.job_id = j.job_id;

-- 3
select e.first_name,e.last_name, d.department_name, c.country_name
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
join countries c on l.country_id = c.country_id;

-- 4
select e.first_name,e.last_name,j.job_title
from    employees e
join jobs j on e.job_id = j.job_id
where e.hire_date > DATE '1999-12-31';

-- 5
select e.first_name,e.last_name,r.region_name
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id
join countries c on l.country_id = c.country_id
join regions r on c.region_id = r.region_id;

-- 6
select d.department_name, count(e.employee_id) as num_employees
from departments d
left join employees e on d.department_id = e.department_id
group by d.department_name;

-- 7
select r.region_name, c.country_name
from regions r
join countries c on r.region_id = c.region_id;

-- 8
select d.department_name, l.city
from departments d
join locations l on d.location_id = l.location_id;

-- 9
select e.first_name,e.last_name, d.department_name,j.job_title
from employees e
join departments d on e.department_id = d.department_id
join jobs j on e.job_id = j.job_id;

-- 10
select e.first_name, e.last_name, e.hire_date, d.department_name
from employees e
join job_history jh on e.employee_id = jh.employee_id
join departments d on jh.department_id = d.department_id;



