package com.example.online.lecture.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online.lecture.Entity.Course;
import com.example.online.lecture.Entity.Instructor;
import com.example.online.lecture.Entity.Lecture;
import com.example.online.lecture.Repository.CourseRepo;
import com.example.online.lecture.Repository.InstructorRepo;
import com.example.online.lecture.Repository.LectureRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    @Autowired
    private InstructorRepo instructorRepository;
    @Autowired
    private CourseRepo courseRepository;
    @Autowired
    private LectureRepo lectureRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Lecture addLectureToCourse(Long courseId, Lecture lecture) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent() && !isScheduleConflict(lecture)) {
            Course course = optionalCourse.get();
            lecture.setCourse(course);
            return lectureRepository.save(lecture);
        }
        return null;
    }

    private boolean isScheduleConflict(Lecture lecture) {
        List<Lecture> lectures = lectureRepository.findByDateAndInstructor_Id(lecture.getDate(), lecture.getInstructor().getId());
        return !lectures.isEmpty();
    }
}
