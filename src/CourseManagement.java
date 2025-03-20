import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CourseManagement {
    private List<Course> courses;
    private String userRole;

    public CourseManagement(String userRole) {
        this.courses = new ArrayList<>();
        this.userRole = userRole;
    }

    public void addCourse(Course course) {
        if (userRole.equals("ADMIN")) {
            courses.add(course);
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Access Denied: Only ADMIN can add courses.");
        }
    }

    public void editCourse(String courseCode, Course updatedCourse) {
        if (userRole.equals("ADMIN")) {
            for (Course course : courses) {
                if (course.getCourseCode().equals(courseCode)) {
                    course.setCourseName(updatedCourse.getCourseName());
                    course.setSubjectName(updatedCourse.getSubjectName());
                    course.setSectionNumber(updatedCourse.getSectionNumber());
                    course.setTeacherName(updatedCourse.getTeacherName());
                    course.setCapacity(updatedCourse.getCapacity());
                    course.setLectureTime(updatedCourse.getLectureTime());
                    course.setFinalExamDateTime(updatedCourse.getFinalExamDateTime());
                    course.setLocation(updatedCourse.getLocation());
                    System.out.println("Course updated successfully.");
                    return;
                }
            }
            System.out.println("Course not found.");
        } else {
            System.out.println("Access Denied: Only ADMIN can edit courses.");
        }
    }
    public void deleteCourse(String courseCode) {
        if (userRole.equals("ADMIN")) {
            courses.removeIf(course -> course.getCourseCode().equals(courseCode));
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Access Denied: Only ADMIN can delete courses.");
        }
    }
    public void viewCourses() {
        if (userRole.equals("ADMIN") || userRole.equals("USER")) {
            if (courses.isEmpty()) {
                System.out.println("No courses available.");
            } else {
                for (Course course : courses) {
                    System.out.println(course);
                }
            }
        } else {
            System.out.println("Access Denied: Invalid role.");
        }
    }


}
