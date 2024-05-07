package com.quiz.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.dto.StudentQuizRecordDto;
import com.quiz.entity.StudentQuizRecord;
import com.quiz.entity.User;
import com.quiz.repo.UserQuizRecordRepo;
import com.quiz.repo.UserRepository;
import com.quiz.service.UserQuizRecordService;
import com.quiz.util.StudentQuizRecordConverter;

@Service
public class UserQuizRecordServiceImpl implements UserQuizRecordService {
  @Autowired
  private UserQuizRecordRepo uQuizRecordRepo;
  
  @Autowired
  private StudentQuizRecordConverter quizRecordConverter;
  
  @Autowired
  private UserRepository userRepository;
	@Override
	public StudentQuizRecord addStudentRecord(StudentQuizRecord studentQuizRecord) {
		// TODO Auto-generated method stub
		studentQuizRecord.setDate(LocalDate.now());
		return this.uQuizRecordRepo.save(studentQuizRecord);
	}
	
	@Override
	public List<StudentQuizRecord> getAllRecords() {
		// TODO Auto-generated method stub
		List<StudentQuizRecord> records = this.uQuizRecordRepo.findAll();
		return records;
	}

	
	
	 @Override
	    public List<StudentQuizRecord> getRecordByUserId(long id) {
	        return uQuizRecordRepo.findByUserId(id);
	    }
	
	


}
