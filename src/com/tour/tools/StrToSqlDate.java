package com.tour.tools;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 将string类型转换为数据库可用的java.sql.Date类型
 * @author KL
 *
 */
public class StrToSqlDate {
	public static Date StringToSqlDate(String strDate){
		String str = strDate;
		SimpleDateFormat fromat = new SimpleDateFormat("yyyy-MM-dd");
		//String先转换为java.util.date类型，然后再转换为java.sql.Date类型
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
