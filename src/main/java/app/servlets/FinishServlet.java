package app.servlets;

import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FinishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();

        if (req.getParameter("answer").equals("yes")) {
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/start.jsp");
////            req.setAttribute("username", currentSession.getAttribute("username"));
//            requestDispatcher.forward(req, resp);

            int stepLevel = Model.getInstance().getStepLevel();
            List<String> textForStep = Model.getInstance().getModel().get(stepLevel);

            currentSession.setAttribute("text", textForStep);
            currentSession.setAttribute("stepLevel", stepLevel);
            Model.getInstance().countPlus();

            currentSession.setAttribute("count", Model.getInstance().getCount());

            resp.sendRedirect("/start");

        } else if (req.getParameter("answer").equals("no")) {
            PrintWriter out = resp.getWriter();
            out.print("<html>  ");
            out.print("<body> ");
            out.print("<h2> See you next time! </h2>");
            out.print("<button type=\"submit\" onclick=\"location.href='index.jsp'\">Play again</button>");
            out.print("</body> ");
            out.print("</html> ");

            Model.getInstance().zeroCount();

            currentSession.invalidate();
        }


    }
}
