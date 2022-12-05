package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InheritanceMapper {
    public ArrayList<Object> memoryObjects;
    EnrollmentMapper EM;
    PersonMapper PM;
    CoursesMapper CM;


    public InheritanceMapper() {
        this.memoryObjects = new ArrayList<>();
        EM = new EnrollmentMapper();
        CM = new CoursesMapper();
        PM = new PersonMapper();
    }

    public void findObject(Object O) throws SQLException {
        if (O instanceof Person) {
            if (O instanceof Student) {
                Student s = (Student) O;
                //TODO: We need something we can access everything in one area for a person. Then the code is essentially copy paste from courses but with person stuff. All personal information columns or all records related to this person?-Carolina
                //ResultSet rs=this.WHATEVER FUNC


                this.memoryObjects.add(s);
            } else {
                Employee e = (Employee) O;
                this.memoryObjects.add(e);
            }
        } else if (O instanceof Courses) {
            Courses c = (Courses) O;
            ResultSet rs=this.CM.getAllCourses();
            while(rs.next()){
                if(rs.getString("courseCode").equals(c.getCourseCode())){
                    c.setTitle(rs.getString("title"));
                    c.setSemester(rs.getString("semester"));
                    c.setDays(rs.getString("daysScheduled"));
                    c.setClassroom(rs.getString("classroom"));
                    c.setTime(rs.getString("timeScheduled"));
                    c.setStartDate(rs.getDate("startDate"));
                    c.setEndDate(rs.getDate("endDate"));
                    c.setInstructor(rs.getString("instructor"));
                    c.setCourseIdentifier(rs.getString("courseIdentifier"));
                    break;
                }
            }
            // Check this after
            this.memoryObjects.add(c);
        } else {
            Enrollment er = (Enrollment) O;
            this.memoryObjects.add(er);
        }
    }

//    public String deleteObject(Object O) {
//
//        for (Object o : memoryObjects) {
//            if (o.getClass() == O.getClass()) {
//                if (o instanceof Person)
//                    if (o instanceof Student) {
//                        if (Student.delete(o, O)) {
//                            memoryObjects.remove(o);
//                        }
//                    } else {
//                        if (Employee.delete(o, O)) {
//                            memoryObjects.remove(o);
//                        }
//                    }
//                else if (O instanceof Courses) {
//                    if (Courses.delete(o, O)) {
//                        memoryObjects.remove(o);
//                    }
//                } else {
//                    if (Enrollment.delete(o, O)) {
//                        memoryObjects.remove(o);
//                    }
//                }
//            }
//        }
//        return null;
//    }

    public String findObjectType(Object O) {
        if (O instanceof Person) {
            if (O instanceof Student) {
                return "s";
            } else {
                return "e";
            }
        } else if (O instanceof Courses) {
            return "c";
        } else {
            return "er";
        }
    }

    public boolean inMapperCourse(Courses c) {
        if(memoryObjects==null){
            return false;
        }

        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Courses) {
                Courses c2 = (Courses) memoryObjects.get(i);
                if (c.getCourseCode().equals(c2.getCourseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateCourse(Courses course) throws SQLException {
        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Courses) {
                Courses c2 = (Courses) memoryObjects.get(i);
                if (course.getCourseCode().equals(c2.getCourseCode())) {
                    memoryObjects.set(i, course);
                    this.CM.updateCourse(course);
                }
            }
        }
    }

    public void deleteCourse(Courses course) throws SQLException {
        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Courses) {
                Courses c2 = (Courses) memoryObjects.get(i);
                if (course.equals(c2)) {
                    this.CM.delete(c2);
                    memoryObjects.remove(i);
                }
            }
        }
    }
//TODO: Solved the date issue, you can default to null if you do not want to update this information.Validate the procedure and confirm that it is what you need.
    public Courses updateMemCourse(Courses course) {
        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Courses) {
                Courses c2 = (Courses) memoryObjects.get(i);
                if (course.getCourseCode().equals(c2.getCourseCode())) {

                    if(!course.getDays().equals("")){
                        c2.setDays(course.getDays());
                    }
                    if(!course.getTitle().equals("")){
                        c2.setTitle(course.getTitle());
                    }
                    if(!course.getTime().equals("")){
                        c2.setTime(course.getTime());
                    }
                    if(!course.getSemester().equals("")){
                        c2.setSemester(course.getSemester());
                    }
                    if(!course.getInstructor().equals("")){
                        c2.setInstructor(course.getInstructor());
                    }
                    if(!course.getStartDate().equals("11111111")){
                        c2.setStartDate(course.getStartDate());
                    }
                    if(!course.getEndDate().equals("11111112")){
                        c2.setEndDate(course.getEndDate());
                    }

                    if(!course.getClassroom().equals("")){
                        c2.setClassroom(course.getClassroom());
                    }
                }
                return c2;}
        }
        return course;
    }

    public Person updateMemPerson(Person p) {
        Person p2 = null;
        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Student) {
                p2 = (Student) memoryObjects.get(i);
                p = (Student) p;
            }
            else if(memoryObjects.get(i) instanceof Employee) {
                p2 = (Employee) memoryObjects.get(i);
                p = (Employee) p;
            }

            if (p.getPersonalID() == p2.getPersonalID()) {

                if(!p.getLastName().equals("")){
                    p.setLastName(p2.getLastName());
                }

                if(!p.getFirstName().equals("")){
                    p.setFirstName(p2.getFirstName());
                }

                if(!p.getCity().equals("")){
                    p.setCity(p2.getCity());
                }

                if(!p.getCountry().equals("")){
                    p.setCountry(p2.getCountry());
                }

                if(!p.getAppartmentNumber().equals("")){
                    p.setAppartmentNumber(p2.getAppartmentNumber());
                }

                if(!p.getEmail().equals("")){
                    p.setEmail(p2.getEmail());
                }

                if(p.getIsStudent()!= p2.getIsStudent()){
                   p.setIsStudent(p2.getIsStudent());
                }

                if(!p.getPhoneNumber().equals("")){
                    p.setPhoneNumber(p2.getPhoneNumber());
                }

                if(!p.getStreetName().equals("")){
                    p.setStreetName(p2.getStreetName());
                }

                if(!p.getStreetNumber().equals("")) {
                    p.setStreetNumber(p.getStreetNumber());
                }

                if(!p.getPostalCode().equals("")){
                    p.setPostalCode(p2.getPostalCode());
                }

                if(!p.getPassword().equals("")){
                    p.setPassword(p2.getPassword());
                }

                if(p.getContactDetails()!=p2.getContactDetails()){
                    p.setContactDetails(p2.getContactDetails());

                }

                if(!p.getDateOfBirth().equals(p2.getDateOfBirth())){
                    p.setDateOfBirth(p2.getDateOfBirth());
                }
            }
        }
            return p;
        }
    public Boolean inMapperPerson(Person p) {
            if(memoryObjects==null){
                return false;
                }

                for (int i = 0; i < memoryObjects.size(); i++) {
                    if (memoryObjects.get(i) instanceof Student) {
                        Student s2 = (Student) memoryObjects.get(i);
                        if (p.getPersonalID()==s2.getPersonalID()) {
                            return true;
                        }
                    }
                    else if (memoryObjects.get(i) instanceof Employee){
                        Employee e2 = (Employee) memoryObjects.get(i);
                        if (p.getPersonalID()==e2.getPersonalID()) {
                            return true;
                        }
                    }
                }
            return false;
        }
//TODO: Validate if the update procedures for person are useful or if you want them combined as one. They all detect if student or employee inside the procedure.
    public void updatePerson(Person p) throws SQLException {
        if(p.getPersonalID()>89999999){
            p= (Employee) p;
        }
        else{
            p = (Student) p;
        }

        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Student && ((Student) memoryObjects.get(i)).getPersonalID()==p.getPersonalID()) {
                memoryObjects.set(i, p);
                this.PM.updatePerson(p);
                }
            else if(memoryObjects.get(i) instanceof Employee && ((Employee) memoryObjects.get(i)).getPersonalID()==p.getPersonalID()){
                memoryObjects.set(i, p);
                this.PM.updatePerson(p);
            }

        }
    }

}