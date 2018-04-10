<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<style>
    .table th{
        text-align: center;
    }

    textarea{
    
        resize: none;
    }
</style>
<script language="javascript" type="text/javascript"
    src="${path }/static/My97DatePicker/WdatePicker.js"></script>
<!-- 模态框  员工详细信息 -->
<!-- Small modal -->
<script type="text/javascript" src="${path }/static/js/ajaxfileupload.js"></script>
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
				<form method="post" id="empDate_form">
				<table class="table table-hover table-striped" id="data_modal_table"
                    width="980" height="679" border="1" cellpadding="0" cellspacing="0" style="border-color: rgba(124, 115, 115, 0.21);" >
                    <caption style="text-align: center;">
                    <span class="name"></span>个人资料</caption>
                    <tr>
                        <th valign="middle" width="166" scope="row">姓名</th>
                        <td width="166"><input class="form-control name" class="name" id="name" name="name" ></input></td>
                        <th width="166">性别</th>
                        <td width="166">
                        <select class="form-control" id="sex" name="sex">
                            <option value="男">男</option>
                             <option value="女">女</option>
                        </select>
                      </td>

							<td width="174" rowspan="4"><img
								style="padding: 0px; margin: 0px;" width="100%"
								height="180px" alt="照片" src="" class="imgMain"  />
							 <!--  -->
									<div class="file-container"
										style="display: inline-block; position: relative; overflow: hidden; vertical-align: bottom;">
										<button class="btn btn-success fileinput-button" style="cursor: pointer;" type="button">上传</button>
										<input type="file" accept=".jpg,.png,.gif,.jpeg" onchange="loadFile()"style="position: absolute; top: 0; left: 0; font-size: 34px; opacity: 0"
											name="imageFile" id="imageFile">
									
									<span id="filename" style="">未上传</span>
								</div>
								
								 
<!-- 								 <input type="file" id="imageFile" name="imageFile" /> -->
								 <script>
									function loadFile(file) {
										$("#filename").text("已选择");
									}
								</script></td>
						</tr>
                    <tr>
                        <th scope="row">出生年月</th>
                        <td>
                          <input type="text" class="form-control"  placeholder="出生年月" 
                                   onClick="WdatePicker()" id="birth" name="birth">
                        </td>
                        <th>身高/cm</th>
                        <td><input  class="form-control"  type="number" id="high" name="high"></input></td>
                    </tr>
                    <tr>
                        <th scope="row">籍贯</th>
                        <td><input  class="form-control"  type="text" id="area"  name="area"></input></td>
                        <th>名族</th>
                         <td><input  class="form-control"  type="text" id="ethnic" name="ethnic"></input></td>
                    </tr>
                    <tr>
                        <th scope="row">毕业院校</th>
                        <td colspan="3"><input  class="form-control"  type="text" id="school" name="school"></input></td>
                    </tr>
                    <tr>
                        <th scope="row">学历</th>
                       <td><input  class="form-control"  type="text" id="studyBg" name="studybg"></input></td>
                        <th>专业</th>
                        <td colspan="3" ><input  class="form-control"  type="text" id="major" name="major"></input></td>
                    </tr>
                    <tr>
                        <th scope="row">政治面貌</th>
                      <td><input  class="form-control"  type="text" id="ps" name="ps"></input></td>
                        <th>QQ</th>
                        <td colspan="2"><input  class="form-control"  type="text" id="qq" name="qq"></input></td>
                    </tr>
                    <tr>
                        <th scope="row">联系电话</th>
                        <td><input  class="form-control"  type="text" id="tel" name="tel"></input></td>
                        <th>电子邮箱</th>
                        <td colspan="2"><input  class="form-control"  type="text" id="mail" name="mail"></input></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">个人能力</th>
                        <td colspan="4"><textarea   class="form-control" id="myAbility" name="myability"></textarea></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">专业特长</th>
                         <td colspan="4"><textarea  class="form-control" id="mySpeciality" name="myspeciality"></textarea></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">教育经历</th>
                       <td colspan="4"><textarea  class="form-control" id="myTeach" name="myteach"></textarea></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">自我评价</th>
                       <td colspan="4"><textarea  class="form-control" id="myIdea" name="myidea"></textarea></td>
                    </tr>
                    
                      <tr>
                       <td colspan="5" align="center">
                         <input type="hidden" 
                         value="<shiro:principal  property='empId'></shiro:principal>"
                          id="empid" name="<shiro:principal  property='empId'></shiro:principal>"></input>
                       
                       <button type="button" id="empDate_add" class="btn btn-primary">
                            <span class="glyphicon glyphicon-floppy-open" aria-hidden="true"></span>
                                                 提交资料
                        </button></td>
                    </tr>
                </table>
            </form>
            
               <script type="text/javascript">
                   
                    </script>
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
	
	
	   <!--     上传简历的模态框 -->
    <div class="modal fade" tabindex="-1" role="dialog" id="dataSC_msg_modal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">上传简历:</h4>
                </div>
                <div class="modal-body">
                    <p id="dataSC_msg_modal_body">
                             <!--  -->
                             <span>仅能上传doc/docx文档</span>
                                    <div class="file-container"
                                        style="display: inline-block; position: relative; overflow: hidden; vertical-align: bottom;">
                                        <button class="btn btn-success fileinput-button" style="cursor: pointer;" type="button">点击选择文件</button>
                                        <input type="file" accept=".doc,.docx"  onchange="loadFile1()"style="position: absolute; top: 0; left: 0; font-size: 34px; opacity: 0"
                                            name="jlFile" id="jlFile">
                                    
                                    <span id="filename1" style="">未选择</span>
                                </div>
                                
                                 
<!--                                 <input type="file" id="imageFile" name="imageFile" /> -->
                                 <script>
                                    function loadFile1() {
                                        $("#filename1").text("已选择");
                                    }
                                </script>
                    
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="tjjl_btn" >提交简历</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->