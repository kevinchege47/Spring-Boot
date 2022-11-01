package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<Student>findStudentByEmail(String email);
    Optional<Student> findStudentByAge(Integer integer);
    @Query("select u from student u where u.name like lower(concat('%',:term,'%')) or " +
            "u.email like lower(concat('%',:term,'%'))")
    Optional<List<Student>> search(@Param("term")String term);

}
