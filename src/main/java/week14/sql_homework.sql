use hr ;
SELECT deptno, ename, job FROM emp where mgr=7902;
SELECT ename, job, sal FROM emp ORDER BY job;
SELECT deptno, ename, job, sal*12 AS salAnual FROM EMP ORDER BY deptno;
SELECT ename, job, (sal + ifnull(comm, 0))  venitLunar from emp where (sal + ifnull(comm, 0)) > 2000;
SELECT empno, ename, job, hiredate from emp where hiredate > '1981-05-01'  order by job;
insert into emp( EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7755,'TOM','ANALYST',102,'1981-11-07',2500,2,10),
(7713,'TOMY','MANAGER',101,'1981-05-11',4500,10,20), (7714,'JANE','ANALYST',30,'1981-11-07',2500,2,30), (7715,'MELINDA','MANAGER',103,'1991-11-07',3500,20,30),
(7716,'ALAN','SALSEMAN',40,'1981-10-07',2500,2,40),(7701,'PAUL','ANALYST',105,'1981-05-12',3100,10,20),(7718,'LINDA','ANALYST',700,'1983-12-07',2500,2,30),(7719,'LILY','SALESEMAN',30,'1977-11-15',3200,10,10),(7722,'IONA','ANALYST',30,'1981-10-06',2400,11,20),
(7733,'MARISA','ANALYST',100,'1982-12-17',2700,2,10);
SELECT ENAME , SAL*0.15 PRIMA  FROM EMP WHERE DEPTNO =20;
SELECT DEPTNO,DNAME FROM DEPT;
SELECT empno, ename, CONCAT(EMPNO," ",ename),job, hiredate from emp ORDER BY empno DESC;
SELECT  empno, ename, job ,(sal + ifnull(comm, 0))  venitLunar  from emp;
select ename, job from emp;
select dname, deptno from dept order by dname;
select * from emp where job = 'manager' order by deptno;
select ename, hiredate from emp  where hiredate between '1981-05-12' and'1981-12-03';
SELECT empno, ename, job, (sal + ifnull(comm, 0))  venitLunar from emp where empno  in(7499,7902, 7876);
select ename , hiredate from emp where year (hiredate)=1980;
select * from emp where ename like 'f%' and job like'_______';
select ename, comm  from emp where deptno =20 and comm is null; 
select ename , comm from emp where job='salesman' and comm>0;
select * from emp where job= 'manager' and sal>1500 || job='analyst';
select *from emp where year(hiredate)<1982 and comm is null; 
select * from emp where mgr=' 'and sal>3000 order by deptno;
SELECT ename, job, (sal + ifnull(comm, 0))  venitLunar from emp  where job not in ('manager') and deptno =10;
select deptno, ename, hiredate from emp where year(hiredate) = 1981 and deptno in( 10,40); 
