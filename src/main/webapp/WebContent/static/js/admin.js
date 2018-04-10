$(document).ready(function() {
		getAdmin(1);
		var nowPage;
		var lastPageClick;
	});

	$(function() {
		//新增按钮被点击

		$("#admin_add").click(function() {
			$('#admin_model').modal("show");
			
			// 清除内容格式
			$("#admin_add_form").find("*").removeClass("has-error has-success");
			
			//重置表单
			$("#admin_add_btn2").click();

			$("#admin_add_btn").click(function() {
				addAdmin();
				getAdmin(nowPage);
			})

		});
		
		//编辑按钮被点击
		$(document).on("click",".edit_btn",function(){
			 $("#admin_model_update").modal("show");
			 
			  // 清除内容格式
             $("#admin_update_form").find("*").removeClass("has-error has-success");
             $("#adminName_update").next("span").text("")
             //重置表单
             $("#admin_update_btn2").click();
			 
			 $("#adminId_update").text($(this).attr("admin_id"));      //把这个按钮上面存的id拿出来
			 
			 $("#admin_update_btn").click(function(){
                 updateAdmin();
             })
		});
		
		
		//单个删除按钮被点击
		$(document).on("click",".delete_btn",function(){
			//取出名字   查询父节点 tr 下的第二个td元素的 text
	        var name =$(this).parents("tr").find("td:eq(2)").text();
	        var id =  $(this).attr("del_id");
	        //显示模态框
	        $("#admin_delete_modal").modal("show");
	        //显示要删除的用户
	        $("#admin_delete_body").text(name);
	        
	        //确认删除
	        $("#admin_delete_btn").click(function(){
	            $.ajax({
	                url:"adminMsg/" + id,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
                        //	 关闭模态框
	                    $("#admin_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getAdmin(nowPage);
	                }
	            });
	        });
		});
		
		//批量删除
		$("#admin_deleteAll").click(function(){
			var checkTd = $(".admin_checkbox:checked");     //每个被选中的框
			var adminContent = "";
			var adminIds = "";
			$.each(checkTd,function(){
				//alert($(this))  this当前正在遍历的元素
				adminContent+=$(this).parents("tr").find("td:eq(2)").text()+" \n " + ",";
				//拼装要到地址栏的字符串Id  获取删除按钮上的id 
				adminIds+=$(this).parents("tr").find("td:eq(4) .delete_btn").attr("del_id") + "-";
				
			})
			if(adminIds==""){
				return false;
			}
			$("#admin_delete_modal").modal("show");
	        //显示要删除的用户
	        adminSub = adminContent.substring(0,adminContent.length - 1);     //去掉最后一个，
	        $("#admin_delete_body").text(adminSub);
	        
	        adminids = adminIds.substring(0,adminIds.length -1);         //去掉最后一个 - 
	        
	        $("#admin_delete_btn").click(function(){
	            $.ajax({
	                url:"adminMsg/" + adminids,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
	                	//关闭模态框
	                    $("#admin_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                     getAdmin(nowPage);
	                    $("#admin_checkboxAll").prop("checked",false);
	                }
	            });
	        });
		});
		//全选  全不选
		$("#admin_checkboxAll").click(function(){
	        //attr获取自定义属性的值
	        //prop获取固定属性的值
	        $(".admin_checkbox").prop("checked",$(this).prop("checked"));
	    });
		$(document).on("click",".admin_checkbox",function(){
			var check =  $(".admin_checkbox:checked").length;    //选中的个数
			var allCheck = $(".admin_checkbox").length;             //单选框的个数
			var bool = (check==allCheck);                     //选中个数是否等于总个数
			
			 $("#admin_checkboxAll").prop("checked",bool);      // 
			
		});
		
		
		
	})

	//重置密码
	function updateAdmin(){
		var p1 = $("#adminName_update2").val();
		var p2 = $("#adminName_update").val();
		 if(p1!=p2||p1==""||p2==""){
             $("#adminName_update").parent().addClass("has-error");
             $("#adminName_update").next("span").text("两次密码不一致")
         } else{
		$.ajax({
			url:"adminMsg",
			type : "PUT",
            data : {
            	"id":$("#adminId_update").text(),
                "pwd" : $("#adminName_update").val()
            },
            success : function(result) {
            	//返回500 就是部门已经存在
               
                $('#admin_model_update').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
                getAdmin(nowPage);
                }
            });
		}
	}
	
	
	
	//添加管理员方法
	function addAdmin() {
		$.ajax({
			url : "adminMsg",
			type : "POST",
			data : $("#admin_add_form").serialize(),
			success : function(result) {
				//返回500 就是部门已经存在
			    if(result.code==500){
			    	$("#adminname").parent().addClass("has-error");
			    	$("#adminname").next("span").text("管理员名称已经存在")
			    } else{
                $('#admin_model').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
                //点击尾页按钮
                getAdmin(nowPage);
			    }
			}
		})
	}
	
	//查询所有
	function getAdmin(pn) {

		$.ajax({
			url : "adminMsg?pn=" + pn,
			type : "GET",
			dataType : "json",
			success : function(result) {
				$("#tab_body").empty();
				$.each(result.map.pageInfo.list,
						function(index, item) {

					//构建节点
					var adminCheckbox = $("<td></td>")
					.append(
					"<input type='checkbox' class='admin_checkbox' />")
					var adminId = $("<td></td>").append(
							item.id);
					var adminName = $("<td> </td>")
					.append(item.adminname);
					var adminDesc = $("<td> </td>")
					.append(item.adminpower==0?'普通管理员':'超级管理员');
					var bj_Btn = $("<button></button>")
					.addClass(
					"btn btn-info btn-sm edit_btn")
					.append(
							$("<span class='glyphicon glyphicon-pencil'></span>"))
							.append("重置密码");
					// 把id和name放入按钮中
					bj_Btn.attr("admin_id", item.id)

					var del_Btn = $("<button></button>")
					.addClass(
					"btn btn-warning btn-sm delete_btn")
					.append(
							$("<span class='glyphicon glyphicon-remove '></span>"))
							.append("删除");
					// 添加到

					del_Btn.attr("del_id",item.id)

					var btn_td = $("<td></td>").append(
							bj_Btn).append("&nbsp;")
							.append(del_Btn);

					$("<tr></tr>").append(adminCheckbox)
					.append(adminId).append(
							adminName).append(
									adminDesc).append(
											btn_td).appendTo(
													"#tab_body");
				})

				//显示分页信息
				build_page_info(result);
				build_page_nav(result);
			}
		});
	}
	
	
	/**********************分页逻辑**********************/

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
				getAdmin(1);
			})
			// 上一页
			PrePage.click(function() {
				getAdmin(result.map.pageInfo.pageNum - 1);
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
				getAdmin(result.map.pageInfo.pageNum + 1);
			})
			// 尾页
			LastPageLi.click(function() {
				getAdmin(result.map.pageInfo.pages);
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
				getAdmin(item);
			})

			$("#page_nav").append(numLi);
		});
		$("#page_nav").append(NextPage).append(LastPageLi);
	}