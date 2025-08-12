package vn.edu.eiu.lab6.lab6_hello_spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
/**
 * Nếu table có key tự tăng thì phải thêm một constructor đầy đủ tham số, nhưng bỏ tham số
 * key đi
 */
public class Student {
    //Nếu id là key tự tăng thì không có trong constructor full tham số. Và nên dùng kiểu
    //wrapper class long.
    @Id
    private Integer id;
    private String name;
    private int yob;
    private double gpa;
}
