<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" type="java.lang.String" required="false" description="模态框标题" %>
<%@ attribute name="message" type="java.lang.String" required="false" description="模态框消息" %>

<%--以上的便签库如果协同开发时候要与其他人商量--%>
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">${title==null ? "温馨提示" : title}</h4>
            </div>
            <div class="modal-body">
                <p id="modal-message">${message}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="btnModalOk" type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
