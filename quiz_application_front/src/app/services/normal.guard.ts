import { Injectable } from '@angular/core';
import { CanActivate, CanActivateFn, Router } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root',
})
export class NormalGuard implements CanActivate {
  constructor(private login: LoginService, private router: Router) {}

  canActivate(): boolean {
    if (this.login.isLoggedIn() && this.login.getUserRole() === 'NORMAL') {
      return true;
    } else {
      this.router.navigate(['login']); // Redirect to access-denied if not admin
      return false;
    }
  }
}

