package api;

import java.io.*;
import java.net.*;

class Light {

	boolean state;
	String name;

	public static void main(String[] args) throws IOException {
		//Light.getLights();
		//String testString = "{\"id\":\"001788fffe6069a9\",\"internalipaddress\":\"192.168.1.2\"}";
		
		String testString = getLights();
		System.out.println(testString);
		//JsonUtils.parseJson(testString);
	}

	public static void setLight() throws IOException {

		String urlName = "http://192.168.1.2/api/";
		String username = "bRhx2nVLKUxHyblPW9dfoBsJ3BwR98qh0uY-NgsG";
		String fullUrl = urlName + username + "/lights/1/state";
		String command = "{\"on\": false}";
		//String command = "{\"bri\": 50}";

		StringBuilder result = new StringBuilder();
		URL url = new URL(fullUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
		out.write(command);
		out.close();

		try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			for (String line; (line = reader.readLine()) != null;) {
				result.append(line);
			}
		}
		System.out.println(result);

	}

	public static String getLights() throws IOException {

		String urlName = "http://192.168.1.2/api/";
		String username = "bRhx2nVLKUxHyblPW9dfoBsJ3BwR98qh0uY-NgsG";
		String fullUrl = urlName + username + "/lights/";

		StringBuilder result = new StringBuilder();
		URL url = new URL(fullUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			for (String line; (line = reader.readLine()) != null;) {
				result.append(line);
			}
		}
		
		String newResult = result.toString();
		return newResult;
	}

	public static void getConnect(String[] args) {

		// id: "001788fffe6069a9"
		// internalIpAddress: "192.168.1.2"
		// username: "bRhx2nVLKUxHyblPW9dfoBsJ3BwR98qh0uY-NgsG"
		String urlName = "https://discovery.meethue.com/";

		try {
			URL myURL = new URL(urlName);
			System.out.println("Created URL. Proceeding to create URLConnection.");

			URLConnection myURLConnection = myURL.openConnection();
			System.out.println("Created URLConnection. Proceeding to connect.");

			myURLConnection.connect();
			System.out.println("Connected.");

			BufferedReader in = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

		} catch (MalformedURLException e) {
			// new URL() failed
			// ...
		} catch (IOException e) {
			// openConnection() failed
			// ...
		}

		// Create URL & HttpClient

		// Request??

		// Store??

		// Display??

	}

	public Light() {

	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean iState) {
		this.state = iState;
	}

	public void getAttributes() {
		// Calls JSON GET method to get the attributes and state of a light.
	}

}