<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/5/28
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="login" method="post">
        <table align="center">
            <tr>
                <th>姓名：</th>
                <td>
                    <input type="text" name="username" required="true"/>
                </td>
            </tr>
            <tr>
                <th>密码：</th>
                <td>
                    <input type="password" name="password" required="true"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input align="center" type="submit" value="登录"/>
                    <input align="center" type="reset" value="重置"/>
                </td>
            </tr>
        </table>

    </form>
</body>
</html>
