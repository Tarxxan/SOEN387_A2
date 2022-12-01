package Classes;

import java.sql.SQLException;
import java.util.ArrayList;

public class InheritanceMapper {
    ArrayList<Object> memoryObjects;
    EnrollmentMapper EM;
    PersonMapper PM;
    CoursesMapper CM;


    public InheritanceMapper() {
        ArrayList<Object> memoryObjects = new ArrayList<Object>();
        EM = new EnrollmentMapper();
        CM = new CoursesMapper();
        PM = new PersonMapper();
    }

    public void findObject(Object O) {
        if (O instanceof Person) {
            if (O instanceof Student) {
                Student s = (Student) O;
                this.memoryObjects.add(s);
            } else {
                Employee e = (Employee) O;
                this.memoryObjects.add(e);
            }
        } else if (O instanceof Courses) {
            Courses c = (Courses) O;
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
                if (course.equals(c2)) {
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
                    memoryObjects.set(i, course);
                    this.CM.delete(course);
                    memoryObjects.remove(i);
                }
            }
        }
    }
}