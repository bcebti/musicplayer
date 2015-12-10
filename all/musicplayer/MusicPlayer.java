package rajesh.bce.com.googlemap;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;



public class MusicPlayer extends Activity {
    ProgressBar pbar;
    MediaPlayer mp;
    private final Handler handler=new Handler();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
       final ToggleButton musicButton=(ToggleButton)findViewById(R.id.musicBtn);
          mp=MediaPlayer.create(MusicPlayer.this,R.raw.sachasukh);
          tv=(TextView)findViewById(R.id.textView);
        tv.setText("0%");
                //PROGRESSBAR
         pbar=(ProgressBar)findViewById(R.id.progressBar);
                    pbar.setProgress(0);
        Log.i("*** Duration",mp.getDuration()+"");
                    pbar.setMax(mp.getDuration());


        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(musicButton.isChecked()==true)
                {
                    //musicButton.setText("one");
                    musicButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.pause));
                    mp.start();
                    updateProgressBar();
                }
                else
                {
                    //musicButton.setText("two");
                    musicButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.play));
                    mp.pause();

                }
            }
        });
    }
    private void updateProgressBar()
    {
        Log.i("*** Duration",mp.getCurrentPosition()+"");
        pbar.setProgress(mp.getCurrentPosition());
        if(mp.isPlaying())
        {
            Runnable notification=new Runnable() {
                @Override
                public void run()
                    {
                         updateProgressBar();
                    }
            };
            handler.postDelayed(notification,10);
            double per=mp.getCurrentPosition()*100.0/mp.getDuration();
            tv.setText(String.format("%.2f", per)+"% completed  ");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_music_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
