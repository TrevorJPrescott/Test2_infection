package com.trevorpc.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Room[][] verticalTrue = new Room[][]{
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new
                        Room(true), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) }
        };
        Log.d("TAG", "loaded");
        boolean a =this.OutBreak(verticalTrue);
        Log.d("TAG", "The Answer is " + a );


    }

    public void Connection(Room[][] input, int h,int v,  int counter)
    {

        counter++;

        int hAbove =h+1;
        int hBelow = h-1;
        int vAbove = v+1;
        int vBelow = v-1;


        input[v][h].setVisited(true);
        if(input[h][vAbove].isInfected() && !input[h][v+1].isVisited() && vAbove>input[0].length)
        {
            Log.d("TAG", "Connection: North "+counter);
            Connection(input,h,vAbove,counter);
        }
        if(input[h][vBelow].isInfected() && !input[h][v-1].isVisited()&& vBelow>=0) {
            Log.d("TAG", "Connection South : " + counter);
            Connection(input, h, vBelow, counter);
        }
        if(input[hAbove][v].isInfected() && !input[hAbove][v].isVisited() && hAbove<input.length)
        {
            Log.d("TAG", "Connection: East  "+counter);
            Connection(input,hAbove,v,counter);
        }
        if(input[hBelow][v].isInfected() && !input[hBelow][v].isVisited() && hBelow>=0)
        {
            Log.d("TAG", "Connection: West "+counter);
            Connection(input,hBelow,v,counter);
        }

    }



    public boolean OutBreak(Room[][] input)
    {
        int counter;


        for (int y=0; y< input.length;y++)
        {
            for (int x=0;x<input.length;x++)
            {

                counter=0;
                if(input[x][y].isInfected())
                {

                    counter++;
                    Connection(input,x,y,counter);

                    if(counter >= 5)
                        Log.d("TAG", "Pandemic ");
                        return true;
                }
            }
        }
        Log.d("TAG", "false alarm");
        return false;

 }



}
