package todolist.servlet;

import todolist.model.Author;
import todolist.model.Item;
import todolist.store.ItemDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

public class EditServlet extends HttpServlet {

    private GregorianCalendar getCurrent() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(System.currentTimeMillis());
        return gc;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("EditServlet#doGet=========");

        String id = req.getParameter("id");

        if ("new".equals(id)) {
            req.setAttribute("item", new Item(0, ""));
        } else {
            req.setAttribute("item", ItemDB.getItem(Integer.parseInt(id)));
        }

        String check = req.getParameter("check");
        if ("1".equals(check)) {
            doPost(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/templates/edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("EditServlet#doPost=========");

        String id = req.getParameter("id");
        String desc = req.getParameter("desc");
        String check = req.getParameter("check");
        Author author = (Author) req.getSession().getAttribute("author");

        if ("0".equals(id)) {
            Item item = new Item(desc);
            item.setCreated(getCurrent());
            item.setAuthor(author);
            ItemDB.save(item);
        } else if ("1".equals(check)) {
            Item item = (Item) req.getAttribute("item");
            if (item.getDone() == null) {
                item.setDone(getCurrent());
            } else {
                item.setDone(null);
            }
            ItemDB.saveOrUpdate(item);
        } else {
            Item item = ItemDB.getItem(Integer.parseInt(id));
            item.setDesc(desc);
            ItemDB.saveOrUpdate(item);
        }

        resp.sendRedirect(req.getContextPath() + "/index.do");
    }
}
