package com.hllbr.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
Bu yapı daha çok oyunlarda kullanıyor fakat illa oyunla kullanılacak diye bir durum yok birşeyi geri saydırmak için de kullanılabilir.

kullanıcının 30 saniye içerisinde birşey yapmasını bekleyebilir yada isteyebilirim...

 */
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        //CountDownTimer nasıl oluşturulur ? Bu yapıyı bir obje olarakta tanımlamam mümkün fakat bunun yerine genellikle alttaki yöntem tercih edilir.

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                //ConutDonwInterval yani her bir saniyede bir ne yapayım sorusu soruyor program ve biz ne tür bir işlem gerçekleştirilmesini istiyorsak onu bu alana yazıyoruz

                //metodun isim tanımlaması android tarafından daha önce birçok kez değiştirildi ileridede değiştirilebilir.

                textView.setText("Left " +millisUntilFinished/1000);//sonucun saniye cinsinden kullanıcıya gösterilmesi için bu şekilde bir bölme işlemi gerçekleştirdim.


            }

            @Override
            public void onFinish() {
                //Sayma işlemi bittiğinde gerçekleştirilmesini istediğim işlemleri bu alanda ifade ediyorum
                Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_LONG).show();
                textView.setText("Finished!!");


            }
        }.start();//birinci parametre milisaniye olarak bu zamanlayıcının kaç saniye sayacağı soruluyor .10 sn için 10000 olarak ifade etmem gerekiyor.İkinci parametre ise nasıl bir aralıkta saymasını istediğimizi ifade ediyor saniyede bir saymasını istiyorsam 1000 olarak ifade etmeme yeterli olacaktır.


    }
}