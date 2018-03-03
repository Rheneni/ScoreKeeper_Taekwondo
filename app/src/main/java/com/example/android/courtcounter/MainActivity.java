package com.example.android.courtcounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    static final int PUNCH_POINTS = 1;
    static final int TORSO_KICK_POINTS = 2;
    static final int HEAD_KICK_POINTS = 3;
    static final int ROUND_KICK_POINTS = 4;
    static final int LOW_KICK_FOUL = 1;
    static final int PUSH_POINTS = -1;
    static final int WINNING_CAP = 7;
    static final int FOULS_LIMIT = 3;
    static final int RESULT_ID_PLAYER1 = R.id.result_player1;
    static final int RESULT_ID_PLAYER2 = R.id.result_player2;

    //update with Player class
    Player player1;
    Player player2;
    int totalScorePlayer1 = 0;
    int totalScorePlayer2 = 0;
    int foulsPlayer1 = 0;
    int foulsPlayer2 = 0;
    boolean existsWinner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void punch(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int totalScoreViewId = 0;
            int scoredViewId = 0;
            int totalScore = 0;
            if (playerId == R.id.punch_button_player1) {
                player1.addScore(PUNCH_POINTS);
                totalScore = totalScorePlayer1 += PUNCH_POINTS;
                totalScoreViewId = R.id.total_score_player_1;
                scoredViewId = R.id.scored_player_1;
            } else if (playerId == R.id.punch_button_player2) {
                player2.addScore(PUNCH_POINTS);
                totalScore = totalScorePlayer2 += PUNCH_POINTS;
                totalScoreViewId = R.id.total_score_player_2;
                scoredViewId = R.id.scored_player_2;
            } else {
                Log.d("punch", "No Matching viewId");
            }
            displayScorePlayer(totalScore, totalScoreViewId);
            displayScorePlayer(PUNCH_POINTS, scoredViewId);
        }
    }

    public void torsoKick(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int totalScoreViewId = 0;
            int scoredViewId = 0;
            int totalScore = 0;
            if (playerId == R.id.torso_kick_button_player1) {
                totalScore = totalScorePlayer1 += TORSO_KICK_POINTS;
                totalScoreViewId = R.id.total_score_player_1;
                scoredViewId = R.id.scored_player_1;
            } else if (playerId == R.id.torso_kick_button_player2) {
                totalScore = totalScorePlayer2 += TORSO_KICK_POINTS;
                totalScoreViewId = R.id.total_score_player_2;
                scoredViewId = R.id.scored_player_2;
            } else {
                Log.d("torsoKick()", "No Matching viewId");
            }
            displayScorePlayer(totalScore, totalScoreViewId);
            displayScorePlayer(TORSO_KICK_POINTS, scoredViewId);
        }
    }

    public void headKick(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int totalScoreViewId = 0;
            int scoredViewId = 0;
            int totalScore = 0;
            if (playerId == R.id.head_kick_button_player1) {
                totalScore = totalScorePlayer1 += HEAD_KICK_POINTS;
                totalScoreViewId = R.id.total_score_player_1;
                scoredViewId = R.id.scored_player_1;
            } else if (playerId == R.id.head_kick_button_player2) {
                totalScore = totalScorePlayer2 += HEAD_KICK_POINTS;
                totalScoreViewId = R.id.total_score_player_2;
                scoredViewId = R.id.scored_player_2;
            } else {
                Log.d("headKick", "No Matching viewId");
            }
            displayScorePlayer(totalScore, totalScoreViewId);
            displayScorePlayer(HEAD_KICK_POINTS, scoredViewId);
        }
    }

    public void roundKick(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int totalScoreViewId = 0;
            int scoredViewId = 0;
            int totalScore = 0;
            if (playerId == R.id.round_kick_button_player1) {
                totalScore = totalScorePlayer1 += ROUND_KICK_POINTS;
                totalScoreViewId = R.id.total_score_player_1;
                scoredViewId = R.id.scored_player_1;
            } else if (playerId == R.id.round_kick_button_player2) {
                totalScore = totalScorePlayer2 += ROUND_KICK_POINTS;
                totalScoreViewId = R.id.total_score_player_2;
                scoredViewId = R.id.scored_player_2;
            } else {
                Log.d("roundKick", "No Matching viewId");
            }
            displayScorePlayer(totalScore, totalScoreViewId);
            displayScorePlayer(ROUND_KICK_POINTS, scoredViewId);
        }
    }

    public void lowKick(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int foulsViewId = 0;
            int scoredViewId = 0;
            int fouls = 0;
            if (playerId == R.id.lowKick_button_player1) {
                fouls = foulsPlayer1 += LOW_KICK_FOUL;
                foulsViewId = R.id.fouls_player_1;
                scoredViewId = R.id.scored_player_1;
            } else if (playerId == R.id.lowKick_button_player2) {
                fouls = foulsPlayer2 += LOW_KICK_FOUL;
                foulsViewId = R.id.fouls_player_2;
                scoredViewId = R.id.scored_player_2;
            } else {
                Log.d("lowKick", "No Matching viewId");
            }
            displayFoulsPlayer(fouls, foulsViewId);
            displayScorePlayer(0, scoredViewId);
        }
    }

    public void push(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int totalScoreViewId = 0;
            int scoredViewId = 0;
            int totalScore = 0;
            if (playerId == R.id.push_button_player1) {
                totalScore = totalScorePlayer1 += PUSH_POINTS;
                totalScoreViewId = R.id.total_score_player_1;
                scoredViewId = R.id.scored_player_1;
            } else if (playerId == R.id.push_button_player2) {
                totalScore = totalScorePlayer2 += PUSH_POINTS;
                totalScoreViewId = R.id.total_score_player_2;
                scoredViewId = R.id.scored_player_2;
            } else {
                Log.d("push", "No Matching viewId");
            }
            displayScorePlayer(totalScore, totalScoreViewId);
            displayScorePlayer(PUSH_POINTS, scoredViewId);
        }
    }

    public void restartFight(View view) {
        player1.resetScore();
        player2.resetScore();
        totalScorePlayer1 = 0;
        totalScorePlayer2 = 0;
        foulsPlayer1 = 0;
        foulsPlayer2 = 0;
        existsWinner = false;
        displayScorePlayer(totalScorePlayer1, R.id.total_score_player_1);
        displayScorePlayer(0, R.id.scored_player_1);
        displayScorePlayer(foulsPlayer1, R.id.fouls_player_1);
        displayScorePlayer(totalScorePlayer2, R.id.total_score_player_2);
        displayScorePlayer(0, R.id.scored_player_2);
        displayScorePlayer(foulsPlayer2, R.id.fouls_player_2);
        cleanResults();
    }

    public void cleanResults() {
        TextView view1 = (TextView) findViewById(RESULT_ID_PLAYER1);
        view1.setText("");

        TextView view2 = (TextView) findViewById(RESULT_ID_PLAYER2);
        view2.setText("");
    }

    public void checkWinningConditions() {
        boolean isFinished = false;
        int winnerId = 0;
        int loserId = 0;
        boolean isDraw = false;
        if(foulsPlayer1 > foulsPlayer2 && foulsPlayer1 >= FOULS_LIMIT) {
            //Player1 loses, Player2 wins
            isFinished = true;
            winnerId = RESULT_ID_PLAYER2;
            loserId = RESULT_ID_PLAYER1;
        }
        else if(foulsPlayer2 > foulsPlayer1 && foulsPlayer2 >= FOULS_LIMIT) {
            //Player2 loses, Player1 wins
            isFinished = true;
            winnerId = RESULT_ID_PLAYER1;
            loserId = RESULT_ID_PLAYER2;
        }
        else if(foulsPlayer1 == foulsPlayer2 && foulsPlayer1 >= FOULS_LIMIT) {
            //DRAW
            isFinished = true;
            isDraw = true;
        }
        else if(totalScorePlayer1 - totalScorePlayer2 >= WINNING_CAP) {
            //Player1 wins, player 2 loses
            isFinished = true;
            winnerId = RESULT_ID_PLAYER1;
            loserId = RESULT_ID_PLAYER2;
        }
        else if(totalScorePlayer2 - totalScorePlayer1 >= WINNING_CAP) {
            //player2 wins, player 1 loses
            isFinished = true;
            winnerId = RESULT_ID_PLAYER2;
            loserId = RESULT_ID_PLAYER1;
        }

        if(isFinished && !existsWinner) {
            if(isDraw) {
                displayDrawResults();
            }
            else {
                displayWinLossResults(winnerId, loserId);
            }
            existsWinner = true;
        }
        else {
            //No Winner yet
        }
    }

    public void displayScorePlayer(int number, int viewId) {
        TextView totalScoreView = (TextView) findViewById(viewId);
        totalScoreView.setText(String.valueOf(number));
        checkWinningConditions();
    }

    public void displayFoulsPlayer(int number, int viewId) {
        TextView totalScoreView = (TextView) findViewById(viewId);
        totalScoreView.setText(String.valueOf(number));
    }

    public void displayWinLossResults(int winner, int loser) {
        TextView winnerView = (TextView) findViewById(winner);
        winnerView.setText("WINNER");
        winnerView.setTextColor(Color.GREEN);

        TextView loserView = (TextView) findViewById(loser);
        loserView.setText("LOSER");
        loserView.setTextColor(Color.RED);
    }

    public void displayDrawResults() {
        TextView view1 = (TextView) findViewById(RESULT_ID_PLAYER1);
        view1.setText("DRAW");
        view1.setTextColor(Color.BLUE);

        TextView view2 = (TextView) findViewById(RESULT_ID_PLAYER2);
        view2.setText("DRAW");
        view2.setTextColor(Color.BLUE);
    }
}
