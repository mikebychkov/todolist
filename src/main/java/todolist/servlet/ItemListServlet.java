package todolist.servlet;

import org.json.JSONObject;
import todolist.model.Item;
import todolist.store.ItemDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ItemListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> list = ItemDB.getItemList();

        JSONObject jo = new JSONObject(list);

        resp.setContentType("text/json");

        PrintWriter out = resp.getWriter();
        out.write(jo.toString());
        out.flush();
    }
}
