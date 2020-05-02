import { movie_JPA_API_URL, API_URL } from '../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Movie } from '../../list-movies/list-movies.component';
import { Theatre } from '../../booking/booking.component';

@Injectable({
  providedIn: 'root'
})
export class MovieDataService {

  public theatre: Theatre

  constructor(
    private http:HttpClient
  ) { }

  retrieveAllmovies() {
    return this.http.get<Movie[]>(`${API_URL}/movies`);
  }

  retrieveThreatresByMovie(movieName) {
    return this.http.get<Theatre[]>(`${API_URL}/screenings?movie=${movieName}`);
  }

  bookTickets(theatre) {
    console.log("Caling service for book tickets")
    return this.http.post<any>(
      `${API_URL}/bookSeats`, theatre);
  }

  deletemovie(id){
    return this.http.delete(`${API_URL}/movies/${id}`);
  }

  searchmovie(movieName){
    return this.http.get<Movie>(`${API_URL}/searchMovie?movieName=${movieName}`);
  }

  updatemovie(id, movie){
    return this.http.put(
          `${API_URL}/movies/${id}`, movie);
  }

  createmovie(movie){
    return this.http.post(
              `${API_URL}/movies`, movie);
  }

}
