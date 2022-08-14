package com.assignment.endtoendtest.utils;

public class Constants {
    private static Constants constants_instance = null;

    private Constants() {
    }

    public static Constants getInstance() {
        if (constants_instance == null) {
            constants_instance = new Constants();
        }
        return constants_instance;
    }

    public static final String PROPERTY_FILE_NAME = "config";
    static final String SERVER_IP = "BASE_URL";
    static final String TOKEN = "API_KEY";
    public static int SCENARIO_COUNT = 1;
    public static String contentType = "application/json";

    public static final String BASE_URL = Configuration.loadProperties(PROPERTY_FILE_NAME).getProperty(SERVER_IP);
    public static final String AUTH_TOKEN = Configuration.loadProperties(PROPERTY_FILE_NAME).getProperty(TOKEN);

    public static String email = "fakhrul@amagroup.io";
    public static String password = "Ama!892358802";
    public static String UserPoolId = "ap-southeast-2_V8zVkgzvH";
    public static String ClientId = "279v815dksd3dr1brinksacb72";
    public static String access_key = "AKIAWUYG3LAIS4UGPSFO";
    public static String secret_key = "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";
    public static String region = "ap-southeast-2";

    public class AppToken {
        public static final String CSO_TOKEN = "e0mr4apit9";
        public static final String DRM_TOKEN = "u0wi6yysyd";
        public static final String SURVEY_TOKEN = "2dkmvarfu9";
    }

    public static final String LEAGUE_ONE_NAME = "Ligue 1";
}
