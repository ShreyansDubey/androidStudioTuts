package com.example.connectthree;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    boolean active = true;
    String curr_player = "Yellow";                      // Yellow goes first
    int [] game_state = {0,0,0,0,0,0,0,0,0};             // 1-yellow 2-red
    int [][] winningPos = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view){

        ImageView counter = (ImageView) view;
        int curr_tag = Integer.parseInt(counter.getTag().toString());
        System.out.println(curr_tag);
        if(game_state[curr_tag-1] == 0 && active == true) {
            counter.setTranslationY(-1000f);
            if (curr_player == "Yellow") {
                counter.setImageResource(R.drawable.yellow);
                game_state[curr_tag-1] = 1;
                curr_player = "Red";
            } else {
                counter.setImageResource(R.drawable.red);
                game_state[curr_tag-1] = 2;
                curr_player = "Yellow";
            }
            counter.animate().translationYBy(1000f).rotation(360f).setDuration(400);
            int done = 0;
            for(int[] winPos : winningPos){
                if(game_state[winPos[0]] == game_state[winPos[1]] &&
                        game_state[winPos[1]] == game_state[winPos[2]] &&
                        game_state[winPos[0]] != 0){
                    System.out.println("in");
                    if(game_state[winPos[0]] == 1){
                        Toast.makeText(this, "Yellow Wins", Toast.LENGTH_LONG).show();
                        System.out.println("yellow");
                        //GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                        //gridLayout.setVisibility(View.INVISIBLE);
                        Button button = findViewById(R.id.playAgain);
                        button.setAlpha(1);
                        active = false;
                        done = 1;
                    }
                    else{
                        Toast.makeText(this, "Red Wins", Toast.LENGTH_LONG).show();
                        System.out.println("red");
                        //GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                        //gridLayout.setVisibility(View.INVISIBLE);
                        Button button = findViewById(R.id.playAgain);
                        button.setAlpha(1);
                        active = false;
                        done = 1;
                    }
                }
            }
            int isActive = 0;
            for(int i : game_state){
                if(i == 0) {
                    isActive = 1;
                }
            }
            if(isActive == 0 && done == 0){
                Toast.makeText(this, "Nobody Wins", Toast.LENGTH_LONG).show();
                System.out.println("nobody");
                //GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                //gridLayout.setVisibility(View.INVISIBLE);
                Button button = findViewById(R.id.playAgain);
                button.setAlpha(1);
            }


        }
    }

    public void playAgain(View view){
        String curr_player = "Yellow";
        Button button = findViewById(R.id.playAgain);
        button.setAlpha(0);
        active = true;
        for (int i = 0; i < game_state.length; i++){
            game_state[i] = 0;
        }

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
