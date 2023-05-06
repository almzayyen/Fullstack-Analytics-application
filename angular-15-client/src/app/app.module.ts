import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TowerTableComponent } from './components/tower-table/tower-table.component';
import {  NgxPaginationModule, PaginationService } from 'ngx-pagination';
import { TowersChartComponent } from './components/tower-chart/towers-chart.component';
import { TowersParentComponent } from './components/towers-parent/towers-parent.component';
@NgModule({
  schemas: [CUSTOM_ELEMENTS_SCHEMA] ,
  declarations: [
    AppComponent,
    TowersParentComponent,
    TowerTableComponent,
    TowersChartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  exports: [TowerTableComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
