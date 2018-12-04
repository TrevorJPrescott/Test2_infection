package com.trevorpc.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static com.trevorpc.test2.Room.Rcounter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Room[][] horizontalTrue = new Room[][] {
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(true), new Room(true), new
                        Room(true), new Room(true), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },{new Room(false), new Room(false), new Room(false), new Room(false),
                new Room(false), new Room(false), new Room(false), new Room(false), new
                Room(false) }, {new Room(false), new Room(false), new Room(false), new Room(false),
                new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }
        };



        Room[][] verticalTrue = new Room[][]
                {
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
        Room[][] noInfection = new Room[][] {
                {new Room(true), new Room(false), new Room(true), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(true), new Room(false), new Room(true), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new
                        Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(true), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(true), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(true), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false), new Room(false), new Room(false), new Room(false), new
                        Room(false) }
        };



// vertical true, noInfection, horizontalTrue
        boolean a = OutBreak(horizontalTrue);
        Log.d("ANSWER", "The Rumors of an Outbreak are " + a +".");
        Log.d("TAG", "The Rumors of an Outbreak are " + a + "." );
    }


    public boolean OutBreak(Room[][] floor) {


        for (int col = 0; col < floor[0].length; col++) {
            for (int row = 0; row < floor.length; row++) {
                Log.d("TAG", "Checking at ("+row+","+col+")");


                if(floor[row][col].isInfected)
                {
                    Search(floor,row,col);

                    if (Rcounter>=5)
                    {
                        return true;
                    }
                }
                if (Rcounter>0)
                {
                    Log.d("TAG", "false alarm ");
                }
                Rcounter =0;

            }
        }
        return false;
    }

    private void Search(Room[][] floor, int row, int col)
    {

        Log.d("TAG", "Possible Detection at ("+row+","+col+")");
        Rcounter++;
        Log.d("TAG", "Detection Level at "+ Rcounter);

        floor[row][col].setVisited(true);

        int rowAbove = row+1;
        int rowBelow = row-1;
        int colAbove = col+1;
        int colBelow = col-1;

        if(!(rowAbove > floor.length))
        {
            if(floor[rowAbove][col].isInfected() && !floor[rowAbove][col].isVisited())
            {
                Search(floor,rowAbove,col);
            }}
        if(!(rowBelow < 0))
        {
            if(floor[rowBelow][col].isInfected() && !floor[rowBelow][col].isVisited()) {
                Search(floor,rowBelow,col); }
        }
        if(!(colAbove > floor[0].length)){
            if(floor[row][colAbove].isInfected() && !floor[row][colAbove].isVisited())
            {
                Search(floor,row,colAbove);
            }}
        if(!(colBelow < 0)){
            if(floor[row][colBelow].isInfected() && !floor[row][colBelow].isVisited()) {
                Search(floor,row,colBelow); }
        }


    }

}
