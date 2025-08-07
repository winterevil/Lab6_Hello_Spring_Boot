package vn.edu.eiu.lab6.lab6_hello_spring_boot.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vn.edu.eiu.lab6.lab6_hello_spring_boot.entity.Student;

import java.util.ArrayList;
import java.util.List;
@Component //Giao cho spring quản lý ==> bean
public class InitStudent {
    private List<Student> studentList;

    //Hàm khởi tạo danh sách: hard-code
    @PostConstruct //Tự chạy khi hàm khởi tạo obj InitStudent
    public void initStudent(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Lady Hương",2000,90));
        studentList.add(new Student(2,"Célien",2001,80));
        studentList.add(new Student(3,"Violet Vũ",2000,80));
        studentList.add(new Student(4,"Vicky Lệ",2001,90));
        studentList.add(new Student(5,"Vy Tây",2000,95));
        System.out.println("The list of students is initialized successfully");
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
