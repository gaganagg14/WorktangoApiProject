package com.worktango.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.asserts.SoftAssert;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Utility {

   
    /**
     * Generic Method :Input takes any  Object ,returns extracted specific List as requested from an Object like offerId,Offercode for a  GRO input.
     *
     * @param rec               any List  like GRO ,GALO,GTO.
     * @param offerDet::offerId for a GRO to get list of offerIds
     * @returns List example: list of OfferIds,Offercode,..for GRO as Input.
     **/
    public static <T, R> List<String> loadObjectByType(List<T> rec, Function<T, R> offerDet) {
        List<String> hs = new ArrayList<>();
        for (T offerObj : rec) {
            hs.add((String) offerDet.apply(offerObj));
        }
        return hs;
    }


    /**
     * This method is used by ManageOfferStatusAPITest aswell
     *
     * @param lstType
     * @return dupOffers
     */
    public static Set<String> checkDupOffers(List<String> lstType) {
        Set<String> tempOffers = new HashSet<>();
        Set<String> dupOffers = null;
        if (lstType != null) {
            dupOffers = lstType.stream().filter(i -> !tempOffers.add(i)).collect(Collectors.toSet());
        }
        return dupOffers;

    }

    /**
     * This method is used by ManageOfferStatusAPITest aswell
     *
     * @param args
     * @return queryParams
     */
    public static Map<String, Object> urlParser(String args) {
        String query = args.split("\\?")[0];
        Map<String, Object> queryParams = new HashMap<String, Object>();
        final Map<String, String> mapStr = Splitter.on('&').trimResults().withKeyValueSeparator("=").split(query);
        queryParams.putAll(mapStr);
        return queryParams;
    }

  

    /* compare two object or List of object
     */
    public boolean compareObject(Object o1, Object o2) {
        if (o1 instanceof List<?> && o2 instanceof List<?>) {
            List l1 = (List<Object>) o1;
            List l2 = (List<Object>) o2;
            if (l1.size() != l2.size()) return false;
            return compareList(l1, l2);
        } else return EqualsBuilder.reflectionEquals(o1, o2);

    }

    //Random UUID function

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }




    /*
    Compare two generic List
     */
    private boolean compareList(List<Object> l1, List<Object> l2) {
        int count = 0;
        for (Object o : l1) {
            Object temp = o;
            for (Object otemp : l2) {
                if (EqualsBuilder.reflectionEquals(temp, otemp)) {
                    count++;
                }
            }

        }

        if (count == l1.size()) return true;
        return false;

    }


   

    public Properties loadPropertyFromFile(String sFileName) {
        Properties property = new Properties();
        InputStream inputStream = null;
        inputStream = getClass().getClassLoader().getResourceAsStream(sFileName);
        if (inputStream == null) {
            System.out.println("No file exists :" + sFileName);
            return null;
        } else {
            try {
                property.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return property;
    }

    public String findPDNByIP() {
        if (SystemProperties.host.split("\\.")[2].equalsIgnoreCase("20") || SystemProperties.host.split("\\.")[2].equalsIgnoreCase("21") || SystemProperties.host.contains("pn2")) {
            return "PDN_PN2";
        } else if (SystemProperties.host.split("\\.")[2].equalsIgnoreCase("4") || SystemProperties.host.split("\\.")[2].equalsIgnoreCase("5") || SystemProperties.host.contains("pn1")) {
            return "PDN_PN1";
        } else if (SystemProperties.host.contains("pdn")) {
            return "PDN_PN1";
        }
        return null;
    }



}