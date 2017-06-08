package tz.co.wadau.muvi.listing;

import tz.co.wadau.muvi.favorites.FavoritesInteractor;
import tz.co.wadau.muvi.network.RequestHandler;
import tz.co.wadau.muvi.listing.sorting.SortingOptionStore;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class ListingModule
{
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          RequestHandler requestHandler,
                                                          SortingOptionStore sortingOptionStore)
    {
        return new MoviesListingInteractorImpl(favoritesInteractor, requestHandler, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor)
    {
        return new MoviesListingPresenterImpl(interactor);
    }
}
