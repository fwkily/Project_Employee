<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html >

<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="${path }/static/js/user/index.js"></script>
<!--     导航栏 -->

<!--    中部 -->
<div class="container-fluid">
    <div class=" col-md-offset-0 col-sm-12 col-xs-12 col-md-offset-2">
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
        </ol>
        <h1>信息总览</h1>
   

  <div class="row placeholders">
            <div class="col-xs-6 col-sm-6 placeholder">
           
               <span>公告内容：</span>
               <p style="text-indent: 20px;" id="content">
                        公告1111111
               </p>
               时间：  <span class="text-muted" id="date">2015-9-9</span>
            </div> 
          
           
        </div>
        <h1 class="page-header">状态</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <tbody>
                    <tr>
                        <td>登录者: <span> <shiro:principal  property="empName"></shiro:principal> </span>
                        </td> 
                    </tr>
                    <tr>
                        <td>你的权限:<span>
                      员工
                          
                        </span></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <h1 class="page-header">系统信息</h1>
        <%
        String agent = request.getHeader("user-agent");

        StringTokenizer st = new StringTokenizer(agent,";");

        st.nextToken();

        //得到用户的浏览器名

        String userbrowser = st.nextToken();

        //得到用户的操作系统名

//         String useros = st.nextToken();
        %>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                      <td>服务器端口:</td>
                        <td><%=request.getServerPort() %></td>
                        <td>客户端浏览器:</td>
                        <td><%=request.getHeader("user-agent") %></td>
                       
                    </tr>
                    <tr>
                        <td>客户端操作系统:</td>
                        <td><%=System.getProperty("os.name") %></td>
                        <td>HTTP协议:</td>
                        <td><%=request.getProtocol() %></td>
                    </tr>
                    <tr>
                        <td>客户端IP:</td>
                        <%

                            String ip = request.getHeader("x-forwarded-for");

                              if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

                                    ip = request.getHeader("Proxy-Client-IP");

                              }

                             if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

                                         ip = request.getHeader("WL-Proxy-Client-IP");

                             }

                            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {

                                   ip = request.getRemoteAddr();

                             }

                               request.setAttribute("ipAddr", ip);
                     
                        %>
                        <td>${ipAddr }</td>
                        <td>MYSQL版本:</td>
                        <td>5.6.17</td>
                    </tr>
                    <tr>
                        <td>程序版本:</td>
                        <td class="version">1.0 <font size="-6" color="#BBB">(20170808)</font></td>
                        <td>上传文件:</td>
                        <td>允许 <font size="-6" color="#BBB">(最大文件：2M ，表单：8M )</font></td>
                    </tr>
                    <tr>
                        <td>程序编码:</td>
                        <td>${headerValues["Accept-Language"][0] }</td>
                        <td>当前时间:</td>
                        <td><% Date d = new Date();
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            out.println( format.format(d));%></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr></tr>
                </tfoot>
            </table>
        </div>
        <footer>
        <h1 class="page-header">程序信息</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <tbody>
                    <tr>
                        <td><span style="display: inline-block; width: 8em">版权所有</span>
                            POWERED BY ZM ALL RIGHTS RESERVED</td>
                    </tr>
                    <tr>
                        <td><span style="display: inline-block; width: 8em">联系我</span>
                           <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=741703967&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:741703967:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
        </footer>

   
</div>
</body>
</html>

