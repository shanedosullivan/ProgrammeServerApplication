package com.programme.server.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

@Component
public class ServerRestClient {
	
	private static final String POST_SYNTAX_EXCEPTION_MSG = "Error creating URI for Http Post";
	private static final String POST_ENCODING_EXCEPTION_MSG = "Error executing Http Post encoding: ";
	private static final String POST_EXCEPTION_MSG = "Error executing Http Post: ";
	
	public void post(String url, String headerName, String headerValue, String body) throws URISyntaxException, IOException, HttpException{
		
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
		
			HttpPost postRequest = new HttpPost(url);
			
			StringEntity bodyEntity = new StringEntity(body);
			
			bodyEntity.setContentType("application/json");
			
			postRequest.setEntity(bodyEntity);

			postRequest.setHeader(headerName, headerValue);
			
			HttpResponse response = httpClient.execute(postRequest);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new URISyntaxException(e.toString(), POST_SYNTAX_EXCEPTION_MSG);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new UnsupportedEncodingException(POST_ENCODING_EXCEPTION_MSG + e.toString());
		} catch (HttpException e) {
			e.printStackTrace();
			throw new HttpException(POST_EXCEPTION_MSG + e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException(POST_EXCEPTION_MSG + e.toString());
		}
	}
	
}
