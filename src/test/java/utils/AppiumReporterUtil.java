package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import io.appium.java_client.AppiumDriver;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class AppiumReporterUtil {

	private static final String BASE_URL = "http://localhost:4723";
    private static final String HTML_REPORT_DIR = System.getProperty("user.dir");
    private static final Set<String> reportedTests = new HashSet<>(); // prevent duplicate test reports
    public static void setTestInfo(String sessionId, String testName, String testStatus, String error) {
        try {
        	
        	 String uniqueKey = sessionId + "-" + testName;
             if (reportedTests.contains(uniqueKey)) {
                 return; // Skip duplicate report
             }
             reportedTests.add(uniqueKey);
            
            String body = "{" +
                    "\"sessionId\":\"" + sessionId + "\"," +
                    "\"testName\":\"" + testName + "\"," +
                    "\"testStatus\":\"" + testStatus + "\"," +
                    "\"error\":\"" + error + "\"" +
                    "}";
            System.out.println("Reporting: " + body);
            HttpResponse<JsonNode> response = Unirest.post(BASE_URL + "/setTestInfo")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asJson();
        } catch (Exception e) {
            System.out.println("Failed to set test info: " + e.getMessage());
        }
    }
    public static void setSkippedTestInfo(String testName, String testStatus, String error) {
        try {
            String body = "{" +
                    "\"testName\":\"" + testName + "\"," +
                    "\"testStatus\":\"" + testStatus + "\"," +
                    "\"error\":\"" + error + "\"" +
                    "}";
            HttpResponse<JsonNode> response = Unirest.post(BASE_URL + "/setTestInfo")
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asJson();
        } catch (Exception e) {
            System.out.println("Failed to report skipped test info");
        }
    }
    public static String getReport() {
        try {
            return Unirest.get(BASE_URL + "/getReport").asString().getBody();
        } catch (Exception e) {
            return "";
        }
    }
    public static void deleteReportData() {
        try {
            Unirest.delete(BASE_URL + "/deleteReportData").asEmpty();
        } catch (Exception e) {
            System.out.println("Failed to clear report data");
        }
    }
    public static void createReportFile(String data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(HTML_REPORT_DIR + "/" + fileName + ".html")) {
            fileWriter.write(data);
        } catch (IOException e) {
            System.out.println("Failed to write report file: " + e.getMessage());
        }
    }
    public static String getSessionId(AppiumDriver driver) {
        try {
            return driver.getSessionId().toString();
        } catch (Exception e) {
            return UUID.randomUUID().toString();
        }
    }
   
    public static boolean isDeviceFarm(AppiumDriver driver) {
        try {
            String deviceName = driver.getCapabilities().getCapability("deviceName").toString().toLowerCase();
            // Adjust this logic based on your real device names or patterns
            return !(deviceName.contains("emulator") || deviceName.contains("sdk"));
        } catch (Exception e) {
            return false; // default to false if something goes wrong
        }
    }
	    
	    
}
