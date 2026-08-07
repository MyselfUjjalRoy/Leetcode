# Write your MySQL query statement below
select emp.name , b.bonus from 
employee as emp left join bonus as b on 
emp.empId = b.empId where
b.bonus is null or b.bonus < 1000