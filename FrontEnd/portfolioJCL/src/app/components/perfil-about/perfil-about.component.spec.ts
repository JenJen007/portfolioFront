import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PerfilAboutComponent } from './perfil-about.component';

describe('PerfilAboutComponent', () => {
  let component: PerfilAboutComponent;
  let fixture: ComponentFixture<PerfilAboutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PerfilAboutComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PerfilAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
