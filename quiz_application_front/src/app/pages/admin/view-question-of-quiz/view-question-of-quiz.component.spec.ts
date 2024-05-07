import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewQuestionOfQuizComponent } from './view-question-of-quiz.component';

describe('ViewQuestionOfQuizComponent', () => {
  let component: ViewQuestionOfQuizComponent;
  let fixture: ComponentFixture<ViewQuestionOfQuizComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewQuestionOfQuizComponent]
    });
    fixture = TestBed.createComponent(ViewQuestionOfQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
