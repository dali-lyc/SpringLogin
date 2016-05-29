<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/5/28
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>welcome</title>
</head>
<body>
    Welcome,${user.username}!
    密码：${user.password}
    <p><a href="${contextPath}/logout">[退出]</a></p>
</body>

</html>
