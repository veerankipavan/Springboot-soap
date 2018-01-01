package com.springboot.endpoint;


import com.springbootsoap.GeoIP;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springbootsoap.GetGeoIP;
import com.springbootsoap.ObjectFactory;
import com.springbootsoap.GetGeoIPResponse;

@Endpoint
public class WebServiceEndpoint {

    private static final String NAMESPACE_URI = "http://springbootsoap.com";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetGeoIP")
    @ResponsePayload
    public GetGeoIPResponse GetGeoIP(@RequestPayload GetGeoIP request) {

        String outputString = "Hello " + request.getIPAddress() + "!";

        ObjectFactory factory = new ObjectFactory();
        GetGeoIPResponse response = factory.createGetGeoIPResponse();

        GeoIP geoIp = new GeoIP();
        geoIp.setCountryName("Australia");
        geoIp.setIP(request.getIPAddress());
        geoIp.setCountryCode("AUS");
        response.setGetGeoIPResult(geoIp);

        return response;
    }
}
