package com.example.razon30.jsonviajackson;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {


//    String json = "{\n" +
//            "  \"id\": 123,\n" +
//            "  \"name\": \"Pankaj\",\n" +
//            "  \"permanent\": true,\n" +
//            "  \"address\": {\n" +
//            "    \"street\": \"Albany Dr\",\n" +
//            "    \"city\": \"San Jose\",\n" +
//            "    \"zipcode\": 95129\n" +
//            "  },\n" +
//            "  \"phoneNumbers\": [\n" +
//            "    123456,\n" +
//            "    987654\n" +
//            "  ],\n" +
//            "  \"role\": \"Manager\",\n" +
//            "  \"cities\": [\n" +
//            "    \"Los Angeles\",\n" +
//            "    \"New York\"\n" +
//            "  ],\n" +
//            "  \"properties\": {\n" +
//            "    \"age\": \"29 years\",\n" +
//            "    \"salary\": \"1000 USD\"\n" +
//            "  }\n" +
//            "}";
//
//    JsonParser jsonParser;
//
//    int id;
//    String name;
//    boolean permanent;
//    HashMap<String, String> address = new HashMap<String, String>();
//    ArrayList<String> phone = new ArrayList<String>();
//    String role;
//    ArrayList<String> cities = new ArrayList<String>();
//    HashMap<String, String> properties = new HashMap<String, String>();
//
//    ArrayList<JacksonHelper> jacksonHelpers = new ArrayList<JacksonHelper>();

    String title;
    String urlToRssFeed = "http://www.javatpoint.com";
    String getUrlToRssFeed = "https://www.youtube.com/watch?v=KTW-PrDliMs";
    String jsoupt = "http://www.academia.edu/9903023/Jsoup_Tutorial_for_Beginners_-_JavaTpoint";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        new RetrieveFeedTask().execute(urlToRssFeed);

//        try {
//            Document doc = Jsoup.connect("http://www.javatpoint.com").get();
//            title = doc.title();
//            tv.setText(title);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        //create JsonParser object
//        try {
//            jsonParser = new JsonFactory().createParser(json);
//
//            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
//
//                String name1 = jsonParser.getCurrentName();
//                if ("id".equals(name1)) {
//                    jsonParser.nextToken();
//                    id = jsonParser.getIntValue();
//                }
//                if ("name".equals(name1)) {
//                    jsonParser.nextToken();
//                    name = jsonParser.getText();
//                }
//                if ("permanent".equals(name1)) {
//                    jsonParser.nextToken();
//                    permanent = jsonParser.getBooleanValue();
//                }
//                if ("address".equals(name1)) {
//                    jsonParser.nextToken();
//                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
//                        String key = jsonParser.getCurrentName();
//                        jsonParser.nextToken();
//                        String value = jsonParser.getText();
//                        address.put(key, value);
//                    }
//                }
//                if ("phoneNumbers".equals(name1)) {
//                    jsonParser.nextToken();
//                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
//                        phone.add(jsonParser.getText());
//                    }
//                }
//                if ("role".equals(name1)) {
//                    jsonParser.nextToken();
//                    role = jsonParser.getText();
//                }
//                if ("cities".equals(name1)) {
//                    jsonParser.nextToken();
//                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
//                        cities.add(jsonParser.getText());
//                    }
//                }
//                if ("properties".equals(name1)) {
//                    jsonParser.nextToken();
//                    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
//                        String key = jsonParser.getText();
//                        jsonParser.nextToken();
//                        String value = jsonParser.getText();
//                        properties.put(key, value);
//                    }
//                }
//
//                JacksonHelper helper = new JacksonHelper(id, name, permanent, address, phone, role,
//                        cities, properties);
//                jacksonHelpers.add(helper);
//
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        tv.setText(jacksonHelpers.get(0).getId() + "\n" + jacksonHelpers.get(0)
//                .getName() + "\n" + jacksonHelpers.get(0).getAddress().toString() + "\n" + jacksonHelpers.get(0)
//                .getCities().toString()
//                + "\n" + jacksonHelpers.get(0).getRole() + "\n" + jacksonHelpers.get(0)
//                .getPhone().toString() + "\n");


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    class RetrieveFeedTask extends AsyncTask<String, Void, Document> {

        private Exception exception;

        protected Document doInBackground(String... urls) {
            Document doc = null;
            try {
                // URL url = new URL(urls[0]);
                doc = Jsoup.connect(urlToRssFeed).get();
                return doc;
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }

        protected void onPostExecute(Document feed) {
            // TODO: check this.exception
            // TODO: do something with the feed

           // tv.setText(feed.toString());
            StringBuilder builder = new StringBuilder();

            String title = feed.title();
            Elements links = feed.select("a[href]");
            Toast.makeText(MainActivity.this, links.toString() + "", Toast.LENGTH_LONG).show();

            String keywords = feed.select("meta[name=keywords]").first().attr("content");
            //String twitter = feed.select("meta[name=twitter:url]").first().attr("content");
            Elements images = feed.select("img[src~=(?i)\\.(png|jpe?g|gif)]");


            tv.setText(images.toString());



//            for (Element link : links) {
//
//
//
//            }




        }
    }


}
