package com.example.whankung.socialherb.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whankung.socialherb.R;


/**
 * Created by Whankung on 31/1/2560.
 */
public class MainInvite extends AppCompatActivity {

    private Typeface font;
    TextView tvI,nameIn, i, i2, i3;
    ImageView img, i4, i5, i6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       setContentView(R.layout.stucture_invite);


        ImageView img= (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือกเภสัช
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });
        setView();
        setinvite();


    }




    private void setView() {
        i = (TextView) findViewById(R.id.name);
        i2 = (TextView) findViewById(R.id.name2);
        i3 = (TextView) findViewById(R.id.name3);
        tvI = (TextView) findViewById(R.id.textI);
        nameIn = (TextView) findViewById(R.id.invite);

        font = Typeface.createFromAsset(getAssets(), "tmedium.ttf");
        tvI.setTypeface(font);
        nameIn.setTypeface(font);

        i.setTypeface(font);
        i2.setTypeface(font);
        i3.setTypeface(font);

        img = (ImageView) findViewById(R.id.action_login);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);

            }
        });

        i.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                final View_popup dialog = new View_popup(MainInvite.this);
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                dialog.setContentView(R.layout.activity_popup);
//                dialog.setCancelable(true);

//                String strMsg = "คุณถูกรางวัลที่ 5";
//
//                final View_popup alertDialog = new View_popup(strMsg, "ตกลง");
//                alertDialog.mListener = MainInvite.this;
//                alertDialog.show(getActionBar(),"");

            }
        });

    }
    private void setinvite() {

//        Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
//                .setMessage(getString(R.string.invitation_message))
//                .setDeepLink(Uri.parse(getString(R.string.invitation_deep_link)))
//                .setCustomImage(Uri.parse(getString(R.string.invitation_custom_image)))
//                .setCallToActionText(getString(R.string.invitation_cta))
//                .build();
//        startActivityForResult(intent, REQUEST_INVITE);
//        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addApi(AppInvite.API)
//                .enableAutoManage(this, (GoogleApiClient.OnConnectionFailedListener) this)
//                .build();
//
//        boolean autoLaunchDeepLink = true;
//        AppInvite.AppInviteApi.getInvitation(mGoogleApiClient, this, autoLaunchDeepLink)
//                .setResultCallback(
//                        new ResultCallback<AppInviteInvitationResult>() {
//                            public static final String TAG = "true";
//
//                            @Override
//                            public void onResult(AppInviteInvitationResult result) {
//
//                                Log.d(TAG, "getInvitation:onResult:" + result.getStatus());
//                                if (result.getStatus().isSuccess()) {
//                                    // Extract information from the intent
//                                    Intent intent = result.getInvitationIntent();
//                                    String deepLink = AppInviteReferral.getDeepLink(intent);
//                                    String invitationId = AppInviteReferral.getInvitationId(intent);
//
//
//                                }
//                            }
//                        });


        Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Try (your game) for Android!");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I'm using (your game) for Android and I recommend it. Click here: http://www.yourdomain.com");

        Intent chooserIntent = Intent.createChooser(shareIntent, "Share with");
        chooserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(chooserIntent);
    }


}
