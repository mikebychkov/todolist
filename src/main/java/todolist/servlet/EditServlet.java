package todolist.servlet;

import todolist.model.Item;
import todolist.store.ItemDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("EditServlet#doGet=========");

        String id = req.getParameter("id");

        if ("new".equals(id)) {
            req.setAttribute("item", new Item(0, ""));
        } else {
            req.setAttribute("item", ItemDB.getItem(Integer.parseInt(id)));
        }
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("EditServlet#doPost=========");

        String id = req.getParameter("id");
        String desc = req.getParameter("desc");

        if ("0".equals(id)) {
            ItemDB.save(new Item(desc));
        } else {
            Item item = new Item(Integer.parseInt(id), desc);
            ItemDB.saveOrUpdate(item);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}
