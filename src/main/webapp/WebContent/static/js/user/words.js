$(document).ready(function() {
		getW(1);
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
	        $("#words_delete_modal").modal("show");
	        //显示要删除的内容
	        $("#words_delete_body").text(name);
	        
	        //确认删除
	        $("#words_delete_btn").click(function(){
	            $.ajax({
	                url:"words/" + id,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
                        //	 关闭模态框
	                    $("#words_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getW(nowPage);
	                }
	            });
	        });
		});
		
		//批量删除
		$("#words_deleteAll").click(function(){
			var checkTd = $(".words_checkbox:checked");     //每个被选中的框
			var wordsContent = "";
			var wordsIds = "";
			$.each(checkTd,function(){
				//alert($(this))  this当前正在遍历的元素
				wordsContent+=$(this).parents("tr").find("td:eq(2)").text()+" \n " + ",";
				//拼装要到地址栏的字符串Id  获取删除按钮上的id 
				wordsIds+=$(this).parents("tr").find("td:eq(4) button").attr("del_id") + "-";
				
			})
			if(wordsIds==""){
				return false;
			}
			$("#words_delete_modal").modal("show");
	        //显示要删除的用户
	        wordsSub = wordsContent.substring(0,wordsContent.length - 1);     //去掉最后一个，
	        $("#words_delete_body").text(wordsSub);
	        
	        wordsids = wordsIds.substring(0,wordsIds.length -1);         //去掉最后一个 - 
	        
	        console.log(wordsids)
	        $("#words_delete_btn").click(function(){
	            $.ajax({
	                url:"words/" + wordsids,
	                type:"DELETE",
	                success:function(result){
	                    //删除成功
	                	//关闭模态框
	                    $("#words_delete_modal").modal("hide");
	                    //显示信息模态框
	                    $("#msg_modal").modal("show");
	                    $("#msg_modal_body").text(result.msg);
	                    getW(nowPage);
	                    $("#words_checkboxAll").prop("checked",false);
	                }
	            });
	        });
		});
		
		
		//全选  全不选
		$("#words_checkboxAll").click(function(){
	        //attr获取自定义属性的值
	        //prop获取固定属性的值
	        $(".words_checkbox").prop("checked",$(this).prop("checked"));
	    });
		$(document).on("click",".words_checkbox",function(){
			var check =  $(".words_checkbox:checked").length;    //选中的个数
			var allCheck = $(".words_checkbox").length;             //单选框的个数
			var bool = (check==allCheck);                     //选中个数是否等于总个数
			
			 $("#words_checkboxAll").prop("checked",bool);      // 
			
		});
		
		
	})

	
/*************************全局方法结束******************************/	
	
	
	//添加公告方法
	function addGg() {
		$.ajax({
			url : "words",
			type : "POST",
			data : {
				"name" : $("#words_addName").text(),"content":$("#words_content").val()
			},
			success : function(result) {
                $('#words_model').modal("hide");
                //显示信息模态框
                $("#msg_modal").modal("show");
                $("#msg_modal_body").text(result.msg);
                getW(1);
			}
		})
	}
	
	function getW(pn) {

		$.ajax({
			url : "words?pn=" + pn,
			type : "GET",
			dataType : "json",
			success : function(result) {
				$("#Msg_content").empty();
				$.each(result.map.pageInfo.list,
						function(index, item) {
					
					$("#Msg_content").append(
					"<li class=''><div class='userPic'><img src='" +
					$("#path").val() +
					"/static/img/msg.png'></div><div class='content'>" + 
	                    "<div class='userName'><a href='javascript:void(0);'>" +
	                    item.empname +
	                    "</a>:</div>" + 
	                    "<div class='msgInfo'>" +
	                    item.content +
	                    "</div>" + 
	                    "<div class='times'><span>" +
	                   item.date +
	                    "</span>" + 
	                    "<a class='del' href='javascript:;' style='display: none;'>删除</a></div></div></li>"
	            ); 
				//显示分页信息
				build_page_info(result);
				build_page_nav(result);
			});
			}
	});

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
				getW(1);
			})
			// 上一页
			PrePage.click(function() {
				getW(result.map.pageInfo.pageNum - 1);
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
				getW(result.map.pageInfo.pageNum + 1);
			})
			// 尾页
			LastPageLi.click(function() {
				getW(result.map.pageInfo.pages);
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
				getW(item);
			})

			$("#page_nav").append(numLi);
		});
		$("#page_nav").append(NextPage).append(LastPageLi);
	}
	}