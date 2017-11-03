<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
<script src="<%=basePath%>resources/js/back/list.js"></script>
<title>列表页</title>
</head>
<body style="background: #e1e9eb;">
		<form action="<%=basePath%>list.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删 除</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">指令：</td>
								<td>
									<input type="text" class="allInput" name="command" value="${command}"/>
								</td>
								<td width="90" align="right">描述：</td>
								<td>
									<input type="text" class="allInput" name="description" value="${description}"/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="#"/></th>
								    <th>序号</th>
								    <th>指令</th>
								    <th>描述</th>
								    <th>操作</th>
								</tr>
								
								<c:forEach items="${messageList}" var="mes" varStatus="status">
								<c:if test="${mes.id%2 == 0}">
									<tr style="background-color:#ECF6EE;">
								</c:if>
								<c:if test="(int)${mes.id}%2==1">						
									<tr>
								</c:if>
									<td><input type="checkbox" name="id" value="${mes.id}" id="checkbox"/></td>
									<td>${mes.id}</td>
									<td>${mes.command}</td>
									<td>${mes.description}</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="<%=basePath%>deleteone.action?id=${mes.id}" onclick="return go()">删除</a>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
</html>