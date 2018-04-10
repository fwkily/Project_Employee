<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!DOCTYPE html>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人事管理系统</title>

<!-- 不加/以资源路径为准    容易出问题 -->

<!--     引入Jquery -->
<script src="${path}/static/js/jquery1.12.4.min.js"></script>
<!-- 引入bootstrap样式 -->
<link href="${path}/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
<link href="${path}/static/nav/default.css" rel="stylesheet"
	type="text/css" />
<script src="${path}/static/nav/default.js" type="text/javascript"></script>
<script type="text/javascript">
  
</script>

<style type="text/css">
/*自定义滚动条*/
::-webkit-scrollbar {
	width: 5px;
} /*侧边栏宽度*/
::-webkit-scrollbar-track {
	background-color: #333;
}

::-webkit-scrollbar-thumb {
	background-color: #666;
}

::-webkit-scrollbar-thumb:hover {
	background-color: #9c3
}

::-webkit-scrollbar-thumb:active {
	background-color: #00aff0
}
</style>
<script type="text/javascript">
  $(function(){
	  $("#xg_add_btn").click(function(){
		  
		var oldPwd = $("#oldPwd").val();
		var newPwd = $("#newPwd").val();
		var newPwd2 = $("#newPwd2").val();
		
		if(oldPwd!=""&&newPwd!=""&&newPwd!=""){
			if(newPwd!=newPwd2){
				$("#msg_modal").modal("show");
	            $("#msg_modal_body").text("两次密码输入必须一致！");
	            return false;
			} 
			if(newPwd.length<3||newPwd2.length<3){
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text("密码长度必须大于3位");
                return false;
            } 
			$.ajax({
				url:"updatePwd",
				method:"POST",
				data:$("#xg_form").serialize(),
				success:function(result){
					if(result.map.scount==-1){
						$("#msg_modal").modal("show");
	                    $("#msg_modal_body").text("原密码不正确！");
	                    return false;
					}else{
						$("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    
	                    $('#xg_model').modal('hide');
	                    
					}
				}
			});
			
		}else{
			$("#msg_modal").modal("show");
			$("#msg_modal_body").text("请填写完整！");
			  return false;
		}
		
	  });
  });



</script>

</head>
<body>
	<!-- 发布任务的模态框 -->
	<!-- 模态框  修改 -->
	<!-- 模态框  新增 -->
	<!-- Small modal -->
	<div class="modal fade" tabindex="-1" id="xg_model" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<div class="modal-body">

					<!--                        表单 -->
					<form class="form-horizontal" id="xg_form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">员工姓名</label>
							<div class="col-sm-10">
								<span class="help-block"><shiro:principal
										property="empName"></shiro:principal> </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">原密码</label>
							<div class="col-sm-10 ">
								<input type="password" class="form-control has-error"
									id="oldPwd" name="oldPwd" placeholder="输入原密码"> <span
									id="helpBlock2" class="help-block"></span>

							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">新密码</label>
							<div class="col-sm-10 ">
								<input type="password" class="form-control has-error"
									id="newPwd" name="newPwd" placeholder="输入新密码"> <span
									id="helpBlock2" class="help-block"></span>

							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">确认密码</label>
							<div class="col-sm-10 ">
								<input type="password" class="form-control has-error"
									id="newPwd2" name="newPwd2" placeholder="确认新密码"> <span
									id="helpBlock2" class="help-block"></span>

							</div>
						</div>
				</div>
				<div class="modal-footer">
					<input type="hidden"
						value="<shiro:principal  property='empId'></shiro:principal>"
						name="id">
					<button type="reset" id="xg_add_btn2" class="btn btn-default">重置</button>
					<button type="button" id="xg_add_btn" class="btn btn-primary">提交</button>
				</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!--     通用信息的模态框 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="msg_modal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">来自服务器的提示信息:</h4>
				</div>
				<div class="modal-body">
					<p id="msg_modal_body"></p>
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

    <!-- 导航栏 -->

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<!-- 左侧隐藏侧边栏按钮 -->
				<button type="button" class="navbar-toggle show pull-left"
					data-target="sidebar">
					<span class="glyphicon glyphicon-chevron-left"
						style="color: white;"></span>
				</button>
				<!-- 隐藏用户按钮 -->
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="l"
					style="line-height: 28px; font: 20px;">人事管理系统</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false"><i
							class="glyphicon glyphicon-user"></i>&nbsp; 员工: <shiro:principal
								property="empName"></shiro:principal>&nbsp; <span class="caret"></span></a>

						<ul class="dropdown-menu" role="menu">
							<li><a href="javascript:$('#xg_model').modal('show');$('#xg_form')[0].reset();">
									<span class="glyphicon glyphicon-edit"></span> 改 密
							</a></li>
							<li class="divider"></li>
							<li><a href="${path }/logout"><span
									class="glyphicon glyphicon-log-out"></span> 注 销</a></li>

						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid all">
		<div class="sidebar">
			<ul class="nav">
				<li>

					<p style="text-align: center;">
						<img alt="" src="${path }/static/img/icon.jpg"
							style="width: 100px; height: 100px; border-radius: 50px; margin-top: 20px;">
						<br> <span style="color: #999; line-height: 50px;">员工:
							<shiro:principal property="empName"></shiro:principal>
						</span>
					</p>
				</li>
				<li><a href="i"> <span class="glyphicon glyphicon-th"></span>
						信息总览
				</a></li>
				<li><a href="z"><span class="glyphicon glyphicon-signal"></span>
						我的资料</a></li>
				<li><a href="k"><span class="glyphicon glyphicon-user"></span>
						模拟打卡</a></li>
				<li><a href="${path }/user/t"><span
						class="glyphicon glyphicon-home"></span> 查看任务</a></li>
				<li><a href="w"><span class="glyphicon glyphicon-user"></span>
						留言板</a></li>
			</ul>
		</div>
		<div class="maincontent">