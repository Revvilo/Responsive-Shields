package revvilo.responsiveshields;

import net.fabricmc.api.ModInitializer;
import revvilo.responsiveshields.config.ResponsiveShieldsConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponsiveShields implements ModInitializer {
	public static final String MOD_ID = "responsiveshields";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ResponsiveShieldsConfig CONFIG = ResponsiveShieldsConfig.createAndLoad();
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}