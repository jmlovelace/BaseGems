package com.mcmoddev.basegems.integration;

import com.google.common.collect.Lists;
import com.mcmoddev.basegems.BaseGems;
import com.mcmoddev.basegems.integration.BaseGemsPlugin;
import com.mcmoddev.lib.integration.IIntegration;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.discovery.ASMDataTable.ASMData;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.List;

public enum IntegrationManager {
    INSTANCE;

    private List<IIntegration> integrations = Lists.newArrayList();

    public void preInit(FMLPreInitializationEvent event) {
    	for( final ASMData asmDataItem : event.getAsmData().getAll(BaseGemsPlugin.class.getCanonicalName()) ) {
    		String modId = asmDataItem.getAnnotationInfo().get("value").toString();
    		String className = asmDataItem.getClassName();
    		if (Loader.isModLoaded(modId)) {
    			IIntegration integration;
				try {
					integration = Class.forName(className).asSubclass(IIntegration.class).newInstance();
					BaseGems.logger.info("BASEGEMS Loaded: "+modId);
					integrations.add(integration);
					integration.init();
				} catch (final Exception e) {
					// do nothing 
				}
    		}
    	}
    }
}