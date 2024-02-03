package ha.tw.masbaha;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class inst extends Activity {

    private AdView mAdView;
    private   RatingBar   bar ;
    private TextView text1,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inst);





        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
       // mAdView.loadAd(adRequest);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
     //   mAdView.loadAd(adRequest1);







        bar = (RatingBar) findViewById(R.id.ratingBar);

        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                String url = "https://play.google.com/store/apps/details?id=halim.Masbaha";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });




        text1 =  (TextView)  findViewById(R.id.text1);
        text2 =  (TextView)  findViewById(R.id.text2);
        text3 =  (TextView)  findViewById(R.id.text3);




        if (Main.getlang()=="en"){
            text1.setText("Instructions");

            text2.setText("1- Choose the size of the rosary from the sliding tape \n 2- Allow the rosary to float to work with other programs. \n 3- Select the colour you like. \n 4- Click the floating button and start the praise. \n \n To reassign the rosary: Press for two seconds and then drag it down.");
            text3.setText("Developed By: \n HA.OverFlow");
        }


     else if(Main.getlang()=="tu") {
            text1.setText("bilgi");
            text2.setText("1- Tespih boyutunu kayar banttan seçin \n" +
                    "2- Tespihin diğer programlarla çalışmasına izin verin.\n" +
                    "3- İstediğiniz rengi seçin. \n" +
                    "4- Kayan düğmeyi tıklayın ve övgüyü başlatın.\n" +
                    "\n Tespihi yeniden atamak için: tuşuna basın ve iki saniye basılı tutun.\n"
                    );
            text3.setText("Geliştiren: \nHA.OverFlow  ");

    }


     else if(Main.getlang()=="fr") {
            text1.setText("Instructions");
            text2.setText("1- Choisissez la taille du chapelet dans le ruban coulissant.\n" +
                    "2- Laisser le chapelet flotter pour fonctionner avec d'autres programmes.\n" +
                    "3- Sélectionnez la couleur que vous aimez.\n" +
                    "4- Cliquez sur le bouton flottant et commencez la louange.\n" +
                    "\n" +
                    "Pour réaffecter le chapelet: appuyez pendant deux secondes puis faites-le glisser vers le bas");
            text3.setText("Développé par: \nHA.OverFlow  ");

    }


     else if(Main.getlang()=="in") {
            text1.setText("Instruksi");
            text2.setText("1- Pilih ukuran rosario dari selotip.\n" +
                    "2 - Biarkan rosario mengapung untuk bekerja dengan program lain.\n" +
                    "3- Pilih warna yang Anda suka.\n" +
                    "4- Klik tombol mengambang dan mulai pujian.\n" +
                    "\n" +
                    "Untuk menetapkan kembali rosario: Tekan selama dua detik lalu seret ke bawah");
            text3.setText("Dikembangkan oleh: \nHA.OverFlow  ");

    }
     else if(Main.getlang()=="ard") {
            text1.setText("ہدایات");
            text2.setText("1- سلائیڈنگ ٹیپ سے مالا کا سائز منتخب کریں۔\n" +
                    "2- مالا کو دوسرے پروگراموں کے ساتھ کام کرنے کے لئے تیرنے دیں۔\n" +
                    "3- اپنی پسند کا رنگ منتخب کریں۔\n" +
                    "4- تیرتے بٹن پر کلک کریں اور تعریف شروع کریں۔\n" +
                    "\n" +
                    "مالا کو دوبارہ تفویض کرنے کے لئے: دو سیکنڈ کے لئے دبائیں اور پھر اسے نیچے گھسیٹیں");
            text3.setText("تیار کردہ منجانب: \nHA.OverFlow  ");

    }

        else {
            text1.setText("المعلومات");
            text2.setText("1للتسبيح الجماعي، قم بالنقر على ^تسبيح جماعي^ من القائمة الرئيسية واختر المجموعة اللتي ترغب التسبيح بها.\n 2للتسبيح بالمسبحة العائمة قم باختيار حجم المسبحة من الشريط المنزلق\n3 قم بالسماح للمسبحة بالعوم لتعمل مع البرامج الاخرى\n 4 قم باختيار اللون اللذي تحب\n 4 اضغط زر التعويم وابدأ التسبيح\n\nلاغلاق المسبحة: اضغط لمدة ثانيتين عليها ثم اسحبها للأسفل* \n");
            text3.setText("تم التطوير بواسطة: \nHA.OverFlow  ");


        }







}






}
