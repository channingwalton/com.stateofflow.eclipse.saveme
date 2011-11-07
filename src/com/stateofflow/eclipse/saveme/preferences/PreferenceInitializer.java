package com.stateofflow.eclipse.saveme.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.stateofflow.eclipse.saveme.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		Activator.getDefault().getPluginPreferences().setDefault(PreferenceConstants.SAVEME_PREFERENCE, false);
	}

}
