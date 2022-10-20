<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 2022-10-19
  Time: 8:27 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Finish</title>
</head>
<body>

<div>
    <h3>

        ${text.get(0)}

    </h3>
</div>
<%
session.removeAttribute("text");
session.removeAttribute("stepLevel");
%>

<form method="post" action="/finish" style="width: 50%; background-color: aquamarine">
    <h3>Do you want to play again?</h3>

    <label><input type="radio" name="answer" value="yes">YES</label><br/>
    <label><input type="radio" name="answer" value="no">NO</label><br/>
    <button type="submit">Submit</button>

</form>



</body>
</html>
