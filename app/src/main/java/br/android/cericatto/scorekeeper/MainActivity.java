package br.android.cericatto.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * MainActivity.java.
 *
 * @author Rodrigo Cericatto
 * @since Aug 15, 2016
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //--------------------------------------------------
    // Attributes
    //--------------------------------------------------

    private Button mResetButton;

    private TextView mHomeScoreTextView;
    private TextView mAwayScoreTextView;

    private Button mHomeTeamPlusOneTextView;
    private Button mHomeTeamPlusTwoTextView;
    private Button mHomeTeamPlusThreeTextView;

    private Button mAwayTeamPlusOneTextView;
    private Button mAwayTeamPlusTwoTextView;
    private Button mAwayTeamPlusThreeTextView;

    private Integer mHomeScore = 0;
    private Integer mAwayScore = 0;

    //--------------------------------------------------
    // Activity Life Cycle
    //--------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private void setLayout() {
        mResetButton = (Button)findViewById(R.id.id_reset_button);
        mResetButton.setOnClickListener(this);

        mHomeScoreTextView = (TextView)findViewById(R.id.id_home__score_text_view);
        mAwayScoreTextView = (TextView)findViewById(R.id.id_away__score_text_view);

        mHomeTeamPlusOneTextView = (Button)findViewById(R.id.id_home__plus_one_text_view);
        mHomeTeamPlusOneTextView.setOnClickListener(this);
        mHomeTeamPlusTwoTextView = (Button)findViewById(R.id.id_home__plus_two_text_view);
        mHomeTeamPlusTwoTextView.setOnClickListener(this);
        mHomeTeamPlusThreeTextView = (Button)findViewById(R.id.id_home__plus_three_text_view);
        mHomeTeamPlusThreeTextView.setOnClickListener(this);

        mAwayTeamPlusOneTextView = (Button)findViewById(R.id.id_away__plus_one_text_view);
        mAwayTeamPlusOneTextView.setOnClickListener(this);
        mAwayTeamPlusTwoTextView = (Button)findViewById(R.id.id_away__plus_two_text_view);
        mAwayTeamPlusTwoTextView.setOnClickListener(this);
        mAwayTeamPlusThreeTextView = (Button)findViewById(R.id.id_away__plus_three_text_view);
        mAwayTeamPlusThreeTextView.setOnClickListener(this);
    }

    //--------------------------------------------------
    // View.OnClickListener
    //--------------------------------------------------

    @Override
    public void onClick(View view) {
        Animation animation90 = AnimationUtils.loadAnimation(this, R.anim.zoom_in_90);
        Animation animation99 = AnimationUtils.loadAnimation(this, R.anim.zoom_in_99);
        switch (view.getId()) {
            // RESET.

            case R.id.id_reset_button:
                mResetButton.startAnimation(animation99);
                mHomeScore = 0;
                mAwayScore = 0;
                break;

            // HOME.

            case R.id.id_home__plus_one_text_view:
                mHomeTeamPlusOneTextView.startAnimation(animation90);
                mHomeScore += 1;
                break;
            case R.id.id_home__plus_two_text_view:
                mHomeTeamPlusTwoTextView.startAnimation(animation90);
                mHomeScore += 2;
                break;
            case R.id.id_home__plus_three_text_view:
                mHomeTeamPlusThreeTextView.startAnimation(animation90);
                mHomeScore += 3;
                break;

            // AWAY.

            case R.id.id_away__plus_one_text_view:
                mAwayTeamPlusOneTextView.startAnimation(animation90);
                mAwayScore += 1;
                break;
            case R.id.id_away__plus_two_text_view:
                mAwayTeamPlusTwoTextView.startAnimation(animation90);
                mAwayScore += 2;
                break;
            case R.id.id_away__plus_three_text_view:
                mAwayTeamPlusThreeTextView.startAnimation(animation90);
                mAwayScore += 3;
                break;
        }
        mHomeScoreTextView.setText(mHomeScore.toString());
        mAwayScoreTextView.setText(mAwayScore.toString());
    }
}
