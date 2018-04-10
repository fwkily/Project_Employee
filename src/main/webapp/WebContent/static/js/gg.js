$(document).ready(function() {
		getGg(1);
		var nowPage;
		var lastPageClick;
	});

	$(function() {
		//新增按钮被点击

		$("#gg_add").click(function() {
			// 查询部门信息
			$('#gg_model').modal("show");

			// 清除内容格式
			$("#gg_add_form").find("*").removeClass("has-error has-success");

			//重置表单
			$("#ggs_add_btn2").click();
		});
		$("#ggs_add_btn").click(function() {
			addGg();
		})
		
		
		
		
		
		//编辑按钮被点击
		$(document).on("click",".edit_btn",function(){
			 $("#gg_model_update").modal("show");
			 
			  // 清除内容格式
             $("#gg_update_form").find("*").removeClass("has-error has-success");

             //重置表单
             $("#gg_update_btn2").click();
			 
			 $("#ggId_update").text($(this).attr("gg_id"));      //把这个按钮上面存的id拿出来
			 $("#ggName_update").val($(this).attr("gg_name"));
			 
			  
			 
			 $("#gg_update_btn").click(function(){
                 updateDept();
             })
		});
		
		
		//单个删除按钮被点击
		$(document).on("click",".delete_btn",function(){
			//取出名字   查询父节点 tr 下的第二个td元素的 text
	        var name =$(this).parents("tr").find("td:eq(2)").text();
	        var id =  $(this).attr("del_id");
	        //显示模态框
	        $("#gg_delete_modal").modal("show");
	        //显示要删除的内容
	        $("#gg_delete_body").text(name);
	        
	        //确认删除
	        $("#gg_delete_btn").click(function(){
	            $.ajax({
	                url:"gg/" + id,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
                        //	 关闭模态框
	                    $("#gg_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getGg(nowPage);
	                }
	            });
	        });
		});
		
		//批量删除
		$("#gg_deleteAll").click(function(){
			var checkTd = $(".gg_checkbox:checked");     //每个被选中的框
			var ggContent = "";
			var ggIds = "";
			$.each(checkTd,function(){
				//alert($(this))  this当前正在遍历的元素
				ggContent+=$(this).parents("tr").find("td:eq(2)").text()+" \n " + ",";
				//拼装要到地址栏的字符串Id  获取删除按钮上的id 
				ggIds+=$(this).parents("tr").find("td:eq(4) button").attr("del_id") + "-";
				
			})
			
			$("#gg_delete_modal").modal("show");
	        //显示要删除的公告
	        ggSub = ggContent.substring(0,ggContent.length - 1);     //去掉最后一个，
	        $("#gg_delete_body").text(ggSub);
	        
	        ggsids = ggIds.substring(0,ggIds.length -1);         //去掉最后一个 - 
	        
	        console.log(ggsids)
	        $("#gg_delete_btn").click(function(){
	            $.ajax({
	                url:"gg/" + ggsids,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
	                	//关闭模态框
	                    $("#gg_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getGg(nowPage);
	                }
	            });
	        });
		});
		
		
		//全选  全不选
		$("#gg_checkboxAll").click(function(){
	        //attr获取自定义属性的值
	        //prop获取固定属性的值
	        $(".gg_checkbox").prop("checked",$(this).prop("checked"));
	    });
		$(document).on("click",".gg_checkbox",function(){
			var check =  $(".gg_checkbox:checked").length;    //选中的个数
			var allCheck = $(".gg_checkbox").length;             //单选框的个数
			var bool = (check==allCheck);                     //选中个数是否等于总个数
			
			 $("#gg_checkboxAll").prop("checked",bool);      // 
			
		});
		
		
	})

	
/*************************全局方法结束******************************/	
	
	
	//添加公告方法
	function addGg() {
		$.ajax({
			url : "gg",
			type : "POST",
			data : {
				"name" : $("#gg_addName").text(),"content":$("#gg_content").val()
			},
			success : function(result) {
                $('#gg_model').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
                getGg(1);
			}
		})
	}
	function getGg(pn) {

		$.ajax({
			url : "gg?pn=" + pn,
			type : "GET",
			dataType : "json",
			success : function(result) {
				$("#tab_body").empty();
				$.each(result.map.pageInfo.list,
						function(index, item) {

					//构建节点
					var ggCheckbox = $("<td></td>")
					.append(
					"<input type='checkbox' class='gg_checkbox' />")
					var ggId = $("<td></td>").append(
							item.empname);
					var ggName = $("<td> </td>")
					.append(item.content);
					var ggDesc = $("<td> </td>")
					.append(item.date);
					var bj_Btn = $("<button></button>")
					.addClass(
					"btn btn-info btn-sm edit_btn")
					.append(
							$("<span class='glyphicon glyphicon-pencil'></span>"))
							.append("编辑");
					// 把id和name放入按钮中
					bj_Btn.attr("gg_id", item.ggId)
					bj_Btn.attr("gg_name", item.ggName)

					var del_Btn = $("<button></button>")
					.addClass(
					"btn btn-warning btn-sm delete_btn")
					.append(
							$("<span class='glyphicon glyphicon-remove '></span>"))
							.append("删除");
					// 添加到

					del_Btn.attr("del_id",item.id)

					var btn_td = $("<td></td>")
					.append(del_Btn);

					$("<tr></tr>").append(ggCheckbox)
					.append(ggId).append(
							ggName).append(
									ggDesc).append(
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
				getGg(1);
			})
			// 上一页
			PrePage.click(function() {
				getGg(result.map.pageInfo.pageNum - 1);
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
				getGg(result.map.pageInfo.pageNum + 1);
			})
			// 尾页
			LastPageLi.click(function() {
				getGg(result.map.pageInfo.pages);
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
				getGg(item);
			})

			$("#page_nav").append(numLi);
		});
		$("#page_nav").append(NextPage).append(LastPageLi);
	}