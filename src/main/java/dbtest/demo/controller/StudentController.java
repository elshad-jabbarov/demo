package dbtest.demo.controller;


import dbtest.demo.entity.Student;
import dbtest.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;



    @GetMapping("/new")
    public String newStudent( Model model) {
        model.addAttribute("student",new Student());
        return "list";
    }

    @GetMapping("/list")
    public String getStudentList(Model model) {
        Iterable<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/id")
    public String getStudent(Model model,Student student ) {

        Optional<Student> st = studentRepo.findByStudentIdOrFirstNameOrLastName(student.getStudentId(),student.getFirstName(),student.getLastName());

        st.ifPresent(value -> model.addAttribute("students", value));

        return "list";
    }
    @GetMapping("/update")
    public String updateStudentById(Model model, @RequestParam Integer id) {

        Optional<Student> student = studentRepo.findById(id);

 if (student.isPresent()){
     Student st= student.get();
     model.addAttribute("student",st);
 }
        return "add";
    }
    @PostMapping("/save")
    public  String saveStudent(Model model,Student student) {

        studentRepo.save(student);

        return "index";
    }


}
