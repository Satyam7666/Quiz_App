import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatecategoriesComponent } from './updatecategories.component';

describe('UpdatecategoriesComponent', () => {
  let component: UpdatecategoriesComponent;
  let fixture: ComponentFixture<UpdatecategoriesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdatecategoriesComponent]
    });
    fixture = TestBed.createComponent(UpdatecategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
