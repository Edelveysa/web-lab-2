package com.servlets;

import com.model.Shot;
import com.model.ShotHistory;
import com.model.ShotRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/shoot")
public class AreaCheckServlet extends HttpServlet {

    String historyAttribute = "history";
    String resultAttribute = "result";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShotRequest shotRequest = ShotRequest.fromHttpRequest(request);
        System.out.println("Прилетел запрос:" + shotRequest.toString());
        if (shotRequest == null) return;

        Shot result = getShotFromRequest(shotRequest);
        HttpSession session = request.getSession();
        ShotHistory shotHistory = ShotHistory.readFromSession(session, historyAttribute);
        shotHistory.pushShot(result);
        session.setAttribute(historyAttribute, shotHistory);
        request.setAttribute(resultAttribute, result);

        request.getRequestDispatcher("/results.jsp").forward(request, response);
    }
    private Shot getShotFromRequest(ShotRequest shotRequest){
        double x = shotRequest.getX();
        double y = shotRequest.getY();
        double r = shotRequest.getR();
        boolean isHit = this.checkHit(x, y, r);
        return new Shot(x, y, r, isHit);

    }
    private boolean checkHit(double x, double y, double r){
        if (x <= 0 && y > 0) return false;
        if (x <= 0 && y <= 0 && x >= -r && y >= -r/2) return true;
        if (x >= 0 && y <= 0 && x + (-y) <= r) return true;
        return x >= 0 && y >= 0 && (x*x + y*y <= r*r/4);
    }
}