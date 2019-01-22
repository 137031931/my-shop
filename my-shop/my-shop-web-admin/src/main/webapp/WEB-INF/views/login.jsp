<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<%--写个头尾注释方便查阅head begin--%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的商城 | 登录</title>
    <!-- Tell the browser to be responsive to screen width这是为了适应不同宽度的屏幕大小 -->
    <meta content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/static/assets/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Font Awesome字体 这里要/结束符-->
    <link rel="stylesheet" href="/static/assets/bower_components/font-awesome/css/font-awesome.min.css"/>
    <!-- Ionicons 字体-->
    <link rel="stylesheet" href="/static/assets/bower_components/Ionicons/css/ionicons.min.css"/>
    <!-- Theme style 主题风格-->
    <link rel="stylesheet" href="/static/assets/css/AdminLTE.min.css"/>
    <!-- iCheck 是一个勾选框样式-->
    <link rel="stylesheet" href="/static/assets/plugins/iCheck/square/blue.css"/>

</head>
<%--写个尾注释方便查阅head end--%>


<body class="hold-transition login-page">
<%--支持响应式,基于媒体查询--%>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<div class="login-box">
    <div class="login-logo">
        <a href="#">我的商城</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">欢迎管理员登录</p>
        <form action="/login" method="post">
            <%--这里可以用<c:if>标签,不用的话也可以像如下--%>
            <%--<c:if test="${message != null}">--%>
            <div class="alert alert-danger alert-dismissible" ${message == null ? "style='display:none'":""}>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h4><i class="icon fa fa-ban"></i> 警告</h4>
                ${message}
            </div>
            <%--</c:if>--%>

            <div class="form-group has-feedback">
                <input name="email" type="email" class="form-control" placeholder="邮箱" value="${tbUser.email}">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="password" type="password" class="form-control" placeholder="密码" value="${tbUser.password}">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input name="isChecked" type="checkbox" ${isChecked==true?"checked":""}> 记住我
                        </label>
                        <label>
                            <input type="checkbox"> 自动登录
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="#">忘记密码?</a><br>
    </div>
</div>

<!-- jQuery 3 -->
<script src="/static/assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/static/assets/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>
</body>
</html>

