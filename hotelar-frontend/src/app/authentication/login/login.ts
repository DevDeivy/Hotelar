import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { ValidatorsRegex } from '../../services/validators-regex';
import { UserService } from '../../services/user-service';

@Component({
  selector: 'app-login',
  imports: [RouterLink, ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login implements OnInit{

  login!: FormGroup;
  private _validatorsRegex = inject(ValidatorsRegex);
  private _userService = inject(UserService);

  ngOnInit(): void {
      this.login = new FormGroup({
        email: new FormControl('', [Validators.required, Validators.pattern(this._validatorsRegex.email), Validators.email]),
        password: new FormControl('', [Validators.required, Validators.pattern(this._validatorsRegex.password)])
      })
  }

  loginValidation(){

  }

}
