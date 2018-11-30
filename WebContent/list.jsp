<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#deleteC").click(function() {
			return confirm("是否确认删除");
		})
	})
</script>
</head>
<body>
	<h3 align="center">客户列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>客户姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>手机</th>
			<th>邮箱</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pb.beanList }" var="it">
			<tr>
				<td>${it.cname }</td>
				<td>${it.gender }</td>
				<td>${it.birthday }</td>
				<td>${it.cellphone }</td>
				<td>${it.email }</td>
				<td>${it.description }</td>
				<td><a
					href="<c:url value='/customerServlet?method=preEdit&cid=${it.cid }'/>">编辑</a>
					<a id="deleteC"
					href="<c:url value='/customerServlet?method=deleteCustomer&cid=${it.cid }'/>">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<center>
		第${pb.pc }页/共${pb.tp }页 <a
			href="${pb.url }&PC=1 ">首页</a>
		<c:if test="${pb.pc>1 }">
			<a	href="${pb.url }&PC=${pb.pc-1 }">上一页</a>
		</c:if>
		
<c:choose>
	<c:when test="${pb.tp<10 }">
		<c:set var="begin" value="1"/>
		<c:set var="end"  value="${pb.tp }"/>
	</c:when>
	<c:otherwise>
		<c:set var="begin" value="${pb.pc-5 }"/>
		<c:set var="end" value="${pb.pc+4 }"/>
		
		<c:if test="${begin<1 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="10"></c:set>
		</c:if>
		
		<c:if test="${end>pb.tp }">
			<c:set var="begin" value="${pb.tp-9 }"></c:set>
			<c:set var="end" value="${pb.tp }"></c:set>
		</c:if>
	</c:otherwise>
</c:choose>
		
<c:forEach var="i" begin="${begin }" end="${end }">
	<c:choose>
		<c:when test="${i eq pb.pc }">
			[${i }]
		</c:when>
		<c:otherwise>
			<a href="${pb.url }&PC=${i }">[${i }]</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
		
		<c:if test="${pb.pc<pb.tp }">
			<a	href="${pb.url }&PC=${pb.pc+1 } ">下一页</a>
		</c:if>
		<a
			href="${pb.url }&PC=${pb.tp }">尾页</a>
	</center>
</body>
</html>