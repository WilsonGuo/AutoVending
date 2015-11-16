package com.huawei.mm.vending.utils;

import java.util.Hashtable;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Utils {

	public static final String ACTION_NAME_NFC_OPEN = "nfc_open";
	public static final String ACTION_NAME_NFC_CLOSE = "nfc_close";
	public static final String ACTION_NAME_SONIC_OPEN = "sonic_open";
	public static final String ACTION_NAME_SONIC_CLOSE = "sonic_close";
	public static String price = "0";
	public static final int DELAY = 5000;

	// 鐢熸垚QR鍥�
	public static Bitmap createQRImage(String text) {
		Bitmap bitmap = null;
		int QR_WIDTH = 200;
		int QR_HEIGHT = 200;
		try {
			QRCodeWriter writer = new QRCodeWriter();
			if (text == null || "".equals(text) || text.length() < 1) {
				return null;
			}
			BitMatrix martix = writer.encode(text, BarcodeFormat.QR_CODE,
					QR_WIDTH, QR_HEIGHT);
			System.out.println("w:" + martix.getWidth() + "h:"
					+ martix.getHeight());
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			BitMatrix bitMatrix = new QRCodeWriter().encode(text,
					BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
			int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
			for (int y = 0; y < QR_HEIGHT; y++) {
				for (int x = 0; x < QR_WIDTH; x++) {
					if (bitMatrix.get(x, y)) {
						pixels[y * QR_WIDTH + x] = 0xff000000;
					} else {
						pixels[y * QR_WIDTH + x] = 0xffffffff;
					}
				}
			}

			bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT,
					Bitmap.Config.ARGB_8888);
			bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);

		} catch (WriterException e) {
			e.printStackTrace();
		}

		return bitmap;
	}

	/**
	 * 鍙戦�鏁版嵁
	 * 
	 * @param num
	 *            鍘熷鏁版嵁锛屼緥濡傗�57.78*100鈥�
	 * @return String 杞寲鍚庣殑浜旇繘鍒舵暟 锛堥拡瀵归煶棰戜紶杈擄級
	 */
	public static String sendStr(String num) {
		float m = Float.valueOf(num);
		long a = (long) (m * 100);
		return changeNum(String.valueOf(a));
	}

	/**
	 * 鎺ユ敹鏁版嵁
	 * 
	 * @param str
	 *            鏀跺埌鐨勪簲杩涘埗鏁帮紝渚嬪鈥�1212135鈥�
	 * @return long 杞崲鍚庣殑缁撴灉 闇�闄や互100锛�
	 */
	public static long receiveStr(String str) {
		return Long.valueOf(changeString(str)).longValue();
	}

	public static String changeNum(String num) {
		String reuslt = "";
		for (int i = 0; i < num.length(); i++) {
			char temp = num.charAt(i);
			if (isNumber(String.valueOf(temp))) {
				reuslt = reuslt + changeFromNum(temp);
			} else if (String.valueOf(temp).equals(".")) {
				reuslt = reuslt + "44";
			}
		}
		return reuslt;
	}

	public static String changeString(String str) {

		String reuslt = "";
		int length = str.length();
		int count = length / 2;
		for (int i = 0; i < count; i++) {
			String num = str.substring(i * 2, (i + 1) * 2);
			if (num.equals("44")) {
				reuslt = reuslt + ".";
			} else {
				reuslt = reuslt + String.valueOf(changeFromString(num));
			}

		}
		return reuslt;
	}

	/**
	 * 鍘熷瓙杞崲
	 * 
	 * @param num1
	 * @return
	 */
	public static int changeFromString(String num1) {
		int e = Integer.valueOf(num1);
		if (e < 50) {
			switch (e) {
			case 11:
				return 6;
			case 12:
				return 7;
			case 13:
				return 8;
			case 14:
				return 9;
			default:
				break;
			}
		} else if (e == 55) {
			return 0;
		} else {
			return e - 50;
		}
		return 0;

	}

	/**
	 * 鍘熷瓙杞崲
	 * 
	 * @param m
	 * @return
	 */
	public static int changeFromNum(char m) {
		int e = Integer.valueOf(String.valueOf(m));
		if (e > 5) {
			switch (e) {
			case 6:
				return 11;
			case 7:
				return 12;
			case 8:
				return 13;
			case 9:
				return 14;
			default:
				break;
			}
		} else {
			int result = 50 + e;
			if (result == 50) {
				result = 55;
			}
			return result;
		}
		return 0;
	}

	public static boolean isNumber(String str) {
		java.util.regex.Pattern pattern = java.util.regex.Pattern
				.compile("[0-9]*");
		java.util.regex.Matcher match = pattern.matcher(str);
		if (match.matches() == false) {
			return false;
		} else {
			return true;
		}
	}

}