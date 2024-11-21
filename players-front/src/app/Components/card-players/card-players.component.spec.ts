import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPlayersComponent } from './card-players.component';

describe('CardPlayersComponent', () => {
  let component: CardPlayersComponent;
  let fixture: ComponentFixture<CardPlayersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardPlayersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardPlayersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
