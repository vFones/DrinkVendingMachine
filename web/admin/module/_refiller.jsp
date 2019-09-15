<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 15/09/2019
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container col-4">
  <form action="${pageContext.request.contextPath}/admin/refill" method="post">
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