import { Component } from '@angular/core';
import { Navar } from '../layout/navar/navar';
import { Footer } from '../layout/footer/footer';
import { CardComponent } from '../features/card/card.component';

@Component({
  selector: 'app-home',
  imports: [
    Navar,
    Footer,
    CardComponent
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

}
