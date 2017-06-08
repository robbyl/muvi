package tz.co.wadau.muvi.listing;

import tz.co.wadau.muvi.Movie;
import tz.co.wadau.muvi.util.RxSchedulersOverrideRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import java.util.List;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author arunsasidharan
 */
@RunWith(RobolectricTestRunner.class)
public class MoviesListingPresenterImplTest
{
    @Mock
    private MoviesListingInteractor interactor;
    @Mock
    private MoviesListingView view;
    @Mock
    Throwable throwable;
    @Mock
    private List<Movie> movies;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    private MoviesListingPresenterImpl presenter;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        presenter = new MoviesListingPresenterImpl(interactor);
    }

    @After
    public void teardown()
    {
        presenter.destroy();
    }

    @Test
    public void shouldBeAbleToDisplayMovies()
    {
        TestScheduler testScheduler = new TestScheduler();
        TestSubscriber<List<Movie>> testSubscriber = new TestSubscriber<>();
        Observable<List<Movie>> responseObservable = Observable.just(movies).subscribeOn(testScheduler);
        responseObservable.subscribe(testSubscriber);
        when(interactor.fetchMovies()).thenReturn(responseObservable);

        presenter.setView(view);
        testScheduler.triggerActions();

        testSubscriber.assertNoErrors();
        testSubscriber.onCompleted();
        verify(view).showMovies(movies);
    }
}