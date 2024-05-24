package com.example.online.lecture.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online.lecture.Entity.Instructor;
import com.example.online.lecture.Entity.Lecture;
import com.example.online.lecture.Service.ScheduleService;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{instructorId}/lectures")
    public List<Lecture> getLecturesByInstructor(@PathVariable Long instructorId) {
        Instructor instructor = scheduleService.getInstructorById(instructorId);
        return instructor != null ? instructor.getLectures() : null;
    }
}