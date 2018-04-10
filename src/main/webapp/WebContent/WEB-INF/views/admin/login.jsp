<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>员工管理系统登陆</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="static/js/jquery1.12.4.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/js/skel.min.js"></script>
<script src="static/js/init.js"></script>
<link rel="stylesheet" href="static/css/style.css" />
<link href="static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="loading">
	<div id="wrapper">
		<div id="bg"></div>
		<div id="overlay"></div>
		<div id="main">

			<!-- Header -->
			<header id="header" style="width: 330px;">
            <h3  class="col-sm-offset-2">后台系统登陆</h3><br>
				<form class="form-horizontal" action="login" method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="username" id="inputEmail3"
								placeholder="输入账号" required="required">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password" id="inputPassword3"
								placeholder="输入密码" required="required">
						</div>
					</div>    
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-8">
							<button type="submit" class="btn btn-default">&nbsp;登 &nbsp;&nbsp;陆&nbsp;</button>
							<button type="reset" class="btn btn-default">&nbsp;重 &nbsp;&nbsp;置&nbsp;</button>
						</div>
					</div>
				</form>
			</header>

			<!-- Footer -->
			<footer id="footer">
				
			</footer>

		</div>
	</div>
</body>
</html>