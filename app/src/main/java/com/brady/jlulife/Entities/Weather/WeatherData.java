package com.brady.jlulife.Entities.Weather;

/**
 * Created by brady on 15-12-15.
 */
public class WeatherData {
    private String city;
    private String pinyin;
    private String citycode;
    private String date;
    private String time;
    private String postCode;
    private String altitude;
    private String weather;
    private String temp;
    private String l_tmp;
    private String h_tmp;
    private String WD;
    private String WS;
    private String sunrise;
    private String sunset;
    private float longitude;
    private float latitude;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getL_tmp() {
        return l_tmp;
    }

    public void setL_tmp(String l_tmp) {
        this.l_tmp = l_tmp;
    }

    public String getH_tmp() {
        return h_tmp;
    }

    public void setH_tmp(String h_tmp) {
        this.h_tmp = h_tmp;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", citycode='" + citycode + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", postCode='" + postCode + '\'' +
                ", altitude='" + altitude + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", l_tmp='" + l_tmp + '\'' +
                ", h_tmp='" + h_tmp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
