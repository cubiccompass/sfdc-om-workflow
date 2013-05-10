package servlet;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import junit.framework.Assert;

import org.junit.Test;
import org.xml.sax.SAXException;

public class OutboundMessageTest {

	private String TEST_MESSAGE =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
				"<soapenv:Body>" +
					"<notifications xmlns=\"http://soap.sforce.com/2005/09/outbound\">" +
						"<OrganizationId>00Dd0000000gzcrEAA</OrganizationId>" +
						"<ActionId>04kd00000008StmAAE</ActionId>" +
			  			"<SessionId>00Dd0000000gzcr!ARkAQAX8isuGmtPsj8gz_m3bsVuqL8KcTf3BtLGRGrb40RRWwP5jLW.gs7uvpBYWCjGaYdqVjicU5OXe.Hq.wsO9HJswcu8c</SessionId>" +
						"<EnterpriseUrl>https://na14-api.salesforce.com/services/Soap/c/26.0/00Dd0000000gzcr</EnterpriseUrl>" +
						"<PartnerUrl>https://na14-api.salesforce.com/services/Soap/u/26.0/00Dd0000000gzcr</PartnerUrl>" +
						"<Notification>" +
							"<Id>04ld000000E885fAAB</Id>" +
							"<sObject xsi:type=\"sf:IO__Order__c\" xmlns:sf=\"urn:sobject.enterprise.soap.sforce.com\">" +
								"<sf:Id>a01d0000006qftoAAA</sf:Id>" +
							"</sObject>" +
						"</Notification>" +
					"</notifications>" +
				"</soapenv:Body>" +
			"</soapenv:Envelope>";
	
	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException {
		OutboundMessage message = new OutboundMessage(TEST_MESSAGE);
		Assert.assertNotNull(message);
		Assert.assertEquals("00Dd0000000gzcrEAA", message.getOrganizationId());
		Assert.assertEquals("04kd00000008StmAAE", message.getActionId());
		Assert.assertEquals("00Dd0000000gzcr!ARkAQAX8isuGmtPsj8gz_m3bsVuqL8KcTf3BtLGRGrb40RRWwP5jLW.gs7uvpBYWCjGaYdqVjicU5OXe.Hq.wsO9HJswcu8c", message.getSessionId());
		Assert.assertEquals("https://na14-api.salesforce.com/services/Soap/c/26.0/00Dd0000000gzcr", message.getEnterpriseUrl().toString() );
		Assert.assertEquals("https://na14-api.salesforce.com/services/Soap/u/26.0/00Dd0000000gzcr", message.getPartnerUrl().toString() );
		Assert.assertEquals("na14-api", message.getInstance() );
		Assert.assertEquals("na14", message.getRESTInstance() );
		Assert.assertEquals("04ld000000E885fAAB", message.getNotificationId());
		Assert.assertEquals("a01d0000006qftoAAA", message.getSObjectId());
		Assert.assertEquals("IO__Order__c", message.getObjectType());
	}
}