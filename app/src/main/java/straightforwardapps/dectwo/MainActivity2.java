package straightforwardapps.dectwo;

/**
 * Created by vishal on 03-12-2017.
 */


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;


public class MainActivity2 extends AppCompatActivity {

    VideoView vv;
    int[] s = {R.raw.v1, R.raw.v2};
    int coun = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landscapeshit);
        vv = (VideoView) findViewById(R.id.vv);

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
