package in.ashwanik.appportfolio;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Bind(R.id.btnSpotify)
    CardView btnSpotify;

    @Bind(R.id.btnScores)
    CardView btnScores;

    @Bind(R.id.btnLibrary)
    CardView btnLibrary;

    @Bind(R.id.btnBuildItBigger)
    CardView btnBuildItBigger;

    @Bind(R.id.btnXyzReader)
    CardView btnXyzReader;

    @Bind(R.id.btnCapstone)
    CardView btnCapstone;

    View view;

    @OnClick({R.id.btnSpotify, R.id.btnScores, R.id.btnLibrary, R.id.btnBuildItBigger, R.id.btnXyzReader, R.id.btnCapstone})
    public void showMessage(View view) {
        String appName = "";

        switch (view.getId())
        {
            case R.id.btnSpotify:
                appName = "Spotify App";
                break;
            case R.id.btnScores:
                appName = "Scores App";
                break;
            case R.id.btnLibrary:
                appName = "Library App";
                break;
            case R.id.btnBuildItBigger:
                appName = "Build it bigger App";
                break;
            case R.id.btnXyzReader:
                appName = "Xyz Reader App";
                break;
            case R.id.btnCapstone:
                appName = "Capstone App";
                break;
        }

        showSnackBar(view, appName);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }


    private void showSnackBar(View view, String appName) {

        SpannableStringBuilder snackBarText = new SpannableStringBuilder();
        snackBarText.append("This will open ");
        int boldStart = snackBarText.length();
        snackBarText.append(appName);
        snackBarText.setSpan(new ForegroundColorSpan(0xFFFF9800), boldStart, snackBarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        snackBarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackBarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Snackbar.make(view, snackBarText, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
