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
import java.util.List;

/**
 * refill servlet used for refill all product in stock
 */
@WebServlet(displayName="refill", urlPatterns = "/admin/refill")
public class Refiller extends HttpServlet {
  private void doRefill(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      // query items and if under 1L per prod than update stock
      List<Product> productList = new GenericDao<Product>("from Product where stock<=1").getAll();
      for ( Product p : productList) {
        p.setStock(50);
        new GenericDao<Product>().update(p);
      }
    }
    catch(NullPointerException e){
      System.out.println(e.getMessage());
    }
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
    doRefill(req, resp);
  }
}
