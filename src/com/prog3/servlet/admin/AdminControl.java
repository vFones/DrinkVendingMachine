package com.prog3.servlet.admin;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;
import com.prog3.db.ormbean.Purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminControl extends AdminServlet {
  public static void adminControl(HttpServletRequest req, HttpServletResponse resp){
    String loggedUser = (String) req.getAttribute("loggedUser");

    String email = req.getParameter("email");
    String password = req.getParameter("password");


    req.setAttribute("purchaseList", new GenericDao<Purchase>("from Purchase").getAll() );
    req.setAttribute("drinkList",  new GenericDao<Product>("from Product order by prod_id").getAll());
    req.setAttribute("loggedUser", loggedUser);
  }
}
