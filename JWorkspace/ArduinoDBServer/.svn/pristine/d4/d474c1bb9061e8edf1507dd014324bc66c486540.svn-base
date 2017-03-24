<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% %>
	<head>	
		<script src="js/jquery-1.11.1.min.js"></script>		
		<link rel=stylesheet type="text/css" href="css/menu.css">
		<script src="css/menu.js"></script>
		<script src="jscroll/jquery.jscroll.min.js"></script>		
	</head>
<style type="text/css">
    .wrapper {
        text-align: center;
    }
    .wrapper ul {
        display: inline-block;
        margin: 0;
        padding: 0;
        /* For IE, the outcast */
        zoom:1;
        *display: inline;
    }
    .wrapper li {
        float: left;
    }
</style>
<div class="wrapper">
	<ul>
		<li>

		</li>
	</ul>
</div>
<div class="wrapper">
	<ul class="navigation">
		<li>
			<a href="#">*基本資料管理</a>
			<ul>
				<li><a href="EmployeeManage.jsp">*員工管理</a></li>	
				<li><a href="UserManage.jsp">*使用者管理</a></li>
				<li><a href="ClearCache.jsp">*清除快取</a></li>						
			</ul>
		</li>
<!-- 		<li> -->
<!-- 			<a href="#">系列料號管理</a> -->
<!-- 			<ul> -->
<!-- 				<li><a href="SerieManage.jsp">系列管理</a></li> -->
<!-- 				<li><a href="MaterialCodeManage.jsp">料號管理</a></li> -->
<!-- 			</ul> -->
<!-- 		</li> -->
		<li>
			<a href="#">環控系統伺服器參數管理</a>
			<ul>
				<li><a href="SystemParameterView.jsp">系統參數檢視</a></li>				
			</ul>			
		</li>
		<li>
			<a href="#">溫濕度及PM值報表</a>
			<ul>
				<li><a href="TemperatureHumidityPMReport.jsp">生成報表</a></li>				
			</ul>			
		</li>
		<li><a href="#" onclick="logout()">登        出</a></li>
	</ul>
</div>
<script>
function logout()
{
	if(confirm("是否登出?"))
	{
		window.location.href="logout.jsp";	
	}
}
</script>

	