<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<body>
<CENTER>
<%@include file="../include/navigator.jsp" %>

<table align="center" border="1" cellspacing="0" width="500px">

	<tr>
		<td>序号</td>
		<td>类别</td>
		<td>产品名称</td>
		<td>编辑</td>
		<td>删除</td>
	</tr>

	<s:iterator value="categorys" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td><a href="listProduct?category.id=${p.id}">products</a></td>
			<td><a href="editCategory?category.id=${p.id}">edit</a></td>
			<td><a href="deleteCategory?category.id=${p.id}">delete</a></td>
		</tr>
	</s:iterator>
</table>

<br/>

<form action="addCategory" method="post">
<table align="center" border="1" cellspacing="0">
 <tr>
 	<td>
 		种类名称:
 	</td>
 	<td>
 		<input type="text" name="category.name" value="">
 	</td>
 </tr>
 <tr>
 	<td colspan="2" align="center"> 
 		<input type="submit" value="添加种类">
 	</td>
 </tr>
</table>
	<div>


		第${page.pageno}/${page.totalpage}页 &nbsp;&nbsp;
		<a href="listCategory?pageNo=1">首页</a>
		<c:choose>
			<c:when test="${page.pageno gt 1}">
				<a href="listCategory?pageNo=${page.pageno-1 }">上一页</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:alert('已经是第一页了,没有上一页!');">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${page.pageno lt page.totalpage}">
				<a href="listCategory?pageNo=${page.pageno+1 }">下一页</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:alert('已经是最有一页了,没有下一页!');">下一页</a>
			</c:otherwise>
		</c:choose>

		<a href="listCategory?pageNo=${page.totalpage}">末页</a>
		&nbsp;&nbsp;
		共${page.totalcount}条

	</div>
</form>
</CENTER>
</body>
</html>