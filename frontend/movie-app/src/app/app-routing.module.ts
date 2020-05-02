import { BookingComponent } from './booking/booking.component';
import { RouteGuardService } from './service/route-guard.service';
import { LogoutComponent } from './logout/logout.component';
import { ListmoviesComponent } from './list-movies/list-movies.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';

// welcome 
const routes: Routes = [
  { path: '', component: LoginComponent  },
  { path: 'login', component: LoginComponent },
  { path: 'search-movies', component: SearchMoviesComponent },
  { path: 'confirmation', component: ConfirmationComponent, canActivate:[RouteGuardService]},
  { path: 'movies', component: ListmoviesComponent, canActivate:[RouteGuardService] },
  { path: 'logout', component: LogoutComponent, canActivate:[RouteGuardService] },
  { path: 'movies/:id', component: BookingComponent, canActivate:[RouteGuardService] },
  { path: 'theatres/:movieName', component: BookingComponent, canActivate:[RouteGuardService] },

  { path: '**', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
