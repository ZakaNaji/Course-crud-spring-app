package com.znaji.springtransactions.controller;

import com.znaji.springtransactions.model.Course;
import com.znaji.springtransactions.repository.CourseRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
@SessionAttributes("username")
@RequiredArgsConstructor
public class CourseController {

    final private CourseRepo courseRepo;
    @GetMapping("")
    public String coursePage(Model model) {
        model.addAttribute("courses", courseRepo.findAllCoursesUsingJpa());
        return "course";
    }

    @GetMapping("/add")
    public String addCourse(Model model) {
        model.addAttribute("course", new Course());
        return "addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute @Valid Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCourse";
        }
        courseRepo.addCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseRepo.findCourseByIdUsingJpa(id));
        return "updateCourse";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@ModelAttribute @Valid Course course, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            return "updateCourse";
        }
        course.setId(id);
        courseRepo.addCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseRepo.deleteCourseById(id);
        return "redirect:/course";
    }

}
