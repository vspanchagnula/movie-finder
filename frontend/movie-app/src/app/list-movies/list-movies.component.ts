import { MovieDataService } from './../service/data/movie-data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

export class Movie {
  constructor(
    public movieId: number,
    public movieName: string,
    public moviePosterUrl: string
  ){

  }
}

@Component({
  selector: 'app-list-movies',
  templateUrl: './list-movies.component.html',
  styleUrls: ['./list-movies.component.css']
})
export class ListmoviesComponent implements OnInit {

  movies: Movie[]
  movieName: string
  selectedMovie : Movie


  constructor(
    private movieService:MovieDataService,
    private router : Router,
    private basicAuthenticationService : BasicAuthenticationService
  ) { }

  ngOnInit() {
    this.retrieveAllmovies();
  }

  retrieveAllmovies(){
    this.movieService.retrieveAllmovies().subscribe(
      response => {
        console.log(response);
        this.movies = response;
      }
    )
  }

  searchmovie(movieName){
    this.movieService.searchmovie(movieName).subscribe(
      response => {
        console.log(response);
        this.selectedMovie = response;
      }
    )
    this.showTheatres(movieName);
  }

  showTheatres(movieName){
    this.router.navigate(['theatres',movieName])
  }
}
