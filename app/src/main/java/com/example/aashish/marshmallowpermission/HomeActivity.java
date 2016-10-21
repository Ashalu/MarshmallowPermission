package com.example.aashish.marshmallowpermission;

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
                if(isReadStorageAllowed()){
                    //If permission is already having then showing the toast
                    Toast.makeText(HomeActivity.this,"You already have the permission",Toast.LENGTH_LONG).show();
                    //Existing the method with return
                    return;
                }

        }

    }
}
