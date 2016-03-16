$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/appiumTest/iOS/ooyalaPlayer_iOS.feature");
formatter.feature({
  "line": 2,
  "name": "Play video using Ooyala Player on iOS",
  "description": "\nAs a iOS user\nI want to play video using Ooyala Player",
  "id": "play-video-using-ooyala-player-on-ios",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@iOS"
    }
  ]
});
formatter.before({
  "duration": 8006364,
  "error_message": "java.lang.ExceptionInInitializerError\n\tat utils.CreateDriver.getIosDesiredCapabilities(CreateDriver.java:104)\n\tat utils.CreateDriver.startIOSDriver(CreateDriver.java:93)\n\tat utils.CreateDriver.setUp(CreateDriver.java:28)\n\tat com.appiumTest.iOS.iOSStepDef.setUp(iOSStepDef.java:18)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:223)\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:211)\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:201)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\n\tat org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\n\tat org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)\nCaused by: java.lang.RuntimeException: java.io.FileNotFoundException: class path resource [environment.properties] cannot be opened because it does not exist\n\tat utils.Settings.\u003cclinit\u003e(Settings.java:20)\n\t... 47 more\nCaused by: java.io.FileNotFoundException: class path resource [environment.properties] cannot be opened because it does not exist\n\tat org.springframework.core.io.ClassPathResource.getInputStream(ClassPathResource.java:172)\n\tat utils.Settings.\u003cclinit\u003e(Settings.java:17)\n\t... 47 more\n",
  "status": "failed"
});
formatter.scenario({
  "line": 8,
  "name": "Play Video",
  "description": "",
  "id": "play-video-using-ooyala-player-on-ios;play-video",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@iOS"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "app is launched",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I select video",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "video should play",
  "keyword": "Then "
});
formatter.match({
  "location": "iOSStepDef.app_is_launched()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "iOSStepDef.I_select_video()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "iOSStepDef.video_should_play()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 10900,
  "status": "passed"
});
});