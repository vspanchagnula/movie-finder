import { WelcomeDataService } from './../service/data/welcome-data.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Theatre } from '../booking/booking.component';
import { MovieDataService } from '../service/data/movie-data.service';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})

export class ConfirmationComponent implements OnInit {


  welcomeMessageFromService:string
  name = ''
  theatre: Theatre
  confirmationNumber : String

  //ActivatedRoute
  constructor(
    private route:ActivatedRoute,
    private movieService: MovieDataService) { 

  }

  ngOnInit(){
   
    this.theatre = this.movieService.theatre; 
    this.movieService.bookTickets(this.theatre).subscribe({
      next: data => this.confirmationNumber = data.confirmationNumber,
      error: error => console.error('There was an error!', error)
    
  })
   
    
  }

  


  handleSuccessfulResponse(response){
    this.welcomeMessageFromService = response.message
  }

  handleErrorResponse(error) {
    this.welcomeMessageFromService = error.error.message
  }
}
