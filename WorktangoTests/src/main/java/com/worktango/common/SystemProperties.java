package com.worktango.common;


public class SystemProperties {
    public static String target = (String) getSystemProperty("target", "");
    public static String env = (String) getSystemProperty("env", "");
    public static String pbEnv = (String) getSystemProperty("pbEnv", "");
    public static String dc = (String) getSystemProperty("dc", "");

    public static String partnerId = (String) getSystemProperty("partner", "");
    public static String banner = (String) getSystemProperty("banner", "");
    public static String partnerCode = (String) getSystemProperty("partnerCode", "");
    public static String clientKey = (String) getSystemProperty("client", "");
    public static String secret = (String) getSystemProperty("secret", "");
    public static String publicKey = (String) getSystemProperty("public", "");
    public static String privateKey = (String) getSystemProperty("private", "");
    public static String appId = (String) getSystemProperty("appId", "");

    public static String testhost = (String) getSystemProperty("testhost", "");
    public static String testcomphost = (String) getSystemProperty("testcomphost", "");
    public static Integer testport = Integer.parseInt(getSystemProperty("testport", 0).toString());
    public static Integer testcompport = Integer.parseInt(getSystemProperty("testcompport", 0).toString());

    public static String TEST_USER_TARGETED = "";
    public static String TEST_USER_INLANETARGETED = "";

    public static Boolean runDataSetupScript = Boolean.valueOf(getSystemProperty("runDataSetupScript", "false").toString());
    public static String retPartnerCode = (String) getSystemProperty("retPartnerCode", "");
    public static String retAppId = (String) getSystemProperty("retAppId", "");
    public static String retPartner = (String) getSystemProperty("retPartner", "");
    public static String retClientKey = (String) getSystemProperty("retClientKey", "");
    public static String retSecret = (String) getSystemProperty("retSecret", "");
    public static String retPublic = (String) getSystemProperty("retPublic", "");
    public static String retPrivate = (String) getSystemProperty("retPrivate", "");

    public static String affUserId = (String) getSystemProperty("affUserId", "");
    public static String retUserId = (String) getSystemProperty("retUserId", "");

    public static String affAppId = (String) getSystemProperty("affAppId", "");
    public static String affSecret = (String) getSystemProperty("affSecret", "");
    public static String affPartner = (String) getSystemProperty("affPartner", "");
    public static String affClientKey = (String) getSystemProperty("affClientKey", "");
    public static String affPublic = (String) getSystemProperty("affPublic", "");
    public static String affPrivate = (String) getSystemProperty("affPrivate", "");
    public static String affPartnerCode = (String) getSystemProperty("affPartnerCode", "");

    public static Integer port = Integer.parseInt(getSystemProperty("port", 0).toString());
    public static Integer compport = Integer.parseInt(getSystemProperty("compport", 0).toString());

    public static String testPriority = (String) getSystemProperty("testpriority", "");
    public static String host = getHost(System.getProperty("host")); // To-do
    public static String comphost = getHost(System.getProperty("comphost")); // To-do
    public static String circularhost = getHost(System.getProperty("circularhost")); // To-do
    public static String saleshost = getHost(System.getProperty("saleshost")); // To-do
    public static String continuityHost = getHost(System.getProperty("continuityHost"));
    public static String cacheCoordinatorHost = getHost(System.getProperty("cacheCoordinatorHost"));
    public static Integer continuityPort = Integer.parseInt(getSystemProperty("continuityPort", 0).toString());
    public static Integer cacheCoordinatorPort = Integer.parseInt(getSystemProperty("cacheCoordinatorPort", 0).toString());
    public static String salesEngineHost = getHost(System.getProperty("salesEngineHost"));
    public static Integer salesEnginePort = Integer.parseInt(getSystemProperty("salesEnginePort", 0).toString());
    public static Boolean setupInlanePrgms = Boolean.valueOf(getSystemProperty("setupInlanePrgms", Boolean.FALSE).toString());
    public static Integer circularport = Integer.parseInt(getSystemProperty("circularport", 0).toString());
    public static String version = (String) getSystemProperty("version", "1.0");
    public static String app = (String) getSystemProperty("app", "ALL");

    public static String appIds = (String) getSystemProperty("appIds", "");
    public static String userId = (String) getSystemProperty("userId", "");
    public static Boolean affiliateMode = Boolean.parseBoolean(getSystemProperty("affiliateMode", Boolean.FALSE).toString());

    public static String partnerBannerName = (String) getSystemProperty("partnerBannerName", "");
    public static String cassandraHost = (String) getSystemProperty("cassandraHost", "");
    public static String keySpace = (String) getSystemProperty("keySpace", "");
    public static String zipCodes = (String) getSystemProperty("zipCodes", "");
    public static String cprHost = (String) getSystemProperty("cprhost", "");
    public static Boolean migrationPath = Boolean.parseBoolean(getSystemProperty("runMigrationPath", Boolean.FALSE).toString());
    public static Boolean isBackupMode = Boolean.parseBoolean(getSystemProperty("isBackupMode", Boolean.FALSE).toString());
    public static Boolean isHornetLdap = Boolean.parseBoolean(getSystemProperty("isHornetLdap", Boolean.FALSE).toString());
    public static Boolean useLbConfigs = Boolean.parseBoolean(getSystemProperty("useLbConfigs", Boolean.FALSE).toString());
    public static Boolean isRetryMode = Boolean.parseBoolean(getSystemProperty("isRetryMode", Boolean.FALSE).toString());
    public static Boolean isActiveQEnabled = Boolean.parseBoolean(getSystemProperty("isActiveQEnabled", Boolean.FALSE).toString());

    public static String tcHost = (String) getSystemProperty("tchost", "");
    public static Integer tcPort = (Integer) getSystemProperty("tchost", 0);
    public static String tcPartnerId = (String) getSystemProperty("tcpartner", "");
    public static Boolean runGCOInProd = Boolean.parseBoolean(getSystemProperty("runGCOInProd", Boolean.FALSE).toString());
    public static String storeCode = (String) getSystemProperty("storeCode", "");
    public static String nreHost = (String) getSystemProperty("nrehost", "");
    public static Integer nrePort = 8099;
    public static Boolean enableFilterTests = Boolean.parseBoolean(getSystemProperty("enableFilterTests", Boolean.FALSE).toString());
    public static Boolean enableCacheRefresh = Boolean.parseBoolean(getSystemProperty("enableCacheRefresh", Boolean.FALSE).toString());
    public static Boolean ENABLE_COMPRESSION = Boolean.parseBoolean(getSystemProperty("enableCompression", Boolean.FALSE).toString());
    public static String NONCE_CONSTANT = "RIQRegression";
    public static Integer circularCacheRefreshIntervalMS = Integer.parseInt(getSystemProperty("circularCacheRefreshIntervalMS", 0).toString());
    public static Boolean qaMetrics = Boolean.parseBoolean(getSystemProperty("qametrics", Boolean.FALSE).toString());

    // The receipt scan host to be provided as VM args
    public static String receiptScanHost = getHost(System.getProperty("receiptScanHost"));


    private static Object getSystemProperty(String sAttribute, Object defaultValue) {
        return System.getProperty(sAttribute) != null ? System.getProperty(sAttribute) : defaultValue;
    }

    private static final String seperator = "#%#";

    public static String getHost(String pSuppliedHost) {
        if (pSuppliedHost == null)
            return "";
        if (pSuppliedHost.contains(seperator))
            return (pSuppliedHost.split(seperator)[0]);
        else
            return pSuppliedHost;
    }

    public static boolean needHMAC() {
        if (!publicKey.isEmpty() && !privateKey.isEmpty())
            return true;
        else
            return false;
    }

    public static boolean getTestHttps() {
        if (port == 443)
            return true;
        else
            return false;
    }

    public static String getPrefix() {
        if (target.equals("WS") || target.equals("VIP")) {
            if (host.equalsIgnoreCase("cfire.apir.receiptiq.com"))
                return "RestWS";
            else
                return "service";
        } else if (target.equals("GW")) {
            return "coupons-nextgen-gateway";
        } else {
            return "coupons-nextgen-rest-provider";
        }
    }
}