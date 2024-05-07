import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SignupComponent } from './pages/signup/signup.component';

import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule} from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {FormsModule} from '@angular/forms';
import {MatToolbarModule} from '@angular/material/toolbar';

import {MatIconModule} from '@angular/material/icon';
import { HomeComponent } from './pages/home/home.component';

import { SigninComponent } from './pages/signin/signin.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { authInterceptorProviders } from './services/auth.interceptor';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import {MatListModule} from '@angular/material/list';
import { ProfileComponent } from './pages/admin/profile/profile.component';
import { UpdateprofileComponent } from './pages/admin/updateprofile/updateprofile.component';
import { AddcategoriesComponent } from './pages/admin/addcategories/addcategories.component';
import { UpdatecategoriesComponent } from './pages/admin/updatecategories/updatecategories.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';

import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';


import {MatSelectModule} from '@angular/material/select';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import { ViewQuestionOfQuizComponent } from './pages/admin/view-question-of-quiz/view-question-of-quiz.component';
import { UpdateQuestionOfQuizComponent } from './pages/admin/update-question-of-quiz/update-question-of-quiz.component';

import { LoadQuizComponent } from './pages/user/load-quiz/load-quiz.component';
import { UsersidebarComponent } from './pages/user/usersidebar/usersidebar.component';
import { InstructionComponent } from './pages/user/instruction/instruction.component';
import { StartQuizComponent } from './pages/user/start-quiz/start-quiz.component';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { UserProfileComponent } from './pages/user/user-profile/user-profile.component';
import { UserProfileUpdateComponent } from './pages/user/user-profile-update/user-profile-update.component';
import { UserGivenQuizzesComponent } from './pages/user/user-given-quizzes/user-given-quizzes.component';
import { UserWelcomeComponent } from './pages/user/user-welcome/user-welcome.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SignupComponent,
    HomeComponent,
    SigninComponent,
    DashboardComponent,
    WelcomeComponent,
    UserdashboardComponent,
    SidebarComponent,
    ProfileComponent,
    UpdateprofileComponent,
    AddcategoriesComponent,
    UpdatecategoriesComponent,
    AddQuizComponent,
    UpdateQuizComponent,
   
    AddQuestionComponent,
    ViewCategoriesComponent,
    ViewQuizzesComponent,
    ViewQuestionOfQuizComponent,
    UpdateQuestionOfQuizComponent,
   
    LoadQuizComponent,
    UsersidebarComponent,
    InstructionComponent,
    StartQuizComponent,
    UserProfileComponent,
    UserProfileUpdateComponent,
    UserGivenQuizzesComponent,
    UserWelcomeComponent,
  
    
    
    
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatInputModule,
    MatCardModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatProgressSpinnerModule

  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
