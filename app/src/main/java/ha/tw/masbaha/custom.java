package ha.tw.masbaha;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import static ha.tw.masbaha.Main.OVERLAY_PERMISSION_REQ_CODE_CHATHEAD;
import static ha.tw.masbaha.Main.setX;

public class custom extends Activity {
    private EditText Name1,Pass1;


    public static String Name;
    public static String Pass;
    public static Button b1;
    public static TextView text1;
    private AdView mAdView;


    public static String getPass() {
        return Pass;
    }


    //DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
      //  DB = new DBHelper(this);



        Name1= (EditText) findViewById(R.id.Name);
        Pass1= (EditText) findViewById(R.id.Pass);
        text1= (TextView) findViewById(R.id.textView5);
        Name=Name1.getText().toString();
        Pass=Pass1.getText().toString();
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




        Name1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                Name=Name1.getText().toString();


            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        Pass1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                Pass=Pass1.getText().toString();
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

            }
        });

        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(Utils.canDrawOverlays(custom.this)) {
                    {

                        if (Main.getX() > 250) {


                        setX(Main.getX());


                    }
                        else{
                        setX(250);


                    }


                        stopChatHead();
                        startChatHead();


                    }
                }
                else{
                    requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
                }

                stopChatHead();
                startChatHead();
            }
        });


        if (Main.getlang()=="en"){
            text1.setText("Type the praise you want \n choose the number of praises \n then start praising.");
            b1.setText("start the praising");
        }
        else if (Main.getlang()=="ar") {
            text1.setText("اكتب التسبيحة الَتي تريد ومن ثم اختر عدد التسبيحات \n ثم ابدأ التسبيح");
            b1.setText("إبدأ التسبيح");
        }
         else if (Main.getlang()=="fr") {
            text1.setText("Tapez l'éloge que vous voulez \n  choisissez le nombre de louanges \n  puis commencez à louer");
            b1.setText("commencer la louange");
        }
         else if (Main.getlang()=="tu") {
            text1.setText("İstediğiniz övgüyü yazın \n övgü sayısını seç \n o zaman övmeye başla");
            b1.setText("övmeye başla");
        }
         else if (Main.getlang()=="in") {
            text1.setText("Ketikkan pujian yang Anda inginkan \n  pilih jumlah pujian\n  kemudian mulailah memuji.");
            b1.setText("mulai memuji");
        }
         else if (Main.getlang()=="ard") {
            text1.setText("آپ جو تعریفیں چاہتے ہیں اسے ٹائپ کریں \n   تعریف کی تعداد کا انتخاب کریں\n   پھر تعریف کرنا شروع کرو.");
            b1.setText("تعریف شروع کرو");
        }








    }

    private void requestPermission(int requestCode){
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, requestCode);
    }















    private void startChatHead(){
        startService(new Intent(custom.this, ChatHeadService.class));

    }
    private void stopChatHead(){
        stopService(new Intent(custom.this, ChatHeadService.class));

    }



}
