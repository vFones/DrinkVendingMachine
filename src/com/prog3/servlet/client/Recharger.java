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


@WebServlet(displayName = "recharge", urlPatterns = "/recharge")
public class Recharger extends HttpServlet {

  protected void doRecharge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String idKeyString = req.getParameter("keyId");
    String billString = req.getParameter("bill");
    float bill = parseFloat(billString.substring(0, billString.length() - 3));
    int idKey = 0;

    Key key = null;
    if(idKeyString != "" ) {
      idKey = parseInt(idKeyString);
      GenericDao<Key> keyDao = new GenericDao<Key>("from Key");

      key = keyDao.queryBean("from Key where id_key=" + idKey);
      if (key == null) {
        req.setAttribute("msg", "No key with that ID...");
      }
      else{
        key.setBalance( round(key.getBalance(), 2).floatValue() + bill);
        keyDao.update(key);
        req.setAttribute("msg", "Recharge received, key #"+ idKey +" --> balance: "+ round(key.getBalance(), 2) +"...");//keyDao.query("select balance from KeyBean where id_key="+idKey) +"...");
      }
    }
    else{
      req.setAttribute("msg", "No key selected...");
    }

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
