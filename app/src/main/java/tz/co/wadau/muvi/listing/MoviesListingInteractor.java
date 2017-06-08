package tz.co.wadau.muvi.listing;

import java.util.List;

import rx.Observable;
import tz.co.wadau.muvi.models.Movie;

/**
 * @author arun
 */
public interface MoviesListingInteractor {
    Observable<List<Movie>> fetchMovies();
}
