package com.example.online.lecture.Repository;

import org.springframework.stereotype.Repository;
import com.example.online.lecture.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

}
