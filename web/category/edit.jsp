<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<body>


<form action="updateCategory" method="post">
<table align="center" border="1" cellspacing="0">
 <tr>
 	<td>
		类别名称:
 	</td>
 	<td>
 		<input type="text" name="category.name" value="${category.name}">
 	</td>
 </tr>

 <tr>
 	<td colspan="2" align="center">
 	    <input type="hidden" name="category.id" value="${category.id}"> 
 		<input type="submit" value="更新">
 	</td>
 </tr>
</table>

</form>

</body>
</html>