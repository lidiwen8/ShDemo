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
		<td>产品序号</td>
		<td>产品名称</td>
		<td>价格</td>
		<td>所属类别</td>
		<td>编辑</td>
		<td>删除</td>
	</tr>

	<s:iterator value="products" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
			<td>${p.price}</td>
			<td>${p.category.name}</td>
			<td><a href="editProduct?product.id=${p.id}">edit</a></td>
			<td><a href="deleteProduct?product.id=${p.id}">delete</a></td>
		</tr>
	</s:iterator>
</table>
<div>


	第${page.pageno}/${page.totalpage}页 &nbsp;&nbsp;
	<a href="listProduct?pageNo=1">首页</a>
	<c:choose>
		<c:when test="${page.pageno gt 1}">
			<a href="listProduct?pageNo=${page.pageno-1 }">上一页</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:alert('已经是第一页了,没有上一页!');">上一页</a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.pageno lt page.totalpage}">
			<a href="listProduct?pageNo=${page.pageno+1 }">下一页</a>
		</c:when>
		<c:otherwise>
			<a href="javascript:alert('已经是最有一页了,没有下一页!');">下一页</a>
		</c:otherwise>
	</c:choose>

	<a href="listProduct?pageNo=${page.totalpage}">末页</a>
	&nbsp;&nbsp;
	共${page.totalcount}条

</div>

<br/>

<form action="addProduct" method="post">
<table align="center" border="1" cellspacing="0">
		<s:select label="categorys"
		       name="product.category.id"
		       list="categorys"
		       listKey="id"
		       listValue="name"
		       multiple="false"
		/>
 <tr>
 	<td>
 		产品名称:
 	</td>
 	<td>
 		<input type="text" name="product.name" value="">
 	</td>
 </tr>
 <tr>
 	<td>
 		价格:
 	</td>
 	<td>
 		<input type="text" name="product.price" value="0">
 	</td>
 </tr>
 <tr>
 	<td colspan="2" align="center"> 
 		<input type="submit" value="添加产品">
 	</td>
 </tr>
</table>

</form>
</CENTER>
</body>
</html>