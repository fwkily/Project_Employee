$(document).ready(function(){
	getEmps(1);
	var lastPageClick;		// 初始化一个尾页按钮
	var nowPage;  			//当前页码
});


$(function(){
	//查询员工逻辑
	$("#selectBox").click(function(){
		$("#selectMsg").val("");
		if($("#selectBox").find("option:selected").val() == 'dept'){
			$("#depts_cx").show();
			$("#selectMsg").hide();
			$("#selectMsg").val("1");
			getDept("#depts_cx");
		}else{
			$("#depts_cx").hide();
			$("#selectMsg").show();
		}
	})

	$("#depts_cx").click(function(){
		var v = $("#depts_cx").find("option:selected").val();
		$("#selectMsg").val(v);
	})

	//查询按钮被点击
	$("#selectBtn").click(function(){
		$.ajax({
			url:"findEmp",
			method:"GET",
			data:$("#searchEmp").serialize(),
			success:function(result){
				if(result.map.pageInfo.list == ""){
					//显示信息模态框
					$("#msg_modal").modal("show");
					$("#msg_modal_body").text("没有查询到信息,请检查输入条件");
				}else{

					build_page_table(result);
					build_page_info(result);
					build_page_nav(result);
				}
			}
		})
	});
	
	
	//查看详细资料被点击
	$(document).on("click",".cxMsg_btn",function(){
		CxEmp($(this).attr("cx_id"));
	});
	
	
	//下载按钮被点击
	$(document).on("click",".downMsg_btn",function(){
		download($(this).attr("downcx_id"));
	});
	
	
})

//查询员工资料
function CxEmp(empid){
	$.ajax({
		url:"empData",
		data:{"empid":empid},
		type:"GET",
		success:function(result){
			if(result.map.msg!=""){
				$("#empData_model").modal("show");
			$.each(result.map.msg,function(index,item){
				$(".name").text(item.name);
				$("#sex").text(item.sex);
				$("#school").text(item.school);
				$("#tel").text(item.tel);
				$("#qq").text(item.qq);
				$("#mail").text(item.mail);
				$("#birth").text(item.birth);
				$("#major").text(item.major);
				$("#high").text(item.high);
				$("#birth").text(item.birth);
				$("#studyBg").text(item.studybg);
				$("#ps").text(item.ps);
				$("#ethnic").text(item.ethnic);
				$("#area").text(item.area);
				$("#myAbility").text(item.myability);
				$("#mySpeciality").text(item.myspeciality);
				$("#myTeach").text(item.myteach);
				$("#myIdea").text(item.myidea);
				$("#img").attr("src",'static/img/' + item.img);
			});
			}else{
				$("#data_msg_modal").modal("show");
				$("#data_msg_modal_body").text("该员工未提交个人资料，请在员工后台提交！")
			}
		}
			
	})
}

//下载简历  首先用ajax判断他是否存在  如果不存在 就弹窗  存在就下载
 	function download(id){
 		$.ajax({
 			url:"static/doc/" + id + ".doc",
 			type:"GET",
 			success:function(result){
 				window.location.href = "static/doc/" + id + ".doc";
 			},
 			error:function(){
 				$("#data_msg_modal").modal("show");
				$("#data_msg_modal_body").text("该员工未提交个人简历，请在员工后台提交！")
 			}
 		})
 	}





//查询部门信息
function getDept(ele){
	$.ajax({
		url:"depts",
		trye:"GET",
		dataType:"json",
		success:function(result){
			$(ele).empty();
			$.each(result.map.depts,function(index,item){
				// 构建节点
				var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
				// 添加到
				optionEle.appendTo(ele);
			})
		}
	});
}


function getEmps(pn){

	$.ajax({
		url:"emps",
		data:{"pn":pn},
		dataType:"json",
		type:"GET",
		success:function(result){
			build_page_table(result);
			build_page_info(result);
			build_page_nav(result);
		}
	});
}


function build_page_table(result){
	$("#tab_body").empty();
	//获取emps集合并遍历
	var emps = result.map.pageInfo.list;
	$.each(emps,function(index,item){
		var empId = $("<td></td>") .append(item.empId);
		var empname =  $("<td> </td>") .append(item.empName);
		var gender =  $("<td></td>") .append(item.gender == '1'?'男':'女');
		var email =  $("<td></td>") .append(item.email);
		var deptName =  $("<td></td>") .append(item.dept.deptName);
		var bj_Btn = $("<button></button>").addClass("btn btn-info btn-sm cxMsg_btn")
		.append($("<span class='glyphicon glyphicon-zoom-in'></span>")).append(" 查看资料");

		// 把id放入按钮中
		bj_Btn.attr("cx_id",item.empId)

		var del_Btn = $("<button></button>").addClass("btn btn-warning btn-sm downMsg_btn" )
		.append($("<span class='glyphicon glyphicon-cloud-download'></span>")).append(" 下载简历");

		// 把id放入按钮中
		del_Btn.attr("downcx_id",item.empId)
		var btn = $("<td></td>").append(bj_Btn).append("&nbsp;").append(del_Btn)

		$("<tr></tr>").
		append(empId)
		.append(empname)
		.append(deptName)
		.append(btn)
		.appendTo("#tab_body");

	});
}

//显示分页数据
function build_page_info(result){
	$("#page_info").empty();
	$("#page_info").append("当前第"  +
			result.map.pageInfo.pageNum  + 
			"页 总" + 
			result.map.pageInfo.pages  + 
			"页 总共" + 
			result.map.pageInfo.total + 
	"条数据 ");
	nowPage = result.map.pageInfo.pageNum;
}

//显示分页导航
function build_page_nav(result){
	$("#page_nav").empty();
	var FirstPageLi = $("<li></li>").append($("<a></a>").attr("href","javascript:void(0)").append("首页"));
	var PrePage = $("<li></li>").append($("<a></a>").attr("href","javascript:void(0)").append("&laquo;"));

	// 如果没有上一页
	if(result.map.pageInfo.hasPreviousPage == false){
		FirstPageLi.addClass("disabled");
		PrePage.addClass("disabled");
	}else{
		// 如果有上一页 再绑定点击事件
		//去首页
		FirstPageLi.click(function(){
			getEmps(1);
		})
		// 上一页
		PrePage.click(function(){
			getEmps(result.map.pageInfo.pageNum - 1 );
		})
	}


	var NextPage = $("<li></li>").append($("<a></a>").attr("href","javascript:void(0)").append("&raquo;"));
	var LastPageLi = $("<li></li>").append($("<a></a>").attr("href","javascript:void(0)").append("尾页"));
	lastPageClick = LastPageLi;		//  尾页按钮赋值
	//  如果没有下一页
	if(result.map.pageInfo.hasNextPage == false){
		NextPage.addClass("disabled");
		LastPageLi.addClass("disabled");
	}else{
		//  如果有下一页 再绑定点击事件
		// 下一页
		NextPage.click(function(){
			getEmps(result.map.pageInfo.pageNum + 1 );
		})  
		// 尾页
		LastPageLi.click(function(){
			getEmps(result.map.pageInfo.pages );
		})   
	}


	$("#page_nav").append(FirstPageLi).append(PrePage);

	$.each(result.map.pageInfo.navigatepageNums,function(index,item){
		var numLi = $("<li></li>").append($("<a></a>").attr("href","javascript:void(0)").append(item));

		// 如果当前页码等于遍历的页码  让这个li高亮
		if(result.map.pageInfo.pageNum == item){
			numLi.addClass("active");
		}

		// 给各个页码添加点击事件
		numLi.click(function(){
			getEmps(item);
		})

		$("#page_nav").append(numLi);
	});
	$("#page_nav").append(NextPage).append(LastPageLi);
}

/*       编辑               */

//按id查询员工
function getEmpById(id){
	$.ajax({
		url:"emp/" + id,
		type:"GET",
		cache:false,
		success:function(result){
			var emp = result.map.emp;
			$("#empName_update").text(emp.empName);
			$("#gender_update").val([emp.gender]);	//把参数放在中括号中就能让他选中
			$("#email_update").val(emp.email);
			$("#depts_udpate").val([emp.dId]);
		}

	})
}

function updateEmp(){
	$.ajax({
		url:"emp/" + $("#emps_update_btn").attr("emp_id"),
		type:"PUT",			// 此处若要发PUT请求  需要在WEb.xml中配置
		data:$("#emp_update_form").serialize() ,	//post转为PUT请求 + "&_method=PUT"
		success:function(result){
//			alert(result.msg);
			$("#emp_model_update").modal("hide");
			getEmps(nowPage);
		}
	})
}
