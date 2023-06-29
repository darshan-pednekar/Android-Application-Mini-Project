package com.example.braintrainer;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class about extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

//    public static Intent newYoutubeProfileIntent(PackageManager pm, String url) {
//        final Intent intent = new Intent(Intent.ACTION_VIEW);
//        try {
//            if (pm.getPackageInfo("com.google.android.youtube", 0) != null) {
//                if (url.endsWith("/")) {
//                    url = url.substring(0, url.length() - 1);
//                }
//                final String username = url.substring(url.lastIndexOf("/") + 1);
//                // http://stackoverflow.com/questions/21505941/intent-to-open-instagram-user-profile-on-android
//                intent.setData(Uri.parse("http://youtube.com/" + username));
//                intent.setPackage("com.google.android.youtube");
//                return intent;
//            }
//        } catch (PackageManager.NameNotFoundException ignored) {
//        }
//        intent.setData(Uri.parse(url));
//        return intent;
//    }



//    public static Intent newInstagramProfileIntent(PackageManager pm, String url) {
//
//        final Intent intent = new Intent(Intent.ACTION_VIEW);
//        try {
//            if (pm.getPackageInfo("com.instagram.android", 0) != null) {
//                if (url.endsWith("/")) {
//                    url = url.substring(0, url.length() - 1);
//                }
//                final String username = url.substring(url.lastIndexOf("/") + 1);
//                // http://stackoverflow.com/questions/21505941/intent-to-open-instagram-user-profile-on-android
//                intent.setData(Uri.parse("http://instagram.com/_u/" + username));
//                intent.setPackage("com.instagram.android");
//                return intent;
//            }
//        } catch (PackageManager.NameNotFoundException ignored) {
//        }
//        intent.setData(Uri.parse(url));
//        return intent;
//    }

//    public void openInsta(View view){
//
//        Intent intent = newInstagramProfileIntent(getApplicationContext().getPackageManager(), "https://www.instagram.com/sayedost/");
//        startActivity(intent);
//
//    }

//    public void openTwitter(View view){
//
//        Intent intent = newTwitterProfileIntent(getApplicationContext().getPackageManager(), "https://twitter.com/OSayed88");
//        startActivity(intent);
//
//    }

//    public void openYoutube(View view){
//
//
//        startActivity(new Intent(Intent.ACTION_VIEW,   Uri.parse("http://www.youtube.com/channel/UCAQ0OObht1cq4ZiznVGQ5RA")));
//        // Intent intent = newYoutubeProfileIntent(getApplicationContext().getPackageManager(), "https://www.youtube.com/channel/UCAQ0OObht1cq4ZiznVGQ5RA");
//        //startActivity(intent);
//
//    }

//    public void openWebsite(View view){
//
//        goToUrl("https://os88ed.wordpress.com/");
//
//    }

//    public void goToUrl (String url) {
//        Uri uriUrl = Uri.parse(url);
//        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
//        startActivity(launchBrowser);
//    }


}
