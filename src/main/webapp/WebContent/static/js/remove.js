//全选 全不选
$(function(){
	$("#emp_checkboxAll").click(function(){
        //attr获取自定义属性的值
        //prop获取固定属性的值
        $(".emp_checkbox").prop("checked",$(this).prop("checked"));
    });
	
	
	$(document).on("click",".emp_checkbox",function(){
		var check =  $(".emp_checkbox:checked").length;    //选中的个数
		var allCheck = $(".emp_checkbox").length;             //单选框的个数
		var bool = (check==allCheck);                     //选中个数是否等于总个数
		
		 $("#emp_checkboxAll").prop("checked",bool);      // 
		
	})
	
	//批量删除
	$("#emp_deleteAll").click(function(){
		var checkTd = $(".emp_checkbox:checked");     //每个被选中的框
		var empNames = "";
		var empIds = "";
		
		$.each(checkTd,function(){
			//alert($(this))  this当前正在遍历的元素
			empNames+=$(this).parents("tr").find("td:eq(2)").text() + ",";
			//拼装要到地址栏的字符串Id
			empIds+=$(this).parents("tr").find("td:eq(1)").text() + "-";
			
		})
		//如果没有选择
		if(empIds==""){
			return false;
		}
		
		
		$("#emp_delete_modal").modal("show");
        //显示要删除的用户
        empSub = empNames.substring(0,empNames.length - 1);     //去掉最后一个，
        $("#emp_delete_body").text(empSub);
        
        empsids = empIds.substring(0,empIds.length -1);         //去掉最后一个 - 
        
        $("#emp_delete").click(function(){
            $.ajax({
                url:"emp/" + empsids,
                type:"DELETE",
                success:function(result){
                    //删除成功
//                  关闭模态框
                    $("#emp_delete_modal").modal("hide");
                    //显示信息模态框
                    $("#msg_modal").modal("show");
                    $("#msg_modal_body").text(result.msg);
                    getEmps(nowPage);
                }
            });
        });
        
	})
	
})
    


