package api;

import java.net.*;
import java.io.*;

public class HueController {

	public static final String URL_HUE_DISCOVERY = "https://discovery.meethue.com/";
	private String username = "";
	private String internalIpAddress = "";

	private URL urlHueDiscovery;
	private URLConnection urlConnection;

	public HueController() {

	}

	public String getUsername() {
		if (!this.username.isEmpty()) {
			return this.username;
		} else {
			return "EMPTY";
		}
	}

	public String[] getConnect() throws IOException {
		// {"id":"001788fffe6069a9","internalipaddress":"192.168.1.2"}

		this.getURLConnection();
		URLConnection connection = this.urlConnection;

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();

		String id = null;
		String internalIpAddress = null;
		String arr[] = new String[2];

		arr[0] = id;
		arr[1] = internalIpAddress;
		return arr;
	}

	public void getURLConnection() throws IOException {
		this.urlHueDiscovery = new URL(HueController.URL_HUE_DISCOVERY);
		this.urlConnection = this.urlHueDiscovery.openConnection();
		this.urlConnection.connect();
	}

	public String send(String iRequest) {
		String response = null;

		return response;
	}

}
