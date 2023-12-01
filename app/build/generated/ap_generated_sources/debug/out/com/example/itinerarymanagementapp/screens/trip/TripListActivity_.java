//
// DO NOT EDIT THIS FILE.
// Generated using AndroidAnnotations 4.8.0.
// 
// You can create a larger work that contains this file and distribute that work under terms of your choice.
//

package com.example.itinerarymanagementapp.screens.trip;

import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import androidx.core.app.ActivityCompat;
import com.example.itinerarymanagementapp.R;
import org.androidannotations.api.bean.BeanHolder;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.builder.PostActivityStarter;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class TripListActivity_
    extends TripListActivity
    implements BeanHolder, HasViews, OnViewChangedListener
{
    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private final Map<Class<?> , Object> beans_ = new HashMap<Class<?> , Object>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public<T extends View> T internalFindViewById(int id) {
        return ((T) this.findViewById(id));
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static TripListActivity_.IntentBuilder_ intent(Context context) {
        return new TripListActivity_.IntentBuilder_(context);
    }

    public static TripListActivity_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new TripListActivity_.IntentBuilder_(fragment);
    }

    public static TripListActivity_.IntentBuilder_ intent(androidx.fragment.app.Fragment supportFragment) {
        return new TripListActivity_.IntentBuilder_(supportFragment);
    }

    @Override
    public<T> T getBean(Class<T> key) {
        return ((T) beans_.get(key));
    }

    @Override
    public<T> void putBean(Class<T> key, T value) {
        beans_.put(key, value);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        this.tripTitle = hasViews.internalFindViewById(R.id.tripTitle);
        this.tripRecyclerView = hasViews.internalFindViewById(R.id.tripRecyclerView);
        this.categoryFilterInput = hasViews.internalFindViewById(R.id.categoryFilterInput);
        this.addTripBtn = hasViews.internalFindViewById(R.id.addTripBtn);
        this.tripListBackBtn = hasViews.internalFindViewById(R.id.tripListBackBtn);
        if (this.addTripBtn!= null) {
            this.addTripBtn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    TripListActivity_.this.addTripBtn();
                }
            }
            );
        }
        if (this.tripListBackBtn!= null) {
            this.tripListBackBtn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View view) {
                    TripListActivity_.this.tripListBackBtn();
                }
            }
            );
        }
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<TripListActivity_.IntentBuilder_>
    {
        private android.app.Fragment fragment_;
        private androidx.fragment.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, TripListActivity_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), TripListActivity_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(androidx.fragment.app.Fragment fragment) {
            super(fragment.getActivity(), TripListActivity_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public PostActivityStarter startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode, lastOptions);
                } else {
                    if (context instanceof Activity) {
                        Activity activity = ((Activity) context);
                        ActivityCompat.startActivityForResult(activity, intent, requestCode, lastOptions);
                    } else {
                        context.startActivity(intent, lastOptions);
                    }
                }
            }
            return new PostActivityStarter(context);
        }
    }
}