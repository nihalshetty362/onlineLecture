package com.example.online.lecture.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.online.lecture.Entity.Course;
import com.example.online.lecture.Entity.Instructor;
import com.example.online.lecture.Entity.Lecture;
import com.example.online.lecture.Service.ScheduleService;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {
        return scheduleService.getAllInstructors();
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return scheduleService.addCourse(course);
    }

    @PostMapping("/courses/{courseId}/lectures")
    public ResponseEntity<Lecture> addLectureToCourse(@PathVariable Long courseId, @RequestBody Lecture lecture) {
        Lecture savedLecture = scheduleService.addLectureToCourse(courseId, lecture);
        if (savedLecture != null) {
            return ResponseEntity.ok(savedLecture);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}