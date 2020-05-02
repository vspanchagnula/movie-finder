import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { ListmoviesComponent } from './list-movies/list-movies.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { LogoutComponent } from './logout/logout.component';
import { BookingComponent } from './booking/booking.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';

@NgModule({
  declarations: [
    AppComponent,
    ConfirmationComponent,
    LoginComponent,
    ErrorComponent,
    ListmoviesComponent,
    MenuComponent,
    FooterComponent,
    LogoutComponent,
    BookingComponent,
    SearchMoviesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
     {provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterBasicAuthService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
