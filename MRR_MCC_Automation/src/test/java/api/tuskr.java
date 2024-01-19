package api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public abstract class tuskr {	
	
	static String testRunName;

	public static void createTestRun(String tuskrProject) throws UnirestException, IOException {
		String body = null;
		String testCases = null;
		
		Path fileName = Path.of("src/test/resources/updateStatus.txt");
		String updateStatusFile = Files.readString(fileName);
		String[] separateTestCases = updateStatusFile.split(";", 0);
		
		for(int i=0;i<separateTestCases.length;i++) {
			if(testCases == null) {
				testCases = '"' + separateTestCases[i].split(",")[0] + '"';
			}else {
				testCases = testCases + ',' + '"' + separateTestCases[i].split(",")[0] + '"';
			}
		} 

		fileName = Path.of("src/test/resources/api/createTestRunBody.txt");
		body = Files.readString(fileName);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		testRunName = tuskrProject + " Automated Test Run " + dtf.format(now);
		body = body.replace("&&_TestRunName_&&", testRunName);
		body = body.replace("&&_Project_&&", tuskrProject);
		body = body.replace("&&_TestCases_&&", testCases);
		
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		body = body.replace("&&_Date_&&", dtf.format(now));
		
		Unirest.setTimeouts(0, 0);
		HttpResponse<String> response = Unirest.post("https://api.tuskr.live/api/tenant/0789f22a-ae0d-4e80-b1d6-a7ece8ae304f/test-run")
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer 94I6CvTTFMPSPcZpVzXqX4E48D2D7pLMrQyeCUiH")
				.body(body)
				.asString();
		
		System.out.println(response.getBody());
	}
	
	public static void updateTestResults() throws UnirestException, IOException {
		Unirest.setTimeouts(0, 0);
		String body = null;
		
		Path fileName = Path.of("src/test/resources/updateStatus.txt");
		String updateStatusFile = Files.readString(fileName);
		String[] separateTestCases = updateStatusFile.split(";", 0);
		
		//Report PASSED
		String testCases = null;
		for(int i=0;i<separateTestCases.length;i++) {
			if(separateTestCases[i].contains("PASSED")) {
				if(testCases == null) {
					testCases = '"' + separateTestCases[i].split(",")[0] + '"';
				}else {
					testCases = testCases + ',' + '"' + separateTestCases[i].split(",")[0] + '"';
				}
			}
		} 
		
		fileName = Path.of("src/test/resources/api/updateTestStatus.txt");
		
		if(testCases != null) {	
			body = Files.readString(fileName);
			body = body.replace("&&_TestRunName_&&", testRunName);
			body = body.replace("&&_Status_&&", "PASSED");
			body = body.replace("&&_TestCases_&&", testCases);
			HttpResponse<String> response = Unirest.post("https://api.tuskr.live/api/tenant/0789f22a-ae0d-4e80-b1d6-a7ece8ae304f/test-run-result/bulk")
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer 94I6CvTTFMPSPcZpVzXqX4E48D2D7pLMrQyeCUiH")
					.body(body)
					.asString();
			
			System.out.println(response.getBody());
		}
		
		
		//Report FAILED
		testCases = null;
		for(int i=0;i<separateTestCases.length;i++) {
			if(separateTestCases[i].contains("FAILED")) {
				if(testCases == null) {
					testCases = '"' + separateTestCases[i].split(",")[0] + '"';
				}else {
					testCases = testCases + ',' + '"' + separateTestCases[i].split(",")[0] + '"';
				}
			}
		} 
		
		if(testCases != null) {	
			body = Files.readString(fileName);
			body = body.replace("&&_TestRunName_&&", testRunName);
			body = body.replace("&&_Status_&&", "FAILED");
			body = body.replace("&&_TestCases_&&", testCases);
			HttpResponse<String> response = Unirest.post("https://api.tuskr.live/api/tenant/0789f22a-ae0d-4e80-b1d6-a7ece8ae304f/test-run-result/bulk")
					.header("Content-Type", "application/json")
					.header("Authorization", "Bearer 94I6CvTTFMPSPcZpVzXqX4E48D2D7pLMrQyeCUiH")
					.body(body)
					.asString();
					
			System.out.println(response.getBody());	
		}
	}
}
