package tz.co.wadau.muvi;

import tz.co.wadau.muvi.details.DetailsComponent;
import tz.co.wadau.muvi.details.DetailsModule;
import tz.co.wadau.muvi.favorites.FavoritesModule;
import tz.co.wadau.muvi.listing.ListingComponent;
import tz.co.wadau.muvi.listing.ListingModule;
import tz.co.wadau.muvi.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent
{
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
