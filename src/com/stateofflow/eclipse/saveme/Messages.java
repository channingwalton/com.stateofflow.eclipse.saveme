package com.stateofflow.eclipse.saveme;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.stateofflow.eclipse.saveme.messages"; //$NON-NLS-1$
	public static String SaveMePreferencePage_autosave;
	public static String SaveMePreferencePage_enable;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
