package com.bvrit.bvritcall;

/**
 * Created by sushma on 15/9/16.
 * Project: bvritcalllog
 */
public class contact {
    private String name;
    private String number;
    private int imageRes;

    public contact(String name, String number, int imageRes) {
        this.name = name;
        this.number = number;
        this.imageRes = imageRes;
    }

    public contact(String name, String number) {
        this.name = name;
        this.number = number;
        this.imageRes = R.drawable.ic_account_circle_black_24dp;
    }

    public contact() {
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + '\n' + number;
    }

    public int getImageRes() {
        return imageRes;
    }
}
