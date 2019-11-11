package com.example.presidents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        List<Presidents> presidentsList = new ArrayList<>();
        presidentsList.add(new Presidents(R.drawable.trump,"Donald Trump","Donald John Trump is the 45th and current president of the United States. Before entering politics, he was a businessman and television personality. "));
        presidentsList.add(new Presidents(R.drawable.obama,"Barack Obama","Barack Hussein Obama II is an American attorney and politician who served as the 44th president of the United States from 2009 to 2017."));
        presidentsList.add(new Presidents(R.drawable.bush,"George W. Bush","George Walker Bush is an American politician and businessman who served as the 43rd president of the United States from 2001 to 2009. He had previously served as the 46th governor of Texas from 1995 to 2000."));
        presidentsList.add(new Presidents(R.drawable.bill,"Bill Clinton","William Jefferson Clinton is an American politician who served as the 42nd president of the United States from 1993 to 2001."));
        presidentsList.add(new Presidents(R.drawable.ronald,"Ronald Reagan","Ronald Wilson Reagan was an American politician who served as the 40th president of the United States from 1981 to 1989 and became the highly influential voice of modern conservatism. Prior to his presidency, he was a Hollywood actor and union leader before serving as the 33rd governor of California from 1967 to 1"));
        presidentsList.add(new Presidents(R.drawable.ford,"Gerald Ford ","Gerald Rudolph Ford Jr. was an American politician who served as the 38th president of the United States from August 1974 to January 1977. Before his accession to the presidency, Ford served as the 40th vice president of the United States from December 1973 to August 1974."));
        presidentsList.add(new Presidents(R.drawable.richard,"Richard Nixon","Richard Milhous Nixon was an American politician who served as the 37th president of the United States from 1969 until his resignation in 1974. The only president to resign from the office, he previously served as the nation's 36th vice president from 1953 to 1961, and as a representative and senator from California."));
        presidentsList.add(new Presidents(R.drawable.lyndon,"Lyndon B. Johnson ","Lyndon Baines Johnson, often referred to by the initials LBJ, was an American politician who served as the 36th president of the United States from 1963 to 1969. Formerly the 37th vice president from 1961 to 1963, he assumed the presidency following the assassination of President John F. Kennedy."));
        presidentsList.add(new Presidents(R.drawable.john, "John F. Kennedy","Lyndon Baines Johnson, often referred to by the initials LBJ, was an American politician who served as the 36th president of the United States from 1963 to 1969. Formerly the 37th vice president from 1961 to 1963, he assumed the presidency following the assassination of President John F. Kennedy"));


        Adapter presidentsAdapter = new Adapter(this,presidentsList);
        recyclerView.setAdapter(presidentsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}
