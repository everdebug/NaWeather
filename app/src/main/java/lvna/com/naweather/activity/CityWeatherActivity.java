package lvna.com.naweather.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.lidroid.xutils.DbUtils;

import java.util.List;

import lvna.com.naweather.R;
import lvna.com.naweather.adapter.WeatherCityAdapter;
import lvna.com.naweather.domain.WeatherInfo;
import lvna.com.naweather.utils.UpdateWeatherUtils;
import lvna.com.naweather.utils.XutilsDataBaseUtils;

public class CityWeatherActivity extends Activity {
    private static final String TAG = "CityWeatherActivity";
    private Intent intent;
    private ListView lv_citys;
    private List<WeatherInfo> weatherInfoList;
    private DbUtils db;
    private ImageView iv_back;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_city_collection);

        db = XutilsDataBaseUtils.createDB(this);
        weatherInfoList = XutilsDataBaseUtils.getWeatherInfoList(db);

        lv_citys = (ListView) findViewById(R.id.lv_citys);
        iv_back = (ImageView) findViewById(R.id.back);
        lv_citys.setAdapter(new WeatherCityAdapter(this, weatherInfoList));
        lv_citys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("city", weatherInfoList.get(position).getCity());
                CityWeatherActivity.this.setResult(1, intent);
                CityWeatherActivity.this.finish();
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            back();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * finish Activity前判断是否结束主Activity
     */
    private void back() {
        intent = getIntent();
        if ("".equals(intent.getStringExtra("city"))) {
            WeatherActivity.context.finish();
        }
        CityWeatherActivity.this.finish();
        System.exit(0);
    }


    class MyHandler extends Handler {

    }

}
