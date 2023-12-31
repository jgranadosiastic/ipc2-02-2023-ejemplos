import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentFormComponent } from './student-form/student-form.component';
import { StudentListComponent } from './student-list/student-list.component';
import { AppComponent } from './app.component';
import { StudentViewComponent } from './student-view/student-view.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: "/students/create",
    pathMatch: "full"
  },
  {
    path: "students/create",
    title: "Crear",
    component: StudentFormComponent
  },
  {
    path: "students/list",
    title: "Listado",
    component: StudentListComponent
  },
  {
    path: "students/:carnet",
    title: "View",
    component: StudentViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
