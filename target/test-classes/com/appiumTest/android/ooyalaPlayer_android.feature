@android
Feature: Play video using Ooyala Player on Android

  As a android user
  I want to play video using Ooyala Player

  @android
  Scenario: Play Video
    Given app is launched
    When I select video
    Then video should play