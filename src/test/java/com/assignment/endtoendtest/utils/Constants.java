package com.assignment.endtoendtest.utils;

public class Constants {
    public static final String PROPERTY_FILE_NAME = "config";
    static final String SERVER_IP = "BASE_URL";
    static final String TOKEN = "API_KEY";

    public static final String BASE_URL = Configuration.loadProperties(PROPERTY_FILE_NAME).getProperty(SERVER_IP);
    public static final String AUTH_TOKEN = Configuration.loadProperties(PROPERTY_FILE_NAME).getProperty(TOKEN);

    public static final String LEAGUE_ONE_NAME = "Ligue 1";
}
