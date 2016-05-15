package lvna.com.naweather.utils;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


import java.util.ArrayList;
import java.util.List;

import lvna.com.naweather.activity.WeatherActivity;
import lvna.com.naweather.domain.WeatherInfo;
import lvna.com.naweather.domain.WeatherInfos;


/**
 * 数据获取
 */
public class UpdateWeatherUtils {
    public static final String TAG = "UpdateWeatherUtils";
    public static final String PATH1 = "http://api.map.baidu.com/telematics/v3/weather?location=";
    public static final String PATH2 = "&output=json&ak=FK9mkfdQsloEngodbFl4FeY3";

    // public static HttpUtils utils = new HttpUtils();

    public static void getData(String city) {
        Log.i(TAG, city + "天气查询");
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, PATH1 + city + PATH2,
                new RequestCallBack<String>() {
                    Message msg = WeatherActivity.handler.obtainMessage();

                    @Override
                    public void onLoading(long total, long current, boolean isUploading) {
                        Log.i(TAG, "请求中。。");
                    }

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        msg.what = 1;
                        //Log.i(TAG, "返回的json" + responseInfo.result.toString());
                        Gson gson = new Gson();
                        WeatherInfos weatherInfos = gson.fromJson(responseInfo.result.toString(), new TypeToken<WeatherInfos>() {
                        }.getType());
                        msg.obj = weatherInfos;
                        WeatherActivity.handler.sendMessage(msg);
                    }

                    @Override
                    public void onStart() {
                        Log.i(TAG, "开始请求");
                    }

                    @Override
                    public void onFailure(HttpException error, String msgs) {
                        Log.i(TAG, msgs);
                        msg.what = 2;
                        WeatherActivity.handler.sendMessage(msg);

                    }
                });

    }

    //方法在首页界面中进行调用，异步更新到数据库中
    public static void updateCitysInfo(DbUtils db,List<WeatherInfo> weatherInfoList) {
        final DbUtils ddb = db;
        for (int i = 0; i < weatherInfoList.size(); i++) {
            final String city = weatherInfoList.get(i).getCity();
            HttpUtils utils = new HttpUtils();
            utils.send(HttpRequest.HttpMethod.GET, PATH1 + city + PATH2,
                    new RequestCallBack<String>() {

                        @Override
                        public void onLoading(long total, long current, boolean isUploading) {
                            Log.i(TAG, "请求中。。");
                        }

                        @Override
                        public void onSuccess(ResponseInfo<String> responseInfo) {

                            //Log.i(TAG, "返回的json" + responseInfo.result.toString());
                            Gson gson = new Gson();
                            WeatherInfos weatherInfos = gson.fromJson(responseInfo.result.toString(), new TypeToken<WeatherInfos>() {
                            }.getType());

                            WeatherInfo info = new WeatherInfo();
                            info.setWeather(weatherInfos.getResults().get(0).getWeather_data().get(0).getWeather());
                            info.setTemp(weatherInfos.getResults().get(0).getWeather_data().get(0).getTemperature());
                            String date = weatherInfos.getResults().get(0).getWeather_data().get(0).getDate();
                            info.setCurrentTemp(date.substring(date.indexOf("：") + 1, date.indexOf("℃")) + "°");
                            info.setCity(city);
                            Log.i(TAG,"更新数据库");
                            XutilsDataBaseUtils.updateInfo(ddb,info);
                            Log.i(TAG, "this:" + info.toString());
                        }

                        @Override
                        public void onStart() {
                            Log.i(TAG, "开始请求");
                        }

                        @Override
                        public void onFailure(HttpException error, String msgs) {
                            Log.i(TAG, msgs);
                        }
                    });

        }
    }


}


/*
*
*
*
*
*
*
*


	@Override
	public void onStart() {
		String city = getHtmlValue("city");
		// 这里的AK替换成自己申请的百度API KEY，申请地址http://lbsyun.baidu.com/apiconsole/key
		final String ak = "C1e34c0bca1e816093604b5fd368c7c5";
		this.uri = "http://api.map.baidu.com/telematics/v3/weather";
		this.type = RequestType.GET;
		this.params = getParams();
		params.put("location", city);
		params.put("output","json");
		params.put("ak", ak);
	}

	@Override
	public void onSuccess(Document doc) {
		analyze(doc);
	}

	private void analyze(Document doc) {
		Message msg = Weather.handler.obtainMessage();
		String status = doc.getElementsByTag("status").get(0).text();
		if ("success".equals(status)) {
			// 查询成功
			msg.what = 1;

			msg.setData(bundle);
		} else if ("No result available".equals(status)) {
			// 没有天气信息
			msg.what = 2;
		} else {
			// 其他错误
			msg.what = 0;
		}
		Weather.handler.sendMessage(msg);
	}
String city = doc.getElementsByTag("currentcity").get(0).text();
			Element weatherDataElem = doc.getElementsByTag("weather_data").get(
					0);
			Elements dateElem = weatherDataElem.getElementsByTag("date");
			Elements weatherElem = weatherDataElem.getElementsByTag("weather");
			Elements windElem = weatherDataElem.getElementsByTag("wind");
			Elements temperatureElem = weatherDataElem
					.getElementsByTag("temperature");
			String[] dateArray = new String[4];
			String[] weatherArray = new String[4];
			String[] windArray = new String[4];
			String[] temperatureArray = new String[4];
			String currentTemperature = null;
			for (int i = 0; i < 4; i++) {
				String date = dateElem.get(i).text();
				if (i == 0) {
					if (date.contains("实时")) {
						currentTemperature = date.substring(
								date.indexOf("：") + 1, date.indexOf("℃")) + "°";
					}
					date = date.substring(0, 2);
				}
				dateArray[i] = date;
				weatherArray[i] = weatherElem.get(i).text();
				windArray[i] = windElem.get(i).text();
				String temperature = temperatureElem.get(i).text();
				if (temperature.contains("~")) {
					String highTem = temperature.substring(0,
							temperature.indexOf(" "));
					String lowTem = temperature.substring(
							temperature.lastIndexOf(" ") + 1,
							temperature.indexOf("℃"));
					temperature = lowTem + "~" + highTem + "°";
				} else {
					temperature = temperature.replace("℃", "°");
				}
				temperatureArray[i] = temperature;
			}
			if (currentTemperature == null) {
				currentTemperature = temperatureArray[0];
			}
			Bundle bundle = new Bundle();
			bundle.putStringArray("date", dateArray);
			bundle.putStringArray("weather", weatherArray);
			bundle.putStringArray("wind", windArray);
			bundle.putStringArray("temperature", temperatureArray);
			bundle.putString("city", city);
			bundle.putString("current_temperature", currentTemperature);
*
* */