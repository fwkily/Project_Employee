<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<!--     导航栏 -->
<script type="text/javascript" src="${path }/static/js/user/task.js"></script>
<!--    中部 -->
<div class="container-fluid">
	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">任务</a></li>
		</ol>
		<h1>任务信息</h1>
		
	</div>

	<!-- 			表格	  -->

	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<table class="table table-hover table-striped">
			<thead align="center" style="font-weight: bold;">
				<tr>
					 <td><font size="-6" color="#BBB" style="text-align: left;">(只显示和我有关的任务)</font></td>
				</tr>
				<tr>
					<td>任务类别</td>
					<td>任务摘要</td>
					<td>发布者</td>
					<td>发布时间</td>
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

	<!-- 模态框 -->




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
                <button type="button" class="btn btn-primary" id="task_delete_btn" data-dismiss="modal">我知道了</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!--     显示任务信息的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="rw_modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">任务信息:</h4>
            </div>
            <div class="modal-body">
                <p id="rw_modal_body">
                   
                    
                    
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="task_delete_btn" data-dismiss="modal">我知道了</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<input type="hidden" value="${path }" id="path">

</body>
</html>