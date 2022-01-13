package com.kzulfazriawan;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class JobRun implements JobCurator {
    Scanner input = new Scanner(System.in);
    ArrayList<Date> dates = new ArrayList<Date>();

    private Date string2Date(String value) {
        // parse the string and then validate if date then return as date else exit(0)
        Date result = new Date();
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        date_format.setLenient(false);
        try {
            result = date_format.parse(value.trim());
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            System.exit(0);
        }
        return result;
    }


    public List<Date> run() {
        // get the number of services
        System.out.print("Number of services ? ");

        // get the dates of services based on the number
        String[] services = new String[input.nextInt()];
        System.out.println("Service date (YYYY-MM-DD) [" + services.length + "]?");
        input.nextLine();

        // input the list of the dates
        for (int i = 0; i < services.length; i++) {
            this.put(this.string2Date(input.nextLine()));
        }

        // input current date
        System.out.print("Current date ? ");
        return this.get(this.string2Date(input.nextLine()));
    }

    @Override
    public void put(Date date) {
        this.dates.add(date);
    }

    @Override
    public List<Date> get(Date after) {
        List<Date> tmp_dates = new ArrayList<Date>();
        for (Date data : this.dates) {
            if (!data.before(after)) {
                tmp_dates.add(data);
            }
        }
        Collections.sort(tmp_dates);
        return tmp_dates;
    }
}


public class Main {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        JobRun job_run = new JobRun();

        for (Date data: job_run.run()){
            System.out.println(formatter.format(data));
        }
    }
}
