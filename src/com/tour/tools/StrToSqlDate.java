package com.tour.tools;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * ��string����ת��Ϊ���ݿ���õ�java.sql.Date����
 * @author KL
 *
 */
public class StrToSqlDate {
	public static Date StringToSqlDate(String strDate){
		String str = strDate;
		SimpleDateFormat fromat = new SimpleDateFormat("yyyy-MM-dd");
		//String��ת��Ϊjava.util.date���ͣ�Ȼ����ת��Ϊjava.sql.Date����
		java.util.Date date = null;
		try{
			date = fromat.parse(str);
		} catch (Exception e){
			e.printStackTrace();
		}
		Date dateSql = new Date(date.getTime());
		return dateSql;
	}
}
