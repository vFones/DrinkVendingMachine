<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 15/09/2019
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
      <input type="text" class="col btn btn-light btn-lg form-control" id="newIngredients" name="newIngredients" placeholder="New ingredients">
    </div>
    <div class="row">
      <input type="text" class="col btn btn-light btn-lg form-control" id="newPrice" name="newPrice" placeholder="New price">
      <button type="submit" name="priceChanger" class="col btn btn-success btn-lg" id="confirmNewDrink">Add new drink</button>
    </div>
  </form>
</div>