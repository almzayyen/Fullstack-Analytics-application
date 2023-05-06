import { Component, OnInit } from '@angular/core';
import { Chart, registerables } from 'chart.js';
import { Tower } from 'src/app/models/tower.model';
import { TowerService } from 'src/app/services/tower.service';

@Component({
  selector: 'app-towers-chart',
  templateUrl: './towers-chart.component.html',
  styleUrls: ['./towers-chart.component.css']
})
export class TowersChartComponent implements OnInit {

  constructor(private towerService: TowerService,) { }

  ngOnInit(): void {
    Chart.register(...registerables);

    this.towerService.getAllTowers().subscribe((towers: Tower[]) => {
      const towerData = {
        labels: ['2G', '3G', '4G', '5G'],
        datasets: [{
          label: 'Number of Towers',
          data: [0, 0, 0, 0],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)'
          ],
          borderWidth: 1
        }]
      };
    
      towers.forEach((tower: Tower) => {
        if (tower.technology === '2G') {
          towerData.datasets[0].data[0]++;
        } else if (tower.technology === '3G') {
          towerData.datasets[0].data[1]++;
        } else if (tower.technology === '4G') {
          towerData.datasets[0].data[2]++;
        } else if (tower.technology === '5G') {
          towerData.datasets[0].data[3]++;
        }
      });
    
      const myChart = new Chart('myChart', {
        type: 'bar',
        data: towerData,
        options: {
          scales: {
            y: {
              beginAtZero: true,
              ticks: {
                stepSize: 1
              }
            }
          }
        }
      });
    });
    
  }

}
