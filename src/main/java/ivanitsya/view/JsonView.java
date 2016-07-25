package ivanitsya.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import ivanitsya.web.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Component
public class JsonView implements View {

    @Autowired
    private JsonSerializer jsonSerializer;

    @Override
    public String getContentType() {
        return "application/json";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json" + ";" + "charset=utf-8");

        PrintWriter writer = response.getWriter();
        Response userResponse = (Response) model.get("response");
        if (userResponse != null) {
            jsonSerializer.serializeResponse(userResponse, writer);
            writer.close();
        }
    }
}
