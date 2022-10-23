<%--
  Created by IntelliJ IDEA.
  User: igor
  Date: 2022-10-14
  Time: 1:07 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SUPER STAR QUEST GAME</title>
  </head>
  <body>
  <h1>Prologue</h1>
  <p style="width: 50%">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
    Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
  <h1>Meeting crew</h1>
<p style="width: 50%">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
  Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
  Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
  <form method="post" action="${pageContext.request.contextPath}/start">

    <p>${reEnterName}</p>
    <label>How to call you in the game?
        <input type="text" name="username"><br/>
    </label>
    <button type="submit">Submit name</button>



  </form>

  </body>
</html>
