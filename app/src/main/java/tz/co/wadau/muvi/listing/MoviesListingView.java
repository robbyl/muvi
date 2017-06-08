package tz.co.wadau.muvi.listing;

import java.util.List;

import tz.co.wadau.muvi.models.Movie;

/**
 * @author arun
 */
interface MoviesListingView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(Movie movie);
}
