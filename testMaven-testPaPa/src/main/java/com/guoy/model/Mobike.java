package com.guoy.model;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Mobike implements Serializable {

	/****/
	 private String orderid;

	/****/
	 private String userid;

	/****/
	 private String bikeid;

	/****/
	 private String starttime;

	/****/
	 private String starttime1;

	/****/
	 private String startLon;

	/****/
	 private String startLat;

	/****/
	 private String endLon;

	/****/
	 private String endLat;



	public void setOrderid(String orderid){
		this.orderid = orderid;
	}

	public String getOrderid(){
		return this.orderid;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return this.userid;
	}

	public void setBikeid(String bikeid){
		this.bikeid = bikeid;
	}

	public String getBikeid(){
		return this.bikeid;
	}

	public void setStarttime(String starttime){
		this.starttime = starttime;
	}

	public String getStarttime(){
		return this.starttime;
	}

	public void setStarttime1(String starttime1){
		this.starttime1 = starttime1;
	}

	public String getStarttime1(){
		return this.starttime1;
	}

	public void setStartLon(String startLon){
		this.startLon = startLon;
	}

	public String getStartLon(){
		return this.startLon;
	}

	public void setStartLat(String startLat){
		this.startLat = startLat;
	}

	public String getStartLat(){
		return this.startLat;
	}

	public void setEndLon(String endLon){
		this.endLon = endLon;
	}

	public String getEndLon(){
		return this.endLon;
	}

	public void setEndLat(String endLat){
		this.endLat = endLat;
	}

	public String getEndLat(){
		return this.endLat;
	}

}
