package app.magiscamp.animationflip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int splashInterval = 2000;
    private static int splashIntervalDua = 1000;

    CardView cv, cv2, cv3, cv4, cv5, cv6,
            cv_tiru, cv2_tiru, cv3_tiru, cv4_tiru, cv5_tiru, cv6_tiru,
            cvFinal, cv2Final, cv3Final;
    RelativeLayout relCv, relCv2, relCv3, relCv4,  relCv5, relCv6,
            relCvTiru, relCv2Tiru, relCv3Tiru, relCv4Tiru, relCv5Tiru, relCv6Tiru;
    LinearLayout nextLay;
    TextView countDownTimer;

    SharedPreferences prefs;
    SharedPreferences.Editor mEditor;
    Intent i;

    Button nextBtn;
    ImageView medsel, diksel;

    CountDownTimer timer;
    long remainingtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // SharedPreferences
        i = new Intent(getApplicationContext(), secondbonus.class);
        prefs = getSharedPreferences("quizData", MODE_PRIVATE);
        mEditor = prefs.edit();

        countDownTimer = (TextView) findViewById(R.id.countDownTimer);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        medsel = (ImageView) findViewById(R.id.medsel);
        diksel = (ImageView) findViewById(R.id.diksel);
        nextLay = (LinearLayout) findViewById(R.id.nextLay);

        // Button GONE
        nextLay.setVisibility(View.GONE);
        diksel.setVisibility(View.GONE);
        medsel.setVisibility(View.GONE);

        // Pengganti CardView
        cvFinal = (CardView) findViewById(R.id.cvFinal);
        cv2Final = (CardView) findViewById(R.id.cv2Final);
        cv3Final = (CardView) findViewById(R.id.cv3Final);

        // Relative CardView Blank
        relCvTiru = (RelativeLayout) findViewById(R.id.relCvTiru);
        relCv2Tiru = (RelativeLayout) findViewById(R.id.relCv2Tiru);
        relCv3Tiru = (RelativeLayout) findViewById(R.id.relCv3Tiru);
        relCv4Tiru = (RelativeLayout) findViewById(R.id.relCv4Tiru);
        relCv5Tiru = (RelativeLayout) findViewById(R.id.relCv5Tiru);
        relCv6Tiru = (RelativeLayout) findViewById(R.id.relCv6Tiru);

        // Relative CardView
        relCv = (RelativeLayout) findViewById(R.id.relCv);
        relCv2 = (RelativeLayout) findViewById(R.id.relCv2);
        relCv3 = (RelativeLayout) findViewById(R.id.relCv3);
        relCv4 = (RelativeLayout) findViewById(R.id.relCv4);
        relCv5 = (RelativeLayout) findViewById(R.id.relCv5);
        relCv6 = (RelativeLayout) findViewById(R.id.relCv6);

        // CardView
        cv = (CardView) findViewById(R.id.cv);
        cv2 = (CardView) findViewById(R.id.cv2);
        cv3 = (CardView) findViewById(R.id.cv3);
        cv4 = (CardView) findViewById(R.id.cv4);
        cv5 = (CardView) findViewById(R.id.cv5);
        cv6 = (CardView) findViewById(R.id.cv6);

        // CardView Blank
        cv_tiru = (CardView) findViewById(R.id.cv_tiru);
        cv2_tiru = (CardView) findViewById(R.id.cv2_tiru);
        cv3_tiru = (CardView) findViewById(R.id.cv3_tiru);
        cv4_tiru = (CardView) findViewById(R.id.cv4_tiru);
        cv5_tiru = (CardView) findViewById(R.id.cv5_tiru);
        cv6_tiru = (CardView) findViewById(R.id.cv6_tiru);

        // CardView Visibility GONE
        cv_tiru.setVisibility(View.GONE);
        cv2_tiru.setVisibility(View.GONE);
        cv3_tiru.setVisibility(View.GONE);
        cv4_tiru.setVisibility(View.GONE);
        cv5_tiru.setVisibility(View.GONE);
        cv6_tiru.setVisibility(View.GONE);
        cvFinal.setVisibility(View.INVISIBLE);
        cv2Final.setVisibility(View.INVISIBLE);
        cv3Final.setVisibility(View.INVISIBLE);

        // Default Relative False
        relCv.setClickable(false);
        relCv2.setClickable(false);
        relCv3.setClickable(false);
        relCv4.setClickable(false);
        relCv5.setClickable(false);
        relCv6.setClickable(false);

        // CountDown Timer Aktif Ketika CardView Terbuka
        timer = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                countDownTimer.setText("" + millisUntilFinished / 1000);
                remainingtime = millisUntilFinished;
            }

            public void onFinish() {
                Intent a = new Intent(getApplicationContext(), secondbonus.class);
                mEditor.putString("scoreBonus", "0.0");
                mEditor.commit();
                startActivity(a);
                finish();
            }
        };

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // CardView Terbuka
                cv.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        cv.setVisibility(View.GONE);
                        cv_tiru.setRotationY(-90);
                        cv_tiru.setVisibility(View.VISIBLE);
                        cv_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                    }
                });
                cv2.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        cv2.setVisibility(View.GONE);
                        cv2_tiru.setRotationY(-90);
                        cv2_tiru.setVisibility(View.VISIBLE);
                        cv2_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                    }
                });
                cv3.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        cv3.setVisibility(View.GONE);
                        cv3_tiru.setRotationY(-90);
                        cv3_tiru.setVisibility(View.VISIBLE);
                        cv3_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                    }
                });
                cv4.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        cv4.setVisibility(View.GONE);
                        cv4_tiru.setRotationY(-90);
                        cv4_tiru.setVisibility(View.VISIBLE);
                        cv4_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                    }
                });
                cv5.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        cv5.setVisibility(View.GONE);
                        cv5_tiru.setRotationY(-90);
                        cv5_tiru.setVisibility(View.VISIBLE);
                        cv5_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                    }
                });
                cv6.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        cv6.setVisibility(View.GONE);
                        cv6_tiru.setRotationY(-90);
                        cv6_tiru.setVisibility(View.VISIBLE);
                        cv6_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                    }
                });
                relCv.setClickable(true);
                relCv2.setClickable(true);
                relCv3.setClickable(true);
                relCv4Tiru.setClickable(false);
                relCv5Tiru.setClickable(false);
                relCv6Tiru.setClickable(false);

                timer.start();
            }
        }, splashInterval);

        // Next Button
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle timetransfer = new Bundle();
                timetransfer.putLong("timer", remainingtime);
                i.putExtras(timetransfer);
                mEditor.putString("scoreBonus", "33.3");
                mEditor.commit();
                startActivity(i);
                finish();
            }
        });
    }

    public void pauseLay(View v){
        timer.cancel();
        // Your Pause Layout
//        game_pause gamePause = new game_pause(this);
//        gamePause.show();
    }

    // Gambar
    // CardView Pertama
    public void meQuesOne(View view){
        cv.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv.setVisibility(View.GONE);
                cv_tiru.setRotationY(-90);
                cv_tiru.setVisibility(View.VISIBLE);
                cv_tiru.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCv2Tiru.setClickable(true);
        relCv3Tiru.setClickable(true);
    }
    public void meQuesTiruOne(View view){
        cv_tiru.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv_tiru.setVisibility(View.GONE);
                cv.setRotationY(-90);
                cv.setVisibility(View.VISIBLE);
                cv.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCv2Tiru.setClickable(false);
        relCv3Tiru.setClickable(false);
        relCv4Tiru.setClickable(true);
        relCv5Tiru.setClickable(true);
        relCv6Tiru.setClickable(true);
    }

    // CardView Kedua
    public void meQuesTwo(View view){
        cv2.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv2.setVisibility(View.GONE);
                cv2_tiru.setRotationY(-90);
                cv2_tiru.setVisibility(View.VISIBLE);
                cv2_tiru.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCvTiru.setClickable(true);
        relCv3Tiru.setClickable(true);
    }
    public void meQuesTiruTwo(View view){
        cv2_tiru.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv2_tiru.setVisibility(View.GONE);
                cv2.setRotationY(-90);
                cv2.setVisibility(View.VISIBLE);
                cv2.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCvTiru.setClickable(false);
        relCv3Tiru.setClickable(false);
        relCv4Tiru.setClickable(true);
        relCv5Tiru.setClickable(true);
        relCv6Tiru.setClickable(true);
    }

    // CardView Ketiga
    public void meQuesThree(View view){
        cv3.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv3.setVisibility(View.GONE);
                cv3_tiru.setRotationY(-90);
                cv3_tiru.setVisibility(View.VISIBLE);
                cv3_tiru.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCvTiru.setClickable(true);
        relCv2Tiru.setClickable(true);
    }
    public void meQuesTiruThree(View view){
        cv3_tiru.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv3_tiru.setVisibility(View.GONE);
                cv3.setRotationY(-90);
                cv3.setVisibility(View.VISIBLE);
                cv3.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCvTiru.setClickable(false);
        relCv2Tiru.setClickable(false);
        relCv4Tiru.setClickable(true);
        relCv5Tiru.setClickable(true);
        relCv6Tiru.setClickable(true);
    }


    // Teks
    // CardView Jawaban Pertama
    public void meAnsOne(View view){
        cv4.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv4.setVisibility(View.INVISIBLE);
                cv4_tiru.setRotationY(-90);
                cv4_tiru.setVisibility(View.VISIBLE);
                cv4_tiru.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCv5Tiru.setClickable(true);
        relCv6Tiru.setClickable(true);
    }
    public void meAnsTiruOne(View view){
        cv4_tiru.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv4_tiru.setVisibility(View.GONE);
                cv4.setRotationY(-90);
                cv4.setVisibility(View.VISIBLE);
                cv4.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        // Jika Jawaban Benar
        if (cv2.getVisibility() == View.VISIBLE){
            relCvTiru.setClickable(true);
            relCv2.setClickable(false);
            relCv3Tiru.setClickable(true);
            relCv4.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
            cv2.setVisibility(View.GONE);
            cv2Final.setVisibility(View.VISIBLE);

            if(medsel.getVisibility() == View.VISIBLE){
                medsel.setVisibility(View.GONE);
                nextLay.setVisibility(View.VISIBLE);
                timer.cancel();
            }else if (diksel.getVisibility() == View.GONE){
                diksel.setVisibility(View.VISIBLE);
            }else if(diksel.getVisibility() == View.VISIBLE){
                diksel.setVisibility(View.GONE);
                medsel.setVisibility(View.VISIBLE);
            }else{
                diksel.setVisibility(View.GONE);
                medsel.setVisibility(View.GONE);
                nextLay.setVisibility(View.GONE);
            }
        }else if (cv.getVisibility() == View.VISIBLE){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cv.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv.setVisibility(View.GONE);
                            cv_tiru.setRotationY(-90);
                            cv_tiru.setVisibility(View.VISIBLE);
                            cv_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                    cv4.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv4.setVisibility(View.INVISIBLE);
                            cv4_tiru.setRotationY(-90);
                            cv4_tiru.setVisibility(View.VISIBLE);
                            cv4_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                }
            }, splashIntervalDua);
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
        }else if (cv3.getVisibility() == View.VISIBLE) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cv3.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv3.setVisibility(View.GONE);
                            cv3_tiru.setRotationY(-90);
                            cv3_tiru.setVisibility(View.VISIBLE);
                            cv3_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                    cv4.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv4.setVisibility(View.INVISIBLE);
                            cv4_tiru.setRotationY(-90);
                            cv4_tiru.setVisibility(View.VISIBLE);
                            cv4_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                }
            }, splashIntervalDua);
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
        }
    }

    // CardView Jawaban Kedua
    public void meAnsTwo(View view){
        cv5.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv5.setVisibility(View.INVISIBLE);
                cv5_tiru.setRotationY(-90);
                cv5_tiru.setVisibility(View.VISIBLE);
                cv5_tiru.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCv4Tiru.setClickable(true);
        relCv6Tiru.setClickable(true);
    }
    public void meAnsTiruTwo(View view){
        cv5_tiru.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv5_tiru.setVisibility(View.GONE);
                cv5.setRotationY(-90);
                cv5.setVisibility(View.VISIBLE);
                cv5.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        // Jika Jawaban Benar
        if (cv3.getVisibility() == View.VISIBLE){
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3.setClickable(false);
            relCv4Tiru.setClickable(false);
            relCv5.setClickable(false);
            relCv6Tiru.setClickable(false);
            cv3.setVisibility(View.GONE);
            cv3Final.setVisibility(View.VISIBLE);

            if(medsel.getVisibility() == View.VISIBLE){
                medsel.setVisibility(View.GONE);
                nextLay.setVisibility(View.VISIBLE);
                timer.cancel();
            }else if (diksel.getVisibility() == View.GONE){
                diksel.setVisibility(View.VISIBLE);
            }else if(diksel.getVisibility() == View.VISIBLE){
                diksel.setVisibility(View.GONE);
                medsel.setVisibility(View.VISIBLE);
            }else{
                diksel.setVisibility(View.GONE);
                medsel.setVisibility(View.GONE);
                nextLay.setVisibility(View.GONE);
            }
        }else if (cv2.getVisibility() == View.VISIBLE){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cv2.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv2.setVisibility(View.GONE);
                            cv2_tiru.setRotationY(-90);
                            cv2_tiru.setVisibility(View.VISIBLE);
                            cv2_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                    cv5.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv5.setVisibility(View.INVISIBLE);
                            cv5_tiru.setRotationY(-90);
                            cv5_tiru.setVisibility(View.VISIBLE);
                            cv5_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                }
            }, splashIntervalDua);
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
        }else if (cv.getVisibility() == View.VISIBLE){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cv.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv.setVisibility(View.GONE);
                            cv_tiru.setRotationY(-90);
                            cv_tiru.setVisibility(View.VISIBLE);
                            cv_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                    cv5.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv5.setVisibility(View.INVISIBLE);
                            cv5_tiru.setRotationY(-90);
                            cv5_tiru.setVisibility(View.VISIBLE);
                            cv5_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                }
            }, splashIntervalDua);
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
        }
    }

    // CardView Jawaban Ketiga
    public void meAnsThree(View view){
        cv6.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv6.setVisibility(View.INVISIBLE);
                cv6_tiru.setRotationY(-90);
                cv6_tiru.setVisibility(View.VISIBLE);
                cv6_tiru.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        relCv4Tiru.setClickable(true);
        relCv5Tiru.setClickable(true);
    }
    public void meAnsTiruThree(View view){
        cv6_tiru.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cv6_tiru.setVisibility(View.GONE);
                cv6.setRotationY(-90);
                cv6.setVisibility(View.VISIBLE);
                cv6.animate().rotationY(0).setDuration(200).setListener(null);
            }
        });
        // Jika Jawaban Benar
        if (cv.getVisibility() == View.VISIBLE){
            relCv.setClickable(false);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6.setClickable(false);
            cv.setVisibility(View.GONE);
            cvFinal.setVisibility(View.VISIBLE);

            if(medsel.getVisibility() == View.VISIBLE){
                medsel.setVisibility(View.GONE);
                nextLay.setVisibility(View.VISIBLE);
                timer.cancel();
            }else if (diksel.getVisibility() == View.GONE){
                diksel.setVisibility(View.VISIBLE);
            }else if(diksel.getVisibility() == View.VISIBLE){
                diksel.setVisibility(View.GONE);
                medsel.setVisibility(View.VISIBLE);
            }else{
                diksel.setVisibility(View.GONE);
                medsel.setVisibility(View.GONE);
                nextLay.setVisibility(View.GONE);
            }
        }else if (cv2.getVisibility() == View.VISIBLE){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cv2.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv2.setVisibility(View.GONE);
                            cv2_tiru.setRotationY(-90);
                            cv2_tiru.setVisibility(View.VISIBLE);
                            cv2_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                    cv6.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv6.setVisibility(View.INVISIBLE);
                            cv6_tiru.setRotationY(-90);
                            cv6_tiru.setVisibility(View.VISIBLE);
                            cv6_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                }
            }, splashIntervalDua);
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
        }else if (cv3.getVisibility() == View.VISIBLE) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cv3.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv3.setVisibility(View.GONE);
                            cv3_tiru.setRotationY(-90);
                            cv3_tiru.setVisibility(View.VISIBLE);
                            cv3_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                    cv6.animate().rotationY(90).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            cv6.setVisibility(View.INVISIBLE);
                            cv6_tiru.setRotationY(-90);
                            cv6_tiru.setVisibility(View.VISIBLE);
                            cv6_tiru.animate().rotationY(0).setDuration(200).setListener(null);
                        }
                    });
                }
            }, splashIntervalDua);
            relCvTiru.setClickable(true);
            relCv2Tiru.setClickable(true);
            relCv3Tiru.setClickable(true);
            relCv4Tiru.setClickable(false);
            relCv5Tiru.setClickable(false);
            relCv6Tiru.setClickable(false);
        }
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
    }
}