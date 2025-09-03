import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Register } from "./authentication/register/register";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'hotelar-frontend';
}
