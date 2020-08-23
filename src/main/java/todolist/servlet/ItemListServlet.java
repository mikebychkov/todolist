package todolist.servlet;

import org.json.JSONArray;
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

        System.out.println("ItemListServlet#doGet=========start query=========");

        List<Item> list = ItemDB.getItemList();

        JSONArray jo = new JSONArray(list);

        resp.setContentType("text/json");

        System.out.println("ItemListServlet#doGet=========write query result into response=========");

        PrintWriter out = resp.getWriter();
        out.write(jo.toString());
        out.flush();
    }
}
