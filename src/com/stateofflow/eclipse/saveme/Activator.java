package com.stateofflow.eclipse.saveme;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin implements IStartup {

	public static final String	PLUGIN_ID	= "com.stateofflow.eclipse.saveme";

	private static Activator	plugin;

	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		EditorSaver.INSTANCE.start();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		EditorSaver.INSTANCE.stop();
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public void earlyStartup() {
		EditorSaver.INSTANCE.start();
	}
}
