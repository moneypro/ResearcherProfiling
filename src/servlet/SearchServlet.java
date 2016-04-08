package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.SearchHandler;
import models.Model;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import models.SearchHandler;
import static utils.Utilities.getNameTokens;


/**
 * Created by MoNeY_Pro on 2016/4/7.
 */
public class SearchServlet extends HttpServlet {
    public void init(){

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
//        Model m = new Model();
        String name = req.getParameter("Name");
        String affiliation = req.getParameter("Affiliation");
        if (name.equals("Name, i.e. Jiawei Han")) {
            return;
        }
        JSONObject searchConditions = new JSONObject();
        String[] nameTokens = getNameTokens(name);
        searchConditions.put("first", nameTokens[0]);
        searchConditions.put("last", nameTokens[1]);
        if (nameTokens[2].length() != 0) {
            searchConditions.put("middle", nameTokens[2]);
        }
        searchConditions.put("fullName", name);
        if(!affiliation.equals("Affiliation, i.e. UIUC")) {
            searchConditions.put("affiliation", affiliation);
        }
        SearchHandler searchHandler = new SearchHandler();
        JSONObject searchResult = searchHandler.search(searchConditions);
        out.println(searchResult);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        doGet(req,res);
    }
    public void destroy(){

    }
}
