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
      <!-- price changer, new drink, refiller, warnings-->
      <div class="row align-items-center">
        <!--price changer-->
        <jsp:include page="module/_pricer.jsp"/>
        <!--new drink-->
        <jsp:include page="module/_mixer.jsp"/>
        <!-- refiller -->
        <jsp:include page="module/_refiller.jsp"/>
      </div>
      <!--warnings-->
      <div class="row justify-content-center">
        <div class="alert alert-danger alert-dismissible fade ${err}" role="alert">
          <c:out value="${errMsg}"/>
        </div>
      </div>
      <!-- report -->
      <jsp:include page="module/_report.jsp"/>
    </div>
    <jsp:include page="../module/_scripts.jsp"/>
  </body>
</html>
