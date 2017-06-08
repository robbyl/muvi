package tz.co.wadau.muvi.details;

import tz.co.wadau.muvi.Movie;
import tz.co.wadau.muvi.Review;
import tz.co.wadau.muvi.Video;

import java.util.List;

/**
 * @author arun
 */
interface MovieDetailsView
{
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();
}
