package com.quiz.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.quiz.dto.StudentQuizRecordDto;
import com.quiz.entity.StudentQuizRecord;

@Component
public class StudentQuizRecordConverter {
	
	//convert User to USerDto
		public StudentQuizRecordDto  convertTostStudentQuizRecordDto(StudentQuizRecord studentQuizRecord) {
			StudentQuizRecordDto studentQuizRecordDto=new StudentQuizRecordDto();
			
			if(studentQuizRecord!=null) {
				BeanUtils.copyProperties(studentQuizRecord, studentQuizRecordDto);
			}
			return studentQuizRecordDto;
		}
		
		//convert UserDto to USer
			public StudentQuizRecord convertToQuestions(StudentQuizRecordDto studentQuizRecordDto) {
				StudentQuizRecord studentQuizRecord=new StudentQuizRecord();
				
				if(studentQuizRecordDto!=null) {
					BeanUtils.copyProperties(studentQuizRecordDto, studentQuizRecord);
					
				}
				return studentQuizRecord;
			}

}
