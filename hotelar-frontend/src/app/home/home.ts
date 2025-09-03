import { Component } from '@angular/core';
import { Navar } from '../layout/navar/navar';
import { Footer } from '../layout/footer/footer';

@Component({
  selector: 'app-home',
  imports: [
    Navar,
    Footer
  ],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

}
