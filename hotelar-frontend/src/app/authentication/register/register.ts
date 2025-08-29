import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { ValidatorsRegex } from '../../services/validators-regex';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register implements OnInit{

  register!: FormGroup
  private _validatorsRegex = inject(ValidatorsRegex);

  ngOnInit(): void {
    this.register = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email, Validators.pattern(this._validatorsRegex.email)]),
      name: new FormControl('',[Validators.required, Validators.pattern(this._validatorsRegex.letter)]),
      lastName: new FormControl('', [Validators.pattern(this._validatorsRegex.letter)]),
      password: new FormControl('', [Validators.required, Validators.pattern(this._validatorsRegex.password)]),
      confirmPassword: new FormControl('', [Validators.required])
    });
  }

  confirmPassword(){
    return this.register.get('password')!.value !== this.register.get('confirmPassword')!.value;
  }

  registerUser(){

  }

}
