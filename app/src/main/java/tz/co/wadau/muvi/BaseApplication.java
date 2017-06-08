package tz.co.wadau.muvi;

import android.app.Application;
import android.os.StrictMode;

import tz.co.wadau.muvi.details.DetailsComponent;
import tz.co.wadau.muvi.details.DetailsModule;
import tz.co.wadau.muvi.favorites.FavoritesModule;
import tz.co.wadau.muvi.listing.ListingComponent;
import tz.co.wadau.muvi.listing.ListingModule;
import tz.co.wadau.muvi.network.NetworkModule;

/**
 * @author arun
 */
public class BaseApplication extends Application
{
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent()
    {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent()
    {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent()
    {
        listingComponent = null;
    }

    public ListingComponent getListingComponent()
    {
        return listingComponent;
    }
}
