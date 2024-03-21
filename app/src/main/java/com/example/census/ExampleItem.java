package com.example.census;

import android.graphics.Bitmap;


public class ExampleItem {
    private String myImageResource;
    private String myLine1;
    private String myLine2;
    private String myLine3;
    public ExampleItem(String imageResource,String line1, String line2,String line3) {
        myImageResource = imageResource;
        myLine1 = line1;
        myLine2 = line2;
        myLine3 = line3;
    }
    public String getImageResource() {
        return myImageResource;
    }
    public String getLine1() {
        return myLine1;
    }

    public String getLine2() {
        return myLine2;
    }
    public String getLine3() {
        return myLine3;
    }
}


