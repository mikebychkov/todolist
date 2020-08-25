package todolist.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import todolist.model.BeautyItem;
import todolist.model.Item;
import todolist.store.ItemDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ItemListServlet#doGet=========start query=========");

        String listType = req.getParameter("list");

        List<Item> list;
        if ("actual".equals(listType)) {
            list = ItemDB.getActualItemList();
        } else {
            list = ItemDB.getItemList();
        }
        List<BeautyItem> bList = list.stream().map(i -> new BeautyItem(i)).collect(Collectors.toList());

        JSONArray jo = new JSONArray(bList);

        resp.setContentType("text/json");

        System.out.println("ItemListServlet#doGet=========write query result into response=========");

        PrintWriter out = resp.getWriter();
        out.write(jo.toString());
        out.flush();
    }
}
