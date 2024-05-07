import { TestBed } from '@angular/core/testing';
import { CanActivate, CanActivateFn } from '@angular/router';

import { NormalGuard } from './normal.guard';
import { RouterTestingModule } from '@angular/router/testing';

describe('NormalGuard', () => {
  let guard: CanActivate;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      providers: [NormalGuard], // Add the guard to providers
    });

    guard = TestBed.inject(NormalGuard); // Get an instance of the guard
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
