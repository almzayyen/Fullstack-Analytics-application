import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TowerTableComponent } from './components/tower-table/tower-table.component';
import { TowersChartComponent } from './components/tower-chart/towers-chart.component';
import { TowersParentComponent } from './components/towers-parent/towers-parent.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'towers', component: TowerTableComponent },
  { path: 'chart', component: TowersChartComponent },
  { path: 'home', component: TowersParentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }