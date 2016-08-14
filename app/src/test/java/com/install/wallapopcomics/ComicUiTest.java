package com.install.wallapopcomics;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.install.wallapopcomics.view.detail.ComicUi;
import com.install.wallapopcomics.model.ComicsData;
import com.install.wallapopcomics.model.response.Image;
import com.install.wallapopcomics.presenter.ActivityPresenter;
import com.install.wallapopcomics.presenter.NavigationCallback;
import com.squareup.picasso.Picasso;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Answers.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ComicUiTest {

    @Mock(answer = RETURNS_DEEP_STUBS)
    private Picasso picasso;

    @Mock
    private ActivityPresenter activityPresenter;

    @Mock
    private NavigationCallback navigationCallback;

    @Mock
    private ComicsData comic;

    @Mock
    private Toolbar toolbar;

    @Mock
    private TextView titleTextView;

    @Mock
    private TextView descriptionTextView;

    @Mock
    private ImageView imageView;

    @Mock
    private View view;

    @Mock
    private Image image;

    private ComicUi comicUi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        List<Image> images = new ArrayList<>();
        images.add(image);
        when(activityPresenter.findViewById(R.id.toolbar)).thenReturn(toolbar);
        when(activityPresenter.findViewById(R.id.comic_title)).thenReturn(titleTextView);
        when(activityPresenter.findViewById(R.id.comic_description)).thenReturn(descriptionTextView);
        when(activityPresenter.findViewById(R.id.comic_image)).thenReturn(imageView);
        when(comic.getTitle()).thenReturn("title");
        when(comic.getDescription()).thenReturn("description");
        when(comic.getImages()).thenReturn(images);
        when(image.getPath()).thenReturn("path");
        when(image.getExtension()).thenReturn("ext");

        comicUi = new ComicUi(picasso);
    }

    @Test
    public void whenCreateView_thenViewsAreInitalisedWithData() throws Exception {
        comicUi.createView(activityPresenter, navigationCallback, comic);

        verify(toolbar).setTitle(R.string.comic_title);
        verify(toolbar).setNavigationIcon(R.mipmap.ic_up);
        verify(toolbar).setNavigationOnClickListener(comicUi);
        verify(titleTextView).setText("title");
        verify(descriptionTextView).setText("description");
        verify(picasso).load("path.ext");
    }

    @Test
    public void whenOnClick_thenNavigationCallbackIsNotified() throws Exception {
        givenTheUiIsCreated();

        comicUi.onClick(view);

        verify(navigationCallback).onUpPressed();
    }

    private void givenTheUiIsCreated() {
        comicUi.createView(activityPresenter, navigationCallback, comic);
    }

}