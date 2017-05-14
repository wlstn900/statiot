package kr.ac.subway.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller // @Component+controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   /**
    * Simply selects the home view to render by returning its name.
    */
//   private String url = "https://fcm.googleapis.com/fcm/send"; 
//   private String message = "\"변전실\"}";//"\"변전실\"}"
//   //String parameters = "{"+ "\"data\": {"+ "\"message\": \"test\""+"},"+ "\"to\": \"/topics/notice\""+"}"; 
//   private String parameters = "{\"data\": {"+"\"message\":"+message+",\"to\":\"/topics/notice\"}";
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Model model) {
//      try {
//         String result = sendPost(url,parameters);
//      } catch (Exception e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
      return "login";
   }
   
//   public String sendPost(String url, String parameters) throws Exception { 
//        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
//                public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
//                public void checkClientTrusted(X509Certificate[] certs, String authType){}
//                public void checkServerTrusted(X509Certificate[] certs, String authType){}
//        }};
//        SSLContext sc = SSLContext.getInstance("TLS");
//        sc.init(null, trustAllCerts, new SecureRandom());
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//   
//       URL obj = new URL(url);
//       HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//   
//       //reuqest header
//       con.setRequestMethod("POST");
//       con.setRequestProperty("Content-Type", "application/json");
//       con.setRequestProperty("Authorization", "key= AAAA6Nz5EqM:APA91bFC3h1KtQeFu3KV2cZzWxEPwL0LFF-61lnsZ6bV5WO_VzGx17iG_m1Q1RghZMtuPXKChQYnffRCpNBl8LQxPExr13I0FDHLY28JAyxE7msA6JISoxX_CnEEnSCforfi0BmVlT6c ");
//       String urlParameters = parameters;
//   
//       //post request
//       con.setDoOutput(true);
//       DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//       wr.write(urlParameters.getBytes("UTF-8"));
//       wr.flush();
//       wr.close();
//
//       int responseCode = con.getResponseCode();     
//       System.out.println("Post parameters : " + urlParameters);
//       System.out.println("Response Code : " + responseCode);
//   
//       StringBuffer response = new StringBuffer();
//   
//       if(responseCode == 200){   
//              BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
//              String inputLine;
//              while ((inputLine = in.readLine()) != null) {
//                     response.append(inputLine);
//              }
//              in.close();   
//       }
//       //result
//       System.out.println(response.toString());
//       return response.toString();
//}
}