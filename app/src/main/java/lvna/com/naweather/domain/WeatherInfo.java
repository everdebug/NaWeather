package lvna.com.naweather.domain;

/**
 * Created by lenovo on 2016/5/2.
 */
public class WeatherInfo {
    int id;
    private String city;
    private String weather;
    private String currentTemp;
    private String temp;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "city='" + city + '\'' +
                ", weather='" + weather + '\'' +
                ", currentTemp='" + currentTemp + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
