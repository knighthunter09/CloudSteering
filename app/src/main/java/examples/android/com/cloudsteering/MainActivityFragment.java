package examples.android.com.cloudsteering;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    private AnimatorSet animatorSet;
    private AnimatorSet sunset;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        animatorSet = (AnimatorSet)AnimatorInflater.loadAnimator(
                this.getActivity(), R.animator.wheel_spin);

        sunset = (AnimatorSet)AnimatorInflater.loadAnimator(
                this.getActivity(), R.animator.sun_swing);
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @Override
    public void onResume() {
        super.onResume();
        ImageView wheel = (ImageView)this.getActivity().findViewById(R.id.wheel);
        animatorSet.setTarget(wheel);

        ImageView sun = (ImageView) this.getActivity().findViewById(R.id.sun);
        sunset.setTarget(sun);

        animatorSet.start();
        sunset.start();
    }
}
