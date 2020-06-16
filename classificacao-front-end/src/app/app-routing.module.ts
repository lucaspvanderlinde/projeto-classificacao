import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarComponent } from './paginas/listar/listar.component';
import { ImportarComponent } from './paginas/importar/importar.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'listar' },
  { path: 'listar', component: ListarComponent },
  { path: 'importar', component: ImportarComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
