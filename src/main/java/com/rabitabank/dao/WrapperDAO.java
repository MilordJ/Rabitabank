/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.dao;

import com.rabitabank.domain.OperationResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lito
 */
@Repository
public class WrapperDAO implements IWrapperDAO {

    private static final Logger log = Logger.getLogger(WrapperDAO.class);
    @Autowired
    LoggerDAO loggerDAO;

    @Override
    public OperationResponse Add(int a, int b) {

        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {

            log.info("Request to SOAP");
            String url = "http://www.dneonline.com/calculator.asmx";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                    + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
                    + "  <soap12:Body>"
                    + "    <Add xmlns=\"http://tempuri.org/\">"
                    + "      <intA>" + a + "</intA>"
                    + "      <intB>" + b + "</intB>"
                    + "    </Add>"
                    + "  </soap12:Body>"
                    + "</soap12:Envelope>";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            
            if(!responseStatus.equals("OK")) {
                return operationResponse;
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
                JSONObject optObjectNewDataSet = xmlJSONObj.getJSONObject("soap:Envelope")
                        .getJSONObject("soap:Body")
                        .getJSONObject("AddResponse");
                
            operationResponse.setData(optObjectNewDataSet.toMap().entrySet().toArray()[1]);
            operationResponse.setCode(OperationResponse.ResultCode.OK);
            loggerDAO.logRequest("asd");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return operationResponse;
    }

    @Override
    public OperationResponse Divide(int a, int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
            log.info("Request to SOAP");
            String url = "http://www.dneonline.com/calculator.asmx";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                            "  <soap:Body>" +
                            "    <Divide xmlns=\"http://tempuri.org/\">" +
                            "      <intA>"+ a +"</intA>" +
                            "      <intB>"+ b +"</intB>" +
                            "    </Divide>" +
                            "  </soap:Body>" +
                            "</soap:Envelope>";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            if(!responseStatus.equals("OK")) {
                return operationResponse;
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
                JSONObject optObjectNewDataSet = xmlJSONObj.getJSONObject("soap:Envelope")
                        .getJSONObject("soap:Body")
                        .getJSONObject("DivideResponse");
                
            operationResponse.setData(optObjectNewDataSet.toMap().entrySet().toArray()[0]);
            operationResponse.setCode(OperationResponse.ResultCode.OK);
            loggerDAO.logRequest("asd");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return operationResponse;
    }

    @Override
    public OperationResponse Multiple(int a, int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
            log.info("Request to SOAP");
            String url = "http://www.dneonline.com/calculator.asmx";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                        "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                        "  <soap12:Body>" +
                        "    <Multiply xmlns=\"http://tempuri.org/\">" +
                        "      <intA>"+ a +"</intA>" +
                        "      <intB>"+ b +"</intB>" +
                        "    </Multiply>" +
                        "  </soap12:Body>" +
                        "</soap12:Envelope>";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            if(!responseStatus.equals("OK")) {
                return operationResponse;
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
                JSONObject optObjectNewDataSet = xmlJSONObj.getJSONObject("soap:Envelope")
                        .getJSONObject("soap:Body")
                        .getJSONObject("MultiplyResponse");
                
            operationResponse.setData(optObjectNewDataSet.toMap().entrySet().toArray()[1]);
            operationResponse.setCode(OperationResponse.ResultCode.OK);
            loggerDAO.logRequest("asd");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return operationResponse;
    }

    @Override
    public OperationResponse Subtract(int a, int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
            log.info("Request to SOAP");
            String url = "http://www.dneonline.com/calculator.asmx";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                        "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                        "  <soap12:Body>" +
                        "    <Subtract xmlns=\"http://tempuri.org/\">" +
                        "      <intA>"+ a +"</intA>" +
                        "      <intB>"+ b +"</intB>" +
                        "    </Subtract>" +
                        "  </soap12:Body>" +
                        "</soap12:Envelope>";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(xml);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
                        if(!responseStatus.equals("OK")) {
                return operationResponse;
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JSONObject xmlJSONObj = XML.toJSONObject(response.toString());
                JSONObject optObjectNewDataSet = xmlJSONObj.getJSONObject("soap:Envelope")
                        .getJSONObject("soap:Body")
                        .getJSONObject("SubtractResponse");
                
            operationResponse.setData(optObjectNewDataSet.toMap().entrySet().toArray()[1]);
            operationResponse.setCode(OperationResponse.ResultCode.OK);
            loggerDAO.logRequest("asd");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return operationResponse;
    }

}
