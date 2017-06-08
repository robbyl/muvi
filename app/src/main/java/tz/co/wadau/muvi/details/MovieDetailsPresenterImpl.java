package tz.co.wadau.muvi.details;

import tz.co.wadau.muvi.Movie;
import tz.co.wadau.muvi.Review;
import tz.co.wadau.muvi.Video;
import tz.co.wadau.muvi.favorites.FavoritesInteractor;
import tz.co.wadau.muvi.util.RxUtils;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author arun
 */
class MovieDetailsPresenterImpl implements MovieDetailsPresenter
{
    private MovieDetailsView view;
    private MovieDetailsInteractor movieDetailsInteractor;
    private FavoritesInteractor favoritesInteractor;
    private Subscription trailersSubscription;
    private Subscription reviewSubscription;

    MovieDetailsPresenterImpl(MovieDetailsInteractor movieDetailsInteractor, FavoritesInteractor favoritesInteractor)
    {
        this.movieDetailsInteractor = movieDetailsInteractor;
        this.favoritesInteractor = favoritesInteractor;
    }

    @Override
    public void setView(MovieDetailsView view)
    {
        this.view = view;
    }

    @Override
    public void destroy()
    {
        view = null;
        RxUtils.unsubscribe(trailersSubscription, reviewSubscription);
    }

    @Override
    public void showDetails(Movie movie)
    {
        if (isViewAttached())
        {
            view.showDetails(movie);
        }
    }

    private boolean isViewAttached()
    {
        return view != null;
    }

    @Override
    public void showTrailers(Movie movie)
    {
        trailersSubscription = movieDetailsInteractor.getTrailers(movie.getId()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTrailersSuccess, t -> onGetTrailersFailure());
    }

    private void onGetTrailersSuccess(List<Video> videos)
    {
        if (isViewAttached())
        {
            view.showTrailers(videos);
        }
    }

    private void onGetTrailersFailure()
    {
        // Do nothing
    }

    @Override
    public void showReviews(Movie movie)
    {
        reviewSubscription = movieDetailsInteractor.getReviews(movie.getId()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetReviewsSuccess, t -> onGetReviewsFailure());
    }

    private void onGetReviewsSuccess(List<Review> reviews)
    {
        if (isViewAttached())
        {
            view.showReviews(reviews);
        }
    }

    private void onGetReviewsFailure()
    {
        // Do nothing
    }

    @Override
    public void showFavoriteButton(Movie movie)
    {
        boolean isFavorite = favoritesInteractor.isFavorite(movie.getId());
        if (isViewAttached())
        {
            if (isFavorite)
            {
                view.showFavorited();
            } else
            {
                view.showUnFavorited();
            }
        }
    }

    @Override
    public void onFavoriteClick(Movie movie)
    {
        if (isViewAttached())
        {
            boolean isFavorite = favoritesInteractor.isFavorite(movie.getId());
            if (isFavorite)
            {
                favoritesInteractor.unFavorite(movie.getId());
                view.showUnFavorited();
            } else
            {
                favoritesInteractor.setFavorite(movie);
                view.showFavorited();
            }
        }
    }
}
