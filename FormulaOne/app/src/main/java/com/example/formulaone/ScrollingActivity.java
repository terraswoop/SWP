package com.example.formulaone;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScrollingActivity extends AppCompatActivity {
    String data;

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        JSONObject json = null;
        try {
            json = new FetchDataTask().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONArray jsonr;
        String textString="";
        ArrayList<DriverStandings> ds=new ArrayList<DriverStandings>();
        try {
            jsonr=json.getJSONObject("MRData").getJSONObject("StandingsTable").getJSONArray("StandingsLists");
            json= (JSONObject) jsonr.get(0);
            jsonr=json.getJSONArray("DriverStandings");
            for(int i=0;i<jsonr.length();i++) {
                JSONObject currJSON=(JSONObject)jsonr.get(i);
                JSONObject currDriver=(JSONObject)currJSON.get("Driver");
                Driver dd=new Driver(currDriver.getString("familyName"),currDriver.getString("givenName"),currDriver.getString("nationality"), Integer.parseInt(currJSON.getString("wins")));
                JSONArray jsonc=currJSON.getJSONArray("Constructors");
                ArrayList<Constructor> clist=new ArrayList<>();
                textString+=currJSON.getInt("position")+". ";
                textString+=currDriver.getString("familyName")+"\n\t";
                for(int j=0;j<jsonc.length();j++){
                    JSONObject cj=jsonc.getJSONObject(j);
                    Constructor c=new Constructor(cj.getString("constructorId"),cj.getString("name"),cj.getString("nationality"),cj.getString("url"));
                    clist.add(c);
                    if(j!=0){
                        textString+="\t";
                    }
                    textString+=c.toString();
                }
                DriverStandings s=new DriverStandings(dd,clist,currJSON.getInt("position"),currJSON.getInt("points"));
                ds.add(s);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView tv= (TextView) findViewById(R.id.textfeld);
        tv.setText(textString);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    class FetchDataTask extends AsyncTask<String, String, JSONObject> {


        private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONObject json = new JSONObject(jsonText);
                return json;
            } finally {
                is.close();
            }
        }

        @Override
        protected JSONObject doInBackground(String... strings) {
            try {
                JSONObject json = readJsonFromUrl("https://ergast.com/api/f1/current/driverStandings.json");
                return json;
                /*data = json.toString();
                TextView v = (TextView) findViewById(R.id.textfeld);
                v.setText(data);*/
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
