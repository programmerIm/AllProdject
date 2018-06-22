<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%--<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + path + "/";
    %>--%>
     <script type="application/javascript" src="../jquery/jquery-2.1.1.js"></script>
    <title>index</title>
</head>
<body>
<h1><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1322569042&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1322569042:53" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></h1>
<h1>这是首页</h1>
<button id="ClickMe">联系我的QQ</button>
<script type="application/javascript">
    $("#ClickMe").click(function () {
      location.href="http://wpa.qq.com/msgrd?v=3&uin=773914386&site=qq&menu=yes";
    });
</script>
</body>
</html>
