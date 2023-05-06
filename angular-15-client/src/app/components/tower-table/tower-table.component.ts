import { Component, OnInit } from '@angular/core';
import { TowerService } from '../../services/tower.service';
import { Tower } from '../../models/tower.model';
import {PaginationInstance, PaginationService,  NgxPaginationModule } from 'ngx-pagination';
@Component({
  selector: 'app-tower-table',
  templateUrl: './tower-table.component.html',
  styleUrls: ['./tower-table.component.css']
})


export class TowerTableComponent implements OnInit {


  towers: Tower[] = [];
  totalTowers: number = 100;
  towersPerPage: number = 10;
  page: number = 1;
  networkOperator: string = "";
  technology: string = "";
  towerType: string = "";
  constructor(private towerService: TowerService, private paginationService: PaginationService) {
   }

  ngOnInit() {
    console.log("Calling getTowers method...");

    this.getPaginatedTowers();
  }
  handlePageChange(event: any) {
    this.page = event;
    // this.towersPerPage = event.pageSize;
    this.getPaginatedTowers();
  }
  
  getPaginatedTowers() {
    this.towerService.getPaginatedTowers(this.page, this.towersPerPage).subscribe((response: any) => {
      this.towers = response.content;
      this.totalTowers = response.totalElements;
    });
  }

}

