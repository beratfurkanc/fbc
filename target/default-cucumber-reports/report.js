$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com/apptium/features/amc.feature");
formatter.feature({
  "name": "AMC",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "get available times for a movie",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@amc"
    }
  ]
});
formatter.step({
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "name": "User select a \"\u003cmovie\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User click get tickets for the movie",
  "keyword": "Then "
});
formatter.step({
  "name": "User change the location with \"\u003czipCode\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "name": "User search for available \"\u003cdays\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "movie",
        "zipCode",
        "days"
      ]
    },
    {
      "cells": [
        "The Lion King",
        "20170",
        "3"
      ]
    },
    {
      "cells": [
        "IT Chapter Two",
        "20170",
        "3"
      ]
    }
  ]
});
formatter.scenario({
  "name": "get available times for a movie",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@amc"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "Amc_Step_Def.user_is_on_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User select a \"The Lion King\"",
  "keyword": "When "
});
formatter.match({
  "location": "Amc_Step_Def.user_select_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click get tickets for the movie",
  "keyword": "Then "
});
formatter.match({
  "location": "Amc_Step_Def.user_click_get_tickets_for_the_movie()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User change the location with \"20170\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Amc_Step_Def.user_change_the_location_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search for available \"3\"",
  "keyword": "And "
});
formatter.match({
  "location": "Amc_Step_Def.user_search_for_available(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "get available times for a movie",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@amc"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "Amc_Step_Def.user_is_on_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User select a \"IT Chapter Two\"",
  "keyword": "When "
});
formatter.match({
  "location": "Amc_Step_Def.user_select_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click get tickets for the movie",
  "keyword": "Then "
});
formatter.match({
  "location": "Amc_Step_Def.user_click_get_tickets_for_the_movie()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User change the location with \"20170\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Amc_Step_Def.user_change_the_location_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User search for available \"3\"",
  "keyword": "And "
});
formatter.match({
  "location": "Amc_Step_Def.user_search_for_available(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});