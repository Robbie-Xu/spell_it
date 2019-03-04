package com.example.spell_it;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    public static int counter = 0;
    public String[][] pic ={{"0","bear"},{"1","bird"},{"2","cat"},{"3","fish"},{"4","flower"},{"5","bee"},
            {"6","house"},{"7","lion"},{"8","pig"},{"9","sun"},{"10","tiger"},{"11","wolf"},{"12","leo"},
            {"13","elephant"},{"14","giraffe"},{"15","hypo"},{"16","kangaroo"},{"17","rhino"}};
    public static int pic_now = 0;
    public static String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static int life = 8;
    public static int toastflag = 0;
    Handler mHandler = new Handler();
    Runnable r = new Runnable() {

        @Override
        public void run() {
            life--;
            Log.w("life",String.valueOf(life));

            switch (life){
                case 7:
                    ((TextView)findViewById(R.id.t2)).setAlpha(0.0f);
                    break;
                case 6:
                    ((TextView)findViewById(R.id.t3)).setAlpha(0.0f);
                    break;
                case 5:
                    ((TextView)findViewById(R.id.t4)).setAlpha(0.0f);
                    break;
                case 4:
                    ((TextView)findViewById(R.id.t5)).setAlpha(0.0f);
                    break;
                case 3:
                    ((TextView)findViewById(R.id.t6)).setAlpha(0.0f);
                    break;
                case 2:
                    ((TextView)findViewById(R.id.t7)).setAlpha(0.0f);
                    break;
                case 1:
                    ((TextView)findViewById(R.id.t8)).setAlpha(0.0f);
                    break;
                case 0:
                    ((TextView)findViewById(R.id.t9)).setAlpha(0.0f);
                    break;


            }

            if(life>0){
                mHandler.postDelayed(this, 1000);
            }else{
                counter = 0;
                pic_now = 0;
                toastflag = 0;
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);//显示intent
                ((TextView)findViewById(R.id.t2)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t3)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t4)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t5)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t6)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t7)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t8)).setAlpha(1.0f);
                ((TextView)findViewById(R.id.t9)).setAlpha(1.0f);
                startActivity(intent);
                finish();
            }
//do something
//每隔1s循环执行run方法

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ChangeImage();
        ChangeText();
        life=8;
        mHandler.postDelayed(r, 100);


    }

    public int ChangeImage(){
        int id = 0;
        if(counter<5) {
            int rad = (int) (Math.random() * (13));

            for (int i = 0; i < 13; i++) {
                if (Integer.toString(rad).equals(pic[i][0])) {
                    id = i;
                }
            }
        }else{
            int rad = (int) (13+Math.random() * (5));
            if(toastflag==0) {
                Toast.makeText(getApplicationContext(), "it's getting more difficult", Toast.LENGTH_LONG).show();
                toastflag =1;
            }
            for (int i = 13; i < 18; i++) {
                if (Integer.toString(rad).equals(pic[i][0])) {
                    id = i;
                }
            }
        }
        ApplicationInfo appInfo = getApplicationInfo();
        ((ImageView)findViewById(R.id.imageView)).setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),getResources().getIdentifier(pic[id][1],"drawable",appInfo.packageName)));
        pic_now = id;
        return id;
    }

    public void ChangeText() {
        char[] arr = pic[pic_now][1].toCharArray();
        int len = arr.length;
        int[] num = {0,0,0,0,0,0,0,0,0};
        int[] flag = {0,0,0,0,0,0,0,0,0};
        for(int i = 0;i<len;i++){
            do {
                num[i] = (int) (1 + Math.random() * (9));

            }while (flag[num[i]-1]!=0);

            switch (num[i]){
                case 1:
                    ((Button) findViewById(R.id.button2)).setText(String.valueOf(arr[i]));
                    flag[0] = 1;
                    break;
                case 2:
                    ((Button) findViewById(R.id.button4)).setText(String.valueOf(arr[i]));
                    flag[1] = 1;
                    break;
                case 3:
                    ((Button) findViewById(R.id.button5)).setText(String.valueOf(arr[i]));
                    flag[2] = 1;
                    break;
                case 4:
                    ((Button) findViewById(R.id.button6)).setText(String.valueOf(arr[i]));
                    flag[3] = 1;
                    break;
                case 5:
                    ((Button) findViewById(R.id.button7)).setText(String.valueOf(arr[i]));
                    flag[4] = 1;
                    break;
                case 6:
                    ((Button) findViewById(R.id.button8)).setText(String.valueOf(arr[i]));
                    flag[5] = 1;
                    break;
                case 7:
                    ((Button) findViewById(R.id.button9)).setText(String.valueOf(arr[i]));
                    flag[6] = 1;
                    break;
                case 8:
                    ((Button) findViewById(R.id.button10)).setText(String.valueOf(arr[i]));
                    flag[7] = 1;
                    break;
                case 9:
                    ((Button) findViewById(R.id.button11)).setText(String.valueOf(arr[i]));
                    flag[8] = 1;
                    break;
            }
        }
        for(int i = 0;i<9;i++){
            if(flag[i]==0){
            int rado = (int)(Math.random() * (26));
                Log.w("rado",String.valueOf(rado));
                switch (i+1){
                    case 1:
                        ((Button) findViewById(R.id.button2)).setText(String.valueOf(alpha[rado]));
                        flag[0] = 1;
                        break;
                    case 2:
                        ((Button) findViewById(R.id.button4)).setText(String.valueOf(alpha[rado]));
                        flag[1] = 1;
                        break;
                    case 3:
                        ((Button) findViewById(R.id.button5)).setText(String.valueOf(alpha[rado]));
                        flag[2] = 1;
                        break;
                    case 4:
                        ((Button) findViewById(R.id.button6)).setText(String.valueOf(alpha[rado]));
                        flag[3] = 1;
                        break;
                    case 5:
                        ((Button) findViewById(R.id.button7)).setText(String.valueOf(alpha[rado]));
                        flag[4] = 1;
                        break;
                    case 6:
                        ((Button) findViewById(R.id.button8)).setText(String.valueOf(alpha[rado]));
                        flag[5] = 1;
                        break;
                    case 7:
                        ((Button) findViewById(R.id.button9)).setText(String.valueOf(alpha[rado]));
                        flag[6] = 1;
                        break;
                    case 8:
                        ((Button) findViewById(R.id.button10)).setText(String.valueOf(alpha[rado]));
                        flag[7] = 1;
                        break;
                    case 9:
                        ((Button) findViewById(R.id.button11)).setText(String.valueOf(alpha[rado]));
                        flag[8] = 1;
                        break;
                }
            }

        }

    }

    public void onClick(View view)
    {
        Button btn = findViewById(view.getId());
        String str = btn.getText().toString();
        ((TextView)findViewById(R.id.name_text)).setText(((TextView)findViewById(R.id.name_text)).getText()+str);
        str = ((TextView)findViewById(R.id.name_text)).getText().toString();

        if(str.equals(pic[pic_now][1])){
            ((TextView)findViewById(R.id.textView4)).setText("Score: "+String.valueOf(counter+1));
            counter++;
            life = 8;
            ((TextView)findViewById(R.id.t2)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t3)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t4)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t5)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t6)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t7)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t8)).setAlpha(1.0f);
            ((TextView)findViewById(R.id.t9)).setAlpha(1.0f);
            Log.w("lifeupdate",String.valueOf(life));
            ((TextView)findViewById(R.id.name_text)).setText("");
            if(counter>10){
                try
                {
                    //startActivity(new Intent("com.AndroidTest.SecondActivity"));//隐式intent
                    Intent intent = new Intent(this, Main3Activity.class);//显示intent
                    startActivity(intent);
                    finish();
                }
                catch (Exception ex)
                {
                    // 显示异常信息
                    Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
            ChangeImage();
            ChangeText();
        }


    }
    public void onClickDelet(View view)
    {
        ((TextView)findViewById(R.id.name_text)).setText("");
    }

}
