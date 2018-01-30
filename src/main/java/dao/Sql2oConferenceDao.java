package dao;

import models.Attende;
import models.Conference;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Sql2oConferenceDao implements ConferenceDao {
    private final Sql2o sql2o;

    public Sql2oConferenceDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(Conference conference) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String sql = "INSERT INTO conferences(confDate, topic, address, instructorId, sponsorId) VALUES (:confDate, :topic, :address, :instructorId, :sponsorId)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("confDate", conference.getConfDate())
                    .addParameter("topic", conference.getTopic())
                    .addParameter("address", conference.getAddress())
                    .addParameter("instructorId", conference.getInstructorId())
                    .addParameter("sponsorId", conference.getSponsorId())
                    .executeUpdate()
                    .getKey();
            conference.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Conference> getAll() {
        return null;
    }

    @Override
    public List<Conference> getAllConferencesForAttendees(int attendeId) {
        return null;
    }

    @Override
    public Conference findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM conferences WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Conference.class);
        }
    }

    @Override
    public void update(int id, Date confDate, String topic, String address, int instructorId, int sponsorId, int attendeesAverageAge, double attendeesAverageSalary, int womenNumber, int menNumber) {

    }

    @Override
    public void deleteById(int id) {

    }
}
