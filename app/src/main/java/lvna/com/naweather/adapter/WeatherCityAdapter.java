package lvna.com.naweather.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import lvna.com.naweather.R;
import lvna.com.naweather.domain.WeatherInfo;

/**
 * Created by lenovo on 2016/5/5.
 */
public class WeatherCityAdapter extends BaseAdapter {

    private static final String TAG = "WeatherCityAdapter";
    private List<WeatherInfo> mList;
    private Context mContext;

    public WeatherCityAdapter(Context mContext, List<WeatherInfo> mList) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_city, null);
            holder = new ViewHolder();
            holder.tv_city = (TextView) convertView.findViewById(R.id.tv_city);
            holder.tv_current_temp = (TextView) convertView.findViewById(R.id.tv_current_temp);
            holder.tv_temp = (TextView) convertView.findViewById(R.id.tv_temp);
            holder.tv_weather = (TextView) convertView.findViewById(R.id.tv_weather);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        WeatherInfo info = mList.get(position);
        //Log.i(TAG,"之前"+info.toString());
        holder.tv_city.setText(info.getCity());
        holder.tv_current_temp.setText(info.getCurrentTemp());
        holder.tv_temp.setText(info.getTemp());
        holder.tv_weather.setText(info.getWeather());

        return convertView;
    }

    class ViewHolder {
        TextView tv_city;
        TextView tv_current_temp;
        TextView tv_temp;
        TextView tv_weather;
    }

}
