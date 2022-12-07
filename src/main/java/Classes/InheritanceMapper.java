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
        if (O instanceof Employee) {
            Employee e = (Employee) O;

            ResultSet rs = this.PM.getAllPerson();
            while (rs.next()) {
                if (rs.getInt("id") == e.getPersonalID()) {
                    e.setDateOfBirth(rs.getDate("dateOfBirth"));
                    e.setPostalCode(rs.getString("postalCode"));
                    e.setStreetNumber(rs.getString("streetNumber"));
                    e.setEmail(rs.getString("email"));
                    e.setPhoneNumber(rs.getString("phonenumber"));
                    e.setAppartmentNumber(rs.getString("appartmentNumber"));
                    e.setStreetName(rs.getString("streetName"));
                    e.setCity(rs.getString("city"));
                    e.setCountry(rs.getString("country"));
//                   p.setFirstName(rs.getString("firstName"));
//                   p.setLastName(rs.getString("lastName"));e
//                   e.setFullName(rs.getString("identifier"));
                    break;
                }
            }
            this.memoryObjects.add(e);
        }
       else if(O instanceof Student){
           Student s= (Student) O;

            ResultSet rs = this.PM.getAllPerson();
            while (rs.next()) {
                if (rs.getInt("id") == s.getPersonalID()) {
                    s.setDateOfBirth(rs.getDate("dateOfBirth"));
                    s.setPostalCode(rs.getString("postalCode"));
                    s.setStreetNumber(rs.getString("streetNumber"));
                    s.setEmail(rs.getString("email"));
                    s.setPhoneNumber(rs.getString("phonenumber"));
                    s.setAppartmentNumber(rs.getString("appartmentNumber"));
                    s.setStreetName(rs.getString("streetName"));
                    s.setCity(rs.getString("city"));
                    s.setCountry(rs.getString("country"));
                    break;
                }
            }
            this.memoryObjects.add(s);
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
            this.memoryObjects.add(c);
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
                    if(course.getStartDate()!=null){
                        c2.setStartDate(course.getStartDate());
                    }
                    if(course.getEndDate()!=null){
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

        for (int i = 0; i < memoryObjects.size(); i++) {
            System.out.println(memoryObjects.get(i) instanceof Student);
            if (memoryObjects.get(i) instanceof Student){
                Student s2= (Student) memoryObjects.get(i);
                Student s1 = (Student) p;

                if (s1.getPersonalID() == s2.getPersonalID()) {
                    s1 = (Student) updatePersonVars(s1, s2);
                    memoryObjects.set(i, s1);
                    return s1;
                }

            }
            else if(memoryObjects.get(i) instanceof Employee) {
             Employee e1 = (Employee) p;
             Employee e2= (Employee) memoryObjects.get(i);

            if (e1.getPersonalID() == e2.getPersonalID()) {
                e1 = (Employee) updatePersonVars(e1, e2);
                memoryObjects.set(i, e1);
                return e1;
            }}
     }
        return p; }
    public Boolean inMapperPerson(Person p) {
            if(memoryObjects==null){
                return false;
                }

                for (int i = 0; i < memoryObjects.size(); i++) {
                    if (memoryObjects.get(i) instanceof Student || memoryObjects.get(i) instanceof Employee ) {
                        Person p2 = (Person) memoryObjects.get(i);
                        if (p.getPersonalID() == p2.getPersonalID()) {
                            return true;
                        }
                    }
                }
//
            return false;
        }

//TODO: Validate if the update procedures for person are useful or if you want them combined as one. They all detect if student or employee inside the procedure.
    public void updatePerson(Person p) throws SQLException {
        Employee e=null;
        Student s=null;
        if(p.getPersonalID()>89999999){
            e= (Employee) p;
        }
        else{
            s = (Student) p;
        }

        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Student && ((Student) memoryObjects.get(i)).getPersonalID()==s.getPersonalID()) {
                s= (Student) memoryObjects.get(i);
                memoryObjects.set(i, s);
                this.PM.updatePerson(s);
                }
            else if(memoryObjects.get(i) instanceof Employee && ((Employee) memoryObjects.get(i)).getPersonalID()==e.getPersonalID()){
                e= (Employee) memoryObjects.get(i);
                System.out.println(e);
                memoryObjects.set(i, e);
                this.PM.updatePerson(e);
            }

        }
    }

   public Person updatePersonVars(Person p,Person p2 ){
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

            if(p.getPhoneNumber()!=null){
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

//                if(!p.getPassword().equals("")){
//                    p.setPassword(p2.getPassword());
//                }

//                if(p.getContactDetails()!=p2.getContactDetails()){
//                    p.setContactDetails(p2.getContactDetails());
//
//                }

            if(p.getDateOfBirth()!=null){
                p.setDateOfBirth(p2.getDateOfBirth());
            }

        }
       return p;}

    public void deletePerson(Person p) throws SQLException {
        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Person) {
               Person p2 = (Person) memoryObjects.get(i);
                if (p2.getPersonalID()==p.getPersonalID()) {
                    System.out.println("Calling delete");
                    this.PM.delete(p);
                    memoryObjects.remove(i);
                }
            }
            else if(memoryObjects.get(i) instanceof Employee){
                System.out.println("Instance of employee");
            }
        }
    }
}