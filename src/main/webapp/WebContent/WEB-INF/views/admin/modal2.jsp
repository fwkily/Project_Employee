<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 模态框  新增 -->
<!-- Small modal -->
<div class="modal fade" tabindex="-1" id="dept_model" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">新增部门</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->
				<form class="form-horizontal" id="dept_add_form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-10">
							<span class="help-block">由系统自动生成</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">名称</label>
						<div class="col-sm-10 ">
							<input type="text" class="form-control has-error" id="dept_addName"
								name="dept_name" placeholder="部门名称"> 
								<span id="helpBlock2" class="help-block"></span>
						</div>
					</div>
					
			</div>
			<div class="modal-footer">
				<button type="reset" id="dept_add_btn2" class="btn btn-default">重置</button>
				<button type="button" id="dept_add_btn" class="btn btn-primary">提交</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->



<!-- 模态框 编辑 -->
<div class="modal fade" tabindex="-1" id="dept_model_update"
	role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">编辑部门信息</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->
				<form class="form-horizontal" id="dept_update_form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-10">
							<p class="form-control-static" id="deptId_update"></p>
							<span id="helpBlock2" class="help-block"></span>
						</div>
					</div>
					

					<div class="form-group">
						<label class="col-sm-2 control-label">名称</label>
						<div class="col-sm-10 ">
							<input type="text" class="form-control" id="deptName_update"
								name="dept_name" placeholder="部门名称"> <span id="helpBlock2"
								class="help-block"></span>
						</div>
					</div>

			</div>
			<div class="modal-footer">
				<button type="reset" id="dept_update_btn2" class="btn btn-default">重置</button>
				<button type="button" id="dept_update_btn" class="btn btn-primary">更新</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--     删除用户的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="dept_delete_modal">
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
				<p id="dept_delete_body"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" id="dept_delete_btn">确认</button>
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
                <button type="button" class="btn btn-primary" id="dept_delete_btn" data-dismiss="modal">我知道了</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->




