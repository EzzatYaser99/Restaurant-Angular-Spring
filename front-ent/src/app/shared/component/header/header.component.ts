import {Component, OnInit} from '@angular/core';
import {MenuItem} from 'primeng/api';
import {LoginUserInformationService} from "../../services/login-user-information.service";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/security/authentication.service";
import {CartService} from "../../services/cart.service";
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent  {
  items: MenuItem[] = [
    {label: 'HOME', routerLink: 'home', icon: 'fa-solid fa-house'},
    {label: 'MENU', routerLink: 'menu', icon: ''},
    {label: 'ABOUT', routerLink: 'about', icon: ''},

  ];

  constructor(public _loginInfo: LoginUserInformationService, private _router: Router,
              private authService:AuthenticationService,
              private cardService: CartService

  ) {
  }

  handeLogOutUser() {
    this.cardService.orders = [];
    this.cardService.totalOrders.next(0);
    this.cardService.totalPrice.next(0);
    this.authService.logOut();
    this._router.navigate(['login'])

  }



}
