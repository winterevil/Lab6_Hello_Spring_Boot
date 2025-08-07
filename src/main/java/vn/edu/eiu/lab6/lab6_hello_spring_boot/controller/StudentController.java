package vn.edu.eiu.lab6.lab6_hello_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.eiu.lab6.lab6_hello_spring_boot.config.InitStudent;
import vn.edu.eiu.lab6.lab6_hello_spring_boot.entity.Student;

import java.util.List;

/**
 * Xử lý và trả về kết quả là một trang web html
 * Ứng với mỗi url sẽ có một hàm xử lý tương ứng
 */
@Controller
public class StudentController {
    //Khởi tạo danh sách sinh viên
    private final InitStudent initStudent;
    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }
    //Hiển thị trang index
    @GetMapping("/")
    public String index(){
        return "index"; //index.html, không cần gõ html vì đã khai báo suffix
    }

    //Hiển thị danh sách sv cho url localhost:8080/students
    @GetMapping("/students")
    public String showStudents(Model model){
        /**
         * Hàm được gọi khi user gõ url localhost:8080/students
         * sau khi xử lý sẽ trả về một trang html
         * nếu kèm theo data thì bỏ trong obj Model (attributeName, attributeValue)
         * Thymeleaf sẽ lấy data này thông qua attributeName
         * attributeValue có thể là bất cứ object gì
         */
        List<Student> students = initStudent.getStudentList();
        model.addAttribute("students", students);
        return "student-list"; //Chính là file html: student-list.html
    }
}
