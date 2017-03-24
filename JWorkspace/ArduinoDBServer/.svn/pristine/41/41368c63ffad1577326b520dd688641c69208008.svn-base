<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="db.manager.User"%>
<%@ page import="db.manager.UserManager"%>
<%@ include file="common/SessionCheck.jsp"%>
<%@ include file="common/conn.jsp"%>
<%@ include file="title.jsp"%>
<%@ include file="menu.jsp"%>
<%@ include file="common/message.jsp"%>
<%
String strSearch="";
if(request.getParameter("txtSearchUser")!=null)
	strSearch=request.getParameter("txtSearchUser").toString();

if(strSearch.equals(""))
{
	session.setAttribute("lstUser", null);
	session.setAttribute("txtSearchUser", null);
}
int iPage=1, iStart=0, iEnd=0, iTotalPages=1;
if(request.getParameter("page")!=null)
{
	iPage = Integer.parseInt(request.getParameter("page").toString());	
}

List<User> lstUser = new ArrayList<User>();
if(session.getAttribute("lstUser")!=null && session.getAttribute("txtSearchUser")!=null)
{
	if(strSearch.equals(session.getAttribute("txtSearchUser").toString()))
		lstUser = (List<User>)session.getAttribute("lstUser");	
}

if(lstUser.size() == 0)
{	
	lstUser = UserManager.getUserByLikeNameLoginName(strSearch);
	session.setAttribute("lstUser", lstUser);
	session.setAttribute("txtSearchUser", strSearch);
}

iTotalPages = (int)Math.ceil(((double)lstUser.size())/((double)iPageRows));
iStart = iPageRows * (iPage-1);
iEnd = iStart + iPageRows;
if(iEnd>lstUser.size())
	iEnd = lstUser.size();
%>
<table align="center">
  <tr>
    <td>姓名<input type="text" id="txtSearchUser" value="<%=strSearch%>"></td>
    <td><input type="button" value="搜尋" onclick="search()"></td>
    <td>    	
    	(<%=iPage%>/<%=iTotalPages%>)  
    	<a href="UserManage.jsp?txtSearchUser=<%=strSearch%>&page=1">最前頁</a>
    	<%
    		if(iPage !=1){
    	%>
    	<a href="UserManage.jsp?txtSearchUser=<%=strSearch%>&page=<%=iPage-1%>">上一頁</a>
    	<%
    		}
    	%>
    	<%
    		if(iPage !=iTotalPages){
    	%>
    	<a href="UserManage.jsp?txtSearchUser=<%=strSearch%>&page=<%=iPage+1%>">下一頁</a>
    	<%
    		}
    	%>
    	<a href="UserManage.jsp?txtSearchUser=<%=strSearch%>&page=<%=iTotalPages%>">最後頁</a>    	
    </td>
  </tr>
</table>
<br>
<%
	if(lstUser.size()>0)
{
%>	
<table align="center" border="1px">
  <tr>
    <th>工號</th>
    <th>姓名</th>
    <th>電子郵件</th>
    <th>性別</th>
    <th>分機</th>
    <th>備註</th>
    <th>啟用</th>
    <th>操作</th>
  </tr>
<%
	for(int i=iStart;i<iEnd;i++) 
  		{
		User usr = lstUser.get(i);
%>
    <tr>
    	<td><%=usr.getId()%></td>
    	<td><%=usr.getName()%></td>
    	<td><%=usr.getEmail()%></td>
    	<td><%=usr.getSex() %></td>    	
    	<td><%=usr.getTel()%></td>
    	<td><%=usr.getMemo()%></td>
    	<% String strChk="";
    		if(usr.isEnable()) 
    			strChk = "checked";
    		%>    		
    	<td><input type="checkbox" <%=strChk%> onclick="activate('<%=usr.getId()%>',this.checked);"></td>
    	<td><input type="button" onclick="userEdit('<%=usr.getId()%>')" value="編輯"></td>
    </tr>
<%
  		}
  %>
</table>
<%
}
%>
<script>
function search()
{
	var obj=document.getElementById("txtSearchUser");
	window.location.href="UserManage.jsp?txtSearchUser=" + obj.value;
}
function activate(id,checked)
{
	var strAlert = checked==true?"啟用":"不啟用";
	if(confirm(strAlert))
		window.location.href="UserActivate.jsp?id=" + id + "&checked=" + checked; 	
}
function userEdit(id)
{
	window.location.href = "UserEdit.jsp?id=" +id;
}

</script>