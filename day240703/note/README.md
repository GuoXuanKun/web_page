# Note 240703
## Review

### SQl 
- 内连
  - `表名 INNER JOIN 表名 ON 关联条件 where 筛选条件` ( INNER 可以不用写 ) 
  - 条件那里 : 如果 字段名相同 应该 表名.字段名
  - 关联条件如果 为空就不会被查询
- 外连
  - 外连接(左外连接`(以左表为主表，主表的数据无论匹不匹配 次表和主表全部显示)`右外连接 同理)
  - `表名 left outer join 表名 on 关联条件 where 筛选条件` ( outer 可以不用写 )
  - 关联条件如果为空,也会显示
- 子查询
  - 将 子语句 查询到的数据作为 筛选条件的值
    - ````sql
      select * from emp where sal >(select avg(sal) from emp);
  - 子语句 作为 临时表
    - ````sql
      select * from dept d
      INNER JOIN (select deptno,avg(sal) from emp GROUP BY deptno) t on d.deptno =t.deptno;