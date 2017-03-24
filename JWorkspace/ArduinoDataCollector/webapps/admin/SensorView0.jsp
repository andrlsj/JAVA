<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="snc01ManagerWebService.Snc01"%>
<%@ page import="snc01ManagerWebService.SNC01Manager"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<%

int iPage=1, iStart=0, iEnd=0, iTotalPages=1;
if(request.getParameter("page")!=null)
{
	iPage = Integer.parseInt(request.getParameter("page").toString());	
}

List<Snc01> lstSnc01 = new ArrayList<Snc01>();

String strURL = hmConfig.get("ArduinoDBServerIP");
if(strURL.equals(""))
	strURL = "192.168.4.162";
String strWsdlPath = "http://" + strURL + ":9092/SNC01Manager?wsdl";
SNC01Manager m = new SNC01Manager();
lstSnc01 = m.getAllSNCX01S(strWsdlPath); 	
//System.out.println(lstSnc01.size());
iTotalPages = (int)Math.ceil(((double)lstSnc01.size())/((double)iPageRows));
iStart = iPageRows * (iPage-1);
iEnd = iStart + iPageRows;
if(iEnd>lstSnc01.size())
	iEnd = lstSnc01.size();
%>
<table align="center">
  <tr>
    <td>    	
    	(<%=iPage%>/<%=iTotalPages%>)  
    	<a href="SensorView.jsp?page=1">最前頁</a>
    	<%
    		if(iPage !=1){
    	%>
    	<a href="SensorView.jsp?page=<%=iPage-1%>">上一頁</a>
    	<%
    		}
    	%>
    	<%
    		if(iPage !=iTotalPages){
    	%>
    	<a href="SensorView.jsp?page=<%=iPage+1%>">下一頁</a>
    	<%
    		}
    	%>
    	<a href="SensorView.jsp?page=<%=iTotalPages%>">最後頁</a>    	
    </td>
  </tr>
</table>

<div id="btnAdd">
	<table align="center" border="0px">
		<tr>
			<td>
<!-- 				<input type="button" id="btnAddSensor" name="btnAddSensor" value="新增感測器" onclick="addSensor('block')"> -->
			</td>
		</tr>
	</table>
</div>
<br>
<form id="form1" action="SensorAddEdit_controller.jsp">
<div id="SensorAdd" style="display:none">
	<table align="center" border="0px">
		<tr>
			<td colspan="4" align="center">
				<h1>感測設備</h1>
			</td>
		</tr>
		<tr>
			<td>公司</td><td><input type="text" id="site" name="site"></td>
		</tr>
		<tr>
			<td>設備代號</td>
			<td>
				<input type="text" id="machineid" name="machineid">
				<input type="hidden" id="machinename" name="machinename">
			</td>
		</tr>
		<tr>
			<td>IP</td><td><input type="text" id="ip" name="ip"></td>
		</tr>	
		<tr>
			<td>MAC address</td><td><input type="text" id="mac" name="mac"></td>
		</tr>		
		<tr>
			<td>感測器說明</td><td><input type="text" id="sensormemo" name="sensormemo"></td>
		</tr>
		<tr>
			<td>收集時間間隔</td><td><input type="text" id="mins" name="mins"></td>
		</tr>		
		<tr>
			<td></td>
			<td>
				<input type="submit" value="儲存">
				<input type="button" value="取消" onclick="cancelEdit()">
			</td>
		</tr>
	</table>
</div>
</form>
<%

if(lstSnc01.size()>0)
{
%>

<table align="center" border="1px">
  <tr>
    <th>公司</th>
    <th>設備名稱(key)</th>
    <th>IP 位址</th>
    <th>MAC address</th>
    <th>感測器說明</th>
    <th>啟用</th>
    <th>收集時間間隔</th>
    <th>操作</th>
  </tr>
<%
	for(int i=iStart;i<iEnd;i++) 
  	{
		Snc01 snc01 = lstSnc01.get(i);
%>
    <tr>
<%--     	<td><%=setting.getId()%></td> --%>
		<td><%=snc01.getCompanyId()%></td>
    	<td><%=snc01.getMachineName()%></td>  
    	<td><%=snc01.getIp()%></td>
    	<td><%=snc01.getMac()%></td>
		<td><%=snc01.getMemo()%></td>
		<% String strChk="";
			if(snc01.getEnable()!=null)
			{
    			if(snc01.getEnable().equals("1")) 
    				strChk = "checked";
			}
    		%>    		
    	<td><input type="checkbox" <%=strChk%> onclick="activate('<%=snc01.getMachineName()%>',this.checked);"></td>
    	<td><%=snc01.getMins()%></td>
    	<td><input type="button" onclick="editSensor('<%=snc01.getMachineName()%>','<%=snc01.getIp()%>','<%=snc01.getMac()%>','<%=snc01.getMemo()%>','<%=snc01.getCompanyId()%>','<%=snc01.getEnable()%>','<%=snc01.getMins()%>')" value="編輯"></td>
    </tr>
<%
  		}
  %>
</table>
<%
}
%>
<script>
function activate(id,checked)
{
	var strAlert = checked==true?"啟用":"不啟用";
	if(confirm(strAlert))
		window.location.href="SensorActivate.jsp?machineid=" + id + "&checked=" + checked; 
	else
		window.location.href = "SystemParameterView.jsp";		
}
function hideAddBtn()
{
	var divBtnAdd = document.getElementById("btnAdd");
	divBtnAdd.style.display="none";
}
function addSensor(style)
{
	var obj=document.getElementById("SensorAdd");
	obj.style.display=style;	
	
	var machineId = document.getElementById("machineid");
	machineId.value="";
	machineId.disabled = false;
	var machineName = document.getElementById("machinename");
	machineName.value="";
	var ip = document.getElementById("ip");
	ip.value = "";
	var mac = document.getElementById("mac");
	mac.value = "";
	var site = document.getElementById("site");
	site.value="";
	var sensormemo = document.getElementById("sensormemo");
	sensormemo.value = "";
	var mins = document.getElementById("mins");
	mins.value="";
	hideAddBtn();
}
function editSensor(machinename,ip,mac,memo,site,enable,mins)
{
	addSensor("block");
	hideAddBtn();
	
	if(machinename!="")
	{
		var txtMachineId = document.getElementById("machineid");
		txtMachineId.value=machinename;
		txtMachineId.disabled= true;
		var txtMachName = document.getElementById("machinename");
		txtMachName.value=machinename;
	}
	if(ip!="")
	{
		var txtIP = document.getElementById("ip");
		txtIP.value = ip;
		txtIP.disabled= true;
	}
	if(mac!="")
	{
		var txtMAC = document.getElementById("mac");
		txtMAC.value = mac;
		txtMAC.disabled= true;
	}	
	if(memo!="")
	{
		var txtMemo = document.getElementById("sensormemo");
		txtMemo.value = memo;
	}
	if(site!="")
	{
		var txtSite = document.getElementById("site");
		txtSite.value = site;
		txtSite.disabled = true;
	}
	if(mins!="")
	{
		var txtMins = document.getElementById("mins");
		txtMins.value = mins;
	}
}
function cancelEdit()
{
	addSensor("none");
	var divBtnAdd = document.getElementById("btnAdd");
	divBtnAdd.style.display="block";
	
	var machineId = document.getElementById("machineid");
	machineId.value="";
	var ip = document.getElementById("ip");
	ip.value = "";
	var mac = document.getElementById("mac");
	mac.value = "";	
	var site = document.getElementById("site");
	site.value="";
	var sensormemo = document.getElementById("sensormemo");
	sensormemo.value = "";
	var mins = document.getElementById("mins");
	mins.value="";
}
</script>