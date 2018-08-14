package com.example.demo.SpreadSheets;

import com.example.demo.DemoApplication;
import com.example.demo.constructor.SpecElement;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class SpreadSheets {

	/** Application name. */
	private static final String APPLICATION_NAME =
			"Google Sheets API Java Quickstart";

	/** Directory to store user credentials for this application. */

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY =
			JacksonFactory.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/** Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials
	 * at ~/.credentials/sheets.googleapis.com-java-quickstart
	 */
	private static final List<String> SCOPES =
			Arrays.asList(SheetsScopes.SPREADSHEETS,SheetsScopes.DRIVE);

	private static final java.io.File DATA_STORE_DIR = new java.io.File(
			System.getProperty("user.home"), ".credentials/2/sheets.googleapis.com-java-quickstart.json");
	
	private static Credential SpreadSheetCredential;

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Creates an authorized Credential object.
	 * @return an authorized Credential object.
	 * @throws Exception 
	 * 
	 */

	public static Credential authorize() throws Exception {
		// Load client secrets.
		
		if (SpreadSheetCredential != null){
			 if (SpreadSheetCredential.getExpiresInSeconds() >0)return SpreadSheetCredential; 
		}

		String path = DemoApplication.class.getClassLoader().getResource("client_secret.json").getPath();
		InputStream in = new FileInputStream(path);

		GoogleClientSecrets clientSecrets =
				GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow =
				new GoogleAuthorizationCodeFlow.Builder(
						HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(DATA_STORE_FACTORY)
				.setAccessType("offline")
				.build();
		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
		System.out.println(
				"Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
		SpreadSheetCredential = credential;
		return credential;
	}

	/*
	 * Build and return an authorized Sheets API client service.
	 * @return an authorized Sheets API client service
	 * @throws Exception 
	 */
	public static Sheets getSheetsService() throws Exception {
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME)
				.build();
	}


	public static void specSheetInsert(Map<SpecElement, Integer> specElements, String unitFullName) {

		List<List<Object>> testSpec = new ArrayList<List<Object>>();
		testSpec.add(Arrays.asList(unitFullName));

		for (Map.Entry<SpecElement, Integer> entry : specElements.entrySet()) {
			ArrayList<Object> line = new ArrayList<>();
			line.add(entry.getKey().getName());
			line.add(entry.getValue());
			testSpec.add(line);
		}
		try {
			insertRow(1,testSpec.size()+1);
			write(testSpec); // write to it
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void write(List<List<Object>> spec) throws Exception {

		int rowsQty = spec.size() + 1;
		String range = String.format("UnitSpecifications!A2:%s%d", "B", rowsQty);
		String valueInputOption = "USER_ENTERED";
		ValueRange requestBody = new ValueRange();
		Sheets sheetsService = getSheetsService();
		Sheets.Spreadsheets.Values.Update request =
				sheetsService.spreadsheets().values().update(TestSheet.sheetId, range, requestBody);
		request.setValueInputOption(valueInputOption);
		@SuppressWarnings("unused")
		UpdateValuesResponse response = request.execute();
		List<List<Object>> values = spec;
		ValueRange body = new ValueRange().setValues(values);
		UpdateValuesResponse result =
				sheetsService.spreadsheets().values().update(TestSheet.sheetId, range, body)
				.setValueInputOption(valueInputOption)
				.execute();
		System.out.printf("%d cells updated.", result.getUpdatedCells());
	}

	public static void insert(String line) throws Exception {

		// The A1 notation of a range to search for a logical table of data.
		// Values will be appended after the last row of the table.
		String range = "????!A1"; // TODO: Update placeholder value.

		// How the input data should be interpreted.
		String valueInputOption = "USER_ENTERED"; // TODO: Update placeholder value.

		// How the input data should be inserted.
		String insertDataOption = "OVERWRITE"; // TODO: Update placeholder value.

		// TODO: Assign values to desired fields of `requestBody`:
		ValueRange requestBody = new ValueRange();

		Sheets sheetsService = getSheetsService();
		Sheets.Spreadsheets.Values.Append request =
				sheetsService.spreadsheets().values().append(TestSheet.sheetId, range, requestBody);
		request.setValueInputOption(valueInputOption);
		request.setInsertDataOption(insertDataOption);

		// TODO: Change code below to process the `response` object:

		Object obj = line;
		List<List<Object>> values = Arrays.asList(
				Arrays.asList(obj)
				);
		ValueRange body = new ValueRange()
				.setValues(values);
		UpdateValuesResponse result =
				sheetsService.spreadsheets().values().update(TestSheet.sheetId, range, body)
				.setValueInputOption(valueInputOption)
				.execute();
		System.out.printf("%d cells updated.", result.getUpdatedCells());
		AppendValuesResponse response = request.execute();
		// TODO: Change code below to process the `response` object:
		System.out.println(response);
	}


	public static void insertRow(int startIndex, int rowsQty) throws Exception {

		// sheetGid is located in the tail of journal's URL.
		// The spreadsheet to apply the updates to.
		//String TestSheet.sheetId = "1569DTiMnVkdFzTW_Rint8juaqVySuRoBsQ0kD5aty04"; // TODO: Update placeholder value.
		// A list of updates to apply to the spreadsheet.
		// Requests will be applied in the order they are specified.
		// If any request is not valid, no requests will be applied.

		InsertDimensionRequest insertDimensionRequest = new InsertDimensionRequest();
		DimensionRange dimRange = new DimensionRange();
		dimRange.setStartIndex(startIndex);
		dimRange.setEndIndex(startIndex+rowsQty);
		dimRange.setSheetId(Integer.parseInt(TestSheet.gId));
		dimRange.setDimension("ROWS");
		insertDimensionRequest.setRange(dimRange);

		List<Request> requests = new ArrayList<Request>(); // TODO: Update placeholder value.
		requests.add( new Request().setInsertDimension(insertDimensionRequest));

		// TODO: Assign values to desired fields of `requestBody`:

		BatchUpdateSpreadsheetRequest requestBody = new BatchUpdateSpreadsheetRequest().setRequests(Arrays.asList(
				new Request().setInsertDimension(insertDimensionRequest)));

		requestBody.setRequests(requests);
		Sheets sheetsService = getSheetsService();
		Sheets.Spreadsheets.BatchUpdate request =
				sheetsService.spreadsheets().batchUpdate(TestSheet.sheetId, requestBody);

		System.out.println(TestSheet.sheetId);

		BatchUpdateSpreadsheetResponse response = request.execute();
		// TODO: Change code below to process the `response` object:
		System.out.println(response);

	}

	public static String read(String range) throws Exception {	        
		// Build a new authorized API client service.

		Sheets service = getSheetsService();
		ValueRange response = service.spreadsheets().values()
				.get(TestSheet.sheetId, range)
				.execute();
		List<List<Object>> values = response.getValues();

		if (values == null || values.size() == 0) {
			return "No data found.";
		} else {
			for (@SuppressWarnings("rawtypes") List row : values) {
				return (String) row.get(0);
			}  
		}
		return "";
	}
}