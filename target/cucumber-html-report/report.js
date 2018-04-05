$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Voicezone_features/Sign_In.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 19,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 21,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "\u003cFeature\u003e Get\"\u003cUsername\u003e\" and \"\u003cPassword\u003e\" and \"\u003cExe\u003e\" and \"\u003cBrowser\u003e\" and \u003ctimelim\u003e",
  "keyword": "Given "
});
formatter.examples({
  "line": 24,
  "name": "",
  "description": "",
  "id": "voicezone;voicezone;",
  "rows": [
    {
      "cells": [
        "Feature",
        "Username",
        "Password",
        "Exe",
        "Browser",
        "timelim"
      ],
      "line": 25,
      "id": "voicezone;voicezone;;1"
    },
    {
      "cells": [
        "NotifybyEmail",
        "NCSTest",
        "Password2013",
        "No",
        "Chrome",
        "80"
      ],
      "line": 26,
      "id": "voicezone;voicezone;;2"
    },
    {
      "cells": [
        "Voicetotext",
        "NCSTest",
        "Password2013",
        "No",
        "Chrome",
        "80"
      ],
      "line": 27,
      "id": "voicezone;voicezone;;3"
    },
    {
      "cells": [
        "Pinskip",
        "NCSTest",
        "Password2013",
        "No",
        "Chrome",
        "80"
      ],
      "line": 28,
      "id": "voicezone;voicezone;;4"
    },
    {
      "cells": [
        "Block Unwanted Callers",
        "NCSTest",
        "Password2013",
        "No",
        "Chrome",
        "80"
      ],
      "line": 29,
      "id": "voicezone;voicezone;;5"
    },
    {
      "cells": [
        "Accept Selected Callers",
        "NCSTest",
        "Password2013",
        "No",
        "Chrome",
        "80"
      ],
      "line": 30,
      "id": "voicezone;voicezone;;6"
    },
    {
      "cells": [
        "Block Outbound Caller ID",
        "NCSTest",
        "Password2013",
        "Yes",
        "Chrome",
        "80"
      ],
      "line": 31,
      "id": "voicezone;voicezone;;7"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 26,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "NotifybyEmail Get\"NCSTest\" and \"Password2013\" and \"No\" and \"Chrome\" and 80",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "NCSTest",
      "offset": 18
    },
    {
      "val": "Password2013",
      "offset": 32
    },
    {
      "val": "No",
      "offset": 51
    },
    {
      "val": "Chrome",
      "offset": 60
    },
    {
      "val": "80",
      "offset": 72
    }
  ],
  "location": "NotifybyEmail.notifybyemail_Get_and_and_and_and(String,String,String,String,int)"
});
formatter.result({
  "duration": 166596753,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "Voicetotext Get\"NCSTest\" and \"Password2013\" and \"No\" and \"Chrome\" and 80",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "NCSTest",
      "offset": 16
    },
    {
      "val": "Password2013",
      "offset": 30
    },
    {
      "val": "No",
      "offset": 49
    },
    {
      "val": "Chrome",
      "offset": 58
    },
    {
      "val": "80",
      "offset": 70
    }
  ],
  "location": "Voicetotext.Voicetotext_Get_and_and_and_and(String,String,String,String,int)"
});
formatter.result({
  "duration": 262551,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "Pinskip Get\"NCSTest\" and \"Password2013\" and \"No\" and \"Chrome\" and 80",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "NCSTest",
      "offset": 12
    },
    {
      "val": "Password2013",
      "offset": 26
    },
    {
      "val": "No",
      "offset": 45
    },
    {
      "val": "Chrome",
      "offset": 54
    },
    {
      "val": "80",
      "offset": 66
    }
  ],
  "location": "Pinskip.Pinskip_Get_and_and_and_and(String,String,String,String,int)"
});
formatter.result({
  "duration": 213220,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "Block Unwanted Callers Get\"NCSTest\" and \"Password2013\" and \"No\" and \"Chrome\" and 80",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "NCSTest",
      "offset": 27
    },
    {
      "val": "Password2013",
      "offset": 41
    },
    {
      "val": "No",
      "offset": 60
    },
    {
      "val": "Chrome",
      "offset": 69
    },
    {
      "val": "80",
      "offset": 81
    }
  ],
  "location": "BlockUnwantedCallers.block_Unwanted_Callers_Get_and_and_and_and(String,String,String,String,int)"
});
formatter.result({
  "duration": 230766,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone;;6",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "Accept Selected Callers Get\"NCSTest\" and \"Password2013\" and \"No\" and \"Chrome\" and 80",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "NCSTest",
      "offset": 28
    },
    {
      "val": "Password2013",
      "offset": 42
    },
    {
      "val": "No",
      "offset": 61
    },
    {
      "val": "Chrome",
      "offset": 70
    },
    {
      "val": "80",
      "offset": 82
    }
  ],
  "location": "AcceptSelectedCaller.accept_Selected_Callers_Get_and_and_and_and(String,String,String,String,int)"
});
formatter.result({
  "duration": 7816936,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Voicezone",
  "description": "",
  "id": "voicezone;voicezone;;7",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "Block Outbound Caller ID Get\"NCSTest\" and \"Password2013\" and \"Yes\" and \"Chrome\" and 80",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "NCSTest",
      "offset": 29
    },
    {
      "val": "Password2013",
      "offset": 43
    },
    {
      "val": "Yes",
      "offset": 62
    },
    {
      "val": "Chrome",
      "offset": 72
    },
    {
      "val": "80",
      "offset": 84
    }
  ],
  "location": "BlockOutboundCallerID.block_Outbound_Caller_ID_Get_and_and_and_and(String,String,String,String,int)"
});
formatter.result({
  "duration": 179625623724,
  "status": "passed"
});
});