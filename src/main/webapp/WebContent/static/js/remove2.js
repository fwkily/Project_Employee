//全选 全不选
$(function(){
	$("#dept_checkboxAll").click(function(){
        //attr获取自定义属性的值
        //prop获取固定属性的值
        $(".dept_checkbox").prop("checked",$(this).prop("checked"));
    });
	
	
	$(document).on("click",".dept_checkbox",function(){
		var check =  $(".dept_checkbox:checked").length;    //选中的个数
		var allCheck = $(".dept_checkbox").length;             //单选框的个数
		var bool = (check==allCheck);                     //选中个数是否等于总个数
		
		 $("#dept_checkboxAll").prop("checked",bool);      // 
		
	})
	
	//批量删除
	$("#dept_deleteAll").click(function(){
		var checkTd = $(".dept_checkbox:checked");     //每个被选中的框
		var deptNames = "";
		var deptIds = "";
		$.each(checkTd,function(){
			//alert($(this))  this当前正在遍历的元素
			deptNames+=$(this).parents("tr").find("td:eq(2)").text() + ",";
			//拼装要到地址栏的字符串Id
			deptIds+=$(this).parents("tr").find("td:eq(1)").text() + "-";
			
		})
		
		//如果没有选择
		if(deptIds==""){
			return false;
		}
		
		$("#dept_delete_modal").modal("show");
        //显示要删除的用户
        deptSub = deptNames.substring(0,deptNames.length - 1);     //去掉最后一个，
        $("#dept_delete_body").text(deptSub);
        
        ids = deptIds.substring(0,deptIds.length -1);         //去掉最后一个 - 
        
        $("#dept_delete_btn").click(function(){
            $.ajax({
                url:"deptsMsg/" + ids,
                type:"DELETE",
                success:function(result){
                    //删除成功
//                  关闭模态框
                    $("#dept_delete_modal").modal("hide");
                    //显示信息模态框
                    $("#msg_modal").modal("show");
                    $("#msg_modal_body").text(result.msg);
                    getDept(nowPage);
                }
            });
        });
        
	})
	
})
    


