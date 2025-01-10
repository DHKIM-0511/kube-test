package basic.service;

import basic.entity.Student;
import basic.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> searchAll(){
        return studentRepository.findAll();
    }

    public Student searchStudent(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다."));
    }

    @Transactional
    public Long registerStudent(String name){
        Student student = studentRepository.save(new Student(name));
        return student.getId();
    }

    @Transactional
    public Student modifyStudent(Long id, String name){
        Student student = searchStudent(id);
        student.setName(name);
        return student;
    }

    @Transactional
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
