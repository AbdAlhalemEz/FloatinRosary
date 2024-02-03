package ha.tw.masbaha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.File;
import java.util.Locale;


public class Main extends Activity {
	public static int OVERLAY_PERMISSION_REQ_CODE_CHATHEAD = 1234;
	public static Button  share;
	public static Button red;
	public static Button blue;
	public static Button green;
	public static Button pink;
	public static Button dpink;
	public static Button yellow;
	public static Button mini;
	public static Button bt;
	public static Button data;
	public static Button m1;
	public static Button m2;
	public static Button reset;
	public static Button online;

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Main.x = x;
	}


	public static int x;
	public static int qq;
	public static String co;
	public static String t1;
	public static String transP;
	public static String lang;
	public static Double w;
    public static Spinner spinner;

	public boolean connected = false;

	DBHelper DB;
	DBHelper1 DB1;
	DBHelper2 DB2;


	public static int getV1() {
        return v1;
    }


	public static String getlang() {
		return lang;
	}


	public static int Pass;
	public static int getPass() {
		return Pass;
	}

	public static void setPass(int Pass) {
		Main.Pass = Pass;
	}


	public String size;


	public static int v1,v2;
	private int in1;
	private double in2;
	private InterstitialAd mInterstitialAd;

	public Switch switch1;
	public TextView share1;
	public TextView statistics;
	public TextView instructions;
	public TextView size1;
	public TextView color1;
	public TextView trans1;
	public TextView type1;
	public TextView sh1;

	private AdView mAdView;
	private AdView mAdView1;
	private AdView mAdView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);









		SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
		boolean firstStart = prefs.getBoolean("firstStart", true);





		DB = new DBHelper(this);
		DB1 = new DBHelper1(this);
		DB2 = new DBHelper2(this);





		if (firstStart) {

			showStartDialog();
		String x = Locale.getDefault().getLanguage();
			if(x=="ar")
				DB1.insertuserdata(1);
			else if(x=="en")
				DB1.insertuserdata(2);
			else  if(x=="fr")
				DB1.insertuserdata(3);
			else  if(x=="tr")
				DB1.insertuserdata(4);
			else if(x=="id")
				DB1.insertuserdata(5);
			else   if(x=="ur")
				DB1.insertuserdata(6);
			else{
				DB1.insertuserdata(2);
			}
			// 	DB2.updateuserdata("0", size,transP,s1,co);

			size = String.valueOf(333);
			transP = String.valueOf(0.44);
			t1="s2";
			co="red";

			DB2.insertuserdata("0", size,transP,t1,co);

			DB.insertuserdata(1, 0);

		}


if(!firstStart) {

	if (!Utils.canDrawOverlays(Main.this)) {
		showStartDialog1();
	}


}



		Cursor resN = DB2.getdata();
		resN.moveToLast();
		v1=Main.getV1();
		co=  resN.getString(4);
		t1=  resN.getString(3);
		size=resN.getString(1);
		transP =resN.getString(2);





		ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

		if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q){
			if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
					connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
				//we are connected to a network
				connected = true;

			}
			else
				connected = false;
		}

		else if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){




			NetworkRequest.Builder builder = new NetworkRequest.Builder();

			connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {
				@Override
				public void onAvailable(Network network) {
					connected = true; // Global Static Variable
				}
				@Override
				public void onLost(Network network) {
					connected = false; // Global Static Variable
				}
			});}





	/*	Cursor res1 = DB2.getdata();
		res1.moveToLast();

		in1 = Integer.parseInt(res1.getString(1));
		in2 =Double.parseDouble(res1.getString(2)) ;
		s1 = res1.getString(3);
		co= res1.getString(4);
*/













		Cursor res1 = DB.getdata();
		res1.moveToLast();
		Pass = Integer.parseInt(res1.getString(1));
		v2=1;











		MobileAds.initialize(this, new OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(InitializationStatus initializationStatus) {}
		});
















        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8157110153359056/2969084863");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //stop adds
		//mInterstitialAd.show();
/*
		if (mInterstitialAd.isLoaded()) {
			mInterstitialAd.show();
		} else {
			Log.d("TAG", "The interstitial wasn't loaded yet.");
		}
*/





















		MobileAds.initialize(this, new OnInitializationCompleteListener() {


				@Override
				public void onInitializationComplete(InitializationStatus initializationStatus) {
				}
			});









		mAdView = findViewById(R.id.adView);
			AdRequest adRequest = new AdRequest.Builder().build();
			// adds stop
		//	mAdView.loadAd(adRequest);





		mAdView1 = findViewById(R.id.adView1);
		AdRequest adRequest1 = new AdRequest.Builder().build();
		// adds stop
	//	mAdView1.loadAd(adRequest1);



	//	mAdView2 = findViewById(R.id.adView2);
		AdRequest adRequest2 = new AdRequest.Builder().build();
		// adds stop
	//	mAdView2.loadAd(adRequest2);





































		SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
		final TextView seekBarValue = (TextView)findViewById(R.id.textView);

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
										  boolean fromUser) {
				// TODO Auto-generated method stub
				seekBarValue.setText(String.valueOf(progress));
				in1 = Integer.valueOf(seekBarValue.getText().toString())+200;
			    setX(in1);
				size= String.valueOf(in1);
				DB2.updateuserdata("0", size,transP,t1,co);
				stopChatHead();
				startChatHead();


				if(Utils.canDrawOverlays(Main.this)) {
					{
						stopChatHead();
						startChatHead();
					}
				}
				else{
					requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub




			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub




			}

		});



		SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
		final TextView seekBarValue2 = (TextView)findViewById(R.id.textView2);

		seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar seekBar2, int progress,
										  boolean fromUser) {
				// TODO Auto-generated method stub
				seekBarValue2.setText(String.valueOf(progress));
				in2 = Integer.valueOf(seekBarValue2.getText().toString())/200.0;
				 transP = Double.toString(in2);

				DB2.updateuserdata("0", size,transP,t1,co);


				if(Utils.canDrawOverlays(Main.this)) {
					{
						stopChatHead();
						startChatHead();
					}
				}
				else{
					requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);

				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar2) {
				// TODO Auto-generated method stub


			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar2) {
				// TODO Auto-generated method stub

			}


		});














		share = (Button) findViewById(R.id.share1);
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				share = (Button) findViewById(R.id.share1);
				share.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {



						Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
						sharingIntent.setType("text/plain");
						String shareBody = "أفضل برنامج مسبحة الكترونية, تمكنك من التسبيح خلال استخدامك اي برنامج آخر \n رابط التحميل : \n https://play.google.com/store/apps/details?id=halim.Masbaha \n لا تنسونا من صالح الدعاء";
						sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "المسبحة العائمة");
						sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
						startActivity(Intent.createChooser(sharingIntent, "مشاركة عبر"));

					}

				});

			}

		});



		online = (Button) findViewById(R.id.online);
		online.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


			//	mInterstitialAd.show();
				Intent i = new Intent(Main.this, multi.class);


				if(connected)
				startActivity(i);
				else{
					Toast toast = Toast.makeText(getApplicationContext(),
							"لست متصل بالانترنت",
							Toast.LENGTH_LONG);

					toast.show();

					finish();
					startActivity(getIntent());

				}
			}

		});










	bt = (Button) findViewById(R.id.bt);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


			//	mInterstitialAd.show();
				Intent i = new Intent(Main.this, inst.class);
				startActivity(i);
			}

		});




		 spinner = (Spinner)findViewById(R.id.spinner);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {



				String text = spinner.getSelectedItem().toString();
				int iCurrentSelection = spinner.getSelectedItemPosition();



              //language


                int l;
                String lang;
					Cursor res = DB1.getdata();
					res.moveToLast();
					 lang= res.getString(0);
					l = Integer.parseInt(lang);






				if(iCurrentSelection==0) {





					if (l == 1) {
						lang = "ar";
						switch1.setText("الاهتزاز");
						share1.setText("مشاركه");
						instructions.setText("التعليمات");
						statistics.setText("الاحصاءات");
					//	customize.setText("تخصيص");
						color1.setText("لون المسبحة");
						size1.setText("حجم المسبحة");
						sh1.setText("الشفافية");
						type1.setText("نوع المسبحة");
						mini.setText("تعويم");
						trans1.setText("تصفير");
						online.setText("تسبيح جماعي");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);




					} else if (l == 2) {
						lang = "en";
						switch1.setText("Vibration");
						share1.setText("Share");
						instructions.setText("Instructions");
						statistics.setText("Statistics");
						//customize.setText("Customize");
						color1.setText("Color");
						size1.setText("Size");
						sh1.setText("Transparency");
						type1.setText("type");
						mini.setText("Float");
						trans1.setText("reset");
						online.setText("Online collective praise");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

					} else if (l == 3) {
						lang = "fr";
						switch1.setText("Vibration");
						share1.setText("Partagez");
						instructions.setText("Instructions");
						statistics.setText("Statistiques");
					//	customize.setText("Personnaliser");
						color1.setText("Couleur du chapelet");
						size1.setText("La taille du chapelet");
						sh1.setText("La transparence");
						type1.setText("Type de chapelet");
						mini.setText("Flotter");
						trans1.setText("réinitialiser");
						online.setText("Louange de groupe en ligne");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

					} else if (l == 4) {
						lang = "tu";
						switch1.setText("titreşim");
						share1.setText("katılım");
						instructions.setText("Yardım");
						statistics.setText("istatistik");
					//	customize.setText("özelleştirme");
						color1.setText("Tespih rengi");
						size1.setText("Tespih büyüklüğü");
						sh1.setText("şeffaflık");
						type1.setText("Tesbih türü");
						mini.setText("şamandıra");
						trans1.setText("Sıfırla");
						online.setText("Çevrimiçi grup övgü");
					} else if (l == 5) {
						lang = "in";
						switch1.setText("Getaran");
						share1.setText("Bagikan");
						instructions.setText("Instruksi");
						statistics.setText("Statistik");
					//	customize.setText("Sesuaikan");
						color1.setText("Warna rosario");
						size1.setText("Ukuran rosario");
						sh1.setText("Transparansi");
						type1.setText("Tipe rosario");
						mini.setText("Mengapung");
						trans1.setText("atur ulang");
						online.setText("Pujian grup online");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

					} else if (l == 6) {
						lang = "ard";
						switch1.setText("لرز اٹھنا");
						share1.setText("شیئر کریں");
						share1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						instructions.setText("ہدایات");
						instructions.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						statistics.setText("اعدادوشمار");
						statistics.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						//customize.setText("تخصیص کریں");
						color1.setText("گلابی رنگ");
						//customize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						trans1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						size1.setText("شفافیت");
						sh1.setText("مالا کا سائز");
						type1.setText("مالا کی قسم");
						mini.setText("فلوٹ");
						trans1.setText("دوبارہ\nترتیب دیں");
						online.setText("آن لائن گروپ کی تعریف");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
					}
					else {


						if (Locale.getDefault().getLanguage() == "ar") {
							lang = "ar";
							switch1.setText("الاهتزاز");
							share1.setText("مشاركه");
							instructions.setText("التعليمات");
							statistics.setText("الاحصاءات");
							//customize.setText("تخصيص");
							color1.setText("لون المسبحة");
							size1.setText("حجم المسبحة");
							sh1.setText("الشفافية");
							type1.setText("نوع المسبحة");
							mini.setText("تعويم");
							trans1.setText("تصفير");
							online.setText("تسبيح جماعي");
							online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


						} else if (Locale.getDefault().getLanguage() == "en") {
							lang = "en";
							switch1.setText("Vibration");
							share1.setText("Share");
							instructions.setText("Instructions");
							statistics.setText("Statistics");
							//customize.setText("Customize");
							color1.setText("Color");
							size1.setText("Size");
							sh1.setText("Transparency");
							type1.setText("type");
							mini.setText("Float");
							trans1.setText("reset");
							online.setText("Online collective praise");
							online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

						} else if (Locale.getDefault().getLanguage() == "fr") {
							lang = "fr";
							switch1.setText("Vibration");
							share1.setText("Partagez");
							instructions.setText("Instructions");
							statistics.setText("Statistiques");
							//customize.setText("Personnaliser");
							color1.setText("Couleur du chapelet");
							size1.setText("La taille du chapelet");
							sh1.setText("La transparence");
							type1.setText("Type de chapelet");
							mini.setText("Flotter");
							trans1.setText("réinitialiser");
							online.setText("Louange de groupe en ligne");
							online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

						} else if (Locale.getDefault().getLanguage() == "tr") {
							lang = "tu";
							switch1.setText("titreşim");
							share1.setText("katılım");
							instructions.setText("Yardım");
							statistics.setText("istatistik");
						//	customize.setText("özelleştirme");
							color1.setText("Tespih rengi");
							size1.setText("Tespih büyüklüğü");
							sh1.setText("şeffaflık");
							type1.setText("Tesbih türü");
							mini.setText("şamandıra");
							trans1.setText("Sıfırla");
							online.setText("Çevrimiçi grup övgü");
						} else if (Locale.getDefault().getLanguage() == "id") {
							lang = "in";
							switch1.setText("Getaran");
							share1.setText("Bagikan");
							instructions.setText("Instruksi");
							statistics.setText("Statistik");
						//	customize.setText("Sesuaikan");
							color1.setText("Warna rosario");
							size1.setText("Ukuran rosario");
							sh1.setText("Transparansi");
							type1.setText("Tipe rosario");
							mini.setText("Mengapung");
							trans1.setText("atur ulang");
							online.setText("Pujian grup online");
							online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

						} else if (Locale.getDefault().getLanguage() == "ur") {
							lang = "ard";
							switch1.setText("لرز اٹھنا");
							share1.setText("شیئر کریں");
							share1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
							instructions.setText("ہدایات");
							instructions.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
							statistics.setText("اعدادوشمار");
							statistics.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						//	customize.setText("تخصیص کریں");
							color1.setText("گلابی رنگ");
						//	customize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
							trans1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
							size1.setText("شفافیت");
							sh1.setText("مالا کا سائز");
							type1.setText("مالا کی قسم");
							mini.setText("فلوٹ");
							trans1.setText("دوبارہ\nترتیب دیں");
							online.setText("آن لائن گروپ کی تعریف");
							online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);


						} else {
							lang = "en";
							switch1.setText("Vibration");
							share1.setText("Share");
							instructions.setText("Instructions");
							statistics.setText("Statistics");
						//	customize.setText("Customize");
							color1.setText("Color");
							size1.setText("Size");
							sh1.setText("Transparency");
							type1.setText("type");
							mini.setText("Float");
							trans1.setText("reset");
							online.setText("Online collective praise");
							online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

						}
					}
				}


				if(iCurrentSelection!=0){


					if(iCurrentSelection==1){

						lang="ar";
					DB1.insertuserdata(1);
						switch1.setText("الاهتزاز");
						share1.setText("مشاركه");
						instructions.setText("التعليمات");
						statistics.setText("الاحصاءات");
					//	customize.setText("تخصيص");
						color1.setText("لون المسبحة");
						size1.setText("حجم المسبحة");
						sh1.setText("الشفافية");
						type1.setText("نوع المسبحة");
						mini.setText("تعويم");
						trans1.setText("تصفير");
						online.setText("تسبيح جماعي");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


					}

					else if(iCurrentSelection==2){
						lang="en";

						DB1.insertuserdata(2);
						switch1.setText("Vibration");
						share1.setText("Share");
						instructions.setText("Instructions");
						statistics.setText("Statistics");
					//	customize.setText("Customize");
						color1.setText("Color");
						size1.setText("Size");
						sh1.setText("Transparency");
						type1.setText("type");
						mini.setText("Float");
						trans1.setText("reset");
						online.setText("Online collective praise");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

					}

					else if(iCurrentSelection==3){
						lang="fr";
				 		DB1.insertuserdata(3);
						switch1.setText("Vibration");
						share1.setText("Partagez");
						instructions.setText("Instructions");
						statistics.setText("Statistiques");
					//	customize.setText("Personnaliser");
						color1.setText("Couleur du chapelet");
						size1.setText("La taille du chapelet");
						sh1.setText("La transparence");
						type1.setText("Type de chapelet");
						mini.setText("Flotter");
						trans1.setText("réinitialiser");
						online.setText("Louange de groupe en ligne");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

					}
					else if(iCurrentSelection==4){
						lang="tu";
				 		DB1.insertuserdata(4);
						switch1.setText("titreşim");
						share1.setText("katılım");
						instructions.setText("Yardım");
						statistics.setText("istatistik");
					//	customize.setText("özelleştirme");
						color1.setText("Tespih rengi");
						size1.setText("Tespih büyüklüğü");
						sh1.setText("şeffaflık");
						type1.setText("Tesbih türü");
						mini.setText("şamandıra");
						trans1.setText("Sıfırla");
						online.setText("Çevrimiçi grup övgü");
					}
					else if(iCurrentSelection==5){
						lang="in";
					 	DB1.insertuserdata(5);
						switch1.setText("Getaran");
						share1.setText("Bagikan");
						instructions.setText("Instruksi");
						statistics.setText("Statistik");
					//	customize.setText("Sesuaikan");
						color1.setText("Warna rosario");
						size1.setText("Ukuran rosario");
						sh1.setText("Transparansi");
						type1.setText("Tipe rosario");
						mini.setText("Mengapung");
						trans1.setText("atur ulang");
						online.setText("Pujian grup online");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

					}

					else if(iCurrentSelection==6){
						lang="ard";
					 	DB1.insertuserdata(6);
						switch1.setText("لرز اٹھنا");
						share1.setText("شیئر کریں");
						share1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						instructions.setText("ہدایات");
						instructions.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						statistics.setText("اعدادوشمار");
						statistics.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
					//	customize.setText("تخصیص کریں");
						color1.setText("گلابی رنگ");
					//	customize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						trans1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
						size1.setText("شفافیت");
						sh1.setText("مالا کا سائز");
						type1.setText("مالا کی قسم");
						mini.setText("فلوٹ");
						trans1.setText("دوبارہ\nترتیب دیں");
						online.setText("آن لائن گروپ کی تعریف");
						online.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

					}
				}








			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// your code here
			}

		});




























		v1=0;

        switch1 = (Switch) findViewById(R.id.switch1);
		share1 = (TextView) findViewById(R.id.share2);
		statistics = (TextView) findViewById(R.id.statistics);
	//	customize = (TextView) findViewById(R.id.customize);
		sh1 = (TextView) findViewById(R.id.sh1);
		instructions = (TextView) findViewById(R.id.instructions);
		size1 = (TextView) findViewById(R.id.size1);
		type1 = (TextView) findViewById(R.id.type1);
		color1 = (TextView) findViewById(R.id.color1);
		trans1 = (TextView) findViewById(R.id.trans1);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()){
                    v1=1;


                    stopChatHead();
                    startChatHead();

                }
                else{
                    v1=0;

                    stopChatHead();
                    startChatHead();
                }
            }
        });










	    data = (Button)findViewById(R.id.data);
		data.setOnClickListener(data1);




	    reset = (Button)findViewById(R.id.reset);


	    m2 = (Button)findViewById(R.id.m2);
	    m1 = (Button)findViewById(R.id.m1);


	    red = (Button)findViewById(R.id.red);
		red.setOnClickListener(red1);

		blue = (Button)findViewById(R.id.blue);
		blue.setOnClickListener(blue1);

		green = (Button)findViewById(R.id.green);
		green.setOnClickListener(green1);

		  pink = (Button)findViewById(R.id.pink);
		pink.setOnClickListener(pink1);

		yellow = (Button)findViewById(R.id.yellow);
		yellow.setOnClickListener(yellow1);

		  dpink = (Button)findViewById(R.id.Dpink);
		dpink.setOnClickListener(dpink1);


  mini = (Button)findViewById(R.id.mini);
		mini.setOnClickListener(mini1);





		m1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
/*
				if(!Utils.canDrawOverlays(Main.this))
				{
					requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
				}
				// TODO Auto-generated method stub
				*/


				//	mInterstitialAd.show();
					t1 = "s1";
					DB2.updateuserdata("0", size,transP,t1,co);

				if(Utils.canDrawOverlays(Main.this)) {
					{
						stopChatHead();
						startChatHead();
					}
				}
				else{
					requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
				}






			}
		});



		m2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if(!Utils.canDrawOverlays(Main.this))
				{
					requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
				}
				// TODO Auto-generated method stub
				else {

					t1 = "s2";

					DB2.updateuserdata("0", size,transP,t1,co);
					startChatHead();
					stopChatHead();
					startChatHead();
				}



			}
		});





		reset.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

		new CountDownTimer(100, 1) {

			public void onTick(long millisUntilFinished) {




				if(!Utils.canDrawOverlays(Main.this))
				{
					requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
				}
				// TODO Auto-generated method stub
				else {
					if (Pass != 0) {



						Cursor res = DB.getdata();
						res.moveToLast();
                        int x =  Integer.parseInt(res.getString(0))+1;
						DB.insertuserdata(x, 0);

/*
                        s="";
						String st22 ;
						String st21 ;
						Cursor c = DB.getdata();
						while (c.moveToNext()) {
							st22= c.getString(0);
							st21= c.getString(1);
							 s+= st22+" "+ st21 +"\n";

						}
						Toast toast = Toast.makeText(getApplicationContext(),
								s,
								Toast.LENGTH_LONG);
						toast.show();
						c.close();

*/







						Pass = 0;


					stopChatHead();

						startChatHead();


					}
					reset.setBackgroundResource(R.drawable.reset0);
				}
			}

			public void onFinish() {



				reset.setBackgroundResource(R.drawable.reset1);
			}
		}.start();



			}
		});
































	}

//end of on create





































































































	private void showStartDialog() {


		new AlertDialog.Builder(this)

				.setTitle("ما الجديد؟")

			// 	.setMessage("Name :"+res.getString(0)+"\n")
				.setMessage("صدقة جارية عن روح المرحوم عبد الحليم عزالدين\n الرجاء الدعاء له بالرحمة.")
				.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

						if(!Utils.canDrawOverlays(Main.this))
						{
							requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
						}
						dialog.dismiss();
					}
				})
				.create().show();

		SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("firstStart", false);
		editor.apply();
	}





	private void showStartDialog1() {


		new AlertDialog.Builder(this)

				.setTitle("تنبيه")

				// 	.setMessage("Name :"+res.getString(0)+"\n")
				.setMessage("يرجى السماح للتطبيق بعرض المسبحة حتى تعمل \n * قم بالبحث عن المسبحة بين التطبيقات وقم بتفعيلها.")
				.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

						if(!Utils.canDrawOverlays(Main.this))
						{
							requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
						}
						dialog.dismiss();
					}
				})
				.create().show();

		SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putBoolean("firstStart", false);
		editor.apply();
	}







	Button.OnClickListener mini1 = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {

            if(Utils.canDrawOverlays(Main.this)) {


                {



 size = Integer.toString(in1);
				 	double nb = in2/200.0;


				 //	DB2.updateuserdata("0", size,transP,s1,co);











                    stopChatHead();
                    startChatHead();
                    moveTaskToBack(true);
				//	mInterstitialAd.show();



                }
            }
            else{
                requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
            }









        }

    };







    Button.OnClickListener blue1 = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			if(!Utils.canDrawOverlays(Main.this))
			{
				requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
			}
			// TODO Auto-generated method stub
			else {

				co = "blue";
				//setX(in1);

				DB2.updateuserdata("0", size,transP,t1,co);
				stopChatHead();
				startChatHead();

			//	mInterstitialAd.show();

			}
		}

	};

	Button.OnClickListener pink1 = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			if(!Utils.canDrawOverlays(Main.this))
			{
				requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
			}
			// TODO Auto-generated method stub
			else {
				co = "pink";
			//	setX(in1);
				DB2.updateuserdata("0", size,transP,t1,co);

				stopChatHead();
				startChatHead();
		//		mInterstitialAd.show();
			}
		}

	};

	Button.OnClickListener red1 = new Button.OnClickListener(){




		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub


			if(!Utils.canDrawOverlays(Main.this))
			{
				requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
			}
			else {
			co = "red";
			DB2.updateuserdata("0", size,transP,t1,co);


				setX(in1);
				stopChatHead();
				startChatHead();
			//	mInterstitialAd.show();










			}


		}

	};

	Button.OnClickListener data1 = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
		//	mInterstitialAd.show();
			Intent i = new Intent(Main.this, data.class);
			startActivity(i);

		}

	};



	Button.OnClickListener yellow1 = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {

			if(!Utils.canDrawOverlays(Main.this))
			{
				requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
			}
			// TODO Auto-generated method stub
			else {
				co = "yellow";
			    DB2.updateuserdata("0", size,transP,t1,co);

				stopChatHead();
				startChatHead();
			//	mInterstitialAd.show();
			}
		}

	};

	Button.OnClickListener dpink1 = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {

			if(!Utils.canDrawOverlays(Main.this))
			{
				requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
			}
			else {
				// TODO Auto-generated method stub
				co = "darkpink";
				DB2.updateuserdata("0", size,transP,t1,co);

				stopChatHead();
				startChatHead();
			//	mInterstitialAd.show();
			}
		}

	};

	Button.OnClickListener green1 = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {

			if(!Utils.canDrawOverlays(Main.this))
			{
				requestPermission(OVERLAY_PERMISSION_REQ_CODE_CHATHEAD);
			}
			// TODO Auto-generated method stub
			else {
				co = "green";
				DB2.updateuserdata("0", size,transP,t1,co);

				stopChatHead();
				startChatHead();

			//	mInterstitialAd.show();
			}








		}

	};













	


	private void startChatHead(){
		startService(new Intent(Main.this, ChatHeadService.class));

	}
private void stopChatHead(){
		stopService(new Intent(Main.this, ChatHeadService.class));

	}





	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
	}

	private void requestPermission(int requestCode){
		Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
		intent.setData(Uri.parse("package:" + getPackageName()));
		startActivityForResult(intent, requestCode);
	}


	@Override
	protected void onStop() {
		super.onStop();  // Always call the superclass method first

		 size = Integer.toString(in1);
		//	double nb = in2/200.0;


	//	DB2.updateuserdata("0", size,transP,s1,co);

			}


}
