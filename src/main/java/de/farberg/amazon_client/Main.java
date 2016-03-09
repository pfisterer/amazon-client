package de.farberg.amazon_client;

import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ECS.client.jax.AWSECommerceService;
import com.ECS.client.jax.ItemSearchRequest;
import com.ECS.client.jax.Items;

import de.malkusch.amazon.ecs.ProductAdvertisingAPI;
import de.malkusch.amazon.ecs.configuration.Configuration;
import de.malkusch.amazon.ecs.configuration.PropertiesConfiguration;
import de.uniluebeck.itm.util.logging.LogLevel;
import de.uniluebeck.itm.util.logging.Logging;

public class Main {

	static {
		Logging.setLoggingDefaults(LogLevel.DEBUG, "[%-5p; %c{1}::%M] %m%n");
	}

	public static void main(String[] args) throws Exception {
		// Obtain an instance of a logger for this class
		Logger log = LoggerFactory.getLogger(Main.class);

		Properties properties = new Properties();
		URL configFile = Main.class.getClassLoader().getResource("dennis-amazon-credentials.private.properties");
		properties.load(configFile.openStream());
		log.debug("Config file is @ {}", configFile);
		log.info(properties.toString());

		// Instantiate the API
		Configuration configuration = new PropertiesConfiguration(properties);
		ProductAdvertisingAPI api = new ProductAdvertisingAPI(configuration, new AWSECommerceService().getAWSECommerceServicePortDE());

		log.info("Got instance of the product advertising API client");

		// Search items
		ItemSearchRequest itemSearchRequest = new ItemSearchRequest();
		itemSearchRequest.setSearchIndex("Books");
		itemSearchRequest.setKeywords("Data Mining");
		Items foundItems = api.getItemSearch().call(itemSearchRequest);

		foundItems.getItem().forEach(item -> log.info(item.getASIN()));

	}

}
