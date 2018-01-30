package dao;

import models.Attende;
import models.Conference;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.List;

public class Sql2oAttendeDao implements AttendeDao {
    private final Sql2o sql2o;

    public Sql2oAttendeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public void add(Attende attende) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String sql = "INSERT INTO attendees (name, email, phone, salary, birthdate, gender) VALUES (:name, :email, :phone, :salary, :birthdate, :gender)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("name", attende.getName())
                    .addParameter("email", attende.getEmail())
                    .addParameter("phone", attende.getPhone())
                    .addParameter("salary", attende.getSalary())
                    .addParameter("birthdate", attende.getBirthdate())
                    .addParameter("gender", attende.getGender())
                    .executeUpdate()
                    .getKey();
            attende.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void addAttendeToConference(Attende attende, Conference conference) {
        String sql = "INSERT INTO attendees_conferences (attendeId, conferenceId) VALUES (:attendeId, :conferenceId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("attendeId", attende.getId())
                    .addParameter("conferenceId", conference.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Attende> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM attendees")
                    .executeAndFetch(Attende.class);
        }
    }

    @Override
    public List<Attende> getAllAttendeesForConference(int conferenceId) {
        ArrayList<Attende> attendees = new ArrayList<>();

        String joinQuery = "SELECT attendeId FROM attendees_conferences WHERE conferenceId = :conferenceId";

        try (Connection con = sql2o.open()) {
            List<Integer> allAttendeesIds = con.createQuery(joinQuery)
                    .addParameter("conferenceId", conferenceId)
                    .executeAndFetch(Integer.class);
            for (Integer attendeId : allAttendeesIds){
                String attendeQuery = "SELECT * FROM attendees WHERE id = :attendeId";
                attendees.add(
                        con.createQuery(attendeQuery)
                                .addParameter("attendeId", attendeId)
                                .executeAndFetchFirst(Attende.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return attendees;
    }


    @Override
    public Attende findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM attendees WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Attende.class);
        }
    }

    @Override
    public void update(int id, String name, String email, String phone, double salary, String birthdate, String gender) {
        String sql = "UPDATE attendees SET (name, email, phone, salary, birthdate, gender) = (:name, :email, :phone, :salary, :birthdate, :gender) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("email", email)
                    .addParameter("phone", phone)
                    .addParameter("salary", salary)
                    .addParameter("birthdate", birthdate)
                    .addParameter("gender", gender)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from attendees WHERE id = :id";
        String deleteJoin = "DELETE from attendees_conferences WHERE attendeId = :attendeId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("attendeId", id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
}
