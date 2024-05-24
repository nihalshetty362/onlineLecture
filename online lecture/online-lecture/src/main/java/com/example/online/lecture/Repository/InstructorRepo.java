package com.example.online.lecture.Repository;

import org.springframework.stereotype.Repository;
import com.example.online.lecture.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {

}
