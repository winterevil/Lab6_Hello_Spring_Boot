package vn.edu.eiu.lab6.lab6_hello_spring_boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.eiu.lab6.lab6_hello_spring_boot.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
