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

/**
 * Mixer servlet used for creating new drink starting from the one in the list
 */
@WebServlet(displayName = "new_drink", urlPatterns = "/admin/new_drink")
public class MixerUp extends HttpServlet {
  private void addNewDrink(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String drinkId = req.getParameter("drinkId");
    String newIngredients = req.getParameter("newIngredients");
    String newPrice = req.getParameter("newPrice");

    // get all elements

    GenericDao<Product> productDao = new GenericDao<Product>();

    Product product = null;
    boolean err = false;
    Product newProduct = null;

    // query drink and if all set
    if(drinkId != null) {
      try { product = productDao.queryBean("from Product where id=" + drinkId);}
      catch (NullPointerException e) { System.out.println(e.getMessage()); }
      finally {
        if (product != null && newIngredients != null && newPrice != null) {
          //set new drink with new ingredients and save
          try{ newProduct = new Product(parseFloat(newPrice), 0, product.getName() + " + " + newIngredients); }
          catch( NumberFormatException numb ){System.out.println(numb.getMessage()); err = true;}
          finally { productDao.save(newProduct); }
        } else
          err = true;
      }
    }
    else
      err = true;

    // if errors then set message with alert
    if (err) {
      req.setAttribute("err", "show");
      req.setAttribute("errMsg", "Drink ID not valid or missing parameter. Please refer to list on the left");
    }
    else
      req.setAttribute("err", "hide");

    //return to admin
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
