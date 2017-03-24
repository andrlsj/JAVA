<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="db.manager.Setting"%>
<%@ page import="db.manager.SettingManager"%>
<%@ page import="Util.DateUtil"%>
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

List<Setting> lstSetting = new ArrayList<Setting>();

if(lstSetting.size() == 0)
{	
	//lstSetting = SettingManager.getSettingBySysnameLikeName(conn, "system", "Mail%");
	lstSetting = SettingManager.getSettingsBySysname(conn, "system", true);
	session.setAttribute("lstSetting", lstSetting);
}

iTotalPages = (int)Math.ceil(((double)lstSetting.size())/((double)iPageRows));
iStart = iPageRows * (iPage-1);
iEnd = iStart + iPageRows;
if(iEnd>lstSetting.size())
	iEnd = lstSetting.size();
%>
<table align="center">
  <tr>
    <td>    	
    	(<%=iPage%>/<%=iTotalPages%>)  
    	<a href="SystemParameterView.jsp?page=1">最前頁</a>
    	<%
    		if(iPage !=1){
    	%>
    	<a href="SystemParameterView.jsp?page=<%=iPage-1%>">上一頁</a>
    	<%
    		}
    	%>
    	<%
    		if(iPage !=iTotalPages){
    	%>
    	<a href="SystemParameterView.jsp?page=<%=iPage+1%>">下一頁</a>
    	<%
    		}
    	%>
    	<a href="SystemParameterView.jsp?page=<%=iTotalPages%>">最後頁</a>    	
    </td>
  </tr>
</table>
<br>
<%
	if(lstSetting.size()>0)
{
%>	
<table align="center" border="1px">
  <tr>
<!--     <th>編號</th> -->
    <th>系統</th>
    <th>鍵名(key)</th>
    <th>值</th>
    <th>備註</th>
    <th>時間</th>
    <th>啟用</th>
    <th>操作</th>
  </tr>
<%
	for(int i=iStart;i<iEnd;i++) 
  		{
		Setting setting = lstSetting.get(i);
%>
    <tr>
<%--     	<td><%=setting.getId()%></td> --%>
    	<td><%=setting.getSysname()%></td>  
    	<td><%=setting.getName()%></td>
    	<td><%=setting.getValue()%></td>
		<td><%=setting.getMemo()%></td>
    	<td><%=DateUtil.getCymmetrikDate(setting.getDatetime())%></td>
    	<% String strChk="";
    		if(setting.isEnable()) 
    			strChk = "checked";
    		%>    		
    	<td><input type="checkbox" <%=strChk%> onclick="activate('<%=setting.getId()%>',this.checked);"></td>
    	<td><input type="button" onclick="userEdit('<%=setting.getId()%>')" value="編輯"></td>
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
		window.location.href="SettingActivate.jsp?id=" + id + "&checked=" + checked; 
	else
		window.location.href = "SystemParameterView.jsp";		
}
function userEdit(id)
{
	window.location.href = "SystemParameterEdit.jsp?id=" +id;
}

</script>