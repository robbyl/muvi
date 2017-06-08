package tz.co.wadau.muvi.details;

import tz.co.wadau.muvi.models.Video;

import java.util.List;

import rx.Observable;
import tz.co.wadau.muvi.models.Review;

/**
 * @author arun
 */
public interface MovieDetailsInteractor
{
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
