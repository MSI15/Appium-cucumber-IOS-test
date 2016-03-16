@iOS
Feature: Play video using Ooyala Player on iOS

  As a iOS user
  I want to play video using Ooyala Player

  @iOS
  Scenario: Play Video
    Given app is launched
    When I select video
    Then video should play