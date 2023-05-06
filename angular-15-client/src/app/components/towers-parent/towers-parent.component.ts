import { Component } from '@angular/core';

@Component({
  selector: 'app-towers-parent',
  templateUrl: './towers-parent.component.html',
  styleUrls: ['./towers-parent.component.css']
})
export class TowersParentComponent {
  showChart = true;

  toggleView() {
    this.showChart = !this.showChart;
  }
}
