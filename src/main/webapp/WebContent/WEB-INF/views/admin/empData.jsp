<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="static/js/ed.js"></script>
<!--     导航栏 -->

<!--    中部 -->
<div class="container-fluid">
	<div class=" col-md-offset-0 col-sm-12 col-xs-12 col-md-offset-2">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">资料</a></li>
		</ol>
		<h1>资料管理</h1>
	</div>

	<!-- 			表格	  -->

	<div class=" col-md-offset-0 col-sm-12 col-xs-12">
		<table class="table table-hover table-striped">
			<thead align="center" style="font-weight: bold;">
				<div class="col-md-5 col-md-offset-6">
					<form action="" id="searchEmp">
						<span style="float: left; line-height: 34px;">查询员工条件:</span>
						<div class="col-sm-3 ">
							<select class="form-control" id="selectBox" name="selectBox">
								<option value="name">姓名</option>
								<option value="id">ID</option>
								<option value="dept">部门</option>
							</select>
						</div>

						<div class="col-lg-6">
							<div class="input-group">
								<!--   提交部门Id -->
								<select class="form-control depts_cx" id="depts_cx" name="did"
									style="display: none">

								</select> <input type="text" class="form-control" placeholder="输入查询信息"
									id="selectMsg" name="selectMsg">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default" id="selectBtn">
										<span class="glyphicon glyphicon-search"></span>&nbsp;查询
									</button>

								</div>
								<!-- /btn-group -->
							</div>
							<!-- /input-group -->
						</div>
						<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
				</form>
				</div>

				<tr>
					<td>员工ID</td>
					<td>姓名</td>
					<td>部门</td>
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
</div>
</div>
<jsp:include page="empDataModal.jsp"></jsp:include>
</body>
</html>

