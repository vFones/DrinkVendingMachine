<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 11/09/2019
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <jsp:include page="../module/_head.jsp"/>
  </head>
  <body>
    <div class="container">
      <form action="submit" method="post">
        <jsp:include page="../module/_drinkslist.jsp"/>
      </form>
    </div>

    <jsp:include page="../module/_scripts.jsp"/>

  </body>
</html>
