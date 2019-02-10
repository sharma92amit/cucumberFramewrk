$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/bdd/feature/Automate.feature");
formatter.feature({
  "line": 1,
  "name": "Add Product into Cart",
  "description": "",
  "id": "add-product-into-cart",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 82,
  "name": "Validate Cart Summary Page is Displaying The Same Product Name,Color and Quantity",
  "description": "",
  "id": "add-product-into-cart;validate-cart-summary-page-is-displaying-the-same-product-name,color-and-quantity",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 81,
      "name": "@CartTest"
    }
  ]
});
formatter.step({
  "line": 84,
  "name": "User Open Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "User Open The URL",
  "keyword": "Then "
});
formatter.step({
  "line": 86,
  "name": "User is on Home Page",
  "keyword": "Then "
});
formatter.step({
  "line": 87,
  "name": "Hover on the MegaMenu Dresses",
  "keyword": "Then "
});
formatter.step({
  "line": 88,
  "name": "Summer Dresses SubMenu is Displaying",
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "Click on Summer Dresses Menu",
  "keyword": "Then "
});
formatter.step({
  "line": 90,
  "name": "Summer Dresses Page is Load",
  "keyword": "When "
});
formatter.step({
  "line": 91,
  "name": "Click on View \"\u003cVIEW\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 92,
  "name": "Products Should Display in \"\u003cVIEW\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "Click on The Product which has Blue Color Option",
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "Product View Page is Load",
  "keyword": "When "
});
formatter.step({
  "line": 95,
  "name": "Enter Quantity \"\u003cQTY\u003e\" and Size \"\u003cSIZE\u003e\" and Color \"\u003cCOLOR\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 96,
  "name": "Click on Add to Card button",
  "keyword": "Then "
});
formatter.step({
  "line": 97,
  "name": "Product Successfully Added Pop up Appear",
  "keyword": "When "
});
formatter.step({
  "line": 98,
  "name": "Click on Proceed to Checkout button",
  "keyword": "Then "
});
formatter.step({
  "line": 99,
  "name": "Shopping Cart Summary Paged Load",
  "keyword": "When "
});
formatter.step({
  "line": 100,
  "name": "Product Color as \"\u003cCOLOR\u003e\" Quantity as \"\u003cQTY\u003e\" Size as \"\u003cSIZE\u003e\" should be Selected",
  "keyword": "Then "
});
formatter.step({
  "line": 101,
  "name": "Close Browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 103,
  "name": "",
  "description": "",
  "id": "add-product-into-cart;validate-cart-summary-page-is-displaying-the-same-product-name,color-and-quantity;",
  "rows": [
    {
      "cells": [
        "QTY",
        "SIZE",
        "COLOR",
        "VIEW"
      ],
      "line": 104,
      "id": "add-product-into-cart;validate-cart-summary-page-is-displaying-the-same-product-name,color-and-quantity;;1"
    },
    {
      "cells": [
        "2",
        "M",
        "Blue",
        "List"
      ],
      "line": 105,
      "id": "add-product-into-cart;validate-cart-summary-page-is-displaying-the-same-product-name,color-and-quantity;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 105,
  "name": "Validate Cart Summary Page is Displaying The Same Product Name,Color and Quantity",
  "description": "",
  "id": "add-product-into-cart;validate-cart-summary-page-is-displaying-the-same-product-name,color-and-quantity;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 81,
      "name": "@CartTest"
    }
  ]
});
formatter.step({
  "line": 84,
  "name": "User Open Browser",
  "keyword": "Given "
});
formatter.step({
  "line": 85,
  "name": "User Open The URL",
  "keyword": "Then "
});
formatter.step({
  "line": 86,
  "name": "User is on Home Page",
  "keyword": "Then "
});
formatter.step({
  "line": 87,
  "name": "Hover on the MegaMenu Dresses",
  "keyword": "Then "
});
formatter.step({
  "line": 88,
  "name": "Summer Dresses SubMenu is Displaying",
  "keyword": "When "
});
formatter.step({
  "line": 89,
  "name": "Click on Summer Dresses Menu",
  "keyword": "Then "
});
formatter.step({
  "line": 90,
  "name": "Summer Dresses Page is Load",
  "keyword": "When "
});
formatter.step({
  "line": 91,
  "name": "Click on View \"List\"",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 92,
  "name": "Products Should Display in \"List\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 93,
  "name": "Click on The Product which has Blue Color Option",
  "keyword": "Then "
});
formatter.step({
  "line": 94,
  "name": "Product View Page is Load",
  "keyword": "When "
});
formatter.step({
  "line": 95,
  "name": "Enter Quantity \"2\" and Size \"M\" and Color \"Blue\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 96,
  "name": "Click on Add to Card button",
  "keyword": "Then "
});
formatter.step({
  "line": 97,
  "name": "Product Successfully Added Pop up Appear",
  "keyword": "When "
});
formatter.step({
  "line": 98,
  "name": "Click on Proceed to Checkout button",
  "keyword": "Then "
});
formatter.step({
  "line": 99,
  "name": "Shopping Cart Summary Paged Load",
  "keyword": "When "
});
formatter.step({
  "line": 100,
  "name": "Product Color as \"Blue\" Quantity as \"2\" Size as \"M\" should be Selected",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 101,
  "name": "Close Browser",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePageStepsDefination.user_Open_Browser()"
});
formatter.result({
  "duration": 4629118400,
  "status": "passed"
});
formatter.match({
  "location": "HomePageStepsDefination.user_Open_URL()"
});
formatter.result({
  "duration": 60040112600,
  "error_message": "org.openqa.selenium.TimeoutException: timeout\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.46.628402 (536cd7adbad73a3783fdc2cab92ab2ba7ec361e1),platform\u003dWindows NT 10.0.17763 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.5.3\u0027, revision: \u0027a88d25fe6b\u0027, time: \u00272017-08-29T12:42:44.417Z\u0027\nSystem info: host: \u0027APPIRIO-13246\u0027, ip: \u0027192.168.0.101\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_201\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, timeouts\u003d{implicit\u003d0, pageLoad\u003d300000, script\u003d30000}, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:49683}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, platformName\u003dXP, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003dignore, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.46.628402 (536cd7adbad73a3783fdc2cab92ab2ba7ec361e1), userDataDir\u003dC:\\Users\\APPIRI~2\\AppData\\Local\\Temp\\scoped_dir26180_21755}, takesHeapSnapshot\u003dtrue, unhandledPromptBehavior\u003dignore, pageLoadStrategy\u003dnormal, strictFileInteractability\u003dfalse, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d71.0.3578.98, browserConnectionEnabled\u003dfalse, proxy\u003dProxy(), nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 00379b668ff88de0fad1dea5f804bbfe\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:82)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:646)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:370)\r\n\tat com.util.Base.TestCommands.openUrl(TestCommands.java:139)\r\n\tat com.automation.stepdefination.HomePageStepsDefination.user_Open_URL(HomePageStepsDefination.java:35)\r\n\tat ✽.Then User Open The URL(src/test/java/com/bdd/feature/Automate.feature:85)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "HomePageStepsDefination.user_is_on_Home_Page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.hover_on_the_MegaMenu_Dresses()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.summer_Dresses_SubMenu_is_Displaying()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.click_on_Summer_Dresses_Menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.summer_Dresses_Page_is_Load()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "List",
      "offset": 15
    }
  ],
  "location": "HomePageStepsDefination.click_on_View_Grid(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "List",
      "offset": 28
    }
  ],
  "location": "HomePageStepsDefination.products_Should_Display_in_Grid(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.click_on_The_Product_which_has_Blue_Color_Option()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.product_View_Page_is_Load()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 16
    },
    {
      "val": "M",
      "offset": 29
    },
    {
      "val": "Blue",
      "offset": 43
    }
  ],
  "location": "HomePageStepsDefination.enter_Quantity_and_Size_and_Color(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.click_on_Add_to_Card_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.product_Successfully_Added_Pop_up_Appear()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.click_on_Proceed_to_Checkout_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.shopping_Cart_Summary_Paged_Load()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Blue",
      "offset": 18
    },
    {
      "val": "2",
      "offset": 37
    },
    {
      "val": "M",
      "offset": 49
    }
  ],
  "location": "HomePageStepsDefination.product_Color_Quantity_Size_should_be_same_as_Selected(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "HomePageStepsDefination.close_Browser()"
});
formatter.result({
  "status": "skipped"
});
});