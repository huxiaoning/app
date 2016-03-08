package org.hxn.app.test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hxn.app.util.DataUtil;
import org.junit.Test;

public class TestDemo {
	@Test
	public void testString() {
		String value = "_%kk";
		int i = value.indexOf("d");
		System.out.println(i);
	}

	public static int getRandm(int min, int max) {
		return (int) (Math.random() * (max + 1 - min) + min);
	}

	@Test
	public void testRandm() {
		for (int i = 0; i < 100; i++) {
			int randm = getRandm(100, 110);
			System.out.println((randm == 100) + " " + (randm >= 100 && randm <= 110) + " " + (randm == 110)+" "+randm);
		}
	}
	
	
	@Test
	public void testMapPut(){
		Map<String,String> map = new HashMap<String,String>();
		String put = map.put("bb", "12345");
		System.out.println(put);
		String put1 = map.put("bb", "67890");
		System.out.println(put1);
		String put2 = map.put("bb", "xxx");
		System.out.println(put2);
	}
	
	@Test
	public void testFloat(){
		System.out.println(new DecimalFormat().format(1.2452F));
	}
	
	/**
	 * 创建别名
	 * property	alias:
	 * 
	 * center	center
	 * center.user	centeruser
	 * center.user.address	centeruseraddress
	 */
	@Test
	public void testStr(){
		String key = "center.user.address.addressId";
		String[] props = key.split("\\.");
		for(int i=0;i<props.length;i++){
			if(i == props.length-1){
				break;
			}
			StringBuilder property = new StringBuilder();
			StringBuilder alias = new StringBuilder();
			for(int j=0;j<=i;j++){
				property.append(props[j]);
				alias.append(props[j]);
				if(j < i){
					property.append(".");
				}
			}
			System.out.println(property.toString());
			System.out.println(alias.toString());
			
			
		}
		
	}
	
	
	@Test
	public void testDate(){
		Map<String, Date> timeRange = DataUtil.getTimeRange(new Date(), Calendar.DAY_OF_MONTH, -5);
		String begin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeRange.get("begin"));
		String end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeRange.get("end"));
		System.out.println(begin);
		System.out.println(end);
	}
	
	@Test
	public void testDays(){
		Map<String, Date> timeRange = DataUtil.getTimeRange(new Date(), Calendar.DAY_OF_MONTH, -5);
		int days = DataUtil.getDays(timeRange.get("begin"), timeRange.get("end"));
		System.out.println(days);
	}
	
	
	@Test
	public void test22(){
		int a,b,c;//男人，女人，小孩人数
		
		for(a=0;a<=25;a++){
			for(b=0;b<34;b++){
				c = 100 - a - b;
				
				if(c%4 == 0 && (4*a+3*b+c/4) == 100){
					System.out.println(a + ":" + b + ":" +c);
				}
			}
		}
		
		
	}
}
