import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  img = 'https://argentinaprograma.inti.gob.ar/pluginfile.php/1/theme_moove/logo/1654917560/APLogo-20-20.png';
  img2 = 'https://argentinaprograma.inti.gob.ar/theme/moove/pix/LogosInti.png';
  isLogged = false;

  constructor(private router:Router,
              private tokenService: TokenService) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  onLogOut():void{
    this.tokenService.logOut();
    window.location.reload();
  }

  login(){
    this.router.navigate(['/login'])
  }
}
