package com.example.tictactoe;
import java.lang.*;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    int i,active = 0;
    Integer gameState[] = {2,2,2,2,2,2,2,2,2};
    List<Integer> l1 = Arrays.asList(gameState);
    int win[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean Game = true;

    public void taplogic(View view)
    {
        TextView status = findViewById(R.id.textView2);
        ImageView img = (ImageView) view;
        int tappedimg = Integer.parseInt(img.getTag().toString());
        if(gameState[tappedimg]==2)
        {
          gameState[tappedimg]=active;
          if(active==0)
          {
              active=1;
              img.setImageResource(R.drawable.zero);
              status.setText("X's Turn now!");
          }
          else
          {
              active = 0;
              img.setImageResource(R.drawable.cross);
              status.setText("O's Turn now!");
          }

        }
        // Draw condition
         boolean flag = l1.contains(2);
        if(flag==false)
        {
            status.setText("No one won! Game draw");
            reset(view);
        }
        // Win condition
        for(int wins[]:win)
        {
            if(gameState[wins[0]]==gameState[wins[1]]&&gameState[wins[1]]==gameState[wins[2]]&&gameState[wins[0]]!=2)
            {
                String winner;
                Game = false;
                if(gameState[wins[0]]==0)
                {
                     winner = "O has won the game";
                }
                else
                {
                     winner = "X has won the game";
                }

                status.setText(winner);
                reset(view);
            }
        }

        }

    public void reset(View view)
    {
      Game = true;
      active = 0;
      for(i=0;i<gameState.length;i++)
      {
          gameState[i]=2;
      }
      ImageView a = findViewById(R.id.imageView22);
      ImageView b = findViewById(R.id.imageView23);
      ImageView c = findViewById(R.id.imageView24);
      ImageView d = findViewById(R.id.imageView25);
      ImageView e = findViewById(R.id.imageView26);
      ImageView f = findViewById(R.id.imageView27);
      ImageView g = findViewById(R.id.imageView28);
      ImageView h = findViewById(R.id.imageView29);
      ImageView i = findViewById(R.id.imageView30);
      a.setImageResource(0);
      b.setImageResource(0);
      c.setImageResource(0);
      d.setImageResource(0);
      e.setImageResource(0);
      f.setImageResource(0);
      g.setImageResource(0);
      h.setImageResource(0);
      i.setImageResource(0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
