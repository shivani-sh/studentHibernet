package com.dz.controller;

import com.dz.model.Student;
import com.dz.service.StudentService;
import com.dz.service.StudentServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableTransactionManagement(proxyTargetClass = true)
public class StudentController {
    private StudentService studentService;
    private final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/")
    public ModelAndView student() {

        return new ModelAndView("display");
    }

    /**
     * to set the model
     *
     * @param model
     * @return add
     */
    @RequestMapping("/add")
    public String add(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("message", "data saved");
        return "add";
    }

    /**
     * here we add data
     *
     * @param student
     */
    @RequestMapping(value = "addsave", method = RequestMethod.POST)
    public ModelAndView addsave(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return new ModelAndView("display");
    }


    /**
     * display
     *
     * @return
     */

    @RequestMapping(value = "/display")
    public ModelAndView display() {
        logger.info("in the display controller");
        List<Student> studentList = studentService.display();
        if (!studentList.isEmpty()) {
            return new ModelAndView("display", "studentList", studentList);

        } else {

            return new ModelAndView("display", "msg", "no data");
        }

    }


    /**
     * Here we delete
     */

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        logger.info(student.getId() + "  " + student.getName() + " " + student.getAge());
        studentService.deletedata(student);
        return new ModelAndView("redirect:/display");
    }


    /**
     * update model
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {

        Student student = studentService.getStudentById(id);
        student.setId(id);
        student.setName(student.getName());
        student.setAge(student.getAge());
        model.addAttribute("student", student);
        model.addAttribute("message", "data saved");
        return "update";
    }


    /**
     * here we update
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateSave(@ModelAttribute("student") Student student) {

        studentService.updatedata(student);
        return new ModelAndView("redirect:/display");
    }


}
