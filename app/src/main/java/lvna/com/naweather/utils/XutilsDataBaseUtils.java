package lvna.com.naweather.utils;

import android.app.Activity;
import android.util.Log;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

import lvna.com.naweather.domain.WeatherInfo;

/**
 * 根据Xutils写的数据库工具类
 * Created by lenovo on 2016/5/2.
 */
public class XutilsDataBaseUtils {

    public static final String TAG = "XutilsDataBaseUtils";
    public static final String PACKAGE_NAME = "lvna.com.naweather";
    public static final String DB_PATH = "/sdcard/Android/data/" + PACKAGE_NAME;

    //创建/获取数据库
    public static DbUtils createDB(Activity activity) {
        DbUtils db = DbUtils.create(activity, DB_PATH, "weather.db");
        db.getDatabase();
        return db;
    }

    /**
     * 添加到数据库
     *
     * @param db
     * @param info
     */
    public static void addInfo2DB(DbUtils db, WeatherInfo info) {
        try {
            if (getInfoExist(db, info.getCity())) {
                return;
            }
            db.save(info);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    public static boolean getInfoExist(DbUtils db, String city) {
        boolean flag = false;
        WeatherInfo info = null;
        try {
            info = db.findFirst(Selector.from(WeatherInfo.class).where("city", "=", city));
        } catch (DbException e) {
            e.printStackTrace();
        }
        if (info != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * 得到全部数据
     *
     * @param db
     * @return
     */
    public static List<WeatherInfo> getWeatherInfoList(DbUtils db) {
        List<WeatherInfo> list = new ArrayList<WeatherInfo>();
        try {
            list = db.findAll(Selector.from(WeatherInfo.class));
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除一条数据
     *
     * @param db   数据库
     * @param city 选择删除的名字
     */
    public static void deleteInfo(DbUtils db, String city) {
        try {
            Log.i(TAG, city + "-->DELETE");
            WeatherInfo info = null;
            info = db.findFirst(Selector.from(WeatherInfo.class).where("city", "=", city));
            db.delete(info);
            Log.i(TAG, getInfoExist(db, city) + "");
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public static void updateInfo(DbUtils db, WeatherInfo info) {
        try {
            Log.i(TAG,"更新操作"+info.getCity());
            db.update(info,WhereBuilder.b("city", "=", info.getCity()),"weather","currentTemp","temp");

        } catch (DbException e) {
            e.printStackTrace();
        }
    }
}
