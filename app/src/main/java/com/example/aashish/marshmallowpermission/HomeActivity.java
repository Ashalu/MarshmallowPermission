package com.example.aashish.marshmallowpermission;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button=(Button)findViewById(R.id.btn_permission);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_permission:
                if(ReadMsgAllowed()){
                    //If permission is already having then showing the toast
                    Toast.makeText(HomeActivity.this,"You already have the permission",Toast.LENGTH_LONG).show();
                    //Existing the method with return
                    return;
                }
                requestReadMsgPermission();
                        

        }

    }

    private void requestReadMsgPermission() {
    if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_SMS)){

    }
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},200);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==200)
        {
            if(grantResults.length>0&& grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Permission Rejected",Toast.LENGTH_LONG).show();
            }
        }


    }

    private boolean ReadMsgAllowed() {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }
}
