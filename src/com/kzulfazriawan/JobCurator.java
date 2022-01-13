package com.kzulfazriawan;

import java.util.Date;
import java.util.List;

public interface JobCurator {
    void put(Date date);

    List<Date> get(Date after);
}
