package com.stateofflow.eclipse.saveme;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.stateofflow.eclipse.saveme.preferences.PreferenceConstants;

public class EditorSaver implements IPartListener {

	public static final EditorSaver	INSTANCE	= new EditorSaver();

	private EditorSaver() {
	}

	public void start() {
		IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int i = 0; i < workbenchWindows.length; i++) {
			workbenchWindows[i].getActivePage().addPartListener(this);
		}
	}

	public void stop() {
		IWorkbenchWindow[] workbenchWindows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (int i = 0; i < workbenchWindows.length; i++) {
			workbenchWindows[i].getActivePage().removePartListener(this);
		}
	}

	public void partDeactivated(IWorkbenchPart part) {
		if (isAutosaveEnabled() && part instanceof IEditorPart) {
			IEditorPart editor = (IEditorPart) part;
			if (editor.isDirty() && editor.isSaveAsAllowed()) {
				save(editor);
			}
		}
	}

	private void save(final IEditorPart editor) {
		Display.getCurrent().asyncExec(new Runnable() {
			public void run() {
				editor.doSave(new NullProgressMonitor());
			}
		});
	}

	private boolean isAutosaveEnabled() {
		return Activator.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.SAVEME_PREFERENCE);
	}

	public void partActivated(IWorkbenchPart part) {
	}

	public void partBroughtToTop(IWorkbenchPart part) {
	}

	public void partClosed(IWorkbenchPart part) {
	}

	public void partOpened(IWorkbenchPart part) {
	}

}
