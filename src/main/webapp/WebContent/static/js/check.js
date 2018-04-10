$(document).ready(function(){
	showCheckMsg(1);
})

$(function(){
	//查看详细按钮绑定点击事件
	$(document).on("click","#cxMsg",function(){

		//取得所有id
		var ids = $(this).parents("tr").find("td:eq(1)").text();
		$.ajax({
			url:"checkMsgAll",
			type:"GET",
			data:{"ids":ids},
			success:function(result){
				//显示信息模态框
				$("#dk_msg_modal").modal("show");
				build_msgAll(result);
			}
		})

	});


	//查询按钮被点击
	$("#kqSelectBtn").click(function(){
		//选择框选中的值
		cxCheck(1);
	});

})
//查询考勤
function cxCheck(pn){
	var selectVal = $("#kqSelectBox option:checked").val();
	var inputVal = $("#kqSelectMsg").val();

	if(inputVal!=""){
		$.ajax({
			url:"cxCheck",
			type:"GET",
			data:{"select":selectVal,"msg":inputVal,"pn":pn},
			success:function(result){
				build_table(result);
				build_page_info(result);
				build_page_nav(result);
			}
		});
	}else{
		alert("查询条件不可为空！");

	}


}


//考勤总览
function showCheckMsg(pn){
	$.ajax({
		url:"checkMsg",
		type:"GET",
		data:{"pn":pn},
		success:function(result){
			build_table(result);
			build_page_info(result);
			build_page_nav1(result);
		}
	})
}

//构建表格
function build_table(result){
	$("#tab_body").empty();
	$.each(result.map.pageInfo.list,function(index,item){

		var dateTd = $("<td></td>").append(item.date);
		var epmid = $("<td></td>").append(item.epmid);
		var xxxx = $("<td></td>").append($("<button></button>").addClass("btn btn-primary").attr("id","cxMsg").append("查看详细"))
		$("<tr></tr>").append(dateTd).append(epmid).append(xxxx).appendTo("#tab_body");
	})

}

//显示详细模态框
function build_msgAll(result){
	$("#dk_msg_tab_body").empty();
	$.each(result.map.list,function(index,item){
		
		var eid = $("<td></td>").append(item.empId);
		var ename = $("<td></td>").append(item.empName);
		var edept = $("<td></td>").append(item.dept.deptName);
		$("<tr></tr>").append(eid).append(ename).append(edept).appendTo("#dk_msg_tab_body");
	});
}

/***********************************分页逻辑****************************/
//显示分页数据
function build_page_info(result){
	$("#page_info").empty();
	$("#page_info").append("当前第"  +
			result.map.pageInfo.pageNum  + 
			"页 总" + 
			result.map.pageInfo.pages  + 
			"页 共" + 
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
			showCheckMsg(1);
		})
		// 上一页
		PrePage.click(function(){
			showCheckMsg(result.map.pageInfo.pageNum - 1 );
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
			showCheckMsg(result.map.pageInfo.pageNum + 1 );
		})  
		// 尾页
		LastPageLi.click(function(){
			showCheckMsg(result.map.pageInfo.pages );
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
			showCheckMsg(item);
		})

		$("#page_nav").append(numLi);
	});
	$("#page_nav").append(NextPage).append(LastPageLi);
}

//查询的分页
function build_page_nav1(result){
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
			cxCheck(1);
		})
		// 上一页
		PrePage.click(function(){
			cxCheck(result.map.pageInfo.pageNum - 1 );
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
			cxCheck(result.map.pageInfo.pageNum + 1 );
		})  
		// 尾页
		LastPageLi.click(function(){
			cxCheck(result.map.pageInfo.pages );
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
			cxCheck(item);
		})

		$("#page_nav").append(numLi);
	});
	$("#page_nav").append(NextPage).append(LastPageLi);
}



/***********************************分页逻辑****************************/