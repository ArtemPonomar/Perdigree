package com.pedigree.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class DateService {
    private final SimpleDateFormat dateRu;
    private final SimpleDateFormat dateISO;

    public DateService(){
        dateRu = new SimpleDateFormat("dd.MM.yyyy");
        dateISO = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String dateToString(Date date){
        if (date == null) return null;
        return dateRu.format(date);
    }

    public Date stringToDate(String string) throws ParseException{
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateRu.parse(string));
            cal.set(Calendar.HOUR_OF_DAY, 23);  //adding hours to date, so date wouldn't get rounded down when being saved to the database
            return cal.getTime();
        } catch (ParseException e) {
            throw new ParseException("Неверный формат даты, используйте календарь.",0);
        }
    }
}
