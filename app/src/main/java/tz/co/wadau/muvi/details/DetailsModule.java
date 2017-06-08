package tz.co.wadau.muvi.details;

import tz.co.wadau.muvi.favorites.FavoritesInteractor;
import tz.co.wadau.muvi.network.RequestHandler;

import dagger.Module;
import dagger.Provides;

/**
 * @author pulkitkumar
 * @author arunsasidharan
 */
@Module
public class DetailsModule
{
    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(RequestHandler requestHandler)
    {
        return new MovieDetailsInteractorImpl(requestHandler);
    }

    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor)
    {
        return new MovieDetailsPresenterImpl(detailsInteractor, favoritesInteractor);
    }
}
