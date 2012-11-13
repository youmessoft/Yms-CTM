package com.youmessoft.ctmseo;

import android.os.Bundle;
import com.facebook.android.Facebook.*;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;

public class FacebookConnect extends Activity {

	Facebook facebook = new Facebook("192160397588128");
    AsyncFacebookRunner mAsyncRunner = new AsyncFacebookRunner(facebook);
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_connect);
        facebook.authorize(this, new String[] { "email", "publish_checkins" },

        	      new DialogListener() {
        	           @Override
        	           public void onComplete(Bundle values) {}

        	           @Override
        	           public void onFacebookError(FacebookError error) {}

        	           @Override
        	           public void onError(DialogError e) {}

        	           @Override
        	           public void onCancel() {}
        	      }
        	);
       
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        facebook.authorizeCallback(requestCode, resultCode, data);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_facebook_connect, menu);
        return true;
    }
    
}
