import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TowerTableComponent } from './tower-table.component';

describe('TowerTableComponent', () => {
  let component: TowerTableComponent;
  let fixture: ComponentFixture<TowerTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TowerTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TowerTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
