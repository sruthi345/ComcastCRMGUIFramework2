package com.comcast.crm.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}
	public String systemDateYYYYDDMM()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date ;	
	}
	public String getRequirdDateYYYYDDMM(int days)
	{
		Date dateobj=new Date();

		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		//sim.format(dateobj);
		
		Calendar cal = sim.getCalendar();//captureing complete calender
		cal.add(Calendar.DAY_OF_MONTH,days);
		String enddate=sim.format(cal.getTime());
		return enddate;

	}
	{
		
	}

}
