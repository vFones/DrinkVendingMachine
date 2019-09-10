<%@ page import="com.prog3.hibernate.ormbean.ProductBean" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vittorio
  Date: 2019-08-14
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%-- page directive --%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="${pageContext.request.contextPath}/client/style/index.css" rel="stylesheet" type="text/css">

  <title>DVM - PROG3 - FONES</title>
</head>

<body>
  <div class="container col-2"></div>
  <div class="container col">
    <form action="submit" method="post">
      <div class="container col">
        <%--Sugar slider--%>
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
              <%
                List<ProductBean> list = (List <ProductBean>) request.getAttribute("list");
                int i = 0;
                for ( ProductBean x : list) {
                  i++;
              %>
              <tbody>
                <tr class="clickable-row" >
                  <th scope="row" >
                    <input type="hidden" class="drinkId" name="" value="<%= x.getProd_id() %>">
                    <%= x.getProd_id() %>
                  </th>
                  <td> <%= x.getName() %> </td>
                  <td> <%= x.getPrice() %> </td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <br>
      <!--Display and buttons-->
      <div class="container col">
        <!--Display-->
        <div class="container-fluid">
          <div class="row text_display">
            <div class="col">
              <marquee scrolldelay="150">
              <%
                String msg = (String) request.getAttribute("msg");
                out.println(msg);
              %></marquee>
            </div>
            <div class="col-2" id="moneyDisplay">
              <%
                String coins = (String) request.getAttribute("coins");
                out.println(coins);
              %>
            </div>
            <input type="hidden" id="inputDisplay" name="coins" value="<%=(String) request.getAttribute("coins")%>">
          </div>
        </div>
        <!--buttons-->
        <div class="container-fluid">
          <!-- key and c.c. payment -->
          <div class="row">
            <input type="text" class="col form-control btn btn-light btn-lg" id="ccId" name="ccId" placeholder="c.c.">
            <input type="text" class="col-5 btn btn-primary btn-lg form-control" id="keyId" name="keyId" placeholder="key">
            <style>
              input[id="keyId"]::placeholder {
                color: white;
              }
            </style>
          </div>
          <!-- coins payment -->
          <div class="">
            <div class="row">
              <select id="selectedCoin" class="col form-control btn btn-warning btn-lg">
                <option>0.05€</option>
                <option>0.10€</option>
                <option>0.20€</option>
                <option>0.50€</option>
                <option>1.00€</option>
                <option>2.00€</option>
              </select>
              <select id="selectedBills" name="bill" class="col-5 form-control btn btn-primary btn-lg">
                <option>5.00€</option>
                <option>10.00€</option>
                <option>20.00€</option>
                <option>50.00€</option>
              </select>
            </div>
            <div class="row">
              <button type="button" class="col btn btn-warning btn-lg" id="insertCoin">insert coin</button>
              <button type="submit" name="rechargeKey" value="rechargeKey" class="col-5 btn btn-primary btn-lg" id="insertBill">recharge key</button>
            </div>
            <!-- Confirm button -->
            <div class="row">
            <button type="submit" name="confirmPurchase" value="confirmPurchase" class="col container btn btn-success success btn-lg">confirm</button>
            </div>
          </div>

        </div>
      </div>
    </form>
  </div>

  <div class="container col-3">
    <ul class="list-group list-group-flush">
      <li class="list-group-item">1) Select sugar quantity within the slider</li>
      <li class="list-group-item">2) Select drink from the list</li>
      <li class="list-group-item">3) Select payment method (cash, c.c. (contact-less) or rechargeable key)</li>
      <li class="list-group-item">4) Wait for dispatch</li>
    </ul>
  </div>
  <div class="container col-2"></div>

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="${pageContext.request.contextPath}/client/js/scripts.js"></script>
</body>
</html>
