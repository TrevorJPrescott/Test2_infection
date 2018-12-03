package com.trevorpc.test2;

public class Room
{

    public final boolean isInfected;
    public boolean visited = false;

    public boolean isInfected() {
        return isInfected;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }



    Room(boolean infected)
    {
        isInfected = infected;
    }


}
