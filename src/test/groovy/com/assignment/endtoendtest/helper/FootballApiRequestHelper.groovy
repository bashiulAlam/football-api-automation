package com.assignment.endtoendtest.helper

import com.assignment.endtoendtest.endpoints.FootballEndPoints
import com.assignment.endtoendtest.utils.Constants
import com.assignment.endtoendtest.utils.HeaderBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static io.restassured.RestAssured.given

class FootballApiRequestHelper {
    private static Logger logger = LoggerFactory.getLogger(FootballApiRequestHelper.class)

    static def contentType = "application/json"
    static def baseUrl = Constants.BASE_URL

    static def getCompetitions() {
        def response
        try {
            def path = FootballEndPoints.COMPETITIONS
            logger.info("\nRequest URL: " + baseUrl + path)

            def header = new HeaderBuilder()
                    .addContentType(contentType)
                    .build()

            response = given()
                    .baseUri(baseUrl).headers(header).body()
                    .when()
                    .get(path)
                    .then()
                    .extract().response()

            return response
        } catch (Exception ex) {
            return ExceptionHelper.handleException(ex)
        }
    }

    static def getMatchesByCompetitionId(def id) {
        def response
        try {
            def path = FootballEndPoints.GET_MATCH_BY_ID.replace("{id}", id)
            logger.info("\nRequest URL: " + baseUrl + path)

            def header = new HeaderBuilder()
                    .addContentType(contentType)
                    .addXAuthToken(Constants.AUTH_TOKEN)
                    .build()

            response = given()
                    .baseUri(baseUrl).headers(header).body()
                    .when()
                    .get(path)
                    .then()
                    .extract().response()

            return response
        } catch (Exception ex) {
            return ExceptionHelper.handleException(ex)
        }
    }
}
