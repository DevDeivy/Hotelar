import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidatorsRegex {

  public email: RegExp = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
  public password: RegExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!¡¿@#$%^&*()_+{}\[\]:;"'<>?,./\\|`~=-]).{4,}$/;

  public letter: RegExp = /^[a-zA-Z]+$/;
  
}
