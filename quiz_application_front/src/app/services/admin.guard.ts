import { CanActivate, CanActivateFn, Router } from '@angular/router';


import { Injectable } from '@angular/core';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root',
})
export class AdminGuardGuard implements CanActivate {
  constructor(private login: LoginService, private router: Router) {}

  canActivate(): boolean {
    if (this.login.isLoggedIn() && this.login.getUserRole() === 'ADMIN') {
      return true;
    } else {
      this.router.navigate(['login']); // Redirect to access-denied if not admin
      return false;
    }
  }
}