import { TestBed } from '@angular/core/testing';

import { MovieDataService } from './movie-data.service';

describe('movieDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MovieDataService = TestBed.get(MovieDataService);
    expect(service).toBeTruthy();
  });
});
