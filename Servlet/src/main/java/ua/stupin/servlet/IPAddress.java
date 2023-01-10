package ua.stupin.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "ipAddress",
        urlPatterns = {"/ip"}
)

public class IPAddress extends HttpServlet {
    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter responseBody = resp.getWriter();
        InetAddress address = InetAddress.getLocalHost();
        String ipAddress = address.getHostAddress();
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">Sample Servlet GET method processing</h1>");
        responseBody.println("<h3 align=\"center\">Request from: " + req.getRemoteAddr() + "</h3>");
        String client = req.getParameter("client");
        if (client == null) {
            client = "anonymous user";
        }
        responseBody.println("<h3 align=\"center\">Hi, " + client + " </h3>");
        for (String key : getHashMap().keySet()) {
            if (key.equals(ipAddress)) {
                responseBody.println("<p><b>" + key + " :: " + getHashMap().get(key) + "</b></p>");
            } else {
                responseBody.println("<p>" + key + " :: " + getHashMap().get(key) + "</p>");
            }
        }
    }

    public Map<String, String> getHashMap() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("172.17.224.1", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.2", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.3", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.4", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.5", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.6", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.7", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.8", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.9", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        hashMap.put("172.17.224.10", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
        return hashMap;
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}