import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateQuestionOfQuizComponent } from './update-question-of-quiz.component';

describe('UpdateQuestionOfQuizComponent', () => {
  let component: UpdateQuestionOfQuizComponent;
  let fixture: ComponentFixture<UpdateQuestionOfQuizComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateQuestionOfQuizComponent]
    });
    fixture = TestBed.createComponent(UpdateQuestionOfQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
