package lvna.com.naweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.lidroid.xutils.DbUtils;

import lvna.com.naweather.R;
import lvna.com.naweather.utils.UpdateWeatherUtils;
import lvna.com.naweather.utils.Utils;
import lvna.com.naweather.utils.XutilsDataBaseUtils;

public class SplashActivity extends Activity {
    private static final String TAG = "SplashActivity";
    private AnimationSet set;
    private ScaleAnimation scale;
    private AlphaAnimation alpha;
    private LinearLayout llayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        llayout = (LinearLayout) findViewById(R.id.llayout);
        set = new AnimationSet(false);
        scale = new ScaleAnimation(0.8f, 1, 0.9f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);//缩放动画
        alpha = new AlphaAnimation(0, 1);//淡入淡出动画
        DbUtils db = XutilsDataBaseUtils.createDB(this);
        UpdateWeatherUtils.updateCitysInfo(db, XutilsDataBaseUtils.getWeatherInfoList(db));//更新数据
        startAnimation();
    }

    /**
     * 开始动画
     */
    private void startAnimation() {
        scale.setDuration(1000);
        scale.setFillAfter(true);

        alpha.setDuration(2000);
        alpha.setFillAfter(true);

        set.addAnimation(scale);
        set.addAnimation(alpha);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i(TAG, "start update");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i(TAG, "stop Anim");
                Intent intent = new Intent(SplashActivity.this, WeatherActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        llayout.startAnimation(set);//设置动画
    }
}
