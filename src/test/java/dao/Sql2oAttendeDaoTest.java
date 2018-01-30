package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Attende;
import models.Conference;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class Sql2oAttendeDaoTest {
    private Connection conn;
    private Sql2oAttendeDao attendeDao;
    private Sql2oConferenceDao conferenceDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/conference.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        attendeDao = new Sql2oAttendeDao(sql2o);
        conferenceDao = new Sql2oConferenceDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
    @Test
    public void addingAttendeSetsId() throws Exception {
        Attende attende = setupAttende();
        attendeDao.add(attende);
        assertEquals(1, attende.getId());
    }
    @Test
    public void getAllAttendeesForAConferenceReturnsAttendeesCorrectly() throws Exception {
        Conference testConference = setupConference();
        conferenceDao.add(testConference);
        Attende otherAttende = setupAttende();
        Attende testAttende = setupAttende();
        attendeDao.add(testAttende);
        attendeDao.addAttendeToConference(testAttende,testConference);
        attendeDao.addAttendeToConference(testAttende,testConference);
        Attende[] attendees = {testAttende, otherAttende}; //oh hi what is this?
        assertEquals(attendeDao.getAllAttendeesForConference(testAttende.getId()).size(), Arrays.asList(attendees).size());
    }



    public Attende setupAttende()  {
        String testDate = "02/04/2014";
        return new Attende("Name", "email","97237",50000, testDate ,"male");
    }
    public Conference setupConference()  {
        String testDate = "02/04/2018";
        return new Conference(testDate, "Topic", "address", 1,1 );
    }
}