$(document).ready(function(){
	getEmps(1);
	var lastPageClick;		// 初始化一个尾页按钮
	var nowPage;  			//当前页码
});


//全局方法
$(function(){
	
	
	//新增按钮被点击
	$("#emp_add").click(function(){
		// 查询部门信息

		getDept("#depts_add");
		$('#emp_model').modal({
			keyboard:"fasle"
		});

		// 清除内容格式
		$("#emp_add_form").find("*").removeClass("has-error has-success");
		$("#emp_add_form").find(".help-block").text("");


		//重置表单
		$("#emps_add_btn2").click();

	});
	
	
	//添加员工方法
	$("#emps_add_btn").click(function(){
		if(valdate_add_form()==false){
			return false;
		}
		if($("#emps_add_btn").attr("ajax_valdate") == "error"){
			return false;
		}

		$.ajax({
			url:"emp",
			type:"POST",
			data:$("#emp_add_form").serialize(),      //表单数据序列化为字符串
			success:function(result){
//				alert(resutlt.msg);
				//保存成功
				if(result.code == 200){
					//关闭模态框
					$('#emp_model').modal("hide");
					$("#emps_add_btn2").click();
					//来到最后一页
					lastPageClick.click();     //让尾页按钮点击
				}else{
					//显示错误信息 如果有邮箱错误信息  就显示
					if(undefined != result.map.fieldError.email){
						$("#email_add").parent().addClass("has-error");
						$("#email_add").next("span").text(result.map.fieldError.email);
					}
					if(undefined != result.map.fieldError.empName){
						$("#name_add").parent().addClass("has-error");
						$("#name_add").next("span").text("用户名必须是3~16位英文或者是2~5位汉字组合");
					}
				}
			}
		});
	});


	//当文本框内容变化的时候
	$("#name_add").change(function(){
		$("#name_add").parent().removeClass("has-error has-success");
		$.ajax({
			url:"checkUser",
			data:{"empName":this.value},
			type:"POST",
			success:function(result){
				if(result.code == 200){
					$("#name_add").parent().addClass("has-success");
					$("#name_add").next("span").text("用户名可用");
					$("#emps_add_btn").attr("ajax_valdate","success")
				}else{
					$("#name_add").parent().addClass("has-error");
					$("#name_add").next("span").text(result.map.val_msg);
					$("#emps_add_btn").attr("ajax_valdate","error")
				}

			}
		})

	});
	//校验邮箱
	$("#email_add").change(function(){
		$("#email_add").parent().removeClass("has-error has-success");
		var email = $("#email_add").val();
		var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		if(!regEmail.test(email)){
			$("#email_add").parent().addClass("has-error");
			$("#email_add").next("span").text("邮箱格式有误");
			return false;
		}else{
			$("#email_add").parent().addClass("has-success");
			$("#email_add").next("span").text("邮箱格式正确");
		}
	});

	
	//编辑按钮被点击
	$("#emps_update_btn").click(function(){
		updateEmp();
	})
	
	//删除按钮被点击
	$(document).on("click",".delete_btn",function(){
		//取出名字   查询父节点 tr 下的第二个td元素的 text
		var name =$(this).parents("tr").find("td:eq(2)").text();
		var id =  $(this).attr("del_id");
		//显示模态框
		$("#emp_delete_modal").modal("show");
		//显示要删除的用户
		$("#emp_delete_body").text(name);
		//确认删除
		$("#emp_delete").click(function(){
			$.ajax({
				url:"emp/" + id,
				type:"DELETE",
				success:function(result){
					//删除成功
//					关闭模态框
					$("#emp_delete_modal").modal("hide");
					//显示信息模态框
					$("#msg_modal").modal("show");
					$("#msg_modal_body").text(result.msg);
					getEmps(nowPage);
				}
			});
		});
	});
	
	//查询员工逻辑
	$("#selectBox").click(function(){
		  if($("#selectBox").find("option:selected").val() == 'dept'){
			  $("#depts_cx").show();
			  $("#selectMsg").hide();
			  $("#selectMsg").val("");
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

})


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
		var empCheckbox = $("<td></td>").append("<input type='checkbox' class='emp_checkbox' />")
		var empId = $("<td></td>") .append(item.empId);
		var empname =  $("<td> </td>") .append(item.empName);
		var gender =  $("<td></td>") .append(item.gender == '1'?'男':'女');
		var email =  $("<td></td>") .append(item.email);
		var deptName =  $("<td></td>") .append(item.dept.deptName);
		var bj_Btn = $("<button></button>").addClass("btn btn-info btn-sm edit_btn")
		.append($("<span class='glyphicon glyphicon-pencil'></span>")).append("编辑");

		// 把id放入按钮中
		bj_Btn.attr("update_id",item.empId)

		var del_Btn = $("<button></button>").addClass("btn btn-warning btn-sm delete_btn" )
		.append($("<span class='glyphicon glyphicon-remove '></span>")).append("删除");
		
		// 把id放入按钮中
		del_Btn.attr("del_id",item.empId)
		var btn = $("<td></td>").append(bj_Btn).append("&nbsp;").append(del_Btn)
		
		$("<tr></tr>").append(empCheckbox).
		append(empId)
		.append(empname)
		.append(gender)
		.append(email)
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

	//添加上一页和首页
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
	//添加下一页和尾页
	$("#page_nav").append(NextPage).append(LastPageLi);
}

//校验表单
function valdate_add_form(){
	var name = $("#name_add").val();
	var regName = /(^[a-z0-9_-]{3,16})|(^[\u2E80-\u9FFF]{2,5})/;

	// 如果有这两个属性 移除
	$("#name_add").parent().removeClass("has-error has-success");
	$("#email_add").parent().removeClass("has-error has-success");

	if(!regName.test(name)){
		//	 alert("用户名可以是3~16位英文或者是2~5位汉字组合")
		$("#name_add").parent().addClass("has-error");
		$("#name_add").next("span").text("用户名必须是3~16位英文或者是2~5位汉字组合");
		return false;
	}

	var email = $("#email_add").val();
	var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	if(!regEmail.test(email)){
		$("#email_add").parent().addClass("has-error");
		$("#email_add").next("span").text("邮箱格式有误");
		return false;
	}else{
		$("#email_add").parent().addClass("has-success");
		$("#email_add").next("span").text("邮箱格式正确");
	}
}

/*       编辑               */


//给编辑按钮绑定编辑事件  不能直接用click 也不能用live
$(document).on("click",".edit_btn",function(){
	//显示dept
	getDept("#depts_udpate");
	var empId = $(this).attr("update_id"); 	 		//获取当前被点击按钮的id
				
	
	//打开模态框
	$('#emp_model_update').modal({
		keyboard:"false"
	});
	
	//模态框打开之后再查询员工信息 	//按id查询出员工信息
	getEmpById(empId);		
	
	//给更新按钮赋值上员工id
	$("#emps_update_btn").attr("emp_id",empId);
	
})

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
		type:"PUT",			// 此处若要发PUT请求  需要在WEb.xml中配置一个过滤器
		data:$("#emp_update_form").serialize() ,	//post转为PUT请求 + "&_method=PUT"
		success:function(result){
//			alert(result.msg);
			$("#emp_model_update").modal("hide");
			getEmps(nowPage);
		}
	})
}
