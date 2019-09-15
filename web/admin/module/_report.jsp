<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 15/09/2019
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<div class="row justify-content-center">
  <form action="${pageContext.request.contextPath}/admin/report" method="post">
    <select name="month" class="col-3 form-control btn btn-light btn-lg">
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
      <option>6</option>
      <option>7</option>
      <option>8</option>
      <option>9</option>
      <option>10</option>
      <option>11</option>
      <option>12</option>
    </select>
    <input type="text" name="year" class="col-3 form-control btn btn-light btn-lg">
    <button type="submit" class="btn btn-light btn-lg">search</button>
  </form>
  <div class="table-wrapper-scroll-y my-custom-scrollbar container">
    <table class="table table-sm table-hover">
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
        </tr>
        </tbody>
      </c:forEach>
    </table>
  </div>
</div>