package com.example.thanhnv.premierleague.ultils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static SimpleDateFormat simpleDateFormat;
    public static String formatDate(Calendar date){
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String s = simpleDateFormat.format(date);
        return s;
    }
    public static String formatDate(Date date){
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String s = simpleDateFormat.format(date);
        return s;
    }
}
