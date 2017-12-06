package com.guoy.util;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 生成序列号
*       
* 创建人：wzq   
* 创建时间：2017-4-14 下午1:16:33
* @version    
*
 */
public class GenerateSequenceUtil {
	public static String GetDateTimeStr() {
		Calendar CD = Calendar.getInstance();
		int YY = CD.get(Calendar.YEAR);
		int MM = CD.get(Calendar.MONTH) + 1;
		int DD = CD.get(Calendar.DATE);
		int HH = CD.get(Calendar.HOUR_OF_DAY);
		int NN = CD.get(Calendar.MINUTE);
		int SS = CD.get(Calendar.SECOND);
		return String.format("%04d%02d%02d%02d%02d%02d", YY, MM, DD, HH, NN, SS);
	}
	private static int seq = 0;
	private static final int MAX = 9999;
	/**
	 * 生成19位唯一数字序号
	 * @return
	 */
	public static synchronized String generate19SequenceNo() {
		String strPart1 = GetDateTimeStr();
		String strPart2 = String.format("%05d", seq);
		if (seq == MAX)
			seq = 0;
		else
			seq++;

		String lValue = new String(strPart1 + strPart2);
		return lValue;
	}
	public static synchronized long generate19SequenceNoLong() {
		String strPart1 = GetDateTimeStr();
		String strPart2 = String.format("%05d", seq);
		if (seq == MAX)
			seq = 0;
		else
			seq++;

		Long lValue = new Long(strPart1 + strPart2);
		return lValue;
	}

    /**
     * 生成9位唯一数字序号
     * @return
     */
	public static synchronized String generate9SequenceNo() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		// 4位日期+2位毫秒数+2位递增种子
		StringBuffer stb = new StringBuffer();

		String str  =retStrFormatNowDate.substring(4,8);
		if (str.startsWith("0"))
		{
			String padstr = retStrFormatNowDate.substring(0, 1);
			str  = str.replace("0", padstr);
		}
		stb.append(str);
		stb.append(retStrFormatNowDate.substring(retStrFormatNowDate.length() - 2, retStrFormatNowDate.length()));
		String strseq = String.format("%03d", seq);
		stb.append(strseq);
		if (seq == MAX)
			seq = 0;
		else
			seq++;
		return new String(stb.toString());
	}

	public static void main(String[] args) {
		for (int i = 0; i < 500; i++) {
			String KeyID = generate19SequenceNo();										
			System.out.println("KeyID=" + KeyID);
		}
	}

}
