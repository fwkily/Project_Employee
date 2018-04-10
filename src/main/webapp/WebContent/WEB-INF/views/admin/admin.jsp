<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<!--     导航栏 -->
<script type="text/javascript" src="static/js/admin.js"></script>
<!--    中部 -->
<div class="container-fluid">
	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">管理员</a></li>
		</ol>
		<h1>管理员管理</h1>
	</div>

	<!-- 			表格	  -->

	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<table class="table table-hover table-striped">
			<thead align="center" style="font-weight: bold;">
				<tr>
					<div class="col-md-2 col-md-offset-0">
						<button type="button" id="admin_add" class="btn btn-primary">
							<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
							新增
						</button>
						<button type="button" class="btn btn-danger" id="admin_deleteAll">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							删除
						</button>
					</div>
					
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input type="checkbox" id="admin_checkboxAll" /></td>
					<td>管理员ID</td>
					<td>管理员用户名</td>
					<td>管理员权限</td>
					<td>操作</td>

				</tr>
			</thead>

			<tbody id="tab_body" align="center" class="">

				<!-- On rows -->

			</tbody>

		</table>

		<!-- 分页导航 -->
		<!-- 分页文字信息 -->
		<div class="col-md-5 col-md-offset-5">
			<span class="label label-default" id="page_info"></span>


			<!-- 页码 -->
			<nav aria-label="Page navigation">

				<ul class="pagination pagination-sm" id="page_nav">
					<!-- 					分页信息 -->
				</ul>
			</nav>
		</div>
	</div>

	<jsp:include page="adminmodal.jsp"></jsp:include>

</div>
</body>
</html>