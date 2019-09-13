<%--
  Created by IntelliJ IDEA.
  User: atom
  Date: 12/09/2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row text_display">
        <div class="col">
            <marquee scrolldelay="150">
                <c:out value="${msg}"/>
            </marquee>
        </div>
        <div class="col-2" id="moneyDisplay">
            <c:out value="${coins}"/>
        </div>
        <input type="hidden" id="inputDisplay" name="coins" value="${coins}">
    </div>
</div>