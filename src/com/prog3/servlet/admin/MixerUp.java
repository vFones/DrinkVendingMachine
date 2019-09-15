package com.prog3.servlet.admin;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Float.parseFloat;

@WebServlet(displayName = "new_drink", urlPatterns = "/admin/new_drink")
public class MixerUp extends HttpServlet {
  protected void addNewDrink(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    String drinkId = req.getParameter("drinkId");
    String newIngredients = req.getParameter("newIngredients");
    String newPrice = req.getParameter("newPrice");

    GenericDao<Product> productDao = new GenericDao<Product>();
    Product product = null;
    boolean err = false;
    Product newProduct = null;

    if(drinkId != null) {
      try { product = productDao.queryBean("from Product where id=" + drinkId);} catch (NullPointerException e) {} finally {
        if (product != null && newIngredients != null && newPrice != null) {
          try{ newProduct = new Product(parseFloat(newPrice), 0, product.getName() + " + " + newIngredients); }
          catch( NumberFormatException numb ){}
          finally { productDao.save(newProduct); }
        } else
          err = true;
      }
    }
    else
      err = true;

    if (err) {
      req.setAttribute("err", "show");
      req.setAttribute("errMsg", "Drink ID not valid or missing parameter. Please refer to list on the left");
    }
    else
      req.setAttribute("err", "hide");

    req.setAttribute("email", req.getAttribute("email"));
    req.setAttribute("password", req.getAttribute("password"));

    RequestDispatcher rd = req.getRequestDispatcher("/admin");
    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    addNewDrink(req, resp);
  }

}
