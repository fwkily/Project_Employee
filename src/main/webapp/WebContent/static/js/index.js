$(document).ready(function(){
	showCount();
});




function showCount(){
	
	$.ajax({
		url:"ic",
		type:"GET",
		success:function(result){
			 $("#empC").text(result.map.map.empCount);
			 $("#deptC").text(result.map.map.deptCount);
			 $("#adminC").text(result.map.map.adminCount);
			 $("#taskC").text(result.map.map.taskCount);
		}
		
	})
	
	
	
}
