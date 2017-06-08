package tz.co.wadau.muvi.listing;

/**
 * @author arun
 */
public interface MoviesListingPresenter
{
    void displayMovies();

    void setView(MoviesListingView view);

    void destroy();
}
