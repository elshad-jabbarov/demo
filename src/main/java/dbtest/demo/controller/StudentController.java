package dbtest.demo.controller;


import dbtest.demo.entity.Student;
import dbtest.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }
    @GetMapping("/list")
public String getStudentList(Model model){
    Iterable<Student> students = studentRepo.findAll();
    model.addAttribute("students",students);
    return "list";
}
}
