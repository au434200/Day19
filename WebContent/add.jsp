<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
.error {color:red;}
</style>
<body>
<h3 align="center">添加客户</h3>
<form action=" <c:url value='/customerServlet'/>" method="post">
<input type="hidden" name="method" value="add">
<table border="0" align="center" width="40%" style="margin-left:100px;">
	<tr>
		<td width="100px">客户名称：</td>
		<td ><input type="text" name="cname" value="${c.cname }"></td>
		<td align="left"><label id="canmeError" class="error">${map.canmeError }</label></td>
	</tr>
	<tr>
		<td >客户性别：</td>
		<td >
			<c:if test="${ empty c.gender }">
				<input type="radio" name="gender" value="男" id="male">
				<label for="male">男</label>
				<input type="radio" name="gender" value="女" id="famale">
				<label for="famale">女</label>
			</c:if>
			<c:if test="${c.gender=='女' }">
				<input type="radio" name="gender" value="男" id="male">
				<label for="male">男</label>
				<input type="radio" name="gender" value="女" id="famale" checked="checked">
				<label for="famale">女</label>
			</c:if>
			<c:if test="${c.gender=='男' }">
				<input type="radio" name="gender" value="男" id="male" checked="checked">
				<label for="male">男</label>
				<input type="radio" name="gender" value="女" id="famale">
				<label for="famale">女</label>
			</c:if>
		</td>
		<td>
			<label id="genderError" class="error">${map.genderError }</label>
		</td>
	</tr>
	<tr>
		<td width="100px">客户生日：</td>
		<td ><input type="text" name="birthday" id="birthday"  value="${c.birthday }"></td>
		<td>
			<label id="birthdayError" class="error">${map.birthdayError }</label>
		</td>
	</tr>
	<tr>
		<td width="100px">手机：</td>
		<td ><input type="text" name="cellphone" value="${c.cellphone }"></td>
		<td>
			<label id="cellphoneError" class="error">${map.cellphoneError }</label>
		</td>
	</tr>
	<tr>
		<td width="100px">邮箱：</td>
		<td ><input type="text" name="email" value="${c.email }"></td>
		<td>
			<label id="emailError" class="error">${map.emailError }</label>
		</td>
	</tr>
	<tr>
		<td width="100px">描述：</td>
		<td ><textarea rows="5" cols="17" name="description">${c.description }</textarea></td>
		<td>
			<label id="descriptionError" class="error">${map.descriptionError }</label>
		</td>
	</tr>
	<tr>
		<td ></td>
		<td ><input type="submit" value="提交">
		<input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</body>
</html>