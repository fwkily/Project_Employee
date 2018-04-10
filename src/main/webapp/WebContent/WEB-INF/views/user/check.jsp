<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${path }/static/button/component.css">
<script src="${path }/static/button/modernizr.custom.js"></script>
<script src="${path }/static/button/classie.js"></script>
<script src="${path }/static/button/uiProgressButton.js"></script>
<script type="text/javascript">
  $(function(){
	  checkDk($("#empid").val());
	  
	  //打卡按钮被点击
	  $("#isDk").click(function(){
		  //判断按钮是否可用
		  if($("#dkBtn").attr("disabled")=="disabled"){
			 return false;
		  }else{
			    $.ajax({
			    	url:"dk",
			        data:{"id":<shiro:principal property='empId'></shiro:principal>},
			        success:function(result){
			        	if(result.code==200){
			        		 $("#isDkText").text("今日已打卡").addClass("glyphicon glyphicon-ok");
			                 $("#dkBtn").attr("disabled","disabled");
			        	}
			        }
			    });
		  }
		 
	  })
	  
  });

  function checkDk(){
	  $.ajax({
		  url:"cxOne",
		  data:{"id":<shiro:principal property='empId'></shiro:principal>},
		  success:function(result){
			  //如果查询到打开数据  就显示已经打卡
			  if(result.map.count>0){
				  $("#isDkText").text("今日已打卡").addClass("glyphicon glyphicon-ok");
				  $("#dkBtn").attr("disabled","disabled")
			  }
		  }
		  
	  });
  }
  
  
 


</script>

<!--    中部 -->
<div class="container-fluid">
	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">打卡</a></li>
		</ol>
		<h1>打卡管理</h1>
	</div>

	<!-- 			表格	  -->

	<div class="col-md-5 col-md-offset-3 col-sm-12 col-xs-12">
    

		<div class="container">
			<!-- Top Navigation -->
			<section>
				<div class="box" style="margin-top: 20%;">
					<!-- progress button -->
					<div id="isDk" class="progress-button">
						<button id="dkBtn">
							<span id="isDkText">点击打卡</span>
						</button>
						<svg class="progress-circle" width="70" height="70">
							<path
								d="m35,2.5c17.955803,0 32.5,14.544199 32.5,32.5c0,17.955803 -14.544197,32.5 -32.5,32.5c-17.955803,0 -32.5,-14.544197 -32.5,-32.5c0,-17.955801 14.544197,-32.5 32.5,-32.5z"
								style="stroke-dasharray: 204.244; stroke-dashoffset: 204.244;"></path></svg>
						<svg class="checkmark" width="70" height="70">
							<path d="m31.5,46.5l15.3,-23.2"
								style="stroke-dasharray: 27.7908; stroke-dashoffset: 27.7908;"></path>
							<path d="m31.5,46.5l-8.5,-7.1"
								style="stroke-dasharray: 11.0752; stroke-dashoffset: 11.0752;"></path></svg>
						<svg class="cross" width="70" height="70">
							<path d="m35,35l-9.3,-9.3"
								style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path>
							<path d="m35,35l9.3,9.3"
								style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path>
							<path d="m35,35l-9.3,9.3"
								style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path>
							<path d="m35,35l9.3,-9.3"
								style="stroke-dasharray: 13.1522; stroke-dashoffset: 13.1522;"></path></svg>
					</div>
					<!-- /progress-button -->
					<!-- progress button -->

				</div>
			</section>

		</div>
		<!-- /container -->

		<script>
            [].slice.call( document.querySelectorAll( '.progress-button' ) ).forEach( function( bttn, pos ) {
                new UIProgressButton( bttn, {
                    callback : function( instance ) {
                        var progress = 0,
                            interval = setInterval( function() {
                                progress = Math.min( progress + Math.random() * 0.1, 1 );
                                instance.setProgress( progress );

                                if( progress === 1 ) {
                                    instance.stop( pos === 1 || pos === 3 ? -1 : 1 );
                                    clearInterval( interval );
                                }
                            }, 150 );
                    }
                } );
            } );
        </script>

	</div>
</div>

</body>
</html>