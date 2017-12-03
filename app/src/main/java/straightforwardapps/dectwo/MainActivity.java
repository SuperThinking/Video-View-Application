package straightforwardapps.dectwo;


/*import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    VideoView vv;
    int[] s = {R.raw.v1, R.raw.v2};
    int coun = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(this.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "__\n__", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.landscapeshit);
        } else if(this.getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "| |", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }
    }

    public void first(View v)
    {
        vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+s[coun]));
        vv.start();
    }
    public void second(View v)
    {
        vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+s[1]));
        vv.start();
    }

}
*/

    import com.google.android.youtube.player.YouTubeBaseActivity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

    import com.google.android.youtube.player.YouTubeBaseActivity;
    import com.google.android.youtube.player.YouTubeInitializationResult;
    import com.google.android.youtube.player.YouTubePlayer;
    import com.google.android.youtube.player.YouTubePlayer.Provider;
    import com.google.android.youtube.player.YouTubePlayerView;

    import java.util.List;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    private YouTubePlayer player;
    EditText txt;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText) findViewById(R.id.text);
        but = (Button) findViewById(R.id.but);
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        this.player = player;
        if (!wasRestored) {
            player.cueVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }

    public void playme(View view)
    {
        try {
            player.cueVideo(txt.getText().toString());
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Wrong Link", Toast.LENGTH_SHORT).show();
        }
    }

    public void first(View v)
    {
        player.cueVideo("android.resource://"+getPackageName()+"/"+R.raw.v1);
    }
    public void second(View v)
    {
        player.cueVideo("android.resource://"+getPackageName()+"/"+R.raw.v2);
    }

}


