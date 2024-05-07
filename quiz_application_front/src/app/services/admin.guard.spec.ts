import { TestBed } from '@angular/core/testing';
import { CanActivate, CanActivateFn } from '@angular/router';


import { RouterTestingModule } from '@angular/router/testing';
import { AdminGuardGuard } from './admin.guard';

describe('AdminGuardGuard', () => {
  let guard: CanActivate;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      providers: [AdminGuardGuard], // Add the guard to providers
    });

    guard = TestBed.inject(AdminGuardGuard); // Get an instance of the guard
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
