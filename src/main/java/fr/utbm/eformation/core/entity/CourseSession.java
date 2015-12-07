package fr.utbm.eformation.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * session of a course
 * @author java
 */
public class CourseSession implements Serializable{
    private static final long serialVersionUID = 1L;
    private int courseSessionId;
    private Date startDate;
    private Date endDate;
    //Attributes Association
    private Course course;
    private Location location;
    private List<Client> clients;
    
    public CourseSession(){
        this.clients = new LinkedList<>();
        this.course = new Course();
        this.location = new Location();
    }
    
    public int getCourseSessionId() {
        return courseSessionId;
    }

    public void setCourseSessionId(int courseSessionId) {
        this.courseSessionId = courseSessionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    
    public void addClient(Client a){
        this.clients.add(a);
    }

    @Override
    public String toString() {
        return "CourseSession{" + "courseSessionId=" + courseSessionId + ", startDate=" + startDate + ", endDate=" + endDate + ", " + course + ", " + location + '}';
    }
    
    
}
