<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="${path }/static/js/user/ed.js"></script>
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
<jsp:include page="empDataModal.jsp"></jsp:include>
	<div class=" col-md-offset-2 col-sm-6 col-xs-12">
		<table class="table table-hover table-striped" border="1" style="border-color: rgba(124, 115, 115, 0.21);">
				  <caption style="text-align: center;">
                    ID<span id="Cxempid"><shiro:principal  property="empId"></shiro:principal></span>个人资料</caption>
                    <tr>
                        <th valign="middle" width="166" scope="row">姓名</th>
                        <td width="166"><span class="name"></span></td>
                        <th width="166">性别</th>
                        <td width="166"><span class="sex"></span></td>
                        <td width="174" rowspan="4">
                        <img style="padding: 0px;margin: 0px;" class="imgMain"
                         width="100%" height="180px" alt="照片" src="" /></td>
                    </tr>
                    <tr>
                        <th scope="row">出生年月</th>
                        <td><span class="birth"></span></td>
                        <th>身高/Cm</th>
                        <td><span class="high"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">籍贯</th>
                        <td><span class="area"></span></td>
                        <th>名族</th>
                        <td><span class="ethnic"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">毕业院校</th>
                        <td colspan="3"><span class="school"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">学历</th>
                        <td><span class="studyBg"></span></td>
                        <th>专业</th>
                        <td colspan="3" ><span class="major"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">政治面貌</th>
                        <td><span class="ps"></span></td>
                        <th>QQ</th>
                        <td colspan="2"><span class="qq"></span></td>
                    </tr>
                    <tr>
                        <th scope="row">联系电话</th>
                        <td><span class="tel"></span></td>
                        <th>电子邮箱</th>
                        <td colspan="2"><span class="mail"></span></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">个人能力</th>
                        <td colspan="4"><span class="myAbility"></span></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">专业特长</th>
                        <td colspan="4"><span class="mySpeciality"></span></td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">教育经历</th>
                        <td colspan="4"><span class="myTeach"></span>
                      </td>
                    </tr>
                    <tr>
                        <th height="85" scope="row">自我评价</th>
                        <td colspan="4"><span class="myIdea"></span></td>
                    </tr>
                    <tr>
                    <td colspan="5" align="center">
                         <input type="hidden" value="<shiro:principal  property="empId"></shiro:principal>" id="empid" name="<shiro:principal  property="empId"></shiro:principal>"></input>
                       
                       <button type="button"  class="btn btn-primary" onclick="javascript:$('#empData_model').modal('show')">
                            <span class="glyphicon glyphicon-floppy-open" aria-hidden="true"></span>
                                                 更新资料
                        </button>
                        
                         <button type="button"  class="btn btn-warning" onclick="javascript:$('#dataSC_msg_modal').modal('show')">
                            <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
                                                 上传简历
                        </button>
                        
                        </td>
                       </tr>
                    
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

<input type="hidden" value="${path }" id="path"></input>
</body>
</html>

