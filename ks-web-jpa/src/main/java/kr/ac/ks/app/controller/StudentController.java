package kr.ac.ks.app.controller;

import kr.ac.ks.app.domain.Student;
import kr.ac.ks.app.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students/new")
    public String showStudentForm(Model model) {
        model.addAttribute("studentForm", new StudentForm());
        return "students/studentForm";
    }

    @GetMapping("/students/updateForm")
    public String showUpdateStudentForm(@RequestParam Long id,Model model) {
        Student student = studentRepository.getOne(id);
        StudentForm studentForm = new StudentForm();
        studentForm.setEmail(student.getEmail());
        studentForm.setName(student.getName());
        model.addAttribute("studentForm", studentForm);
        model.addAttribute("student", student);
        return "students/studentUpdateForm";
    }

    @PostMapping("/students/new")
    public String createStudent(@Valid StudentForm studentForm, BindingResult result) {
        if (result.hasErrors()) {
            return "students/studentForm";
        }

        Student student = new Student();
        student.setName(studentForm.getName());
        student.setEmail(studentForm.getEmail());
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String list(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students/studentList";
    }

    @GetMapping("/students/delete")
    public String deleteStudent(@RequestParam Long id, Model model) {
        studentRepository.deleteById(id);
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "redirect:/students";
    }

    @PostMapping("/students/update")
    public String updateStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return "students/studentUpdateForm";
        }
        studentRepository.save(student);
        return "redirect:/students";
    }



}
