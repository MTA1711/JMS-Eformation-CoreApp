package fr.utbm.eformation.core.entity;

import java.io.Serializable;

/**
 * Represent a client who subcribes a course session
 * @author java
 */
public class Client implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idClient;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;
    //Attributes Association
    private CourseSession session;
    
    public Client(){
        this.session = new CourseSession();
    }
    
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getSession() {
        return session;
    }

    public void setSession(CourseSession session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Client{" + "idClient=" + idClient + ", lastName=" + lastName + ", firstName=" + firstName + ", address=" + address + ", phone=" + phone + ", email=" + email + ", " + session + '}';
    }
    
    
}
