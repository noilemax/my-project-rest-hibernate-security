package ivanitsya.view;


import ivanitsya.users.model.UserRole;
import org.hibernate.type.SerializationException;
import org.json.JSONException;
import org.json.JSONWriter;
import org.springframework.stereotype.Component;
import ivanitsya.users.model.User;
import ivanitsya.web.Response ;
//import taskivanitsyarest.web.Response;

import java.io.Writer;
import java.util.Set;

/**
 * Created by Администратор on 23.06.2016.
 */
@Component
public class JsonSerializer {

    public void serializeResponse(Response response, Writer writer) throws SerializationException {

        try {
            JSONWriter jsonWriter = new JSONWriter(writer);
            jsonWriter.object();
            jsonWriter.key("response").object();
            jsonWriter.key("users");
            jsonWriter.array();
            for (User user : response.getUsers()) {
                serializeUser(user, jsonWriter);
            }
            jsonWriter.endArray();

            jsonWriter.endObject();
            jsonWriter.endObject();
        } catch (JSONException e) {
            throw new SerializationException(null, e);
        }
    }

    private void serializeUser(User user, JSONWriter jsonWriter) {
        jsonWriter.object();
        serializeField("userName", user.getUsername(), jsonWriter);
        serializeField("password", user.getPassword(), jsonWriter);
        serializeField("isActive", String.valueOf(user.isEnabled()), jsonWriter);
        jsonWriter.key("roles");
        jsonWriter.array();
        for (UserRole role : user.getUserRole()){
            serializeRole(role, jsonWriter);
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
//TODO ТУТ Я ТАК ПОНИМАЮ ЧТО СЕРИАЛИЗАБЛИТЬ ОН ДОЛЖЕН ВСЕ ПОЛЯ?
        //КАК СЕРИАЛИЗАБЛИТЬ РОЛЬ НАДО ПОГУГЛИТЬ

    }

    private void serializeRole(UserRole role,JSONWriter jsonWriter) {
        jsonWriter.object();
        serializeField("role", role.getRole(),jsonWriter);
        jsonWriter.endObject();
    }

    private void serializeField(String key, String value, JSONWriter jsonWriter) {
        if (key != null && value != null) {
            jsonWriter.key(key).value(value);
        }
    }
}
