package com.example.dn;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import json.OpenWeatherJSon;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView theoGio;
    RecyclerView theongay;

    ImageView findcity, here, maps;
    TextView txtName, txtndmax, txtndmin, txtStatus, txtHumidity, txtCloud, txtWind, txtDay;
    ImageView imageIcon;
    EditText etfindcity;
    LinearLayout all;

    ImageView image;
    TextView statusitem, ndmax, ndmin, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findcity = findViewById(R.id.findcity);
        theongay = findViewById(R.id.theongay);
        txtName = findViewById(R.id.cityShow);
        here = findViewById(R.id.here);
        etfindcity = findViewById(R.id.etfindcity);
        maps = findViewById(R.id.maps);

        txtndmax = findViewById(R.id.celsiusmax);
        txtndmin = findViewById(R.id.celsiusmin);
        txtStatus = findViewById(R.id.weather);
        txtHumidity = findViewById(R.id.doAm);
        txtCloud = findViewById(R.id.pcloud);
        txtWind = findViewById(R.id.tocdogio);
        txtDay = findViewById(R.id.now);
        imageIcon = findViewById(R.id.imagewerther);

        day = findViewById(R.id.thu);
        image = findViewById(R.id.image);
        statusitem = findViewById(R.id.statusitem);
        ndmax = findViewById(R.id.ndmax);
        ndmin = findViewById(R.id.ndmin);


        all = findViewById(R.id.all);
        GetWeatherData("hanoi");

//        setViewNgay();
        setFindcity();
        setViewGio();
        ttinChiTiet();
        weather7("hanoi");

    }
    public void setViewNgay() {
        theongay=findViewById(R.id.theongay);
        theongay.setHasFixedSize(true);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        theongay.setLayoutManager(layoutManager);
        ArrayList<Custom_ngay> arrayList=new ArrayList<>();
//        Adapter_ngay adapterNgay = new Adapter_ngay(MainActivity.this, arrayList);
        arrayList.add(new Custom_ngay("thu 2","78","24 oC","21"));
        arrayList.add(new Custom_ngay("thu 3","79","25do C","22"));
        arrayList.add(new Custom_ngay("thu 4","80","26do C","23"));
        arrayList.add(new Custom_ngay("thu 5","81","27do C","24"));
        arrayList.add(new Custom_ngay("thu 6","82","28do C","25"));
        arrayList.add(new Custom_ngay("thu 7","78","24do C","21"));
        arrayList.add(new Custom_ngay("thu 8","79","25do C","22"));


        Adapter_ngay adapterNgay=new Adapter_ngay(arrayList,getApplicationContext());
        theongay.setAdapter(adapterNgay);
    }
    private void weather7(final String data) {
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + data + "&units=metric&cnt=8&appid=b15c6285f8ad4ea604deee730d0fde7f";
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        theongay = findViewById(R.id.theogio);
        theongay.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        theongay.setLayoutManager(layoutManager);
        final ArrayList<custom_gio> arrayList = new ArrayList<custom_gio>();
        final adapter_gio adapterNgay = new adapter_gio(arrayList,MainActivity.this);
        theongay.setAdapter(adapterNgay);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ketqua", "json: " + response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
//                            JSONObject jsonObjectCity=jsonObject.getJSONObject("city");
//                            String name=jsonObjectCity.getString("name");
//                            txtName.setText(name);
                            JSONArray jsonArrayList=jsonObject.getJSONArray("list");
                            for(int i=0;i<jsonArrayList.length();i++){
                                JSONObject jsonObjectList=jsonArrayList.getJSONObject(i);
                                String ngay=jsonObjectList.getString("dt");

                                long l = Long.valueOf(ngay);
                                Date date = new Date(l * 1000L);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
                                String Day = simpleDateFormat.format(date);
//                                txtDay.setText(Day);

                                JSONObject main=jsonObjectList.getJSONObject("main");
                                String doam = main.getString("humidity");
                                txtHumidity.setText(doam + "%");


                                String max=main.getString("temp");
//                                String min=jsonObjectTemp.getString("min");
                                Double a = Double.valueOf(max);
//                                Double b = Double.valueOf(min);
                                String Nhietdomax = String.valueOf(a.intValue()); // a.intValue() chuyen  a thanh kieu so int    .. String.valueOf chuyen thanh kieu chuoi
//                                String Nhietdomin = String.valueOf(b.intValue());
//                                txtndmax.setText(Nhietdomax);
//                                txtndmin.setText(Nhietdomin);

                                JSONArray jsonArrayWeather =jsonObjectList.getJSONArray("weather");
                                JSONObject jsonObjectWeather=jsonArrayWeather.getJSONObject(0);
                                String status = jsonObjectWeather.getString("description");
                                String icon=jsonObjectWeather.getString("icon");
                                arrayList.add(new custom_gio(Day,doam,Nhietdomax));
                            }
                            adapterNgay.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }
    public void GetWeatherData(String data) {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + data + "&units=metric&appid=b15c6285f8ad4ea604deee730d0fde7f";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.d("ket qua", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String day = jsonObject.getString("dt");
                    String name = jsonObject.getString("name");

                    txtName.setText(name);

                    long l = Long.valueOf(day);
                    Date date = new Date(l * 1000L);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE yyyy-MM-dd HH-mm-ss");
                    String Day = simpleDateFormat.format(date);
                    txtDay.setText(Day);

                    JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
                    JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);


                    String status = jsonObjectWeather.getString("main");
                    txtStatus.setText(status);

                    String icon = jsonObjectWeather.getString("icon");
                    Picasso.with(MainActivity.this).load("http://openweathermap.org/img/wn/" + icon + ".png").into(imageIcon);


                    JSONObject jsonObjectMain = jsonObject.getJSONObject("main");

                    String nhietdomax = jsonObjectMain.getString("temp_max");
                    String nhietdomin = jsonObjectMain.getString("temp_min");
                    Double a = Double.valueOf(nhietdomax);
                    Double b = Double.valueOf(nhietdomin);
                    String Nhietdomax = String.valueOf(a.intValue());
                    String Nhietdomin = String.valueOf(b.intValue());
                    txtndmax.setText(Nhietdomax);
                    txtndmin.setText(Nhietdomin);

                    String doam = jsonObjectMain.getString("humidity");
                    txtHumidity.setText(doam + "%");

                    JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
                    String gio = jsonObjectWind.getString("speed");
                    txtWind.setText(gio + " m/s");

                    JSONObject jsonObjectClouds = jsonObject.getJSONObject("clouds");
                    String may = jsonObjectClouds.getString("all");
                    txtCloud.setText(may + " %");

                    JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
//                    String sys=jsonObjectSys.getString("timezone");
//                    String id = jsonObjectSys.getString("id");
                    String nameSys = jsonObjectSys.getString("name");
//                    String cod = jsonObjectSys.getString("cod");
                    txtName.setText(nameSys);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
    public void setFindcity() {
        findcity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String city = etfindcity.getText().toString();
                etfindcity.setVisibility(EditText.VISIBLE);

//                if (city.equals("")) {
//                    etfindcity.setVisibility(EditText.GONE);
//                }
                GetWeatherData(city);
                weather7(city);
                all.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etfindcity.setVisibility(EditText.GONE);
                        etfindcity.setText("");
                    }
                });
            }
        });
    }
    public void ttinChiTiet() {
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.herect,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.herect:
                                Toast.makeText(getBaseContext(), "Vị trí hiện tại", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
//                getWindow().setLayout(8,6);
                popupMenu.show();
            }

        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.bando,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.bando:
                                Toast.makeText(getBaseContext(), "Tìm kiếm trên bản đồ", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return false;
                    }
                });
//                getWindow().setLayout(8,6);
                popupMenu.show();
            }

        });
    }
    public void setViewGio() {
        theoGio = findViewById(R.id.theogio);
        theoGio.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        theoGio.setLayoutManager(layoutManager);
        ArrayList<custom_gio> arrayList = new ArrayList<>();

        arrayList.add(new custom_gio("1:00", "78%", "24do C"));
        arrayList.add(new custom_gio("4:00", "79%", "25do C"));
        arrayList.add(new custom_gio("7:00", "80%", "26do C"));
        arrayList.add(new custom_gio("10:00", "81%", "27do C"));
        arrayList.add(new custom_gio("13:00", "82%", "28do C"));
        arrayList.add(new custom_gio("16:00", "83%", "29do C"));
        arrayList.add(new custom_gio("19:00", "84%", "30do C"));
        arrayList.add(new custom_gio("22:00", "85%", "31do C"));

        adapter_gio adapterGio = new adapter_gio(arrayList, getApplicationContext());
        theoGio.setAdapter(adapterGio);
    }


//    public void getFragment(Fragment fragment) {
//        try {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, fragment)
//                    .commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d(TAG, "getFragment: " + e.getMessage());
//        }
//    }

//    public class WeatherAsyncTask extends AsyncTask<Void, Void, OpenWeatherJSon> {
//
//        @Override
//        protected OpenWeatherJSon doInBackground(Void... voids) {
//            return null;
//        }
//    }
//
//
//    public static OpenWeatherJSon prediction(String q) {
//        try {
//            String location = URLEncoder.encode(q, "UTF-8");//
//
//            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + location);
//            InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
//            OpenWeatherJSon results = new Gson().fromJson(reader, OpenWeatherJSon.class);
//
//            String idIcon = results.getWeather().get(0).getIcon().toString();
//            String urlIcon = "http://openweathermap.org/img/w/" + idIcon + ".png";
//            URL urlImage = new URL(urlIcon);
//
//            return results;
//
//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//        return null;
//    }

}
