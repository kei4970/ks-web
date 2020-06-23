package kr.ac.ks.app.controller;

import kr.ac.ks.app.domain.Lesson;
import kr.ac.ks.app.domain.Student;
import kr.ac.ks.app.repository.LessonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LessonController {

    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @GetMapping(value = "/lessons/new")
    public String createForm(Model model) {
        model.addAttribute("lessonForm", new LessonForm());
        return "lessons/lessonForm";
    }

    @PostMapping(value = "/lessons/new")
    public String create(LessonForm form) {
        Lesson lesson = new Lesson();
        lesson.setName(form.getName());
        lesson.setQuota(form.getQuota());
        lessonRepository.save(lesson);
        return "redirect:/lessons";
    }

    @GetMapping(value = "/lessons")
    public String list(Model model) {
        List<Lesson> lessons = lessonRepository.findAll();
        model.addAttribute("lessons", lessons);
        return "lessons/lessonList";
    }

    @GetMapping("/lessons/delete")
    public String deleteLesson(@RequestParam Long id, Model model) {
        lessonRepository.deleteById(id);
        List<Lesson> lessons = lessonRepository.findAll();
        model.addAttribute("lessons", lessons);
        return "redirect:/lessons";
    }

    @PostMapping("/lessons/update")
    public String updateLesson(@Valid Lesson lesson, BindingResult result) {
        if (result.hasErrors()) {
            return "lessons/lessonUpdateForm";
        }
        lessonRepository.save(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/lessons/updateForm")
    public String showUpdateLessonForm(@RequestParam Long id,Model model) {
        Lesson lesson = lessonRepository.getOne(id);
        LessonForm lessonForm = new LessonForm();
        lessonForm.setQuota(lesson.getQuota());
        lessonForm.setName(lesson.getName());
        model.addAttribute("lessonForm", lessonForm);
        model.addAttribute("lesson", lesson);
        return "lessons/lessonUpdateForm";
    }
}
