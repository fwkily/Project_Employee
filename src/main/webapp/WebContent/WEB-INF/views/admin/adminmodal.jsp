<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 模态框  新增 -->
<!-- Small modal -->
<div class="modal fade" tabindex="-1" id="admin_model" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">新增管理员</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->
				<form class="form-horizontal" id="admin_add_form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">ID</label>
						<div class="col-sm-10">
							<span class="help-block">由系统自动生成</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-10 ">
							<input type="text" class="form-control" id="adminname"
								name="adminname" placeholder="用户名"> 
								<span id="helpBlock2" class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
                        <label class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10 ">
                            <input type="password" class="form-control" id="adminpwd"
                                name="adminpwd" placeholder="密码"> 
                                <span id="helpBlock2" class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">权限</label>
                        <div class="col-sm-10 ">
                            <select style="width:180px;" class="form-control" id="adminpower"
                                name="adminpower">
                            <option value="0">普通管理员</option>    
                               <option value="1">超级管理员</option>      
                             </select>
                        </div>
                    </div>
					
			</div>
			<div class="modal-footer">
				<button type="reset" id="admin_add_btn2" class="btn btn-default">重置</button>
				<button type="button" id="admin_add_btn" class="btn btn-primary">提交</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->



<!-- 模态框 编辑 -->
<div class="modal fade" tabindex="-1" id="admin_model_update"
	role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">编辑管理员信息</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->
				<form class="form-horizontal" id="admin_update_form">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">管理员ID</label>
						<div class="col-sm-10">
							<p class="form-control-static" id="adminId_update"></p>
							<span id="helpBlock2" class="help-block"></span>
						</div>
					</div>
					

					<div class="form-group">
						<label class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-10 ">
							<input type="text" class="form-control" id="adminName_update"
								name="admin_name" placeholder="输入新密码"> <span id="helpBlock2"
								class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
                        <label class="col-sm-2 control-label">确认密码</label>
                        <div class="col-sm-10 ">
                            <input type="text" class="form-control" id="adminName_update2"
                                name="admin_name2" placeholder="确认新密码"> <span id="helpBlock2"
                                class="help-block"></span>
                        </div>
                    </div>

			</div>
			<div class="modal-footer">
				<button type="reset" id="admin_update_btn2" class="btn btn-default">重置</button>
				<button type="button" id="admin_update_btn" class="btn btn-primary">更新</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--     删除用户的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="admin_delete_modal">
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
				<p id="admin_delete_body"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-primary" id="admin_delete_btn">确认</button>
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
                <button type="button" class="btn btn-primary" id="admin_delete_btn" data-dismiss="modal">我知道了</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->




