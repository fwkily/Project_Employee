$(document).ready(function() {
		getDept(1);
		var nowPage;
		var lastPageClick;
	});

	$(function() {
		//新增按钮被点击

		$("#dept_add").click(function() {
			// 查询部门信息
			$('#dept_model').modal("show");

			// 清除内容格式
			$("#dept_add_form").find("*").removeClass("has-error has-success");

			//重置表单
			$("#dept_add_btn2").click();

			$("#dept_add_btn").click(function() {
				addDept();
				getDept(nowPage);
			})

		});
		
		//编辑按钮被点击
		$(document).on("click",".edit_btn",function(){
			 $("#dept_model_update").modal("show");
			 
			  // 清除内容格式
             $("#dept_update_form").find("*").removeClass("has-error has-success");

             //重置表单
             $("#dept_update_btn2").click();
			 
			 $("#deptId_update").text($(this).attr("dept_id"));      //把这个按钮上面存的id拿出来
			 $("#deptName_update").val($(this).attr("dept_name"));
			 
			  
			 
			 $("#dept_update_btn").click(function(){
                 updateDept();
             })
		});
		
		
		//单个删除按钮被点击
		$(document).on("click",".delete_btn",function(){
			//取出名字   查询父节点 tr 下的第二个td元素的 text
	        var name =$(this).parents("tr").find("td:eq(2)").text();
	        var id =  $(this).attr("del_id");
	        //显示模态框
	        $("#dept_delete_modal").modal("show");
	        //显示要删除的用户
	        $("#dept_delete_body").text(name);
	        
	        //确认删除
	        $("#dept_delete_btn").click(function(){
	            $.ajax({
	                url:"deptsMsg/" + id,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
                        //	 关闭模态框
	                    $("#dept_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getDept(nowPage);
	                }
	            });
	        });
		});
		
		
		
		
		
	})

	function updateDept(){
		$.ajax({
			url:"deptsMsg",
			type : "PUT",
            data : {
            	"id":$("#deptId_update").text(),
                "name" : $("#deptName_update").val()
            },
            success : function(result) {
            	//返回500 就是部门已经存在
                if(result.code==500){
                    $("#deptName_update").parent().addClass("has-error");
                    $("#deptName_update").next("span").text("部门名称已经存在")
                } else{
                $('#dept_model_update').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
              
                getDept(nowPage);
                }
            }
			
		})
	}
	
	
	
	//添加部门方法
	function addDept() {
		$.ajax({
			url : "deptsMsg",
			type : "POST",
			data : {
				"name" : $("#dept_addName").val()
			},
			success : function(result) {
				//返回500 就是部门已经存在
			    if(result.code==500){
			    	$("#dept_addName").parent().addClass("has-error");
			    	$("#dept_addName").next("span").text("部门名称已经存在")
			    } else{
                $('#dept_model').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
                //点击尾页按钮
                lastPageClick.click();
			    }
			}
		})
	}
	function getDept(pn) {

		$.ajax({
					url : "deptsMsg?pn=" + pn,
					type : "GET",
					dataType : "json",
					success : function(result) {
						$("#tab_body").empty();
						$.each(result.map.pageInfo.list,
										function(index, item) {

											//构建节点
											var deptCheckbox = $("<td></td>")
													.append(
															"<input type='checkbox' class='dept_checkbox' />")
											var deptId = $("<td></td>").append(
													item.deptId);
											var deptName = $("<td> </td>")
													.append(item.deptName);
											var deptDesc = $("<td> </td>")
													.append(item.deptDesc);
											var bj_Btn = $("<button></button>")
													.addClass(
															"btn btn-info btn-sm edit_btn")
													.append(
															$("<span class='glyphicon glyphicon-pencil'></span>"))
													.append("编辑");
											// 把id和name放入按钮中
											bj_Btn.attr("dept_id", item.deptId)
											bj_Btn.attr("dept_name", item.deptName)
											
											var del_Btn = $("<button></button>")
													.addClass(
															"btn btn-warning btn-sm delete_btn")
													.append(
															$("<span class='glyphicon glyphicon-remove '></span>"))
													.append("删除");
											// 添加到
											
											del_Btn.attr("del_id",item.deptId)
											
											var btn_td = $("<td></td>").append(
													bj_Btn).append("&nbsp;")
													.append(del_Btn);

											$("<tr></tr>").append(deptCheckbox)
													.append(deptId).append(
															deptName).append(
															deptDesc).append(
															btn_td).appendTo(
															"#tab_body");
										})
					
										   //显示分页信息
								        build_page_info(result);
								        build_page_nav(result);
					}
				});
	}

	//显示分页数据
	function build_page_info(result) {
		$("#page_info").empty();
		$("#page_info").append(
				"当前第" + result.map.pageInfo.pageNum + "页 总"
						+ result.map.pageInfo.pages + "页 总共"
						+ result.map.pageInfo.total + "条数据 ");
		nowPage = result.map.pageInfo.pageNum;
	}

	//显示分页导航
	function build_page_nav(result) {
		$("#page_nav").empty();
		var FirstPageLi = $("<li></li>").append(
				$("<a></a>").attr("href", "javascript:void(0)").append("首页"));
		var PrePage = $("<li></li>").append(
				$("<a></a>").attr("href", "javascript:void(0)").append(
						"&laquo;"));

		// 如果没有上一页
		if (result.map.pageInfo.hasPreviousPage == false) {
			FirstPageLi.addClass("disabled");
			PrePage.addClass("disabled");
		} else {
			// 如果有上一页 再绑定点击事件
			//去首页
			FirstPageLi.click(function() {
				getDept(1);
			})
			// 上一页
			PrePage.click(function() {
				getDept(result.map.pageInfo.pageNum - 1);
			})
		}

		var NextPage = $("<li></li>").append(
				$("<a></a>").attr("href", "javascript:void(0)").append(
						"&raquo;"));
		var LastPageLi = $("<li></li>").append(
				$("<a></a>").attr("href", "javascript:void(0)").append("尾页"));
		lastPageClick = LastPageLi; //  尾页按钮赋值
		//  如果没有下一页
		if (result.map.pageInfo.hasNextPage == false) {
			NextPage.addClass("disabled");
			LastPageLi.addClass("disabled");
		} else {
			//  如果有下一页 再绑定点击事件
			// 下一页
			NextPage.click(function() {
				getDept(result.map.pageInfo.pageNum + 1);
			})
			// 尾页
			LastPageLi.click(function() {
				getDept(result.map.pageInfo.pages);
			})
		}

		$("#page_nav").append(FirstPageLi).append(PrePage);

		$.each(result.map.pageInfo.navigatepageNums, function(index, item) {
			var numLi = $("<li></li>").append(
					$("<a></a>").attr("href", "javascript:void(0)")
							.append(item));

			// 如果当前页码等于遍历的页码  让这个li高亮
			if (result.map.pageInfo.pageNum == item) {
				numLi.addClass("active");
			}

			// 给各个页码添加点击事件
			numLi.click(function() {
				getDept(item);
			})

			$("#page_nav").append(numLi);
		});
		$("#page_nav").append(NextPage).append(LastPageLi);
	}