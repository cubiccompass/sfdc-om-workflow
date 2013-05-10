package servlet;

import java.net.MalformedURLException;

import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SalesforceConnection {	    	
	public static PartnerConnection createPartnerConnection(OutboundMessage message) throws ConnectionException, MalformedURLException {
        final ConnectorConfig config = new ConnectorConfig();
        config.setServiceEndpoint(message.getPartnerUrl().toString() );
        config.setSessionId(message.getSessionId());
        return new PartnerConnection(config);
    }
}