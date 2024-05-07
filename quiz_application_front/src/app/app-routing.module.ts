import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './pages/signup/signup.component';

import { HomeComponent } from './pages/home/home.component';

import { SigninComponent } from './pages/signin/signin.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { AdminGuardGuard } from './services/admin.guard';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';
import { NormalGuard } from './services/normal.guard';
import { ProfileComponent } from './pages/admin/profile/profile.component';
import { UpdateprofileComponent } from './pages/admin/updateprofile/updateprofile.component';
import { AddcategoriesComponent } from './pages/admin/addcategories/addcategories.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { AddQuizComponent } from './pages/admin/add-quiz/add-quiz.component';
import { ViewQuizzesComponent } from './pages/admin/view-quizzes/view-quizzes.component';
import { UpdateQuizComponent } from './pages/admin/update-quiz/update-quiz.component';
import { ViewQuestionOfQuizComponent } from './pages/admin/view-question-of-quiz/view-question-of-quiz.component';
import { AddQuestionComponent } from './pages/admin/add-question/add-question.component';
import { UpdateQuestionOfQuizComponent } from './pages/admin/update-question-of-quiz/update-question-of-quiz.component';
import { LoadQuizComponent } from './pages/user/load-quiz/load-quiz.component';
import { InstructionComponent } from './pages/user/instruction/instruction.component';
import { StartQuizComponent } from './pages/user/start-quiz/start-quiz.component';
import { UserProfileComponent } from './pages/user/user-profile/user-profile.component';
import { UserProfileUpdateComponent } from './pages/user/user-profile-update/user-profile-update.component';
import { UserGivenQuizzesComponent } from './pages/user/user-given-quizzes/user-given-quizzes.component';
import { UserWelcomeComponent } from './pages/user/user-welcome/user-welcome.component';



const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full',
  },
  {
    path:'signup',
    component:SignupComponent,
    pathMatch:'full',
  },
  {
    path:'login',
    component:SigninComponent,
    pathMatch:'full'
  },
  {
    path : 'admin',
    component: DashboardComponent,
   canActivate:[AdminGuardGuard],
   children :[
    {
      path:'',
      component:WelcomeComponent
    },
    {
      path:'profile/:username',
      component:ProfileComponent
    },
    {
      path:'updateprofile',
      component:UpdateprofileComponent
    },
    {
      path:'add-category',
      component:AddcategoriesComponent
    },
    {
      path:'view-category',
      component:ViewCategoriesComponent
    },
    {
      path:'add-quiz',
      component:AddQuizComponent
    },
    {
      path:'view-quizes',
      component:ViewQuizzesComponent
    },
    {
      path:'update-quizes/:quizId',
      component:UpdateQuizComponent
    },
    {
      path:'add-question/:qId/:title',
      component:AddQuestionComponent
    },
    {
      path:'view-questions/:qId/:title',
      component:ViewQuestionOfQuizComponent
    },
    {
      path:'update-questions/:qId/:quesId/:title',
      component:UpdateQuestionOfQuizComponent
    },
    
    
  ],
  },
  {
    path: 'user-dashboard',
    component: UserdashboardComponent,
    canActivate:[NormalGuard],
    children:[
      {
        path:'',
        component:UserWelcomeComponent
      },
      {
        path:':catId',
        component:LoadQuizComponent
      },
      {
        path:'profile/:username',
        component:UserProfileComponent
      },
      {
        path:'update-profile/:username',
        component: UserProfileUpdateComponent
      },
      {
        path:'update-profile/:username',
        component: UserProfileUpdateComponent
      },
      {
        path:'instructions/:quizId',
        component:InstructionComponent
      },
      {
        path:'user-record/:username',
        component:UserGivenQuizzesComponent
      },
      
    ]
  },
  {
    path:'start/:qid',
    component:StartQuizComponent,
    canActivate:[NormalGuard]
  }
  
];
  
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
