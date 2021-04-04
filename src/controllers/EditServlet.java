package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utility.DBUtility;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtility.createEntityManager();

        // 該当のIDのメッセージ1件のみをデータベースから取得
        Tasks t = em.find(Tasks.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // タスク情報とセッションIDをリクエストスコープに登録
        request.setAttribute("task", t);
        request.setAttribute("_token", request.getSession().getId());

        // タスクデータが存在しているときのみメッセージIDをセッションスコープに登録
        if (t != null) {
            request.getSession().setAttribute("task_id", t.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/edit.jsp");
        rd.forward(request, response);
    }
}