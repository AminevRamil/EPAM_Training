--Поиск products по title\
select *
from products
where title='ADAPTATION ACE';

--Поиск products по price = 9.99 и category = 8 и отсортировать по category и price
select *
from products
where price = 9.99 and category = 8
order by category, price;

--Поиск products у которых category = 8 или 15
select *
from products
where category = 8 or category = 15;

--Поиск products у которых price между 10 и 20 (используйте BETWEEN)
select *
from products
where price between 10 and 20;

--Поиск orders у которых orderdate между 2004-01-05 и 2004-02-05
select *
from orders
where orderdate between to_date('2004-01-05', 'YYYY-MM-DD') and to_date('2004-02-05 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.MS');

--Сгруппировать данные в orders по полю customerid и посчитать количество относительно каждого customerid
select distinct customerid, count(orderid) as total_orders
from orders
group by customerid

--Сгруппировать данные в orders по полям customerid и orderdate и просуммировать totalamount, при этом сумма totalamount должна быть больше 100
select customerid, orderdate, sum(totalamount) as amount_sum
from orders
group by customerid, orderdate
having sum(totalamount) > 100
order by customerid

--Написать запрос к таблицам customer, orders, orderlines и products с использованием JOIN и вывести firstname, lastname, title, orderdate
select c.firstname, c.lastname, p.title, o2.orderdate
from customers c
join orders o1 on c.customerid = o1.customerid
join orderlines o2 on o1.orderid = o2.orderid
join products p on o2.prod_id = p.prod_id
