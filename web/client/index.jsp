<%--
  Created by IntelliJ IDEA.
  User: vittorio
  Date: 2019-08-14
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%-- page directive --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <jsp:include page="../module/_head.jsp"/>
  </head>
<body>
  <div class="container col-2">
  </div>
  <div class="container col">
    <form action="submit" method="post">
      <%--Sugar slider--%>
      <div class="container col">
        <div class="row">
          <div class="col-3"></div>
          <div class=".col-auto .mr-auto"><b>Sugar: </b></div>
          <div class="col-1"></div>
          <div class="col-3"><input type="range" class="custom-range" min="0" max="5" step="1" id="customRange" name="sugar"></div>
          <div class="col-1"></div>
          <div class=".col-auto .mr-auto"><b id="customRangeValue"></b></div>
          <script>
          var values = [0,1,2,3,4,5];
          var input = document.getElementById('customRange'),
                  output = document.getElementById('customRangeValue');
          input.oninput = function(){
            output.innerHTML = values[this.value];
          };
          input.oninput();
        </script>
        </div>
      </div>
      <br>
      <!--Table of drinks-->
      <div class="container col">
        <jsp:include page="../module/_drinkslist.jsp"/>
      </div>
      <br>
      <!--Display and buttons-->
      <div class="container col">
        <jsp:include page="../module/_display.jsp"/>
        <jsp:include page="../module/_buttons.jsp"/>
      </div>
    </form>
  </div>

  <!-- instructions -->
  <div class="container col-3 align-self-center">
    <div class="alert alert-danger alert-dismissible fade ${alert}" role="alert">
      Error: email or password wrong!
    </div>
    <ul class="list-group list-group-flush">
      <li class="list-group-item">1) Select sugar quantity within the slider</li>
      <li class="list-group-item">2) Select drink from the list</li>
      <li class="list-group-item">3) Select payment method (cash, c.c. (contact-less) or rechargeable key)</li>
      <li class="list-group-item">4) Wait for dispatch</li>
    </ul>
    <br>
    <!-- admin log in -->
    <form class="col-6 text-center mx-auto" action="log_in" method="post">
      <div class="form-group">
        <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email">
      </div>
      <div class="form-group">
        <input type="password" class="form-control" name="password" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
  <div class="container col-2"></div>

  <jsp:include page="../module/_scripts.jsp" />

</body>
</html>
