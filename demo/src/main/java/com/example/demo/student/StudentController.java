package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void  registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @GetMapping(value = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@Param(value = "term")String term){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.search(term));
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }


}
