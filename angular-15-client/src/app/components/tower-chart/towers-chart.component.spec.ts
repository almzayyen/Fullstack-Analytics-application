import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TowersChartComponent } from './towers-chart.component';

describe('TowersChartComponent', () => {
  let component: TowersChartComponent;
  let fixture: ComponentFixture<TowersChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TowersChartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TowersChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
