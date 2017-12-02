package straightforwardapps.dectwo;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

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
