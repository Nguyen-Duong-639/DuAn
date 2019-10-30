package xuly;

import com.google.gson.Gson;

import json.OpenWeatherJSon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

// đọc thông tin thời tiết tqua Gson
public class OpenWeatherMapAPI {

    public static OpenWeatherJSon prediction(String q) {
        try {
            String location = URLEncoder.encode(q, "UTF-8");//

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location);
            InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
            OpenWeatherJSon results = new Gson().fromJson(reader, OpenWeatherJSon.class);

            String idIcon = results.getWeather().get(0).getIcon().toString();
            String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";
            URL urlImage = new URL(urlIcon);

            return results;

        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public static OpenWeatherJSon prediction(double lat, double lon) {
        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&amp;lon=" + lon);
            InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
            OpenWeatherJSon results = new Gson().fromJson(reader, OpenWeatherJSon.class);

            String idIcon = results.getWeather().get(0).getIcon().toString();
            String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";
            URL urlImage = new URL(urlIcon);

            return results;

        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static OpenWeatherJSon predictionDaily(double lat, double lon, int cnt) {
        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + lat + "&amp;lon=" + lon + "&amp;cnt=" + cnt);
            InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
            OpenWeatherJSon results = new Gson().fromJson(reader, OpenWeatherJSon.class);

            String idIcon = results.getWeather().get(0).getIcon().toString();
            String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";
            URL urlImage = new URL(urlIcon);

            return results;

        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static OpenWeatherJSon predictionDaily(String q, int cnt) {
        try {
            String location = URLEncoder.encode(q, "UTF-8");
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=" + location + "&amp;cnt=" + cnt);
            InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
            OpenWeatherJSon results = new Gson().fromJson(reader, OpenWeatherJSon.class);

            String idIcon = results.getWeather().get(0).getIcon().toString();
            String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";
            URL urlImage = new URL(urlIcon);

            return results;

        } catch (MalformedURLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
