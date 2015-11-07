package fr.utbm.eformation.core.entity;

/**
 *
 * @author java
 */
public class Course {
    private String courseCode;
    private String title;
    private String resume;
    private String courseDesc;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    @Override
    public String toString() {
        return "Course{" + "courseCode=" + courseCode + ", title=" + title + '}';
    }
    
}
