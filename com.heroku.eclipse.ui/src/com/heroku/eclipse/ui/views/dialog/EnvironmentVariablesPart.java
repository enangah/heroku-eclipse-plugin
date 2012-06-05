package com.heroku.eclipse.ui.views.dialog;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.heroku.api.App;
import com.heroku.eclipse.ui.Messages;

/**
 * View part responsible for displaying environment variables for Heroku Apps
 * @author udo.rader@bestsolution.at
 */
public class EnvironmentVariablesPart {
	/**
	 * Creates the UI
	 * @param parent
	 * @return the container with the UI stuff inside
	 */
	public Composite createUI(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2,false));
		
		{
			TableViewer viewer = new TableViewer(container);
			viewer.getTable().setHeaderVisible(true);
			viewer.getTable().setLinesVisible(true);
			
			GridData gd = new GridData(GridData.FILL_BOTH);
			gd.heightHint = 300;
			viewer.getControl().setLayoutData(gd);
			
			{
				TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
				column.getColumn().setText(Messages.getString("HerokuAppInformationEnvironment_Key")); //$NON-NLS-1$
				column.getColumn().setWidth(200);
			}
			
			{
				TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
				column.getColumn().setText(Messages.getString("HerokuAppInformationEnvironment_Value")); //$NON-NLS-1$
				column.getColumn().setWidth(200);
			}
			
			viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		
		{
			Composite controls = new Composite(container, SWT.NONE);
			controls.setLayout(new GridLayout(1,true));
			
			{
				Button b = new Button(controls, SWT.PUSH);
				b.setText("+");	 //$NON-NLS-1$
				b.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
			
			{
				Button b = new Button(controls, SWT.PUSH);
				b.setText("-"); //$NON-NLS-1$
				b.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
			
			{
				Button b = new Button(controls, SWT.PUSH);
				b.setText(Messages.getString("HerokuAppInformationEnvironment_Save")); //$NON-NLS-1$	
				b.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}
		
		return container;
	}
	
	public void setDomainObject(App domainObject) {
		
	}
	
	public void dispose() {
		
	}
}