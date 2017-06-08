package tz.co.wadau.muvi.listing;

import tz.co.wadau.muvi.Movie;

import java.util.List;

import rx.Observable;

/**
 * @author arun
 */
public interface MoviesListingInteractor
{
    Observable<List<Movie>> fetchMovies();
}
