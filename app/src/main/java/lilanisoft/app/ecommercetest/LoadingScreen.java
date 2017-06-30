package lilanisoft.app.ecommercetest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        ActionBar ab = getSupportActionBar();
        ab.hide();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(LoadingScreen.this,SplashActivity.class));
                finish();
            }
        },3000);
    }
}
