package servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "OutboundMessageHandler", 
		urlPatterns = {"/*"}
		)
public class OutboundMessageHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	ServletOutputStream out = resp.getOutputStream();
        out.write("Salesforce Outbound Message Handler (supports POST only)\n".getBytes());
        String pathInfo = "pathInfo: " + req.getPathInfo() + "\n";
        out.write(pathInfo.getBytes());
        out.flush();
        out.close();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	String body = RequestUtils.getBody(req);
    	OutboundMessage message = new OutboundMessage(body);
    	message.doCallback(req);
    	 
    	resp.setContentType("text/xml");
    	OutputStreamWriter out = new OutputStreamWriter(resp.getOutputStream());
		out.write(OutboundMessage.ACK_RESPONSE);
		out.flush();
		out.close();
    }
}