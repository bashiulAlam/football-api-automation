package com.assignment.endtoendtest.specification

import com.assignment.endtoendtest.helper.FootballApiRequestHelper
import com.assignment.endtoendtest.utils.Constants
import com.assignment.endtoendtest.utils.Utils
import io.restassured.path.json.JsonPath
import io.restassured.path.json.config.JsonPathConfig
import org.junit.Rule
import org.junit.rules.TestName
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll
import jodd.json.*

class APITestSpec extends Specification {
    private static Logger logger = LoggerFactory.getLogger(APITestSpec.class)

    @Rule
    TestName testName = new TestName()

    static def scenarioCount = 1
    static def scenarioSerial = Utils.formatNumber(scenarioCount)

    @Shared
    static def leagueId = -1

    def setupSpec() {
        logger.info("Setup Spec method executed...")
    }

    def setup() {
        logger.info("\n\n============================== Scenario - " + testName.methodName + " ==============================\n")
        ++scenarioCount
        scenarioSerial = Utils.formatNumber(scenarioCount)
    }

    @Unroll
    def "(#scenarioSerial) Get competitions"() {
        when: "we search for competitions"
        def response = FootballApiRequestHelper.getCompetitions()
        logger.info("Status code : " + response.statusCode())
        logger.info("Json Response : " + response.getBody().asString())

        def totalCount = JsonSerializer.create().serialize(response.path("count"))
        logger.info("Total competition count : " + totalCount)

        JsonPath path = response.jsonPath()
        int s = path.getInt("competitions.size()")
        for(int i = 0; i < s; i++) {
            def id = path.getString("competitions[" + i + "].id")
            def name = path.getString("competitions[" + i + "].name")
            if (name.equals(leagueName)) {
                leagueId = id
                break
            }
        }

        logger.info("Id of " + leagueName + " is : " + leagueId)

        then: "we receive a success response"
        response.statusCode() == responseCode

        where: "a set of parameters"
        responseCode | leagueName | scenarioSerial
        200 | Constants.LEAGUE_ONE_NAME | scenarioSerial
    }

    @Unroll
    def "(#scenarioSerial) Get league one matches"() {
        when: "we search for a league matches by id"
        def response = FootballApiRequestHelper.getMatchesByCompetitionId(leagueId)
        logger.info("Status code : " + response.statusCode())
        logger.info("Json Response : " + response.getBody().asString())

        def totalCount = JsonSerializer.create().serialize(response.path("count"))
        logger.info("Total matches count : " + totalCount)

        def homeTeamList = new ArrayList<String>()
        def awayTeamList = new ArrayList<String>()

        JsonPath path = response.jsonPath()
        int s = path.getInt("matches.size()")
        for(int i = 0; i < s; i++) {
            homeTeamList.add(path.getString("matches[" + i + "].homeTeam.name"))
            awayTeamList.add(path.getString("matches[" + i + "].awayTeam.name"))
        }

        logger.info("Home team names : ")
        for (int i = 0; i < homeTeamList.size(); i++)
            logger.info(homeTeamList.get(i))

        logger.info("Away team names : ")
        for (int i = 0; i < awayTeamList.size(); i++)
            logger.info(awayTeamList.get(i))

        then: "we receive a success response"
        response.statusCode() == responseCode && homeTeamList.size() > 0 && awayTeamList.size() > 0

        where: "a set of parameters"
        responseCode | leagueId | scenarioSerial
        200 | leagueId | scenarioSerial
    }
}
