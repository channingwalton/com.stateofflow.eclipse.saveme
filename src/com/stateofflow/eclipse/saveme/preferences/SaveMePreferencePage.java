package com.stateofflow.eclipse.saveme.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.stateofflow.eclipse.saveme.Activator;
import com.stateofflow.eclipse.saveme.Messages;

public class SaveMePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public SaveMePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.SaveMePreferencePage_autosave);
	}

	public void createFieldEditors() {
		addField(new BooleanFieldEditor(PreferenceConstants.SAVEME_PREFERENCE, Messages.SaveMePreferencePage_enable, getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
	}

}