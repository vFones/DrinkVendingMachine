<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 11/09/2019
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<jsp:include page="../client/module/_head.jsp"/>
<body>
<div class="container">
  <form action="submit" method="post">
    <jsp:include page="../client/module/_drinkslist.jsp"/>

  </form>
</div>
</body>
</html>
