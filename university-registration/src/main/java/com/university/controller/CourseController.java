package com.university.controller;

import com.university.dao.CourseDAO;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showCourses(HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedStudent");
        if (student == null) {
            return "redirect:/login";
        }
        model.addAttribute("courses", courseDAO.getAllCourses());
        model.addAttribute("student", student);
        return "courses";
    }

    @RequestMapping(value = "/register/{courseId}", method = RequestMethod.POST)
    public String registerCourse(@PathVariable("courseId") int courseId,
                                  HttpSession session, Model model) {
        Student student = (Student) session.getAttribute("loggedStudent");
        if (student == null) {
            return "redirect:/login";
        }

        if (courseDAO.isAlreadyRegistered(student.getStudentId(), courseId)) {
            model.addAttribute("message", "You are already registered for this course!");
            model.addAttribute("success", false);
        } else {
            courseDAO.registerCourse(student.getStudentId(), courseId);
            model.addAttribute("message", "Successfully registered for the course!");
            model.addAttribute("success", true);
        }
        return "success";
    }
}