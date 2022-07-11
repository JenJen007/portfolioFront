import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkillHySComponent } from './skill-hy-s.component';

describe('SkillHySComponent', () => {
  let component: SkillHySComponent;
  let fixture: ComponentFixture<SkillHySComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SkillHySComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SkillHySComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
