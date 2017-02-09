package com.mcmoddev.basegems.integration.plugins;

import com.mcmoddev.basegems.integration.BaseGemsPlugin;
import com.mcmoddev.lib.integration.IIntegration;

/**
 * VeinMiner Integration Plugin
 *
 * @author Jasmine Iwanek
 *
 */
@BaseGemsPlugin(VeinMiner.PLUGIN_MODID)
public class VeinMiner extends com.mcmoddev.lib.integration.plugins.VeinMiner implements IIntegration {

	private static boolean initDone = false;

	@Override
	public void init() {
		if (initDone || !com.mcmoddev.basemetals.util.Config.Options.ENABLE_VEINMINER) {
			return;
		}

		initDone = true;
	}
}
