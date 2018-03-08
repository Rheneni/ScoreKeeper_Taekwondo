package com.example.android.courtcounter;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.courtcounter.AttackTypes.Attack;
import com.example.android.courtcounter.AttackTypes.HeadKick;
import com.example.android.courtcounter.AttackTypes.LowKick;
import com.example.android.courtcounter.AttackTypes.Punch;
import com.example.android.courtcounter.AttackTypes.Push;
import com.example.android.courtcounter.AttackTypes.RoundKick;
import com.example.android.courtcounter.AttackTypes.TorsoKick;


public class MainActivity extends AppCompatActivity {

    static final int WINNING_CAP = 7;
    static final int FOULS_LIMIT = 3;
    static final int RESULT_ID_PLAYER1 = R.id.result_player1;
    static final int RESULT_ID_PLAYER2 = R.id.result_player2;

    Player player1 = new Player();
    Player player2 = new Player();
    boolean existsWinner = false;
    boolean isPlayer1Turn = true;
    int[] imagesPlayer1 = {R.drawable.stance1, R.drawable.defend1, R.drawable.punch1, R.drawable.torso_kick, R.drawable.head_kick, R.drawable.torso_kick, R.drawable.torso_kick, R.drawable.punch1};
    int[] imagesPlayer2 = {R.drawable.stance2, R.drawable.defend2, R.drawable.punch2, R.drawable.torso_kick, R.drawable.head_kick, R.drawable.torso_kick, R.drawable.torso_kick, R.drawable.punch2};
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void punch(View view) {
        if(!existsWinner) {
            executeAttack(new Punch(), view.getId(),
                    R.id.punch_button_player1, R.id.punch_button_player2, Position.PUNCH, "punch");
        }
    }

    public void torsoKick(View view) {
        if(!existsWinner) {
            executeAttack(new TorsoKick(), view.getId(),
                    R.id.torso_kick_button_player1, R.id.torso_kick_button_player2, Position.TORSO_KICK, "torsoKick");
        }
    }

    public void headKick(View view) {
        if(!existsWinner) {
            executeAttack(new HeadKick(), view.getId(),
                    R.id.head_kick_button_player1, R.id.head_kick_button_player2, Position.HEAD_KICK, "headKick");
        }
    }

    public void roundKick(View view) {
        if(!existsWinner) {
            executeAttack(new RoundKick(), view.getId(),
                    R.id.round_kick_button_player1, R.id.round_kick_button_player2, Position.ROUND_KICK, "roundKick");
        }
    }

    public void lowKick(View view) {
        if(!existsWinner) {
            int playerId = view.getId();
            int foulsViewId = 0;
            int scoredViewId = 0;
            int scored = 0;
            int fouls = 0;
            Position position1 = Position.STANCE;
            Position position2 = Position.STANCE;
            boolean isCorrectTurn = true;
            if (playerId == R.id.lowKick_button_player1 && isPlayer1Turn) {
                scored = player1.updatePlayer(new LowKick(), player2);
                fouls = player1.getFouls();
                foulsViewId = R.id.fouls_player_1;
                scoredViewId = R.id.scored_player_1;
                position1 = Position.PUSH;
                position2 = Position.DEFEND;
            } else if (playerId == R.id.lowKick_button_player2 && !isPlayer1Turn) {
                scored = player2.updatePlayer(new LowKick(), player1);
                fouls = player2.getFouls();
                foulsViewId = R.id.fouls_player_2;
                scoredViewId = R.id.scored_player_2;
                position2 = Position.PUSH;
                position1 = Position.DEFEND;
            } else {
                //Log.d("lowKick", "No Matching viewId");
                isCorrectTurn = false;
                int playerNum = isPlayer1Turn ? 2 : 1;
                String msg = "Not Player" + playerNum + "'s Turn.";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
            if (isCorrectTurn) {
                isPlayer1Turn = !isPlayer1Turn;
                displayFoulsPlayer(fouls, foulsViewId);
                displayScorePlayer(scored, scoredViewId);
                dislpayEnergyPlayers();
                updateImages(position1, position2);
            }
        }
    }

    public void push(View view) {
        if(!existsWinner) {
            executeAttack(new Push(), view.getId(),
                    R.id.push_button_player1, R.id.push_button_player2, Position.PUSH, "push");
        }
    }

    public <T extends Attack> void executeAttack(T attack, int playerId, int id1, int id2, Position position, String tag) {
        int totalScoreViewId = 0;
        int scoredViewId = 0;
        int scored = 0;
        int totalScore = 0;
        Position position1 = Position.STANCE;
        Position position2 = Position.STANCE;
        boolean isCorrectTurn = true;
        if (playerId == id1 && isPlayer1Turn) {
            scored = player1.updatePlayer(attack, player2);
            totalScore = player1.getTotalScore();
            totalScoreViewId = R.id.total_score_player_1;
            scoredViewId = R.id.scored_player_1;
            position1 = position;
            position2 = Position.DEFEND;
        } else if (playerId == id2 && !isPlayer1Turn) {
            scored = player2.updatePlayer(attack, player1);
            totalScore = player2.getTotalScore();
            totalScoreViewId = R.id.total_score_player_2;
            scoredViewId = R.id.scored_player_2;
            position2 = position;
            position1 = Position.DEFEND;
        } else {
            Log.d(tag, "No Matching viewId");
            isCorrectTurn = false;
            int playerNum = isPlayer1Turn ? 2 : 1;
            String msg = "Not Player" + playerNum + "'s Turn.";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }
        if (isCorrectTurn) {
            isPlayer1Turn = !isPlayer1Turn;
            displayScorePlayer(totalScore, totalScoreViewId);
            displayScorePlayer(scored, scoredViewId);
            dislpayEnergyPlayers();
            updateImages(position1, position2);
        }
    }

    public void restartFight(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        player1.resetScore();
        player2.resetScore();
        existsWinner = false;
        isPlayer1Turn = true;
        //player1
        displayScorePlayer(player1.getTotalScore(), R.id.total_score_player_1);
        displayScorePlayer(player1.getTotalScore(), R.id.scored_player_1);
        displayFoulsPlayer(player1.getFouls(), R.id.fouls_player_1);

        //player2
        displayScorePlayer(player2.getTotalScore(), R.id.total_score_player_2);
        displayScorePlayer(player2.getTotalScore(), R.id.scored_player_2);
        displayFoulsPlayer(player2.getFouls(), R.id.fouls_player_2);
        dislpayEnergyPlayers();
        cleanResults();
        updateImages(Position.STANCE, Position.STANCE);
    }

    public void cleanResults() {
        TextView view1 = findViewById(RESULT_ID_PLAYER1);
        view1.setText("");

        TextView view2 = findViewById(RESULT_ID_PLAYER2);
        view2.setText("");
    }

    public void checkWinningConditions() {
        boolean isFinished = false;
        int winnerId = 0;
        int loserId = 0;
        boolean isDraw = false;
        int totalScorePlayer1 = player1.getTotalScore();
        int totalScorePlayer2 = player2.getTotalScore();
        int foulsPlayer1 = player1.getFouls();
        int foulsPlayer2 = player2.getFouls();
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
        TextView totalScoreView = findViewById(viewId);
        totalScoreView.setText(String.valueOf(number));
        checkWinningConditions();
    }

    public void displayFoulsPlayer(int number, int viewId) {
        TextView totalFoulsView = findViewById(viewId);
        totalFoulsView.setText(String.valueOf(number));
    }

    public void dislpayEnergyPlayers() {
        TextView energyView1 = findViewById(R.id.energy_player_1);
        energyView1.setText(String.valueOf(player1.getEnergy()));
        TextView energyView2 = findViewById(R.id.energy_player_2);
        energyView2.setText(String.valueOf(player2.getEnergy()));
    }

    public void updateImages(Position position1, Position position2) {
        ImageView imageView1 = findViewById(R.id.image_player1);
        imageView1.setImageResource(imagesPlayer1[position1.getValue()]);
        ImageView imageView2 = findViewById(R.id.image_player2);
        imageView2.setImageResource(imagesPlayer2[position2.getValue()]);
    }

    public void displayWinLossResults(int winner, int loser) {
        TextView winnerView = findViewById(winner);
        winnerView.setText("WINNER");
        winnerView.setTextColor(Color.GREEN);

        TextView loserView = findViewById(loser);
        loserView.setText("LOSER");
        loserView.setTextColor(Color.RED);

        if (winner == RESULT_ID_PLAYER1) {
            if (player1.getFouls() > player2.getFouls()) {
                mediaPlayer = MediaPlayer.create(this, R.raw.winning_booing);
            } else {
                mediaPlayer = MediaPlayer.create(this, R.raw.winning_cheering);
            }
        } else {
            if (player2.getFouls() > player1.getFouls()) {
                mediaPlayer = MediaPlayer.create(this, R.raw.winning_booing);
            } else {
                mediaPlayer = MediaPlayer.create(this, R.raw.winning_cheering);
            }
        }
        mediaPlayer.start();
    }

    public void displayDrawResults() {
        TextView view1 = findViewById(RESULT_ID_PLAYER1);
        view1.setText("DRAW");
        view1.setTextColor(Color.BLUE);

        TextView view2 = findViewById(RESULT_ID_PLAYER2);
        view2.setText("DRAW");
        view2.setTextColor(Color.BLUE);
    }

    public enum Position {
        STANCE(0), DEFEND(1), PUNCH(2), TORSO_KICK(3), HEAD_KICK(4), ROUND_KICK(5), LOW_KICK(6), PUSH(7);
        private int m_value;

        Position(int value) {
            this.m_value = value;
        }

        public int getValue() {
            return this.m_value;
        }

    }

    public enum PlayerId {
        NO_PLAYER(0), PLAYER1(1), PLAYER2(2);
        private int m_value;

        PlayerId(int value) {
            this.m_value = value;
        }

        public int getValue() {
            return this.m_value;
        }
    }
}
