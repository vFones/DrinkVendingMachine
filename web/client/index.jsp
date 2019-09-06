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
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <link href="style/index.css" rel="stylesheet" type="text/css">

  <title>DVM - PROG3 - FONES</title>
</head>

<body>
  <%--
  <% for ( fontSize = 10; fontSize <= 18; fontSize+=2) { %>
    <span style="color: green; font-size: <%= fontSize %>;">
      JSP Tutorial
    </span> <br/>
  <% } %>
  <% out.println("Your IP address is: " + request.getRemoteAddr()); %>
  <p> Dio <%= new java.util.Date().toString() %> </p>
  --%>
  <div class="container">
    <div class="container">
      <div class="row">
        <div class="col-3 mx-auto">
          <label for="customRange">Zucchero: </label>
          <input type="range" class="custom-range" min="0" max="5" step="1" id="customRange">
        </div>
      </div>
    </div>
    <br>
    <div class="container col-5">
      <div class="row">
        <div class="table-wrapper-scroll-y my-custom-scrollbar overflow-hidden container">
            <table class="table table-sm table-hover">
              <thead class="thead-dark">
               <tr>
                 <th scope="col">#</th>
                 <th scope="col">Drink</th>
                 <th scope="col">Price</th>
               </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                </tr>
                <tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                </tr>
                <tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                </tr>
                <tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                </tr>
                <tr>
                  <th scope="row">1</th>
                  <td>Mark</td>
                  <td>Otto</td>
                </tr>
              </tbody>
            </table>
          </div>
      </div>
    </div>
    <br>
    <div class="container col-5">
      <div class="container-fluid">
        <div class="row">
            <div class="col text_display">
              <marquee scrolldelay="150">Inserire monete...</marquee>
            </div>
            <div class="col-3 calculator_display">00.0 E</div>
          </div>
      </div>
      <div class="container-fluid">
        <div class="row">
            <button type="button" class="col btn btn-primary" data-toggle="button" aria-pressed="false"> key </button>
            <button type="button" class="col btn btn-light btn-lg"> c.c. </button>
          </div>
      </div>
      <div class="container-fluid">
        <div class="row">
            <button type="button" class="col btn btn-warning btn-lg">coin</button>
            <button type="button" class="col btn btn-warning btn-lg">bills</button>
          </div>
      </div>
    </div>
  </div>

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
