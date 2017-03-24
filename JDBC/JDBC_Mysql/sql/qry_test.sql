
drop procedure if exists qry_test;
DELIMITER $$
CREATE PROCEDURE qry_test 
(
	IN p_deptno DECIMAL(3,0),
	OUT p_empno DECIMAL(4,0)
)






BEGIN
 select empno into p_empno from employee where deptno=p_deptno;
END
