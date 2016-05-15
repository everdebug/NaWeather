package lvna.com.naweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import lvna.com.naweather.R;
import lvna.com.naweather.domain.WeatherInfos;

/**
 * title--index/img    tipt-zs
 * des
 * Created by lenovo on 2016/5/2.
 */
public class DataAdapter extends BaseAdapter {

    private String[] indexs = {"穿衣", "洗车", "旅游", "感冒", "运动", "紫外线强度", "PM"};
    private int[] index_pics = {R.mipmap.ic_wear_grey, R.mipmap.ic_wash_car_grey, R.mipmap.ic_travel_grey, R.mipmap.ic_ill_grey, R.mipmap.ic_sport_grey, R.mipmap.ic_sun_grey, R.mipmap.ic_pm_grey};
    private List<WeatherInfos.ResultsBean.IndexBean> list;
    private Context context;
    private String PM_index;

    public DataAdapter(List<WeatherInfos.ResultsBean.IndexBean> list, Context context, String PM_index) {
        this.list = list;
        this.context = context;
        this.PM_index = PM_index;
    }

    @Override
    public int getCount() {
        return list.size()+1;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_index, null);
            holder = new ViewHolder();
            holder.tv_tipt_zs = (TextView) convertView.findViewById(R.id.tv_tipt_zs);
            holder.tv_des = (TextView) convertView.findViewById(R.id.tv_des);
            holder.iv_title = (ImageView) convertView.findViewById(R.id.iv_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position == 6) {
            holder.tv_tipt_zs.setText("PM2.5指数");
            if(PM_index.equals("")){
                holder.tv_des.setText("信息暂无");
            }else{
                holder.tv_des.setText(PM_index);
            }

            holder.iv_title.setImageResource(index_pics[position]);
            return convertView;
        }
        WeatherInfos.ResultsBean.IndexBean indexBean = list.get(position);
        if ((indexBean.getTitle().equals(indexs[position]))) {
            holder.tv_tipt_zs.setText(indexBean.getTipt() + "-" + indexBean.getZs());
            holder.tv_des.setText(indexBean.getDes());
            holder.iv_title.setImageResource(index_pics[position]);
        }
        return convertView;
    }

    class ViewHolder {
        ImageView iv_title;
        TextView tv_tipt_zs;
        TextView tv_des;
    }
}
