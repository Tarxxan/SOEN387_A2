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
                    e.setPhoneNumber(rs.getString("phoneNumber"));
                    e.setAppartmentNumber(rs.getString("appartmentNumber"));
                    e.setStreetName(rs.getString("streetName"));
                    e.setCity(rs.getString("city"));
                    e.setCountry(rs.getString("country"));
                   e.setFirstName(rs.getString("firstName"));
                   e.setLastName(rs.getString("lastName"));
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
                    s.setPhoneNumber(rs.getString("phoneNumber"));
                    s.setAppartmentNumber(rs.getString("appartmentNumber"));
                    s.setStreetName(rs.getString("streetName"));
                    s.setCity(rs.getString("city"));
                    s.setCountry(rs.getString("country"));
                    s.setFirstName(rs.getString("firstName"));
                    s.setLastName(rs.getString("lastName"));
                    break;
                }
            }
            this.memoryObjects.add(s);
        }
       else if (O instanceof Courses) {
            Courses c = (Courses) O;
            ResultSet rs=this.CM.getAllCourses();
            while(rs.next()){
                if( rs.getInt("ID_courses") == (c.getPkid())){
                    c.setCourseCode(rs.getString("courseCode"));
                    c.setTitle(rs.getString("title"));
                    c.setSemester(rs.getString("semester"));
                    c.setDays(rs.getString("daysScheduled"));
                    c.setTime(rs.getString("timeScheduled"));
                    c.setClassroom(rs.getString("classroom"));
                    c.setInstructor(rs.getString("instructor"));
                    c.setStartDate(rs.getDate("startDate"));
                    c.setEndDate(rs.getDate("endDate"));
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
                if (c.getPkid()==(c2.getPkid())) {
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
                if (course.getPkid()==(c2.getPkid())) {
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

    public Courses updateMemCourse(Courses course) {
        for (int i = 0; i < memoryObjects.size(); i++) {
            if (memoryObjects.get(i) instanceof Courses) {
                Courses c2 = (Courses) memoryObjects.get(i);
                if (course.getPkid()==(c2.getPkid())) {

                    if(course.getDays().equals("")){
                        course.setDays(c2.getDays());
                    }
                    if(course.getTitle().equals("")){
                        course.setTitle(c2.getTitle());
                    }
                    if(course.getTime().equals("")){
                        course.setTime(c2.getTime());
                    }
                    if(course.getSemester().equals("")){
                        course.setSemester(c2.getSemester());
                    }
                    if(course.getInstructor().equals("")){
                        course.setInstructor(c2.getInstructor());
                    }
                    if(course.getStartDate()==null){
                        course.setStartDate(c2.getStartDate());
                    }
                    if(course.getEndDate()==null){
                        course.setEndDate(c2.getEndDate());
                    }

                    if(course.getClassroom().equals("")){
                        course.setClassroom(c2.getClassroom());
                    }
                    memoryObjects.set(i, course);
                    return course;
                }
            }
        }
        return course;
    }

    public Person updateMemPerson(Person p) {

        for (int i = 0; i < memoryObjects.size(); i++) {
            System.out.println((memoryObjects.get(i) instanceof Student)+"Call from mapper");
            if (memoryObjects.get(i) instanceof Student){
                Student s2= (Student) memoryObjects.get(i);
                if (p.getPersonalID() == s2.getPersonalID()) {
                    Student s1 = (Student) p;
                    s1 = (Student) updatePersonVars(s1, s2);
                    memoryObjects.set(i, s1);
                    return s1;
                }
            }

            else if(memoryObjects.get(i) instanceof Employee) {
                Employee e2= (Employee) memoryObjects.get(i);
                if (p.getPersonalID() == e2.getPersonalID()) {
                    Employee e1 = (Employee) p;
                    e1 = (Employee) updatePersonVars(e1, e2);
                    memoryObjects.set(i, e1);
                    return e1;
                }
            }
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

    public void updatePerson(Person p) throws SQLException {
        Employee e=null;
        Student s=null;
        if(p.getPersonalID()>89999999){
            e= (Employee) p;
            this.PM.updatePerson(e);
        }
        else{
            s = (Student) p;
            this.PM.updatePerson(s);
        }


        }


   public Person updatePersonVars(Person p,Person p2 ){
        if (p.getPersonalID() == p2.getPersonalID()) {
            if(p.getLastName().equals("")){
                p.setLastName(p2.getLastName());
            }

            if(p.getFirstName().equals("")){
                p.setFirstName(p2.getFirstName());
            }

            if(p.getCity().equals("")){
                p.setCity(p2.getCity());
            }

            if(p.getCountry().equals("")){
                p.setCountry(p2.getCountry());
            }

            if(p.getAppartmentNumber().equals("")){
                p.setAppartmentNumber(p2.getAppartmentNumber());
            }

            if(p.getEmail().equals("")){
                p.setEmail(p2.getEmail());
            }

            if(p.getIsStudent()!= p2.getIsStudent()){
                p.setIsStudent(p2.getIsStudent());
            }

            if(p.getPhoneNumber().equals("")){
                p.setPhoneNumber(p2.getPhoneNumber());
            }

            if(p.getStreetName().equals("")){
                p.setStreetName(p2.getStreetName());
            }

            if(p.getStreetNumber().equals("")) {
                p.setStreetNumber(p2.getStreetNumber());
            }

            if(p.getPostalCode().equals("")){
                p.setPostalCode(p2.getPostalCode());
            }

            if(p.getDateOfBirth()==null){
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
                Person p2 = (Person) memoryObjects.get(i);
                if (p2.getPersonalID()==p.getPersonalID()) {
                    System.out.println("Calling delete");
                    this.PM.delete(p);
                    memoryObjects.remove(i);
                }
            }
        }
    }
}