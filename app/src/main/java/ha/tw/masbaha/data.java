package ha.tw.masbaha;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class data extends Activity {
    private TextView data1,sum;
    private AdView mAdView;

    private TextView text1,text2,text3;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        DB = new DBHelper(this);
        Cursor res = DB.getdata();
        StringBuffer buffer = new StringBuffer();
        int x=0;

        while(res.moveToNext()){
            buffer.append(res.getString(1)+"\t\t\t\t\t\t\t\t\t\t\t\t\t");
            buffer.append(res.getString(0)+"\n");

       int y= Integer.parseInt(res.getString(1));
            x=x+y;

        }



        data1= (TextView) findViewById(R.id.data);
        sum= (TextView) findViewById(R.id.sum);



          data1.setText(


                  buffer.toString()



          );


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest1);



        text1 =  (TextView)  findViewById(R.id.text1);
        text2 =  (TextView)  findViewById(R.id.text2);
        text3 =  (TextView)  findViewById(R.id.text3);

        if (Main.getlang()=="ar"){
            text1.setText("رقم التسبيحة");
            text3.setText("عدد التسبيحات");
            sum.setText("المحموع الكلي : "+x+"");



        }
        else {

            text1.setText("Praises number");

            text3.setText(" Counted praises");
            sum.setText("The total number of Praises is : \n" + x);

        }




    }
}
