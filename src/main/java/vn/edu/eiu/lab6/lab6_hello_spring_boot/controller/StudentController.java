//package vn.edu.eiu.lab6.lab6_hello_spring_boot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import vn.edu.eiu.lab6.lab6_hello_spring_boot.config.InitStudent;
//import vn.edu.eiu.lab6.lab6_hello_spring_boot.entity.Student;
//
//import java.util.List;
//
///**
// * Xử lý và trả về kết quả là một trang web html
// * Ứng với mỗi url sẽ có một hàm xử lý tương ứng
// */
//@Controller
//public class StudentController {
//    //Khởi tạo danh sách sinh viên
//    private final InitStudent initStudent;
//    @Autowired
//    public StudentController(InitStudent initStudent) {
//        this.initStudent = initStudent;
//    }
//    //Hiển thị trang index
//    @GetMapping("/")
//    public String index(){
//        return "index"; //index.html, không cần gõ html vì đã khai báo suffix
//    }
//
//    //Hiển thị danh sách sv cho url localhost:8080/students
//    @GetMapping("/students")
//    public String showStudents(Model model){
//        /**
//         * Hàm được gọi khi user gõ url localhost:8080/students
//         * sau khi xử lý sẽ trả về một trang html
//         * nếu kèm theo data thì bỏ trong obj Model (attributeName, attributeValue)
//         * Thymeleaf sẽ lấy data này thông qua attributeName
//         * attributeValue có thể là bất cứ object gì
//         */
//        List<Student> students = initStudent.getStudentList();
//        model.addAttribute("students", students);
//        return "student-list"; //Chính là file html: student-list.html
//    }
//
//    //Xử lý localhost:8080/student/edit/id
//    @GetMapping("/student/edit/{id}")
//    public String showEditForm(@PathVariable int id, Model model){
//        /*
//        Các công việc cần làm:
//        Gửi kèm thông tin của sv cần sửa
//        Có nút save để lưu thông tin mới
//        Trả về trang html có form edit student
//         */
//        for (Student foundStudent: initStudent.getStudentList()){
//            if (foundStudent.getId() == id){
//                model.addAttribute("foundStudent", foundStudent);
//                break;
//            }
//        }
//        return "student-form"; //student=form.html
//    }
//    //Phiên bản 1
////    @PostMapping("/student/edit/result")
////    public String saveStudent(@RequestParam("id") String id, @RequestParam("name") String name,
////                              @RequestParam("yob") String yob, @RequestParam("gpa") String gpa, Model model){
////        /*
////        Lấy thông tin từ form
////        Hiển thị thông tin đó lên trang result.html
////         */
////        model.addAttribute("pmsg","The students has been saved successfully");
////        model.addAttribute("pid",id);
////        model.addAttribute("pname",name);
////        model.addAttribute("pyob",yob);
////        model.addAttribute("pgpa",gpa);
////        return "result"; //result.html
////    }
//
//    /*
//    Khi xử lý form:
//    Sau khi xử lý và trả về trang html, nhưng url không thay đổi, vẫn là url của action
//    form => nếu bấm f4 (refresh) thì sẽ gọi lại hàm xử lý này => lỗi resubmission form
//    Trong trường hợp thêm mới data, với key tự tăng thì sẽ bị duplicate dữ liệu
//     */
//    //Phiên bản 2 sử dụng redirect để tránh lỗi
////    @PostMapping("/student/edit")
////    public String saveStudent(@RequestParam("id") String id, @RequestParam("name") String name,
////                              @RequestParam("yob") String yob, @RequestParam("gpa") String gpa, RedirectAttributes redirectAtt){
////        /*
////        Lấy thông tin từ form
////        Hiển thị thông tin đó lên trang result.html
////         */
////        redirectAtt.addFlashAttribute("pmsg","The students has been saved successfully");
////        redirectAtt.addFlashAttribute("pid",id);
////        redirectAtt.addFlashAttribute("pname",name);
////        redirectAtt.addFlashAttribute("pyob",yob);
////        redirectAtt.addFlashAttribute("pgpa",gpa);
////        return "redirect:/student/edit/result"; //chuyển hướng url thành localhost:8080/student/edit/result
////        //Tại sao chỗ này không cần Model? Model sẽ được gửi kèm theo trang html cho thymeleaf dùng để mix
////        //Mà ở đây không hề gửi trang html nào hết?
////    }
////
////    @GetMapping("/student/edit/result")
////    public String showResult(Model model){
////        return "result"; //đây mới là trang result.html
////        //Sẽ bị lỗi null vì không nhận dược data từ model của bên @PostMapping saveStudent
////        //Xử lý bằng cách khi redirect bên saveStudent, gửi kèm thêm gói hàng RedirectAttribute
////        //Nghĩa là trong hàm này có 2 loại dữ liệu:
////        //1. Model chính của nó
////        //2. RedirectAttribute được gửi kèm theo từ bên saveStudent
////    }
//
//    //Phiên bản 3: lấy thông tin đã sửa redirect sang trang student-list
//    /*
//    Thực tế sau khi edit xong thì lưu db -> cập nhập lên students ->quay lại trang students
//    Hiện tại chỉ làm: lấy thông tin cp nhật hiển thị lên trang students
//     */
//    @PostMapping("/student/edit")
//    public String saveStudent(@RequestParam("id") String id, @RequestParam("name") String name,
//                              @RequestParam("yob") String yob, @RequestParam("gpa") String gpa, RedirectAttributes redirectAtt){
//        /*
//        Lấy thông tin từ form
//        Hiển thị thông tin đó lên trang result.html
//         */
//        redirectAtt.addFlashAttribute("pmsg","The students has been saved successfully");
//        redirectAtt.addFlashAttribute("pid",id);
//        redirectAtt.addFlashAttribute("pname",name);
//        redirectAtt.addFlashAttribute("pyob",yob);
//        redirectAtt.addFlashAttribute("pgpa",gpa);
//        return "redirect:/students";
//    }
//}

package vn.edu.eiu.lab6.lab6_hello_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.lab6.lab6_hello_spring_boot.config.InitStudent;
import vn.edu.eiu.lab6.lab6_hello_spring_boot.entity.Student;

import java.util.Iterator;
import java.util.List;

@Controller
public class StudentController {
    private final InitStudent initStudent;

    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/students";
    }

    // ========== LIST ==========
    @GetMapping("/students")
    public String showStudents(Model model,
                               @ModelAttribute("pmsg") String pmsg,
                               @ModelAttribute("pid") String pid,
                               @ModelAttribute("pname") String pname,
                               @ModelAttribute("pyob") String pyob,
                               @ModelAttribute("pgpa") String pgpa){
        List<Student> students = initStudent.getStudentList();
        model.addAttribute("students", students);
        model.addAttribute("pmsg", pmsg);
        model.addAttribute("pid", pid);
        model.addAttribute("pname", pname);
        model.addAttribute("pyob", pyob);
        model.addAttribute("pgpa", pgpa);
        return "student-list";
    }

    // ========== CREATE FORM ==========
    @GetMapping("/student/new")
    public String showCreateForm(Model model){
        model.addAttribute("foundStudent", new Student());
        return "student-form";
    }

    // ========== CREATE SUBMIT ==========
    @PostMapping("/student/new")
    public String createStudent(@RequestParam("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("yob") String yob,
                                @RequestParam("gpa") String gpa,
                                RedirectAttributes redirectAtt){
        try {
            int pid = Integer.parseInt(id.trim());
            int pyob = Integer.parseInt(yob.trim());
            double pgpa = Double.parseDouble(gpa.trim());

            if (findById(pid) != null) {
                redirectAtt.addFlashAttribute("pmsg","Student ID already exists!");
                return "redirect:/students";
            }

            initStudent.getStudentList().add(new Student(pid, name, pyob, pgpa));

            redirectAtt.addFlashAttribute("pmsg","The student has been created successfully");
            redirectAtt.addFlashAttribute("pid", id);
            redirectAtt.addFlashAttribute("pname", name);
            redirectAtt.addFlashAttribute("pyob", yob);
            redirectAtt.addFlashAttribute("pgpa", gpa);
        } catch (NumberFormatException e){
            redirectAtt.addFlashAttribute("pmsg","Invalid number format (ID/YOB/GPA)");
        }
        return "redirect:/students";
    }

    // ========== EDIT FORM ==========
    @GetMapping("/student/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model, RedirectAttributes redirectAtt){
        Student found = findById(id);
        if (found == null){
            redirectAtt.addFlashAttribute("pmsg","Student not found");
            return "redirect:/students";
        }
        model.addAttribute("foundStudent", found);
        return "student-form";
    }

    // ========== EDIT SUBMIT ==========
    @PostMapping("/student/edit")
    public String saveStudent(@RequestParam("id") String id,
                              @RequestParam("name") String name,
                              @RequestParam("yob") String yob,
                              @RequestParam("gpa") String gpa,
                              RedirectAttributes redirectAtt){
        try {
            int pid = Integer.parseInt(id.trim());
            int pyob = Integer.parseInt(yob.trim());
            double pgpa = Double.parseDouble(gpa.trim());

            Student found = findById(pid);
            if (found == null){
                redirectAtt.addFlashAttribute("pmsg","Student not found");
                return "redirect:/students";
            }

            found.setName(name);
            found.setYob(pyob);
            found.setGpa(pgpa);

            redirectAtt.addFlashAttribute("pmsg","The student has been saved successfully");
            redirectAtt.addFlashAttribute("pid", id);
            redirectAtt.addFlashAttribute("pname", name);
            redirectAtt.addFlashAttribute("pyob", yob);
            redirectAtt.addFlashAttribute("pgpa", gpa);
        } catch (NumberFormatException e){
            redirectAtt.addFlashAttribute("pmsg","Invalid number format (ID/YOB/GPA)");
        }
        return "redirect:/students";
    }

    // ========== DELETE ==========
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id, RedirectAttributes redirectAtt){
        List<Student> list = initStudent.getStudentList();
        boolean removed = false;
        for (Iterator<Student> it = list.iterator(); it.hasNext();){
            if (it.next().getId() == id){
                it.remove();
                removed = true;
                break;
            }
        }
        redirectAtt.addFlashAttribute("pmsg", removed ? "Deleted" : "Student not found");
        return "redirect:/students";
    }

    private Student findById(int id){
        for (Student s : initStudent.getStudentList()){
            if (s.getId() == id) return s;
        }
        return null;
    }
}
