<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<!--     导航栏 -->
<script type="text/javascript" src="static/js/task.js"></script>
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
					<div class="col-md-2 col-md-offset-0">
					<button type="button" class="btn btn-primary" id="task_add">
                            <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                             发布任务
                        </button>
						<button type="button" class="btn btn-danger" id="task_deleteAll">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							批量删除
						</button>
					</div>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input type="checkbox" id="task_checkboxAll" /></td>
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



<!--     删除用户的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="task_delete_modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">是否删除？</h4>
            </div>
            <div class="modal-body">
                <p id="task_delete_body"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="task_delete_btn">确认</button>
            </div>
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


<!-- 发布任务的模态框 -->
<!-- 模态框  新增 -->
<!-- Small modal -->
<div class="modal fade" tabindex="-1" id="task_model" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">任务发布</h4>
            </div>
            <div class="modal-body">

                <!--                        表单 -->
                <form class="form-horizontal" id="task_add_form">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">任务名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tnmae"
                                name="tnmae" placeholder="任务名称"> <span id="helpBlock2"
                                class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">任务类别</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="tclass"  id="tclass">
                                <option value="0">单人任务</option>
                                <option value="1">部门任务</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">任务内容</label>
                        <div class="col-sm-10 ">
                            <textarea type="text" class="form-control" id="tcontent"
                                name="tcontent" placeholder="任务内容"></textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">任务指派(由谁完成)</label>
                        <div class="col-sm-10">
                            <!--   提交部门Id -->
                            <div id="target"><input class="form-control" type="text" name="target" id="task_target" >
                            <font size="-6" color="#BBB">(此处输入员工ID，以“,”分隔) <a href="l" target="_blank">不知道员工ID?</a>
                            </font>
                            </div>
                          <div class="btn-group" role="group" id="depts_add" style="display: none;">
						    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						     选择部门
						      <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu"  id="depts_add_ul">
						      

						    </ul>
						  </div>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="task_add_btn" class="btn btn-primary">提交</button>
            </div>
            </form>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->




</body>
</html>