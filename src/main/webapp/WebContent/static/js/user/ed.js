$(document).ready(function(){
	CxEmp($("#Cxempid").text());

});
$(function(){

	//下载按钮被点击
	$(document).on("click",".downMsg_btn",function(){
		download($(this).attr("downcx_id"));
	});

	$(document).on("click","#empDate_add",function(){

		if($("#name").val()==""||$("#tel").val()==""){
			$("#data_msg_modal").modal("show");
			$("#data_msg_modal_body").text("请填写完整！")
			return false;
		}
		updateEmpdata();
		$("#empData_model").modal("hide");	
	
	});
	
	//提交简历按钮被单击

	$(document).on("click","#tjjl_btn",function(){
		   $("#filename1").text("未选择");
		scJl();
	})
	
})
//查询员工资料
function CxEmp(empid){
	$.ajax({
		url:$("#path").val() + "/empData",
		data:{"empid":empid},
		type:"GET",
		success:function(result){

			if(result.map.msg==""){
				$("#data_msg_modal").modal("show");
				$("#data_msg_modal_body").text("你还没有提交个人信息，请提交！")
				$("#emp_delete_btn").click(function(){
					$("#empData_model").modal("show");	
				});
			}
//查询出来一起设置内容
			$.each(result.map.msg,function(index,item){
				$(".name").text(item.name);
				$(".sex").text(item.sex);
				$(".school").text(item.school);
				$(".tel").text(item.tel);
				$(".qq").text(item.qq);
				$(".mail").text(item.mail);
				$(".birth").text(item.birth);
				$(".major").text(item.major);
				$(".high").text(item.high);
				$(".birth").text(item.birth);
				$(".studyBg").text(item.studybg);
				$(".ps").text(item.ps);
				$(".ethnic").text(item.ethnic);
				$(".area").text(item.area);
				$(".myAbility").text(item.myability);
				$(".mySpeciality").text(item.myspeciality);
				$(".myTeach").text(item.myteach);
				$(".myIdea").text(item.myidea);

				$("#name").val(item.name),
				$("#sex").val(item.sex)
				$("#school").val(item.school),
				$("#tel").val(item.tel),
				$("#qq").val(item.qq),
				$("#mail").val(item.mail),
				$("#birth").val(item.birth),
				$("#major").val(item.major),
				$("#high").val(item.high),
				$("#birth").val(item.birth),
				$("#studyBg").val(item.studybg),
				$("#ps").val(item.ps),
				$("#ethnic").val(item.ethnic),
				$("#area").val(item.area),
				$("#myAbility").val(item.myability),
				$("#mySpeciality").val(item.myspeciality),
				$("#myTeach").val(item.myteach),
				$("#myIdea").val(item.myidea)

				if(item.img==""||item.img==null){
					$("#img").attr("src",$("#path").val() + '/static/img/icon.jpg');

				}else{
					$(".imgMain").attr("src",$("#path").val() + '/static/img/' + item.img);
					$("#filename").text("已上传");
					
				}

			});
		}
	});
}

//下载简历  首先用ajax判断他是否存在  如果不存在 就弹窗  存在就下载
function download(id){
	$.ajax({
		url:"static/doc/" + id + ".docx",
		type:"GET",
		success:function(result){
			window.location.href = "static/doc/" + id + ".docx";
		},
		error:function(){
			$("#data_msg_modal").modal("show");
			$("#data_msg_modal_body").text("该员工未提交个人简历，请在员工后台提交！")
		}
	})
}


function updateEmpdata(){
	$.ajaxFileUpload({
		url:"empData",
		type:"post",
		data:$("#empDate_form").serialize(),
		fileElementId:'imageFile',
		data:{
			"empid":$("#empid").val(),
			"name":$("#name").val(),
			"sex":$("#sex").val(),
			"school":$("#school").val(),
			"tel":	$("#tel").val(),
			"qq":	$("#qq").val(),
			"mail":$("#mail").val(),
			"birth":$("#birth").val(),
			"major":$("#major").val(),
			"high":$("#high").val(),
			"birth":$("#birth").val(),
			"studybg":$("#studyBg").val(),
			"ps":$("#ps").val(),
			"ethnic":$("#ethnic").val(),
			"area":$("#area").val(),
			"myability":$("#myAbility").val(),
			"myspeciality":$("#mySpeciality").val(),
			"myteach":$("#myTeach").val(),
			"myidea":$("#myIdea").val()

		},
		secureuri: false, //是否需要安全协议，一般设置为false
		dataType: "JSON",
		success: function(result){
			$("#data_msg_modal").modal("show");
			$("#data_msg_modal_body").text("处理成功");
			CxEmp($("#Cxempid").text());
		}
	})
}


//上传简历
function scJl(){
	$.ajaxFileUpload({
		url:"scJl",
		type:"post",
		fileElementId:'jlFile',
		secureuri: false, 				//是否需要安全协议，一般设置为false
		dataType: "JSON",
		success: function(result){
				$('#dataSC_msg_modal').modal('hide');
				$("#data_msg_modal").modal("show");
				$("#data_msg_modal_body").text("提交成功");
		}
	})
}
