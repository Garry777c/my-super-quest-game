<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 2022-10-14
  Time: 3:36 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>START</title>
</head>
<body>


<h3>Hello <%
    out.println(session.getAttribute("username"));
    out.println(request.getRequestedSessionId());
%>
</h3>


<div>
    <h3>

${text.get(0)}


    </h3>
</div>

<form method="post" action="/game" style="width: 50%; background-color: aquamarine">

    <label><input type="radio" name="answer" value="yes">${text.get(1)}</label><br/>
    <label><input type="radio" name="answer" value="no">${text.get(2)}</label><br/>
    <button type="submit">Submit</button>

</form>

</body>

<footer>
    <div style="background-color: darkcyan; width: 50%">
        <ul>Statictics:</ul>
            <li>IP address:
                <%
                    out.println(request.getRemoteAddr());
                %>

            </li>
            <li>Your name:
            <%
                out.println(session.getAttribute("username"));
            %>
            </li>
            <li>Games finished:
                <%
                    out.println(session.getAttribute("count"));
                %>
            </li>

    </div>
</footer>

</html>
