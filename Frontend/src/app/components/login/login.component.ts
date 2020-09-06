import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AlertService} from '../../service/alert.service';
import {first} from 'rxjs/operators';
import {LoginService} from '../../service/login.service';
import {User} from '../../model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user;

  constructor(private loginservice: LoginService, private router: Router) {
  }

  ngOnInit(): void {
    this.user = new User();
  }

  submit() {
    console.log('Inside submit');
    console.log(this.user.username);
    console.log(this.user.password);
    this.loginservice.loginV2(this.user)
      .subscribe( (data) => {
          console.log('Got the response');
          console.log(data.code);
          console.log(data.message);
          if (data.code === '0') {
            alert('Login Successful');
            this.router.navigate(['menu']);
          } else {
            this.router.navigate(['menuv']);
            alert('Login UnSuccessful. Please Retry');
          }
        }
      );
  }
 /* loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private loginService: LoginService,
    private alertService: AlertService
  ) {
    // redirect to home if already logged in
    if (this.loginService.currentUserValue) {
      this.router.navigate(['/']);
    }
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;

    // reset alerts on submit
    this.alertService.clear();

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.loginService.login(this.f.username.value, this.f.password.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        });
  }
*/
}
