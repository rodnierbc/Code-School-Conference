import com.google.gson.Gson;
import dao.Sql2oConferenceDao;
import dao.Sql2oAttendeDao;
import models.Conference;
import models.Attende;
import exceptions.ApiException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Sql2oConferenceDao conferenceDao;
        Sql2oAttendeDao attendeDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/something.db;INIT=RUNSCRIPT from 'classpath:db/conference.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        conferenceDao = new Sql2oConferenceDao(sql2o);
        attendeDao = new Sql2oAttendeDao(sql2o);
        conn = sql2o.open();

        post("/conferences/new", "application/json", (req, res) -> {
            Conference conference = gson.fromJson(req.body(), Conference.class);
            conferenceDao.add(conference);
            res.status(201);
            return gson.toJson(conference);
        });
        post("/attendees/new", "application/json", (req, res) -> {
            Attende attende = gson.fromJson(req.body(), Attende.class);
            attendeDao.add(attende);
            res.status(201);
            return gson.toJson(attende);
        });

        post("/conferences/:conferenceId/attendees/:attendeId", "application/json", (req, res) -> {
            int conferenceId = Integer.parseInt(req.params("conferenceId"));
            int attendeId = Integer.parseInt(req.params("attendeId"));
            Conference conference = conferenceDao.findById(conferenceId);
            Attende attende = attendeDao.findById(attendeId);

            if (conference != null && attende != null){
                attendeDao.addAttendeToConference(attende, conference);
                res.status(201);
                return gson.toJson(String.format("Conference '%s' and Attende '%s' have been associated",conference.getTopic(), attende.getName()));
            }
            else {
                throw new ApiException(404, String.format("Conference or Attende does not exist"));
            }
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((req, res) ->{
            res.type("application/json");
        });

    }
}
