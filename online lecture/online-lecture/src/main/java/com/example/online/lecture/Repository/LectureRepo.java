package com.example.online.lecture.Repository;

import org.springframework.stereotype.Repository;
import com.example.online.lecture.Entity.Lecture;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, Long> {

    List<Lecture> findByDateAndInstructor_Id(String date, Long id);

}
