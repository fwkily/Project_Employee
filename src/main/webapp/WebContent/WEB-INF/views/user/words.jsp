<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="${path }/static/js/user/words.js"></script>
<style type="text/css">
body,div,h2,h3,ul,li,p{margin:0;padding:0;}
ul{list-style-type:none;}
#msgBox{width:800px;background:#fff;border-radius:5px;margin:10px auto;padding-top:10px;}
#msgBox form h2{font-weight:700;font:400 18px/1.5 \5fae\8f6f\96c5\9ed1;}
#msgBox form{padding:0 20px 15px;}
#userName,#conBox{color:#777;border:1px solid #d0d0d0;border-radius:6px;font:14px/1.5 arial;}
#userName.active,#conBox.active{border:1px solid #7abb2c;}
#userName{height:20px;}
#conBox{width:748px;resize:none;height:65px;overflow:auto;}
#msgBox form div{position:relative;color:#999;margin-top:10px;}
#msgBox img{border-radius:3px;}
#face{position:absolute;top:0;left:172px;}
#face img{width:30px;height:30px;cursor:pointer;margin-right:6px;opacity:0.5;filter:alpha(opacity=50);}
#face img.hover,#face img.current{width:28px;height:28px;border:1px solid #f60;opacity:1;filter:alpha(opacity=100);}
#sendBtn{border:0;width:112px;height:30px;cursor:pointer;margin-left:10px;}
#sendBtn.hover{background-position:0 -30px;}
#msgBox form .maxNum{font:26px/30px Georgia, Tahoma, Arial;padding:0 5px;}
#msgBox .list{padding:10px;}
#msgBox .list h3{position:relative;height:33px;font-size:14px;font-weight:400;background:#e3eaec;border:1px solid #dee4e7;}
#msgBox .list h3 span{position:absolute;left:6px;top:6px;background:#fff;line-height:28px;display:inline-block;padding:0 15px;}
#msgBox .list ul{overflow:hidden;zoom:1;}
#msgBox .list ul li{float:left;clear:both;width:100%;border-bottom:1px dashed #d8d8d8;padding:10px 0;background:#fff;overflow:hidden;}
#msgBox .list ul li.hover{background:#f5f5f5;}
#msgBox .list .userPic{float:left;width:50px;height:50px;display:inline;margin-left:10px;border:1px solid #ccc;border-radius:3px;}
#msgBox .list .content{float:left;width:700px;font-size:14px;margin-left:10px;font-family:arial;word-wrap:break-word;}
#msgBox .list .userName{display:inline;padding-right:5px;}
#msgBox .list .userName a{color:#2b4a78;text-decoration: none;}
#msgBox .list .msgInfo{display:inline;word-wrap:break-word;}
#msgBox .list .times{color:#889db6;font:12px/18px arial;margin-top:5px;overflow:hidden;zoom:1;}
#msgBox .list .times span{float:left;}
#msgBox .list .times a{float:right;color:#889db6;display:none;}
.tr{overflow:hidden;zoom:1;}
.tr p{float:right;line-height:30px;}
.tr *{float:left;}
</style>
<script type="text/javascript">
/*-------------------------- +
  获取id, class, tagName
 +-------------------------- */
var get = {
    byId: function(id) {
        return typeof id === "string" ? document.getElementById(id) : id
    },
    byClass: function(sClass, oParent) {
        var aClass = [];
        var reClass = new RegExp("(^| )" + sClass + "( |$)");
        var aElem = this.byTagName("*", oParent);
        for (var i = 0; i < aElem.length; i++) reClass.test(aElem[i].className) && aClass.push(aElem[i]);
        return aClass
    },
    byTagName: function(elem, obj) {
        return (obj || document).getElementsByTagName(elem)
    }
};
/*-------------------------- +
  事件绑定, 删除
 +-------------------------- */
var EventUtil = {
    addHandler: function (oElement, sEvent, fnHandler) {
        oElement.addEventListener ? oElement.addEventListener(sEvent, fnHandler, false) : (oElement["_" + sEvent + fnHandler] = fnHandler, oElement[sEvent + fnHandler] = function () {oElement["_" + sEvent + fnHandler]()}, oElement.attachEvent("on" + sEvent, oElement[sEvent + fnHandler]))
    },
    removeHandler: function (oElement, sEvent, fnHandler) {
        oElement.removeEventListener ? oElement.removeEventListener(sEvent, fnHandler, false) : oElement.detachEvent("on" + sEvent, oElement[sEvent + fnHandler])
    },
    addLoadHandler: function (fnHandler) {
        this.addHandler(window, "load", fnHandler)
    }
};
/*-------------------------- +
  设置css样式
  读取css样式
 +-------------------------- */
function css(obj, attr, value)
{
    switch (arguments.length)
    {
        case 2:
            if(typeof arguments[1] == "object")
            {   
                for (var i in attr) i == "opacity" ? (obj.style["filter"] = "alpha(opacity=" + attr[i] + ")", obj.style[i] = attr[i] / 100) : obj.style[i] = attr[i];
            }
            else
            {   
                return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle(obj, null)[attr]
            }
            break;
        case 3:
            attr == "opacity" ? (obj.style["filter"] = "alpha(opacity=" + value + ")", obj.style[attr] = value / 100) : obj.style[attr] = value;
            break;
    }
};

EventUtil.addLoadHandler(function ()
{
    var oMsgBox = get.byId("msgBox");
    var oUserName = get.byId("userName");
    var oConBox = get.byId("conBox");
    var oSendBtn = get.byId("sendBtn");
    var oMaxNum = get.byClass("maxNum")[0];
    var oCountTxt = get.byClass("countTxt")[0];
    var oList = get.byClass("list")[0];
    var oUl = get.byTagName("ul", oList)[0];
    var aLi = get.byTagName("li", oList);
    var aFtxt = get.byClass("f-text", oMsgBox);
    var aImg = get.byTagName("img", get.byId("face"));
    var bSend = false;
    var timer = null;
    var oTmp = "";
    var i = 0;
    var maxNum = 140;
    
    //禁止表单提交
    EventUtil.addHandler(get.byTagName("form", oMsgBox)[0], "submit", function () {return false});
    
    //为广播按钮绑定发送事件
    EventUtil.addHandler(oSendBtn, "click", fnSend);
    
    //为Ctrl+Enter快捷键绑定发送事件
    EventUtil.addHandler(document, "keyup", function(event)
    {
        var event = event || window.event;
        event.ctrlKey && event.keyCode == 13 && fnSend()
    });
    
    //发送广播函数
    function fnSend()
    {
    	if($("#conBox").val().length>0){
    		$.ajax({
    			url:"addwords",
    			method:"POST",
    			data:{"name":"<shiro:principal property='empName'></shiro:principal>","content":$("#conBox").val()},
    			success:function(result){
    				
    				$("#msg_modal").modal("show");
    				$("#msg_modal_body").text(result.msg);
    				$("#conBox").val("");
    				getW(nowPage);
    			}
    		});
    		
    	}else{
    		$("#msg_modal").modal("show");
            $("#msg_modal_body").text("内容不能为空！");
    	}
        
    };
    
    //事件绑定, 判断字符输入
    EventUtil.addHandler(oConBox, "keyup", confine);    
    EventUtil.addHandler(oConBox, "focus", confine);
    EventUtil.addHandler(oConBox, "change", confine);
    
    //输入字符限制
    function confine ()
    {
        var iLen = 0;       
        for (i = 0; i < oConBox.value.length; i++) iLen += /[^\x00-\xff]/g.test(oConBox.value.charAt(i)) ? 1 : 0.5;
        oMaxNum.innerHTML = Math.abs(maxNum - Math.floor(iLen));    
        maxNum - Math.floor(iLen) >= 0 ? (css(oMaxNum, "color", ""), oCountTxt.innerHTML = "\u8fd8\u80fd\u8f93\u5165", bSend = true) : (css(oMaxNum, "color", "#f60"), oCountTxt.innerHTML = "\u5df2\u8d85\u51fa", bSend = false)
    }
    //加载即调用
    confine();      
    
    //广播按钮鼠标划过样式
    $(document).on( "mouseover", oSendBtn,function () {this.className = "hover"});

    //广播按钮鼠标离开样式
    EventUtil.addHandler(oSendBtn, "mouseout", function () {this.className = ""});
    
    //li鼠标划过/离开处理函数

    
    //删除功能
   
   
    
    //输入框获取焦点时样式
    for (i = 0; i < aFtxt.length; i++)
    {
        EventUtil.addHandler(aFtxt[i], "focus", function () {this.className = "active"});       
        EventUtil.addHandler(aFtxt[i], "blur", function () {this.className = ""})
    }
    
    //头像
    for (i = 0; i < aImg.length; i++)
    {
        aImg[i].onmouseover = function ()
        {
            this.className += " hover"
        };
        aImg[i].onmouseout = function ()
        {
            this.className = this.className.replace(/\s?hover/,"")
        };
        aImg[i].onclick = function ()
        {
            for (i = 0; i < aImg.length; i++) aImg[i].className = "";
            this.className = "current"  
        }
    }
}); 
</script>
<!--     导航栏 -->

<!--    中部 -->
<div class="container-fluid">
	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">留言</a></li>
		</ol>
		<h1>留言板</h1>
	</div>

	<!-- 			表格	  -->

	<div class="col-md-offset-0 col-sm-12 col-xs-12">
		 <div id="msgBox">
    <form>
        <h2>来 , 说说你对公司发展的建议</h2>

        
        <div><textarea id="conBox" class=""></textarea></div>
        <div class="tr">
            <p>
                <span class="countTxt">还能输入</span><strong class="maxNum">140</strong><span>个字</span>

                <input maxlength="140" id="sendBtn" type="button" value="" title="快捷键 Ctrl+Enter" class="" style="background:url(${path}/static/img/btn.png) no-repeat;">
            </p>
        </div>
    </form>
    <div class="list">
        <h3><span>大家都在说</span></h3>
        <ul id="Msg_content">
            
            
        </ul>
    </div>  
</div>
    
		<!-- 分页导航 -->
		<!-- 分页文字信息 -->
		<div class="col-md-5 col-md-offset-5">
			<span class="label label-default" id="page_info"></span>

			<!-- 页码 -->
			<nav aria-label="Page navigation">

				<ul class="pagination pagination-sm" id="page_nav">
					<!-- 					分页信息 -->
				</ul>
			</nav>
		</div>
	</div>

	<!-- 模态框 -->



<!--     删除用户的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="words_delete_modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">是否删除？</h4>
            </div>
            <div class="modal-body">
                <p id="words_delete_body"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="words_delete_btn">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->


<!--     通用信息的模态框 -->
<div class="modal fade" tabindex="-1" role="dialog" id="msg_modal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">来自服务器的提示信息:</h4>
            </div>
            <div class="modal-body">
                <p id="msg_modal_body"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="words_delete_btn" data-dismiss="modal">我知道了</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<input type="hidden" id="path" value="${path }">
</div>
</body>
</html>