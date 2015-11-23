/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.CourseSession;
import fr.utbm.eformation.core.entity.Location;
import java.util.Date;
import java.util.List;

/**
 * Interface for the courses session DAO. It extends DAOInterface
 * @author java
 */
public interface CourseSessionInterfaceDAO extends DAOInterface<CourseSession>{
    /**
     * Looking for session using severals information: title, date, location
     * @param title
     * @param date
     * @param location
     * @return list of course session
     */
    public List<CourseSession> findSessionByInfos(String title,Date date,Location location);
    /**
     * Get all the clients who subscribed for a course session
     * @param cc
     * @return list of client
     */
    public List<Client> getClientBySession(CourseSession cc);
    /**
     * Get all the sessions in DB.
     * @return list of course session
     */
    public List<CourseSession> getListSession();
}
