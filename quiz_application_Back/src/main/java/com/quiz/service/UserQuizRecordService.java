package com.quiz.service;

import java.util.List;

import com.quiz.dto.StudentQuizRecordDto;
import com.quiz.entity.StudentQuizRecord;
import com.quiz.entity.User;

public interface UserQuizRecordService {
	public StudentQuizRecord addStudentRecord(StudentQuizRecord studentQuizRecord);
    
    List<StudentQuizRecord> getRecordByUserId(long id);
    public List<StudentQuizRecord> getAllRecords();
    
}
