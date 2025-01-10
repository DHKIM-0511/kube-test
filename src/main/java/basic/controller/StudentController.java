package basic.controller;

import basic.entity.Student;
import basic.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/api/students")
    ResponseEntity<List<Student>> searchAll(){
        return new ResponseEntity<>(studentService.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/api/students/{id}")
    ResponseEntity<Student> searchStudent(@PathVariable("id") Long id){
        return new ResponseEntity<>(studentService.searchStudent(id), HttpStatus.OK);
    }

    @PostMapping("/api/students")
    ResponseEntity<Long> registerStudent(String name){
        return new ResponseEntity<>(studentService.registerStudent(name), HttpStatus.OK);
    }

    @PutMapping("/api/students/{id}")
    ResponseEntity<Student> modifyStudent(@PathVariable("id") Long id, String name){
        return new ResponseEntity<>(studentService.modifyStudent(id, name), HttpStatus.OK);
    }

    @DeleteMapping("/api/students/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
