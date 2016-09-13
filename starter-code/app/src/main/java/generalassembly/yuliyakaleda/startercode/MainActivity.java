package generalassembly.yuliyakaleda.startercode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  EditText editText;
  Button button;
  TextView textView;
  ListView listView;
  ArrayList<String> list;
  ArrayAdapter<String> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: set up all the view and event listeners.

    editText = (EditText) findViewById(R.id.editText);
    button = (Button) findViewById(R.id.button);
    textView = (TextView) findViewById(R.id.textView);
    listView = (ListView) findViewById(R.id.wishList);

    list = new ArrayList<>();

    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
    listView.setAdapter(adapter);


    View.OnClickListener listener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        textView.setText(editText.getText().toString());
        Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation);
        textView.startAnimation(anim);

        list.add(textView.getText().toString());
        editText.setText("");
        adapter.notifyDataSetChanged();

      }
    };

    button.setOnClickListener(listener);
  }
}
