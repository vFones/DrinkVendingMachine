<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 12/09/2019
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
  <div class="table-wrapper-scroll-y my-custom-scrollbar container">
    <table class="table table-sm table-hover" id="myTable">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Drink</th>
          <th scope="col">Price</th>
        </tr>
      </thead>
        <c:forEach var="x" items="${drinkList}">
          <c:if test="${x.getStock() > 1}">
          <tbody>
          <tr class="clickable-row" >
            <th scope="row">
              <input type="hidden" class="drinkId" name="" value="${x.prod_id}">
              ${x.getProd_id()}
            </th>
            <td>${x.getName()}</td>
            <td>${x.getPrice()}</td>
          </tr>
          </tbody>
          </c:if>
        </c:forEach>
    </table>
  </div>
</div>