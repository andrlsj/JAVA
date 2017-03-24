<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="db.manager.SNC01"%>
<%@ page import="OracleDB.manager.SNC01Manager"%>
<%@ page import="java.util.Date"%>
<%@ page import="Util.DateUtil"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<link rel="stylesheet" href="js/jquery-ui.css">
  <script src="js/jquery-ui.js"></script>
  
<%
Date nowDate = new Date();
nowDate = DateUtil.addDay(nowDate, -1);

String strCompId="";
List<SNC01> lstSNC01 = new ArrayList<SNC01>();
List<SNC01> lstSNC01CompanyId = SNC01Manager.getSNCX01sCompanyId();
if(request.getParameter("compid")!=null)
{
	strCompId = request.getParameter("compid");
	System.out.println(lstSNC01.size());
}else{
	strCompId="CCM";
}
lstSNC01 = SNC01Manager.getSNCX01sByCompanyId(strCompId);
%>
<form id="form1" action=".jsp">
<table align="center" border="1px">	
	<tr>
		<td>廠別代碼
			<select id="compid" onchange="refresh(this.value)">
			<%for(int i=0; i<lstSNC01CompanyId.size(); i++)
				{
				SNC01 snc01 = lstSNC01CompanyId.get(i);
				String strSelected="";
				if(strCompId.equals(snc01.getCompanyId()))
				{
					strSelected = "selected";
				}
			%>
				<option value="<%=snc01.getCompanyId()%>" <%=strSelected%>><%=snc01.getCompanyId()%></option>
			<%
				}
			%>	
			</select>
	    </td>
	</tr>
	<br>
	<tr>
		<td>開始時間
			<input type="text" id="reportdate" name="reportdate" value="<%=DateUtil.getDateString(nowDate)%>" size="10">
	    </td>
	</tr>
	</br>
	<br>
	<tr>
		<td>設備名稱
			<select id="deviceid">
			<%						
			for(int i=0; i<lstSNC01.size(); i++)
			{
				SNC01 snc01 = lstSNC01.get(i);
			%>
				<option value="<%=snc01.getMachineName()%>"><%=snc01.getMachineName() %></option>	
			<% 
			}
			%>
			</select>
	    </td>
	</tr>
	<br>
	<tr>
		<td>設備類別
			<input type="radio" name="rbtemperaturehumiditypm" value="T22" checked>T22/H22
			<input type="radio" name="rbtemperaturehumiditypm" value="PM2.5">PM2.5
	    </td>
	</tr>
	</br>
	<tr>
		<td>
			<input type="button" id="login_submit" value="產生報表" onclick="view()">
		</td>
	</tr>
	
</table>
</form>    
<br>



<script>
//設定中文語系
$.datepicker.regional['zh-TW']={
   dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
   dayNamesMin:["日","一","二","三","四","五","六"],
   monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
   monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
   prevText:"上月",
   nextText:"次月",
   weekHeader:"週"
};
//將預設語系設定為中文
$.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
$(function() {
  $( "#reportdate" ).datepicker({
   dateFormat: 'yy-mm-dd', 
   showOn: 'both', 
   buttonImageOnly: true, 
   buttonImage: 'images/calendar.gif', 
   showWeek: true,
   firstDay: 1
   });
});

function refresh(compid)
{
	//alert(compid);
	window.location.href="./TemperatureHumidityPMReport.jsp?compid="+compid;
}
function view()
{	
	var d=document.getElementsByName("rbtemperaturehumiditypm");
	var i = document.getElementById("deviceid").selectedIndex;
	var o = document.getElementById("deviceid")[i];
	var date = document.getElementById("reportdate").value;
	
	//alert(o.value);
	var strURL = "../report/";
	if (d[0].checked)
	{
		strURL = strURL + "TemperatureHumidity-" + o.value + "-" + date + ".html";
	}
	else if (d[1].checked)
	{
		strURL = strURL + "PM2.5-" + o.value + "-" + date + ".html";
	}
	
	window.open("view.jsp?url="+strURL);
}

</script>