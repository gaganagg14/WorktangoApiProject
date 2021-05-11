package com.coupons.riq.config;

import org.aeonbits.owner.ConfigFactory;

public class EnvConfig {
    private static Environment env = ConfigFactory.create(Environment.class);


    public static String COUPON_NEXTGEN_GW_LB_HOST = System.getProperty("COUPON_NEXTGEN_GW_LB_HOST") != null ? System.getProperty("COUPON_NEXTGEN_GW_LB_HOST") : env.couponNextGenGWLBHost();
    public static Integer COUPON_NEXTGEN_GW_LB_PORT = System.getProperty("COUPON_NEXTGEN_GW_LB_PORT") != null ? Integer.valueOf(System.getProperty("COUPON_NEXTGEN_GW_LB_PORT")) : Integer.valueOf(env.couponNextGenGWLBPort());
    public static String COUPON_NEXTGEN_REST_LB_HOST = System.getProperty("COUPON_NEXTGEN_REST_LB_HOST") != null ? System.getProperty("COUPON_NEXTGEN_REST_LB_HOST") : env.couponNextGenRestLBHost();
    public static Integer COUPON_NEXTGEN_REST_LB_PORT = System.getProperty("COUPON_NEXTGEN_REST_LB_PORT") != null ? Integer.valueOf(System.getProperty("COUPON_NEXTGEN_REST_LB_PORT")) : Integer.valueOf(env.couponNextGenRestLBPort());
    public static String CPR_SERVICE_HOST = System.getProperty("CPR_SERVICE_HOST") != null ? System.getProperty("CPR_SERVICE_HOST") : env.cprHost();
    public static Integer CPR_SERVICE_PORT = System.getProperty("CPR_SERVICE_PORT") != null ? Integer.valueOf(System.getProperty("CPR_SERVICE_PORT")) : Integer.valueOf(env.cprPort());
    public static String CPR_SERVICE_PID = System.getProperty("CPR_SERVICE_PID") != null ? System.getProperty("CPR_SERVICE_PID") : env.cprPid();
    public static String CPR_SERVICE_NID = System.getProperty("CPR_SERVICE_NID") != null ? System.getProperty("CPR_SERVICE_NID") : env.cprNid();
    public static String TEXT2REBATE_COUPONS_AFFILIATE_APPID = System.getProperty("TEXT2REBATE_COUPONS_AFFILIATE_APPID") != null ? System.getProperty("TEXT2REBATE_COUPONS_AFFILIATE_APPID") : env.textToRebateCouponsAffiliateAppId();
    public static String SHOPMIUM_APPLICATION_KEY = System.getProperty("SHOPMIUM_APPLICATION_KEY") != null ? System.getProperty("SHOPMIUM_APPLICATION_KEY") : env.shopmiumApplicationKey();
    public static String COUPONS_AFFILIATE_WEB_APPID = System.getProperty("COUPONS_AFFILIATE_WEB_APPID") != null ? System.getProperty("COUPONS_AFFILIATE_WEB_APPID") : env.couponsAffiliateWebAppID();
    public static String USERPROFILE_SERVICE_HOST = System.getProperty("USERPROFILE_SERVICE_HOST") != null ? System.getProperty("USERPROFILE_SERVICE_HOST") : env.useProfileServiceHost();
    public static String CC_HOST = System.getProperty("CC_HOST") != null ? System.getProperty("CC_HOST") : env.ccHost();
    public static Integer CC_PORT = System.getProperty("CC_PORT") != null ? Integer.valueOf(System.getProperty("CC_PORT")) : env.ccPort();
    public static String COUPONS_AFFILIATE_IOS_APPID = System.getProperty("COUPONS_AFFILIATE_IOS_APPID") != null ? System.getProperty("COUPONS_AFFILIATE_IOS_APPID") : env.couponsAffiliateIOSAppID();
    public static String TAHOE_COUPONS_AFFILIATE_APPID = System.getProperty("TAHOE_COUPONS_AFFILIATE_APPID") != null ? System.getProperty("TAHOE_COUPONS_AFFILIATE_APPID") : env.tahoeCouponsAffiliateAppId();
    public static Integer RECEIPTSCAN_PORT = System.getProperty("RECEIPTSCAN_PORT") != null ? Integer.valueOf(System.getProperty("RECEIPTSCAN_PORT")) : Integer.valueOf(env.receiptScanPort());
    public static String RECEIPTSCAN_HOST = System.getProperty("RECEIPTSCAN_HOST") != null ? System.getProperty("RECEIPTSCAN_HOST") : env.receiptScanHost();
    public static String TAHOE_DEFAULT_APPID = System.getProperty("TAHOE_DEFAULT_APPID") != null ? System.getProperty("TAHOE_DEFAULT_APPID") : env.tahoeCouponsAffiliateAppId();
    public static String T2R_OFFER_CACHE_REGION = env.t2rOfferCacheRegion();
    public static String T2R_DECRYPT_MANDS_FUNC_KEY = env.t2rDecryptMAndSFunctionKey();
    //Tahoe services
    public static String TAHOE_HOST = System.getProperty("tahoeEnv") != null ?
            (System.getProperty("tahoeEnv").equalsIgnoreCase("EAST")?
                    env.tahoeEastHost(): (System.getProperty("tahoeEnv").equalsIgnoreCase("WEST") ? env.tahoeWestHost() : env.tahoeMultiIngressHost()))
            : env.tahoeMultiIngressHost();
    public static Integer TAHOE_PORT = Integer.valueOf(env.tahoeServicePort());

    public static String PAYMENT_SERVICE_HOST =  System.getProperty("tahoeEnv") != null ?
            (System.getProperty("tahoeEnv").equalsIgnoreCase("EAST")?
                    env.paymentServiceEastHost(): (System.getProperty("tahoeEnv").equalsIgnoreCase("WEST") ? env.paymentServiceWestHost() : env.paymentServiceMultiIngressHost()))
            : env.paymentServiceMultiIngressHost();
    public static Integer PAYMENT_SERVICE_PORT = Integer.valueOf(env.paymentServicePort());



}
