<%--
  Created by IntelliJ IDEA.
  User: Zhou
  Date: 2017/7/25
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录失败</title>
    <style type="text/css">
        span{
            position: fixed;
            left: 40%;
            top: 50%;
            font-size: 250%;
        }
    </style>
</head>
<body>
    <script type="text/javascript">
        var t = 5; // 设定跳转的时间
        setInterval("refer()", 1000); // 启动1秒定时
        function refer(){
            if (t == 0) {
                location = "/"; // 设定跳转的链接地址
            }
            document.getElementById('show').innerHTML = "登录失败" + t + "秒后跳转到登录界面"; // 显示倒计时
            t--; // 计数器递减
        }
    </script>
    <span id="show"></span>
</body>
</html>
