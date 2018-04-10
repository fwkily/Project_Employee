$(document).ready(function(){
	showMsg();
});




function showMsg(){
	
	$.ajax({
		url:"ggOne",
		type:"GET",
		success:function(result){
			 $("#content").text(result.map.map.content);
			 $("#date").text(result.map.map.date);
		}
		
	})
	
	
	
}
