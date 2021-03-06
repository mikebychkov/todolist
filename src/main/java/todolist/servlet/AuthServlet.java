package todolist.servlet;

import todolist.model.Author;
import todolist.store.AuthorDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String log = req.getParameter("log");
        if ("0".equals(log)) {
            req.getSession().removeAttribute("author");
        }
        req.getRequestDispatcher("WEB-INF/templates/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Author author = AuthorDB.get(email);
        if (author != null && password.equals(author.getPassword())) {
            HttpSession sc = req.getSession();
            sc.setAttribute("author", author);
            resp.sendRedirect(req.getContextPath() + "/index.do");
        } else {
            req.setAttribute("error", "Неверный email или пароль");
            req.getRequestDispatcher("auth.do").forward(req, resp);
        }
    }
}
