import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserGivenQuizzesComponent } from './user-given-quizzes.component';

describe('UserGivenQuizzesComponent', () => {
  let component: UserGivenQuizzesComponent;
  let fixture: ComponentFixture<UserGivenQuizzesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserGivenQuizzesComponent]
    });
    fixture = TestBed.createComponent(UserGivenQuizzesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
