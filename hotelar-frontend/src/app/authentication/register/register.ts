import { Component, inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { ValidatorsRegex } from '../../services/validators-regex';
import { UserService } from '../../services/user-service';
import { user } from '../../interface/user';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register implements OnInit{

  register!: FormGroup
  private _validatorsRegex = inject(ValidatorsRegex);
  private _api = inject(UserService);
  public response?: Object;
  private _router = inject(Router);
  public advert: boolean = false;

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

  registerUser(res: user){

    if(!this.register){
      this.advert = true;
      return
    }

    this._api.createUser(res).subscribe(data => {
      this.response = data
      this._router.navigate(['/login'])
      console.log(this.response)
    }, err => {
      console.log(err)
      this.advert = true
    })
  }


}
