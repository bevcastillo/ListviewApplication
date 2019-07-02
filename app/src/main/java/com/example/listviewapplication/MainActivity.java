package com.example.listviewapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView lv;
    ArrayList<Characters> list = new ArrayList<Characters>();
    CustomAdapter adapter;
    AlertDialog.Builder builder1, builder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)this.findViewById(R.id.listview1);
        adapter = new CustomAdapter(this,list);

        list.add(new Characters(R.drawable.ant_man,"Lang, Scott","BSIT-4"));
        list.add(new Characters(R.drawable.black_widow,"Romanova, Natalia", "BEED-4"));
        list.add(new Characters(R.drawable.bucky_barnes,"Barnes, Bucky", "BSNAME-5"));
        list.add(new Characters(R.drawable.captain_america,"Rogers, Steve","BSED-4"));
        list.add(new Characters(R.drawable.captain_marvel,"Danvers, Carol","BSIT-4"));
        list.add(new Characters(R.drawable.clint,"Barton, Clint","BSCRIM-1"));
        list.add(new Characters(R.drawable.doctor_strange,"Strange, Stephen","BSNursing-4"));
        list.add(new Characters(R.drawable.hulk,"Banner, Bruce","BSNursing-4"));
        list.add(new Characters(R.drawable.scarlett_witch,"Maximoff, Wanda","BSHRM-1"));
        list.add(new Characters(R.drawable.thor,"Odinson, Thor","BSCRIM-11"));
        list.add(new Characters(R.drawable.tony_stark,"Stark, Tony","BSME-5"));

        lv.setAdapter(adapter);
        builder1 = new AlertDialog.Builder(this);
        builder2 = new AlertDialog.Builder(this);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Characters selectedCharacters = this.list.get(position);

        int image = selectedCharacters.getImg();
        String name = selectedCharacters.getName();
        String course = selectedCharacters.getCourse();
        ImageView iv = new ImageView(this);
        iv.setImageResource(image);

        builder1.setTitle(""+name+ "\n" +course);
        builder1.setView(iv);
        builder1.setNeutralButton("Okay", null);

        AlertDialog dialog = builder1.create();
        dialog.show();
        dialog.getWindow().setLayout(1000, 1200); //customize the layout of your AlertDialog Box

    }


    //when the items in the listview is long pressed
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        final CharSequence[] options = {"Edit", "Delete"};

        builder2.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(options[which].equals("Edit")){

                    Toast.makeText(MainActivity.this, "You have clicked edit!", Toast.LENGTH_LONG).show();
                }else if(options[which].equals("Delete")){

                    list.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Item Deleted!", Toast.LENGTH_LONG).show();
                }


            }
        });

        AlertDialog dialog = builder2.create();
        dialog.show();


        return true;
    }
}
