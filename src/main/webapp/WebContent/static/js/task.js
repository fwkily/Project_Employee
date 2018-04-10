$(document).ready(function() {
		getTask(1);
		var nowPage;
		var lastPageClick;
	});

	$(function() {
		
		//单个删除按钮被点击
		$(document).on("click",".delete_btn",function(){
			//取出名字   查询父节点 tr 下的第二个td元素的 text
	        var name =$(this).parents("tr").find("td:eq(2)").text();
	        var id =  $(this).attr("del_id");
	        //显示模态框
	        $("#task_delete_modal").modal("show");
	        //显示要删除的内容
	        $("#task_delete_body").text(name);
	        
	        //确认删除
	        $("#task_delete_btn").click(function(){
	            $.ajax({
	                url:"task/" + id,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
                        //	 关闭模态框
	                    $("#task_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getTask(nowPage);
	                }
	            });
	        });
		});
		
		//批量删除
		$("#task_deleteAll").click(function(){
			var checkTd = $(".task_checkbox:checked");     //每个被选中的框
			var taskContent = "";
			var taskIds = "";
			$.each(checkTd,function(){
				//alert($(this))  this当前正在遍历的元素
				taskContent+=$(this).parents("tr").find("td:eq(2)").text()+" \n " + ",";
				//拼装要到地址栏的字符串Id  获取删除按钮上的id 
				taskIds+=$(this).parents("tr").find("td:eq(5) .delete_btn").attr("del_id") + "-";
				
			})
			if(taskIds==""){
				return false;
			}
			$("#task_delete_modal").modal("show");
	        //显示要删除的用户
	        taskSub = taskContent.substring(0,taskContent.length - 1);     //去掉最后一个，
	        $("#task_delete_body").text(taskSub);
	        
	        taskids = taskIds.substring(0,taskIds.length -1);         //去掉最后一个 - 
	        
//	        console.log(taskids)
	        $("#task_delete_btn").click(function(){
	            $.ajax({
	                url:"task/" + taskids,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
	                	//关闭模态框
	                    $("#task_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getTask(nowPage);
	                    $("#task_checkboxAll").prop("checked",false);
	                }
	            });
	        });
		});
		
		
		//全选  全不选
		$("#task_checkboxAll").click(function(){
	        //attr获取自定义属性的值
	        //prop获取固定属性的值
	        $(".task_checkbox").prop("checked",$(this).prop("checked"));
	    });
		$(document).on("click",".task_checkbox",function(){
			var check =  $(".task_checkbox:checked").length;    //选中的个数
			var allCheck = $(".task_checkbox").length;             //单选框的个数
			var bool = (check==allCheck);                     //选中个数是否等于总个数
			
			 $("#task_checkboxAll").prop("checked",bool);      // 
			
		});
		
		
		
		//查看详细按钮被点击
		$(document).on("click",".edit_btn",function(){
			//取出名字   查询父节点 tr 下的第二个td元素的 text
	        var id =  $(this).attr("task_id");
	        //显示模态框
	        $("#rw_modal").modal("show");	    
	      
	            $.ajax({
	                url:"taskByid/" + id,
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
		
		//发布任务
		$("#task_add").click(function(){
			$("#task_model").modal("show");
			//重置表单
			$("#task_add_form")[0].reset();
			$("#tclass").click(function(){
				 if($("#tclass").find("option:selected").val() == "0"){
					  $("#target").show();
					  $("#depts_add").hide();
					  $("#task_target").val("");
					  $("#task_target").removeAttr("readonly");
					  $("#task_target").attr("placeholder","填写员工ID");
				  }else{
					  $("#task_target").attr("readonly","readonly");
					  $("#task_target").attr("placeholder","点击下方选择部门，ID自动填写");
					  $("#depts_add").show();
					  getDept("#depts_add_ul");
					  
					  $(document).on("click","#depts_add_ul li a",function(){
						  var deptId = $(this).attr("value");
						  $("#task_target").val( $("#task_target").val() + deptId + ",")
					  })
				  }
			});
		
			$("#task_add_btn").click(function(){
				if($("#tnmae").val()!=""&&$("#tconent").val()!=""&&$("#task_target").val()!=""){
//				//发送请求
				$.ajax({
					url:"task",
					method:"POST",
					data:$("#task_add_form").serialize(),
					success:function(result){
						  $("#task_model").modal("hide");
						  $("#msg_modal").modal("show");
		                  $("#msg_modal_body").text(result.msg);
		                  getTask(1);
					}
				});
				}else{
					alert("请填写完整！")
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
	//添加任务方法
	function addGg() {
		$.ajax({
			url : "task",
			type : "POST",
			data : {
				"name" : $("#task_addName").text(),"content":$("#task_content").val()
			},
			success : function(result) {
                $('#task_model').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
                getTask(1);
			}
		})
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
					var taskCheckbox = $("<td></td>").append("<input type='checkbox' class='task_checkbox' />");
					var taskClass = $("<td></td>").append(item.tclass==0?'单人任务':'部门任务');
					var taskName = $("<td> </td>").append(item.tnmae);
					var taskContent = $("<td> </td>").append(item.tcontent);
					var taskTarget = $("<td> </td>").append(item.target);
					var taskAdmin = $("<td> </td>").append(item.tadmin);
					var taskDate = $("<td> </td>").append(item.tdate);
					var bj_Btn = $("<button></button>").addClass("btn btn-info btn-sm edit_btn")
					.append($("<span class='glyphicon glyphicon-pencil'></span>")).append("查看任务详细");
					
					var del_Btn = $("<button></button>").addClass("btn btn-warning btn-sm delete_btn")
					.append($("<span class='glyphicon glyphicon-remove '></span>")).append("删除");
					
					del_Btn.attr("del_id",item.id)
					bj_Btn.attr("task_id",item.id)

					var btn_td = $("<td></td>").append(bj_Btn).append("&nbsp;")
					.append(del_Btn);

					$("<tr></tr>").append(taskCheckbox)
					.append(taskClass).append(taskName)
					.append(taskAdmin).append(taskDate)
					.append(btn_td).appendTo("#tab_body");
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