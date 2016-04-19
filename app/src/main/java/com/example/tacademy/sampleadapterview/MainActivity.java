package com.example.tacademy.sampleadapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputView;
    ListView listView;
    TextView textView;
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputView = (EditText)findViewById(R.id.edit_add);
        listView=(ListView)findViewById(R.id.list_view);
        textView=(TextView)findViewById(R.id.text_select);
        mAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text=(String)listView.getItemAtPosition(position);
                textView.setText(text);
            }
        });
        Button btn=(Button)findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=inputView.getText().toString();
                if(text!=null && !text.equals("")) {
                    mAdapter.add(text);
                    inputView.setText("");
                    listView.smoothScrollToPosition(mAdapter.getCount()-1);
                }
            }
        });
        initData();

    }
    private void initData()
    {
        String[] items=getResources().getStringArray(R.array.list_item);
        for(String s : items)
        {
            mAdapter.add(s);
        }
    }
}
