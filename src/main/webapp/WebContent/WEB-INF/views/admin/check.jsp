<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<script language="javascript" type="text/javascript"
	src="static/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$("#kqSelectBox").click(function(){
        if($("#kqSelectBox").find("option:selected").val() == 'id'){
            $("#kqSelectMsg").removeAttr("onClick");
            $("#kqSelectMsg").attr("placeholder","请输入员工ID");
            $("#kqSelectMsg").val("");
        }else{
        	  $("#kqSelectMsg").attr("onClick","WdatePicker()");
              $("#kqSelectMsg").attr("placeholder","点击选择时间");
            
        }
    })
})
</script>
<script type="text/javascript" src="static/js/check.js"></script>
<!--    中部 -->
<div class="container-fluid">
	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">考勤</a></li>
		</ol>
		<h1>考勤管理</h1>
	</div>

	<!-- 			表格	  -->

	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<table class="table table-hover table-striped">
			<thead align="center" style="font-weight: bold;">
				<tr>

					<div class="col-md-6 col-md-offset-6">
						<span style="float: left; line-height: 34px;">考勤查询筛选条件:</span>
						<div class="col-sm-3 ">
							<select class="form-control" id="kqSelectBox">
								<option value="date">考勤时间</option>
								<option value="id">员工ID</option>
							</select>
						</div>
						<div class="col-lg-6">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="点击选择时间"
									onClick="WdatePicker()" id="kqSelectMsg">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default" id="kqSelectBtn">
										<span class="glyphicon glyphicon-search"></span>&nbsp;查询
									</button>

								</div>
							</div>
						</div>
					</div>
					</div>
					<td></td>
				</tr>
				<tr>
					<td>考勤时间</td>
					<td>打卡人员</td>
					<td>详细信息</td>

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
<!--     通用信息的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="dk_msg_modal">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">以下人员今天打卡:</h4>
			</div>
			<div class="modal-body">
				<p id="msg_modal_body">
				<table class="table table-hover table-striped" id="modal_table">
					<thead align="center" style="font-weight: bold;">
						<tr>
							<td>员工ID</td>
							<td>姓名</td>
							<td>部门</td>
						</tr>
					</thead>

					<tbody id="dk_msg_tab_body" align="center" class="">
                      <tr>
                        <td>1</td>
                         <td>2</td>
                          <td>3</td>
					   </tr>
					
					</tbody>

				</table>

				</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="emp_delete_btn"
					data-dismiss="modal">我知道了</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

</body>
</html>