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

               HttpSession currentSession = req.getSession();
               Model model = Model.getInstance();

        int curStepLevel = (Integer) currentSession.getAttribute("stepLevel");
        int nextStepLevel = curStepLevel + 1;

        List <String> nextStepText;

        if(req.getParameter("answer").equals("no")){
            PrintWriter out = resp.getWriter();
            out.print("<html>  ");
            out.print("<body> ");
            out.print("<h2> You have lost! </h2>");
            out.print("<button type=\"submit\" onclick=\"location.href='index.jsp'\">Play again</button>");
            out.print("</body> ");
            out.print("</html> ");

            Model.getInstance().zeroCount(); //если надо делать общее количество игр вообще, с учетом всех поражений, то эту строку надо убрать и раскоментировать другую
            currentSession.invalidate();

//            Model.getInstance().countPlus(); //эту нужно расскоментировать чтобы был счетчик любых игр, даже проигранных
        }


        else if (nextStepLevel==model.getModel().size()) {
            nextStepText = model.getModel().get(nextStepLevel);
            currentSession.setAttribute("text", nextStepText);
            currentSession.setAttribute("stepLevel", nextStepLevel);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/finish.jsp");
            requestDispatcher.forward(req, resp);

        }

        else if (req.getParameter("answer").equals("yes")) {
            nextStepText = model.getModel().get(nextStepLevel);

            currentSession.setAttribute("text", nextStepText);
            currentSession.setAttribute("stepLevel", nextStepLevel);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/start.jsp");
            requestDispatcher.forward(req, resp);

        }

    }
}
