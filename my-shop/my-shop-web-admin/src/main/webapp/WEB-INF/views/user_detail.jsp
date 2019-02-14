<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--c标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--jstl提供的格式化工具--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--springmvc的自定义标签库--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <title>我的商城 | 用户详情</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<%--52.61-48.93--%>
<body class="hold-transition skin-blue sidebar-mini">

<div class="box-body">
    <table id="dataTable" class="table>
        <tbody>
            <tr>
                <td>
                    邮箱:
                </td>
                <td>
                    ${tbUser.email}
                </td>
            </tr>
        </tbody>
    </table>
</div>

<jsp:include page="../includes/footer.jsp"/>

</body>
</html>
