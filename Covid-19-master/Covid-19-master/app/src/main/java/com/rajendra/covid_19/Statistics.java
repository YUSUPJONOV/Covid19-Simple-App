package com.rajendra.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Statistics extends AppCompatActivity {

    ImageView back;
    String word1,word2,word3,word4,word5,word6,word7,word8,word9,word10;
    TextView text1,text2,text3,text4,text5,text6,text7,text8,text9,text10;

    private Document doc;
    private Thread secThread;
    private Runnable runnable;
    private ListView listView;
    private CustomArrayAdapter adapter;
    private List<ListItemClass> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        back = findViewById(R.id.imageView);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(Statistics.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        init();




    }


    private void init()
    {

        runnable = new Runnable() {
            @Override
            public void run() {
                new AT().execute();
            }
        };
        secThread = new Thread(runnable);
        secThread.start();



        text1 = findViewById(R.id.textView11);
        text2 = findViewById(R.id.textView12);
        text3 = findViewById(R.id.textView13);
        text4 = findViewById(R.id.textView14);
        text5 = findViewById(R.id.textView15);
        text6 = findViewById(R.id.textView16);
        text7 = findViewById(R.id.textView17);
        text8 = findViewById(R.id.textView18);
        text9 = findViewById(R.id.textView19);
        text10 = findViewById(R.id.textView20);


//
//        listView = findViewById(R.id.listView);
//        arrayList = new ArrayList<>();
//        adapter = new CustomArrayAdapter(this,R.layout.list_item_1,arrayList,getLayoutInflater());
//        listView.setAdapter(adapter);




    }

//
//    private void getWeb()
//    {
//        try {
//            doc = Jsoup.connect("https://index.minfin.com.ua/reference/coronavirus/geography/uzbekistan/").get();
//            Elements tables = doc.getElementsByTag("tbody");
//            Element our_table = tables.get(0);
//            Elements elements_from_table = our_table.children();
//            Element dollar = elements_from_table.get(0);
//            Elements dollar_elements = dollar.children();
//            Log.d("MyLog","Tbody size : " +dollar_elements.get(0).text());
//
////            for (int i = 0; i < 5; i++) {
////                ListItemClass items = new ListItemClass();
////                items.setData_1(our_table.children().get(i).child(0).text());
////                items.setData_2(our_table.children().get(i).child(1).text());
////                arrayList.add(items);
////                items.getData_1();
////            }
//
//
//
//            text1.setText(our_table.children().get(0).child(0).text());
//            text1.setText(our_table.children().get(0).child(1).text());
//            text2.setText(our_table.children().get(1).child(0).text());
//            text2.setText(our_table.children().get(1).child(1).text());
//            text3.setText(our_table.children().get(2).child(0).text());
//            text3.setText(our_table.children().get(2).child(1).text());
////            text7.setText(our_table.children().get(3).child(0).text());
////            text8.setText(our_table.children().get(3).child(1).text());
////            text9.setText(our_table.children().get(4).child(0).text());
////            text10.setText(our_table.children().get(4).child(1).text());
//
//
//
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    adapter.notifyDataSetChanged();
//                }
//            });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public class AT extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                doc = Jsoup.connect("https://index.minfin.com.ua/reference/coronavirus/geography/uzbekistan/").get();
                final Elements tables = doc.getElementsByTag("tbody");
                Element our_table = tables.get(0);

                word1 = our_table.children().get(0).child(0).text();
                word2 = our_table.children().get(0).child(1).text();
                word3 = our_table.children().get(1).child(0).text();
                word4 = our_table.children().get(1).child(1).text();
                word5 = our_table.children().get(2).child(0).text();
                word6 = our_table.children().get(2).child(1).text();
                word7= our_table.children().get(3).child(0).text();
                word8 = our_table.children().get(3).child(1).text();
                word9 = our_table.children().get(4).child(0).text();
                word10 = our_table.children().get(4).child(1).text();



            } catch (IOException e) {
                System.out.println("error");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            text1.setText(word1);
            text2.setText(word2);
//            text3.setText(word3);
            text4.setText(word4);
//            text5.setText(word5);
            text6.setText(word6);
//            text7.setText(word7);
            text8.setText(word8);
//            text9.setText(word9);
            text10.setText(word10);
        }
}
}
