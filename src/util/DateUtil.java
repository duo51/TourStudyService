package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Calendar c;
	public static int year,month,day,hour,minute,second;
	
	public static String getDate() {
		c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DATE);
        hour= c.get(Calendar.HOUR_OF_DAY);
        minute=c.get(Calendar.MINUTE);
        second=c.get(Calendar.SECOND);
        month=month+1;
        return year+"-"+editTime(month)+"-"+editTime(day)+" "+editTime(hour)+":"+editTime(minute)+":"+editTime(second);
	}
	
	public static String editTime(int n){
        String str=String .valueOf(n);
        if(String.valueOf(n).length()==1){
            str=0+String.valueOf(n);
        }
        return str;
    }
	
	public static String compareDate(String now,String before){
		long n=changeDate(now);
		long b=changeDate(before);
		long result=(n-b)/1000;
		long resultYear=result/3600/24/365;//�������Ƚ�
		long resultMonth=result/3600/24/30;//�������Ƚ�
		long resultDay=result/3600/24;//���������Ƚ�
		long resultHour=result/3600;//��Сʱ���Ƚ�
		long resultMinute=result/60;//�ͷ������Ƚ�
		if(resultYear>0){
			System.out.println(resultYear+"��ǰ");
			return resultYear+"��ǰ";
		}else if(resultMonth>0){
			System.out.println(resultMonth+"��ǰ");
			return resultMonth+"��ǰ";
		}else if(resultDay>0){
			System.out.println(resultDay+"��ǰ");
			return resultDay+"��ǰ";
		}else if(resultHour>0){
			System.out.println(resultHour+"Сʱǰ");
			return resultHour+"Сʱǰ";
		}else if(resultMinute>0){
			System.out.println(resultMinute+"����ǰ");
			return resultMinute+"����ǰ";
		}else {
			System.out.println("�ո�");
			return "�ո�";
		}
	}
	
	//���ַ�����ʽ��ʱ���Ϊ���룬����Ƚ�
	public static long changeDate(String date){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//�ַ���ת����
		try {
			Date d=df.parse(date);
			long m=d.getTime();
			return m;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -111111;
		}
	}

}
