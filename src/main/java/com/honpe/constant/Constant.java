package com.honpe.constant;

public class Constant {

	public static interface RoleConst {
		public static final String SALESMAN_CODE = "salesman";
	}

	public static interface CategoryConst {
		public static final long TOP_PARENT = 0;
		public static final long COMPANY_INSTRODUCE = 87;
		public static final long INDEX_SWIPER = 68;// 首页轮播
		public static final long INDEX_AD = 69;// 首页左侧广告
		public static final long NEWS = 104;// 企业新闻
		public static final long CASE_MAKE = 103;// 案例-手板制作
		public static final long CASE_3D = 102;// 案例-3D打印
		public static final long CASE = 71;// 案例
		public static final long ABOUT_US = 70;// 关于我们
	}

	public static interface InquiryConst {
		public static final String PAY_DAYS = "PAY_DAYS";
		public static final String BUY_TYPE = "BUY_TYPE";
		public static final String TRADE_TYPE = "TRADE_TYPE";
		public static final String OFFER_CURRENCY = "OFFER_CURRENCY";
		public static final String INVOICE_TYPE = "INVOICE_TYPE";
		public static final String MAKE_MATERIAL = "MAKE_MATERIAL";
		public static final String TECHNICS = "TECHNICS";
		public static final String MATERIEL_UNIT = "MATERIEL_UNIT";
		public static final String INQUIRY_STATUS = "INQUIRY_STATUS";
	}

	public static interface OrderConst {
		public static final String SHIPPING_TYPE = "SHIPPING_TYPE";
		public static final String PAYMENT_TYPE = "PAYMENT_TYPE";
		public static final String PAYMENT_CHANNEL = "PAYMENT_CHANNEL";
		public static final byte ACCOUNT_DEADLINE = 2;// 账期支付
		public static final String ORDER_STATUS = "ORDER_STATUS";
	}
}
