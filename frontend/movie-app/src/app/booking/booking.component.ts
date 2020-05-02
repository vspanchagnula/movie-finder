import { ActivatedRoute, Router } from '@angular/router';
import { MovieDataService } from '../service/data/movie-data.service';
import { Component, OnInit } from '@angular/core';
import { Movie } from '../list-movies/list-movies.component';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  id:number
  movie: Movie
  theatres: Theatre[]
  movieName: String
  confirmationNumber : String
  selectedTheatre: Theatre

  constructor(
    private movieService: MovieDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    
    this.movieName = this.route.snapshot.params['movieName'];
    
    console.log(this.movieName)
    
    if(this.movieName!= null) {
        this.movieService.retrieveThreatresByMovie(this.movieName).subscribe(
          response => {
            console.log(response);
            this.theatres = response;
          }
        )
     
  }
}

bookTickets(theatre){
  console.log("In booktickets")
  this.movieService.theatre = theatre
  this.router.navigate(['confirmation']);
  
}

  savemovie() {
    console.log("movie name:"+this.movie.movieName)
    if(this.id == -1) { 
      this.movieService.createmovie(this.movie)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['movies'])
            }
          )
    } else {
      this.movieService.updatemovie(this.id, this.movie)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['movies'])
            }
          )
    }
  }

 

}

export class Theatre {
  constructor(
    public  movieName : String,
    public  moviePosterUrl : String,
    public  theatreId : number,
    public theatreName : String,
    public theatreCity : String,
    public screeningDate : String,
    public screeningTime : String,
    public  numSeats : number,
  ){

  }
}
