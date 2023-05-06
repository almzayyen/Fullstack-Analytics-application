import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TowersParentComponent } from './towers-parent.component';

describe('TowersParentComponent', () => {
  let component: TowersParentComponent;
  let fixture: ComponentFixture<TowersParentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TowersParentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TowersParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
