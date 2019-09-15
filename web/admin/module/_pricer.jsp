<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 15/09/2019
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container col-5">
  <form action="${pageContext.request.contextPath}/admin/price_change" method="post">
    <!--drinklist-->
    <div class="row">
      <div class="table-wrapper-scroll-y my-custom-scrollbar container">
        <table class="table table-sm table-hover" id="myTable">
          <thead class="thead-dark">
          <tr>
            <th scope="col">#</th>
            <th scope="col">Drink</th>
            <th scope="col">Stock</th>
            <th scope="col">Price</th>
          </tr>
          </thead>
          <c:forEach var="x" items="${drinkList}">
            <tbody>
            <tr class="clickable-row" >
              <th scope="row">
                <input type="hidden" class="drinkId" name="" value="${x.prod_id}">
                  ${x.getProd_id()}
              </th>
              <td>${x.getName()}</td>
              <td>${x.getStock()}</td>
              <td>${x.getPrice()}</td>
            </tr>
            </tbody>
          </c:forEach>
        </table>
      </div>
    </div>
    <!--button price changer-->
    <div class="row">
      <input type="text" class="col btn btn-light btn-lg form-control" id="priceValue" name="priceValue" placeholder="Price">
      <button type="submit" name="priceChanger" class="col btn btn-success btn-lg" id="priceChanger">Change price</button>
    </div>
  </form>
</div>