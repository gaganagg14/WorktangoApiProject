package com.coupons.riq.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:com/coupons/riq/envconfig/${env}.properties")
public interface Environment extends Config {
    @Key("rebate.service.host")
    String rebateServiceHost();

    @Key("rebate.service.port")
    String rebateServicePort();
    
    @Key("user.profile.host")
    String useProfileServiceHost();
    
    @Key("user.profile.port")
    String useProfileServicePort();
    
    @Key("payment.service.host")
    String paymentServiceHost();

    @Key("pubsub.service.host")
    String pubsubServiceHost();
    
    @Key("pubsub.service.port")
    String pubsubServicePort();

    @Key("url.service.host")
    String urlServiceHost();

    @Key("url.service.port")
    String urlServicePort();

    @Key("sms.service.host")
    String smsServiceHost();

    @Key("sms.service.port")
    String smsServicePort();

    @Key("cpr.service.host")
    String cprHost();

    @Key("cpr.service.port")
    String cprPort();

    @Key("cpr.service.pid")
    String cprPid();

    @Key("cpr.service.nid")
    String cprNid();

    @Key("coupon.nextgen.gw.lb.host")
    String couponNextGenGWLBHost();

    @Key("coupon.nextgen.gw.lb.port")
    String couponNextGenGWLBPort();

    @Key("coupon.nextgen.rest.lb.host")
    String couponNextGenRestLBHost();

    @Key("coupon.nextgen.rest.lb.port")
    String couponNextGenRestLBPort();

    @Key("text2rebate.couponsAffiliateAppId")
    String textToRebateCouponsAffiliateAppId();

    @Key("shopmium.application.key")
    String shopmiumApplicationKey();

    @Key("couponsAffiliate.webAppId")
    String couponsAffiliateWebAppID();

    @Key("cache.coordinator.host")
    String ccHost();

    @Key("cache.coordinator.port")
    Integer ccPort();

    @Key("couponsAffiliate.iosAppId")
    String couponsAffiliateIOSAppID();

    @Key("tahoe.couponsAffiliateAppId")
    String tahoeCouponsAffiliateAppId();

    @Key("tahoe.defaultAppId")
    String tahoeDefaultAppId();

    @Key("redemption.service.host")
    String redemptionServiceHost();

    @Key("redemption.service.port")
    String redemptionServicePort();

    @Key("receipt.scan.host")
    String receiptScanHost();

    @Key("receipt.scan.port")
    String receiptScanPort();

    @Key("tahoe.east.host")
    String tahoeEastHost();

    @Key("tahoe.west.host")
    String tahoeWestHost();

    @Key("tahoe.multi.ingress.host")
    String tahoeMultiIngressHost();

    @Key("payment.service.multi.ingress.host")
    String paymentServiceMultiIngressHost();

    @Key("tahoe.service.port")
    String tahoeServicePort();

    @Key("payment.service.west.host")
    String paymentServiceWestHost();

    @Key("payment.service.east.host")
    String paymentServiceEastHost();

    @Key("payment.service.port")
    String paymentServicePort();

    @Key("t2r.offer.cache.region")
    String t2rOfferCacheRegion();

    @Key("t2r.decrypt.mands.func.key")
    String t2rDecryptMAndSFunctionKey();
}

