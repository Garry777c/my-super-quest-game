package app.servlets;

import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("Method Get from StartServlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/start.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        Model model = Model.getInstance();
        String sessionID = currentSession.getId();
        int currentCount = Model.getInstance().getCount();

        String username = req.getParameter("username");

        if(username==null || username =="") {
            req.setAttribute("reEnterName", "Please enter name!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }

        int stepLevel = model.getStepLevel();
        List<String> textForStep = model.getModel().get(stepLevel);

//        String step1 = model.getModel().get(stepLevel)[0];
//        String answerYes = model.getModel().get(stepLevel)[1];
//        String answerNo = model.getModel().get(stepLevel)[2];




        currentSession.setAttribute("username", username);

        currentSession.setAttribute("text", textForStep);
        currentSession.setAttribute("stepLevel", stepLevel);

        currentSession.setAttribute("count", currentCount);

         resp.sendRedirect("/start");


//        PrintWriter writer = resp.getWriter();
//        writer.println("Method Post from StartServlet");
//        String name = req.getParameter("username");
//        writer.println("Your name "+name);
    }

}
