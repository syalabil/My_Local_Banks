package sg.edu.rp.c346.id19046836.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView dbs;
TextView ocbc;
TextView uob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == dbs){
            menu.add(0,0,0, R.string.Website);
            menu.add(0,1,1, R.string.Contact_the_Bank);
        }
        else if(v == ocbc){
            menu.add(0,2,0, R.string.Website);
            menu.add(0,3,1,R.string.Contact_the_Bank);
        }
        else if(v == uob){
            menu.add(0,4,0, R.string.Website);
            menu.add(0,5,1,R.string.Contact_the_Bank);
        }


    }

// changing language
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText(R.string.ocbc);
            ocbc.setText(R.string.ocbc);
            uob.setText(R.string.uob);
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText(R.string.星展银行);
            ocbc.setText(R.string.华侨银行);
            uob.setText(R.string.大华银行);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.dbsWebsite)));
                startActivity(intent);
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentcall1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +getString(R.string.dbsNumber)));
            startActivity(intentcall1);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==2) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.ocbcWebsite)));
            startActivity(intent);
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==3) { //check if the selected menu item ID is 1
            //code for action
            Intent intentcall1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +getString(R.string.ocbcNumber)));
            startActivity(intentcall1);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==4) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.uobWebsite)));
            startActivity(intent);
            return true; //menu item successfully handled
        }
        else if(item.getItemId()==5) { //check if the selected menu item ID is 1
            //code for action
            Intent intentcall1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +getString(R.string.uobNumber)));
            startActivity(intentcall1);
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }






}
