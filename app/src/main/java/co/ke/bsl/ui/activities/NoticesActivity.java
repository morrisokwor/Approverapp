package co.ke.bsl.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import co.ke.bsl.R;

public class NoticesActivity extends AppCompatActivity {
    TextView rmks;
    Button viewRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_notices);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notice");
        getSupportActionBar().setIcon(R.drawable.ic_notifications_active_black_24dp);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent=getIntent();
        if(intent !=null) {
            getincomingIntent();
            acknowledge();
        }
        viewreference();
    }
     public void getincomingIntent(){
         Intent intent=getIntent();
            String note= intent.getStringExtra("notices");
            String msg= intent.getStringExtra("messages");
            String creted= "26-11-2019";
            String refer= "Morris Leave Application Request";
            String desc= "Morris parternal Leave of months as per the new regulations. He's to report back on 26-02-2020";
            String remks= "";
            setdetails(note,msg,creted,refer,desc,remks);


     }
    public void setdetails(String notice, String message, String createddate, String ref, String descrption, String remarks){
        TextView note= findViewById(R.id.editTextNotice);
        note.setText(notice);
        TextView msg= findViewById(R.id.editTextMsg);
        msg.setText(message);
        TextView created= findViewById(R.id.editTextCreated);
        created.setText(createddate);
        TextView reference= findViewById(R.id.editTextRef);
        reference.setText(ref);
        TextView desc= findViewById(R.id.editTextDesc);
        desc.setText(descrption);
        TextView rmks= findViewById(R.id.editTextRemark);
        rmks.setText(remarks);



    }
public void acknowledge() {
    rmks = findViewById(R.id.editTextRemark);
    final CheckBox ackno = ( CheckBox ) findViewById( R.id.acknowledge );
    ackno.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            System.out.println("checked******************");
            if ( ackno.isChecked() ) {
                if(rmks.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "Enter Remarks", Toast.LENGTH_LONG).show();
                    ackno.setChecked(false);
                    rmks.setFocusable(true);
                } else{
                    ackno.setChecked(true);
                    rmks.setFocusable(false);
                    
                }
            }
            else{
                System.out.println("not checked");
                rmks.setFocusable(true);
            }

        }
    }
    );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        if(item.getItemId()==android.R.id.home) {
            super.onBackPressed();
            return  true;
//            intent = new Intent(getApplicationContext(), DashboardActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void viewreference(){

        viewRef= (Button) findViewById(R.id.viewReference);
        viewRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"To be coming in Version II",Toast.LENGTH_LONG).show();
            }
        });
    }

}
