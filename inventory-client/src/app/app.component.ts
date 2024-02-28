import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'inventory-client';

  public profile!: KeycloakProfile;

  constructor(public keycloakService: KeycloakService) {}

  async ngOnInit(): Promise<void> {
    if(await this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
      });
    }
  }

  async handleLogin() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    });
  }

  handleLogout() {
    this.keycloakService.logout(window.location.origin);
  }
}
