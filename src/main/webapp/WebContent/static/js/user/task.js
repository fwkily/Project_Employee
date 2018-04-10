$(document).ready(function() {
		getTask(1);
		var nowPage;
		var lastPageClick;
	});

	$(function() {
		
		//查看详细按钮被点击
		$(document).on("click",".edit_btn",function(){
			//取出名字   查询父节点 tr 下的第二个td元素的 text
	        var id =  $(this).attr("task_id");
	        //显示模态框
	        $("#rw_modal").modal("show");	    
	      
	            $.ajax({
	                url: $("#path").val() + "/taskByid/" + id,
	                type:"GET",
	                success:function(result){
	                	  $("#rw_modal_body").empty();
	                		//构建节点
	                		$("#rw_modal_body").append(
	                				"<dt>任务类别</dt><dd>" + 
	                				(result.map.task.tclass==0?'单人任务':'部门任务') + 
	                				"</dd><dt>任务摘要</dt><dd>" + 
	                				result.map.task.tnmae + 
	                				"</dd><dt>任务内容</dt><dd>"+
	                				result.map.task.tcontent + 
	                				"</dd><dt>任务指派(由谁完成)</dt><dd>" +
	                				result.map.task.target +
	                				"</dd><dt>任务发布者</dt><dd>" +
	                				result.map.task.tadmin +
	                				"</dd><dt>任务发布时间</dt><dd>" +
	                				result.map.task.tdate +
	                				"</dd>");
	                	}
	            });
	        });
		});

	
/*************************全局方法结束******************************/	
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
					var optionEle = $(" <li></li>").append($("<a href='javascript:;'></a>").append(this.deptName).attr("value",this.deptId));
					// 添加到
					optionEle.appendTo(ele);
				})
			}
		});
	}

	function getTask(pn) {

		$.ajax({
			url : "task?pn=" + pn,
			type : "GET",
			dataType : "json",
			success : function(result) {
				$("#tab_body").empty();
				$.each(result.map.pageInfo.list,
						function(index, item) {

					//构建节点
					var taskClass = $("<td></td>").append(item.tclass==0?'单人任务':'部门任务');
					var taskName = $("<td> </td>").append(item.tnmae);
					var taskContent = $("<td> </td>").append(item.tcontent);
					var taskTarget = $("<td> </td>").append(item.target);
					var taskAdmin = $("<td> </td>").append(item.tadmin);
					var taskDate = $("<td> </td>").append(item.tdate);
					var bj_Btn = $("<button></button>").addClass("btn btn-info btn-sm edit_btn")
					.append($("<span class='glyphicon glyphicon-pencil'></span>")).append("查看任务详细");
					
					
//					del_Btn.attr("del_id",item.id)
					bj_Btn.attr("task_id",item.id)
					$("<tr></tr>")
					.append(taskClass).append(taskName)
					.append(taskAdmin).append(taskDate)
					.append($("<td> </td>").append(bj_Btn))
					.appendTo("#tab_body");
				})

				//显示分页信息
				build_page_info(result);
				build_page_nav(result);
			}
		});
	}
	
	
	
	
	
	
	
	

	/********************显示分页数据*********************/
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
				getTask(1);
			})
			// 上一页
			PrePage.click(function() {
				getTask(result.map.pageInfo.pageNum - 1);
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
				getTask(result.map.pageInfo.pageNum + 1);
			})
			// 尾页
			LastPageLi.click(function() {
				getTask(result.map.pageInfo.pages);
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
				getTask(item);
			})

			$("#page_nav").append(numLi);
		});
		$("#page_nav").append(NextPage).append(LastPageLi);
	}