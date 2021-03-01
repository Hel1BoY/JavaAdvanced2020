package com.example.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {

    public List<String> students = new ArrayList<>();

    @GetMapping("/student")
    public String studentform(Model model){
        model.addAttribute("student",new Student());

        return "student";
    }

    @PostMapping("/student")
    public String postStudent(@ModelAttribute Student student, Model model){
        students.add(student.getName());
        model.addAttribute("student",student);

        return "result";
    }



}
