package tz.co.wadau.muvi.details;

import tz.co.wadau.muvi.models.Movie;
import tz.co.wadau.muvi.models.Review;
import tz.co.wadau.muvi.models.Video;

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
