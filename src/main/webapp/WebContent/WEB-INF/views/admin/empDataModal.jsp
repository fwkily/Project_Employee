<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    .table th{
        text-align: center;
    }

</style>
<script type="text/javascript">

</script>
<!-- 模态框  员工详细信息 -->
<!-- Small modal -->
<div class="modal fade" tabindex="-1" id="empData_model" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">员工资料</h4>
			</div>
			<div class="modal-body">

				<!--                        表单 -->

				<table class="table table-hover table-striped" id="data_modal_table"
                    width="980" height="679" border="1" cellpadding="0" cellspacing="0" >
                    <caption style="text-align: center;"><span class="name"></span>个人资料</caption>
                    <tr>
                        <th valign="middle" width="166" scope="row">姓名</th>
                        <td width="166"><span class="name"></span></td>
                        <th width="166">性别</th>
                        <td width="166"><span id="sex"></span></td>
                        <td width="174" rowspan="4"><img style="padding: 0px;margin: 0px;" id="img" width="170px" height="42%" alt="照片" src="" /></td>
                    </tr>
                    <tr>
                        <th scope="row">出生年月</th>
                        <td><span id="birth"></span></td>
                        <th>身高/cm</th>
                        <td><span id="high"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">籍贯</th>
                        <td><span id="area"></span></td>
                        <th>名族</th>
                        <td><span id="ethnic"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">毕业院校</th>
                        <td colspan="3"><span id="school"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">学历</th>
                        <td><span id="studyBg"></span></td>
                        <th>专业</th>
                        <td colspan="3" ><span id="major"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">政治面貌</th>
                        <td><span id="ps"></span></td>
                        <th>QQ</th>
                        <td colspan="2"><span id="qq"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">联系电话</th>
                        <td><span id="tel"></span></td>
                        <th>电子邮箱</th>
                        <td colspan="2"><span id="mail"></span></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">个人能力</th>
                        <td colspan="4"><span id="myAbility"></span></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">专业特长</th>
                        <td colspan="4"><span id="mySpeciality"></span></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">教育经历</th>
                        <td colspan="4"><span id="myTeach"></span>
                      </td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">自我评价</th>
                        <td colspan="4"><span id="myIdea"></span></td>
                    </tr>
                </table>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</div>
	<!--     通用信息的模态框 -->
	<div class="modal fade" tabindex="-1" role="dialog" id="data_msg_modal">
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
					<p id="data_msg_modal_body"></p>
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