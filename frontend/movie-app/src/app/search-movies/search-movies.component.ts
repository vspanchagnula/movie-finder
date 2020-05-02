import { Component, OnInit } from '@angular/core';
import { MovieDataService } from '../service/data/movie-data.service';
import { Router } from '@angular/router';
import { Movie } from '../list-movies/list-movies.component';

@Component({
  selector: 'app-search-movies',
  templateUrl: './search-movies.component.html',
  styleUrls: ['./search-movies.component.css']
})
export class SearchMoviesComponent implements OnInit {

  

  movies: Movie[]
  constructor(
    private movieService:MovieDataService,
    private router : Router,
  ) { }

  ngOnInit() {
    this.refreshmovies();
  }

  

  refreshmovies(){
    this.movieService.retrieveAllmovies().subscribe(
      response => {
        console.log(response);
        this.movies = response;
      }
    )
  }

}
