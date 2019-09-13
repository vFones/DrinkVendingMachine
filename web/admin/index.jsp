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
      <div class="row">
        <div class="container col-5">
          <form action="${pageContext.request.contextPath}/admin/price_change" method="post">
        <jsp:include page="../module/_drinkslist.jsp"/>
          <div class="row">
            <input type="text" class="col btn btn-light btn-lg form-control" id="priceValue" name="priceValue" placeholder="Price">
            <button type="submit" name="priceChanger" class="col btn btn-success btn-lg" id="priceChanger">Change price</button>
          </div>
      </form>
        </div>

        <div class="container col-4">
      <div class="col">
        <span><strong>
          Create new drinks. Starting from the one already in list:
        </strong></span>
      </div>
      <br>
      <form action="${pageContext.request.contextPath}/admin/new_drink" method="post">
        <div class="row">

          <input type="text" class="col btn btn-light btn-lg form-control" id="drinksId" name="drinkId" placeholder="ID">
          <input type="text" class="col btn btn-light btn-lg form-control" id="drinkName" name="drinkName" placeholder="New ingredients">

        </div>
        <div class="row">

          <input type="text" class="col btn btn-light btn-lg form-control" id="newPrice" name="newPrice" placeholder="New price">
          <button type="submit" name="priceChanger" class="col btn btn-success btn-lg" id="confirmNewDrink">Add new drink</button>

        </div>
      </form>
    </div>

        <div class="container col-4">
        <form action="${pageContext.request.contextPath}/admin/refill" method="get">
          <div class="row">
            <div class="table-wrapper-scroll-y my-custom-scrollbar container">
              <table class="table table-sm table-hover" id="refillTable">
                <thead class="thead-dark">
                <th>To refill</th>
                </thead>
                <c:forEach var="x" items="${drinkList}">
                  <tbody>
                  <tr class="clickable-row" >
                    <c:if test="${x.getStock() <= 1}">
                      <td>${x.getName()}</td>
                    </c:if>
                  </tr>
                  </tbody>
                </c:forEach>
              </table>
            </div>
            <button type="submit" name="refiller" class="col btn btn-warning btn-lg" id="refiller">Refill</button>
          </div>
        </form>
      </div>
      </div>

    <div class="row">
      <div class="table-wrapper-scroll-y my-custom-scrollbar container">
        <table class="table table-sm table-hover" id="myTable">
          <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Drink</th>
            <th scope="col">Date</th>
            <th scope="col">Payment</th>
          </tr>
          </thead>
          <c:forEach var="x" items="${purchaseList}">
            <tbody>
            <tr class="clickable-row" >
              <th scope="row">
                <input type="hidden" class="drinkId" name="" value="${x.getPurchase_id()}">
                  ${x.getPurchase_id()}
              </th>
              <td>${x.getProduct().getName()}</td>
              <td>${x.getDate()}</td>
              <td>
                <c:if test="${x.isCash() != false}">
                  Cash
                </c:if>
                <c:if test="${x.getCc_number() != null}">
                  C.C.: ${x.getCc_number()}
                </c:if>
                <c:if test="${x.getKey() != null}">
                  Key: ${x.getKey().getId_key()}
                </c:if>
              </td>
            </td>
            </tbody>
          </c:forEach>
        </table>
      </div>
    </div>
    </div>

    <jsp:include page="../module/_scripts.jsp"/>

  </body>
</html>
