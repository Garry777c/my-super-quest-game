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

public class GameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
               HttpSession currentSession = req.getSession();
               Model model = Model.getInstance();

        int previousStepLevel = (Integer) currentSession.getAttribute("stepLevel");
        int currentStepLevel = ++previousStepLevel;
        List <String> nextStepText;

        if (currentStepLevel==model.getModel().size()) {
            nextStepText = model.getModel().get(currentStepLevel);
            currentSession.setAttribute("text", nextStepText);
            currentSession.setAttribute("stepLevel", currentStepLevel);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/finish.jsp");
            requestDispatcher.forward(req, resp);

        }

        else if (req.getParameter("answer").equals("yes")) {
            nextStepText = model.getModel().get(currentStepLevel);

            currentSession.setAttribute("text", nextStepText);
            currentSession.setAttribute("stepLevel", currentStepLevel);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/start.jsp");
            requestDispatcher.forward(req, resp);
        } else if (req.getParameter("answer").equals("no")){
            PrintWriter out = resp.getWriter();
            out.print("<html>  ");
            out.print("<body> ");
            out.print("<h2> You have lost! </h2>");
            out.print("<button type=\"submit\" onclick=\"location.href='index.jsp'\">Play again</button>");
            out.print("</body> ");
            out.print("</html> ");

            Model.getInstance().zeroCount();

            currentSession.invalidate();
        }





    }
}
