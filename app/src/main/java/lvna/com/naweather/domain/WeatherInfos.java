package lvna.com.naweather.domain;


import java.util.List;

/**
 * 基本查询天气信息
 * Created by lvna on 2016/5/1.
 */
public class WeatherInfos {

    /**
     * error : 0
     * status : success
     * date : 2016-05-01
     * results : [{"currentCity":"广州","pm25":"52","index":[{"title":"穿衣","zs":"热","tipt":"穿衣指数","des":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},{"title":"洗车","zs":"较适宜","tipt":"洗车指数","des":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"title":"旅游","zs":"适宜","tipt":"旅游指数","des":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"},{"title":"感冒","zs":"少发","tipt":"感冒指数","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},{"title":"运动","zs":"较适宜","tipt":"运动指数","des":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"},{"title":"紫外线强度","zs":"弱","tipt":"紫外线强度指数","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}],"weather_data":[{"date":"周日 05月01日 (实时：24℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"微风","temperature":"28 ~ 21℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/leizhenyu.png","weather":"多云转雷阵雨","wind":"微风","temperature":"30 ~ 23℃"},{"date":"周二","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/leizhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"雷阵雨转多云","wind":"微风","temperature":"28 ~ 22℃"},{"date":"周三","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"微风","temperature":"28 ~ 24℃"}]}]
     */

    private int error;
    private String status;
    private String date;
    public List<ResultsBean> results;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    /**
     * currentCity : 广州
     * pm25 : 52
     * index : [{"title":"穿衣","zs":"热","tipt":"穿衣指数","des":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},{"title":"洗车","zs":"较适宜","tipt":"洗车指数","des":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},{"title":"旅游","zs":"适宜","tipt":"旅游指数","des":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"},{"title":"感冒","zs":"少发","tipt":"感冒指数","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},{"title":"运动","zs":"较适宜","tipt":"运动指数","des":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"},{"title":"紫外线强度","zs":"弱","tipt":"紫外线强度指数","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}]
     * weather_data : [{"date":"周日 05月01日 (实时：24℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"微风","temperature":"28 ~ 21℃"},{"date":"周一","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/leizhenyu.png","weather":"多云转雷阵雨","wind":"微风","temperature":"30 ~ 23℃"},{"date":"周二","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/leizhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"雷阵雨转多云","wind":"微风","temperature":"28 ~ 22℃"},{"date":"周三","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/duoyun.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/duoyun.png","weather":"多云","wind":"微风","temperature":"28 ~ 24℃"}]
     */
    public static class ResultsBean {
        private String currentCity;
        private String pm25;
        public List<IndexBean> index;
        public List<WeatherDataBean> weather_data;

        public String getCurrentCity() {
            return currentCity;
        }

        public void setCurrentCity(String currentCity) {
            this.currentCity = currentCity;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public List<IndexBean> getIndex() {
            return index;
        }

        public void setIndex(List<IndexBean> index) {
            this.index = index;
        }

        public List<WeatherDataBean> getWeather_data() {
            return weather_data;
        }

        public void setWeather_data(List<WeatherDataBean> weather_data) {
            this.weather_data = weather_data;
        }

        /**
         * title : 穿衣
         * zs : 热
         * tipt : 穿衣指数
         * des : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
         */
        public static class IndexBean {
            private String title;
            private String zs;
            private String tipt;
            private String des;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getZs() {
                return zs;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }

            public String getTipt() {
                return tipt;
            }

            public void setTipt(String tipt) {
                this.tipt = tipt;
            }

            public String getDes() {
                return des;
            }

            public void setDes(String des) {
                this.des = des;
            }
        }

        /**
         * date : 周日 05月01日 (实时：24℃)
         * dayPictureUrl : http://api.map.baidu.com/images/weather/day/duoyun.png
         * nightPictureUrl : http://api.map.baidu.com/images/weather/night/duoyun.png
         * weather : 多云
         * wind : 微风
         * temperature : 28 ~ 21℃
         */
        public static class WeatherDataBean {
            private String date;
            private String dayPictureUrl;
            private String nightPictureUrl;
            private String weather;
            private String wind;
            private String temperature;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDayPictureUrl() {
                return dayPictureUrl;
            }

            public void setDayPictureUrl(String dayPictureUrl) {
                this.dayPictureUrl = dayPictureUrl;
            }

            public String getNightPictureUrl() {
                return nightPictureUrl;
            }

            public void setNightPictureUrl(String nightPictureUrl) {
                this.nightPictureUrl = nightPictureUrl;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }
        }
    }

    @Override
    public String toString() {
        return "WeatherInfos{" +
                "date='" + date + '\'' +
                ", error=" + error +
                ", status='" + status + '\'' +
                ", results=" + results +
                '}';
    }
}
