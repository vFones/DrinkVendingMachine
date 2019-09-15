package com.prog3.servlet.client;

import com.prog3.db.dao.GenericDao;
import com.prog3.db.ormbean.Key;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.prog3.util.Float2.round;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;


/**
 * Recharger servlet used for recharge a Key with bills.
 */
@WebServlet(displayName = "recharge", urlPatterns = "/recharge")
public class Recharger extends HttpServlet {
  private void doRecharge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String idKeyString = req.getParameter("keyId");
    String billString = req.getParameter("bill");
    //correct bill parse
    float bill = parseFloat(billString.substring(0, billString.length() - 3));
    int idKey = 0;

    Key key = null;
    if(idKeyString != "" ) {
      // correctly parse key id
      try {
        idKey = parseInt(idKeyString);
      }
      catch(NumberFormatException e) {
        System.out.println(e.getMessage());
      } finally {
        //search for that key
        key = new GenericDao<Key>().queryBean("from Key where id_key=" + idKey);
        if (key == null) {
          req.setAttribute("msg", "No key with that ID...");
        }
        else{//if found update balance and display message
          key.setBalance( round(key.getBalance(), 2) + bill);
          new GenericDao<Key>().update(key);
          req.setAttribute("msg", "Recharge received, key #"+ idKey +" --> balance: "+ round(key.getBalance(), 2) +"...");
        }
      }
    }
    else{
      req.setAttribute("msg", "No key selected...");
    }

    //go back to client.
    req.setAttribute("coins", "0.0");
    RequestDispatcher rd = req.getRequestDispatcher("/client");
    rd.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doGet(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doRecharge(req, resp);
  }

}
