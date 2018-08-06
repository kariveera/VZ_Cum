#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Voicezone

  Scenario Outline: Voicezone
    Given <Feature> Get"<Username>" and "<Password>" and "<Exe>" and "<Browser>" and <timelim>

    Examples: 
      | Feature                     | Username | Password     | Exe | Browser | timelim |
      | Block Unwanted Callers      | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | NotifybyText                | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | Accept Selected Callers     | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | Block Outbound Caller ID    | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | Nomorobo                    | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | AnswerAnywhere              | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | CallForwardingBusy          | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | CallForwardingNoAnswer      | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | CallForwardingUnconditional | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | SelectiveCallForwarding     | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | VIPRing                     | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | SpeedDial                   | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | CallBlockerBasicPlus        | NCSTest  | Password2013 | No  | Chrome  |      80 |
      | NotifybyEmail               | NCSTest  | Password2013 | No  | Chrome  |      80 |
      | ThreeWayCalling             | NCSTest  | Password2013 | Yes | Chrome  |      80 |
      | Voicetotext                 | NCSTest  | Password2013 | No  | Chrome  |      80 |
      | Pinskip                     | NCSTest  | Password2013 | No  | Chrome  |      80 |
      | Pinchange                   | NCSTest  | Password2013 | No  | Chrome  |      80 |
      | CallWaiting                 | NCSTest  | Password2013 | No  | Chrome  |      80 |
