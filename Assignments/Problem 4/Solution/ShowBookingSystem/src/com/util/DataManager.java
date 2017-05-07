package com.util;

import java.util.List;
import com.bean.*;
import com.exception.InvalidSeatNumberException;
import com.exception.SeatsNotAvailableException;
import com.exception.UnknownShowException;

public interface DataManager {
 List<Show> populateDataFromFile(String fileName);
 void bookShow(List<Show> showList,String showName,String show_time,int noOfSeats)throws SeatsNotAvailableException, UnknownShowException, InvalidSeatNumberException;
 }
