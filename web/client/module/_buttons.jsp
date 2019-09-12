<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 12/09/2019
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!--buttons-->
<div class="container-fluid">
    <!-- key and c.c. payment -->
    <div class="row">
        <input type="text" class="col form-control btn btn-light btn-lg" id="ccId" name="ccId" autocomplete="off" maxlength="16" pattern="\d{16}" placeholder="c.c.">
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