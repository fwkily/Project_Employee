<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
<!--
function delEmps(id){
	 //确认删除
    $.ajax({
        url:"emp/" + id,
        type:"DELETE",
        success:function(result){
            //删除成功
//          关闭模态框
            $("#emp_delete_modal").modal("hide");
            //显示信息模态框
            $("#msg_modal").modal("show");
            $("#msg_modal_body").text(result.msg);
            getEmps(nowPage);
        }
    });	
}
$(function(){
	//删除按钮被点击
    $(document).on("click",".delete_btn",function(){
        //取出名字   查询父节点 tr 下的第二个td元素的 text
        var name =$(this).parents("tr").find("td:eq(2)").text();
        var id =  $(this).attr("del_id");
        //显示模态框
        $("#emp_delete_modal").modal("show");
        //显示要删除的用户
        $("#emp_delete_body").text(name);
    });
})
//-->
</script>
<!-- 模态框  新增 -->
<!-- Small modal -->
<div class="modal fade" tabindex="-1" id="emp_model" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">新增员工</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->
				<form class="form-horizontal" id="emp_add_form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name_add"
								name="empName" placeholder="姓名"> <span id="helpBlock2"
								class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-4">
							<select class="form-control" id="gender_add" name="gender">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-10 ">
							<input type="text" class="form-control" id="email_add"
								name="email" placeholder="邮箱"> <span id="helpBlock2"
								class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">部门</label>
						<div class="col-sm-4">
							<!--   提交部门Id -->
							<select class="form-control" id="depts_add" name="dId">

							</select>
						</div>
					</div>
			</div>
			<div class="modal-footer">
				<button type="reset" id="emps_add_btn2" class="btn btn-default">重置</button>
				<button type="button" id="emps_add_btn" class="btn btn-primary">提交</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->



<!-- 模态框 编辑 -->
<div class="modal fade" tabindex="-1" id="emp_model_update"
	role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">编辑员工信息</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->
				<form class="form-horizontal" id="emp_update_form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-10">
							<p class="form-control-static" id="empName_update"></p>
							<span id="helpBlock2" class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-4">
							<select class="form-control" id="gender_update" name="gender">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-10 ">
							<input type="text" class="form-control" id="email_update"
								name="email" placeholder="邮箱"> <span id="helpBlock2"
								class="help-block"></span>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">部门</label>
						<div class="col-sm-4">
							<!--   提交部门Id -->
							<select class="form-control" id="depts_udpate" name="dId">

							</select>
						</div>
					</div>
			</div>
			<div class="modal-footer">
				<button type="reset" id="emps_update_btn2" class="btn btn-default">重置</button>
				<button type="button" id="emps_update_btn" class="btn btn-primary">更新</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--     删除用户的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog"
	id="emp_delete_modal">
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
				<p id="emp_delete_body"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" id="emp_delete">确认</button>
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
				<button type="button" class="btn btn-primary" data-dismiss="modal">我知道了</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->




