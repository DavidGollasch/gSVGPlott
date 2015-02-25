package de.tudresden.inf.gsvgplott.ui;

import java.awt.Color;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.explodingpixels.macwidgets.HudWindow;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class LineStyleToolbox extends Dialog {

	protected Object result;
	protected Shell shlTest;
	private Table tableScreenLineStyle;
	private Table tableScreenLineWidth;
	private Table tableScreenLineColor;
	private Table tablePrintLineStyle;
	private Table tablePrintLineWidth;
	private Table tablePrintLineColor;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public LineStyleToolbox(Shell parent, int style) {
		super(parent, SWT.BORDER | SWT.CLOSE);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlTest.open();
		shlTest.layout();
		Display display = getParent().getDisplay();
		while (!shlTest.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlTest = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.TOOL);
		shlTest.setText("Line Style");
		shlTest.setSize(215, 310);
		shlTest.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CTabFolder tabFolder = new CTabFolder(shlTest, SWT.BORDER);
		tabFolder.setBorderVisible(false);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmScreen = new CTabItem(tabFolder, SWT.NONE);
		tbtmScreen.setText("Screen");
		
		Composite compositeScreen = new Composite(tabFolder, SWT.NONE);
		tbtmScreen.setControl(compositeScreen);
		compositeScreen.setLayout(new GridLayout(2, false));
		
		CLabel lblScreenStyle = new CLabel(compositeScreen, SWT.NONE);
		lblScreenStyle.setText("Style");
		
		CLabel lblScreenStyleSelected = new CLabel(compositeScreen, SWT.NONE);
		lblScreenStyleSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblScreenStyleSelected.setText("(selected)");
		
		tableScreenLineStyle = new Table(compositeScreen, SWT.FULL_SELECTION);
		GridData gd_tableScreenLineStyle = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tableScreenLineStyle.minimumHeight = 50;
		tableScreenLineStyle.setLayoutData(gd_tableScreenLineStyle);
		
		TableColumn tblclmnScreenLineStyle = new TableColumn(tableScreenLineStyle, SWT.NONE);
		tblclmnScreenLineStyle.setResizable(false);
		tblclmnScreenLineStyle.setWidth(193);
		tblclmnScreenLineStyle.setText("Line Style");
		
		TableItem tableItemScreenStyle1 = new TableItem(tableScreenLineStyle, SWT.NONE);
		tableItemScreenStyle1.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenStyle1.setText("Solid");
		
		TableItem tableItemScreenStyle2 = new TableItem(tableScreenLineStyle, SWT.NONE);
		tableItemScreenStyle2.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenStyle2.setText("Dotted");
		
		TableItem tableItemScreenStyle3 = new TableItem(tableScreenLineStyle, SWT.NONE);
		tableItemScreenStyle3.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenStyle3.setText("Dashed");
		
		TableItem tableItemScreenStyle4 = new TableItem(tableScreenLineStyle, 0);
		tableItemScreenStyle4.setText("Longdashed");
		tableItemScreenStyle4.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItemScreenStyle5 = new TableItem(tableScreenLineStyle, 0);
		tableItemScreenStyle5.setText("Dashdotted");
		tableItemScreenStyle5.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItemScreenStyle6 = new TableItem(tableScreenLineStyle, 0);
		tableItemScreenStyle6.setText("Dashdoubledotted");
		tableItemScreenStyle6.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		CLabel lblScreenWidth = new CLabel(compositeScreen, SWT.NONE);
		lblScreenWidth.setText("Width");
		
		CLabel lblScreenWidthSelected = new CLabel(compositeScreen, SWT.NONE);
		lblScreenWidthSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblScreenWidthSelected.setText("(selected)");
		
		tableScreenLineWidth = new Table(compositeScreen, SWT.FULL_SELECTION);
		GridData gd_tableScreenLineWidth = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tableScreenLineWidth.minimumHeight = 50;
		tableScreenLineWidth.setLayoutData(gd_tableScreenLineWidth);
		
		TableColumn tblclmnScreenLineWidth = new TableColumn(tableScreenLineWidth, SWT.NONE);
		tblclmnScreenLineWidth.setWidth(193);
		tblclmnScreenLineWidth.setText("Line Width");
		tblclmnScreenLineWidth.setResizable(false);
		
		TableItem tableItemScreenWidth1 = new TableItem(tableScreenLineWidth, SWT.NONE);
		tableItemScreenWidth1.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth1.setText("1px");
		
		TableItem tableItemScreenWidth2 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth2.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth2.setText("2px");
		
		TableItem tableItemScreenWidth3 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth3.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth3.setText("3px");
		
		TableItem tableItemScreenWidth4 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth4.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth4.setText("4px");
		
		TableItem tableItemScreenWidth5 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth5.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth5.setText("5px");
		
		TableItem tableItemScreenWidth6 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth6.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth6.setText("6px");
		
		TableItem tableItemScreenWidth7 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth7.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth7.setText("7px");
		
		TableItem tableItemScreenWidth8 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth8.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth8.setText("8px");
		
		TableItem tableItemScreenWidth9 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth9.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth9.setText("9px");
		
		TableItem tableItemScreenWidth10 = new TableItem(tableScreenLineWidth, 0);
		tableItemScreenWidth10.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		tableItemScreenWidth10.setText("10px");
		
		CLabel lblScreenColor = new CLabel(compositeScreen, SWT.NONE);
		lblScreenColor.setText("Color");
		
		CLabel lblScreenColorSelected = new CLabel(compositeScreen, SWT.NONE);
		lblScreenColorSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblScreenColorSelected.setText("(selected)");
		
		tableScreenLineColor = new Table(compositeScreen, SWT.FULL_SELECTION);
		GridData gd_tableScreenLineColor = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tableScreenLineColor.minimumHeight = 50;
		tableScreenLineColor.setLayoutData(gd_tableScreenLineColor);
		
		TableColumn tblclmnScreenLineColor = new TableColumn(tableScreenLineColor, SWT.NONE);
		tblclmnScreenLineColor.setWidth(193);
		tblclmnScreenLineColor.setText("Line Color");
		tblclmnScreenLineColor.setResizable(false);
		
		TableItem tableItemScreenColor1 = new TableItem(tableScreenLineColor, SWT.NONE);
		tableItemScreenColor1.setText("Color 1");
		
		TableItem tableItemScreenColor2 = new TableItem(tableScreenLineColor, 0);
		tableItemScreenColor2.setText("Color 2");
		
		TableItem tableItemScreenColor3 = new TableItem(tableScreenLineColor, 0);
		tableItemScreenColor3.setText("Color 3");
		
		CTabItem tbtmPrint = new CTabItem(tabFolder, SWT.NONE);
		tbtmPrint.setText("Print");
		
		Composite compositePrint = new Composite(tabFolder, SWT.NONE);
		tbtmPrint.setControl(compositePrint);
		compositePrint.setLayout(new GridLayout(2, false));
		
		CLabel lblPrintStyle = new CLabel(compositePrint, SWT.NONE);
		lblPrintStyle.setText("Style");
		
		CLabel lblPrintStyleSelected = new CLabel(compositePrint, SWT.NONE);
		lblPrintStyleSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrintStyleSelected.setText("(selected)");
		
		tablePrintLineStyle = new Table(compositePrint, SWT.FULL_SELECTION);
		GridData gd_tablePrintLineStyle = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tablePrintLineStyle.minimumHeight = 50;
		gd_tablePrintLineStyle.widthHint = 132;
		tablePrintLineStyle.setLayoutData(gd_tablePrintLineStyle);
		
		TableColumn tblclmnPrintLineStyle = new TableColumn(tablePrintLineStyle, SWT.NONE);
		tblclmnPrintLineStyle.setWidth(193);
		tblclmnPrintLineStyle.setText("Line Style");
		tblclmnPrintLineStyle.setResizable(false);
		
		TableItem tableItem = new TableItem(tablePrintLineStyle, 0);
		tableItem.setText("Solid");
		tableItem.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_1 = new TableItem(tablePrintLineStyle, 0);
		tableItem_1.setText("Dashed");
		tableItem_1.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_2 = new TableItem(tablePrintLineStyle, 0);
		tableItem_2.setText("Dotted");
		tableItem_2.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		CLabel lblPrintWidth = new CLabel(compositePrint, SWT.NONE);
		lblPrintWidth.setText("Width");
		
		CLabel lblPrintWidthSelected = new CLabel(compositePrint, SWT.NONE);
		lblPrintWidthSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrintWidthSelected.setText("(selected)");
		
		tablePrintLineWidth = new Table(compositePrint, SWT.FULL_SELECTION);
		GridData gd_tablePrintLineWidth = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tablePrintLineWidth.minimumHeight = 50;
		tablePrintLineWidth.setLayoutData(gd_tablePrintLineWidth);
		
		TableColumn tblclmnPrintLineWidth = new TableColumn(tablePrintLineWidth, SWT.NONE);
		tblclmnPrintLineWidth.setWidth(193);
		tblclmnPrintLineWidth.setText("Line Width");
		tblclmnPrintLineWidth.setResizable(false);
		
		TableItem tableItem_3 = new TableItem(tablePrintLineWidth, 0);
		tableItem_3.setText("1px");
		tableItem_3.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_4 = new TableItem(tablePrintLineWidth, 0);
		tableItem_4.setText("2px");
		tableItem_4.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_5 = new TableItem(tablePrintLineWidth, 0);
		tableItem_5.setText("3px");
		tableItem_5.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_6 = new TableItem(tablePrintLineWidth, 0);
		tableItem_6.setText("4px");
		tableItem_6.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_7 = new TableItem(tablePrintLineWidth, 0);
		tableItem_7.setText("5px");
		tableItem_7.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_8 = new TableItem(tablePrintLineWidth, 0);
		tableItem_8.setText("6px");
		tableItem_8.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_9 = new TableItem(tablePrintLineWidth, 0);
		tableItem_9.setText("7px");
		tableItem_9.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_10 = new TableItem(tablePrintLineWidth, 0);
		tableItem_10.setText("8px");
		tableItem_10.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_11 = new TableItem(tablePrintLineWidth, 0);
		tableItem_11.setText("9px");
		tableItem_11.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		TableItem tableItem_12 = new TableItem(tablePrintLineWidth, 0);
		tableItem_12.setText("10px");
		tableItem_12.setImage(SWTResourceManager.getImage(LineStyleToolbox.class, "/de/tudresden/inf/gsvgplott/ui/icons/graphic-16.png"));
		
		CLabel lblPrintColor = new CLabel(compositePrint, SWT.NONE);
		lblPrintColor.setText("Color");
		
		CLabel lblPrintColorSelected = new CLabel(compositePrint, SWT.NONE);
		lblPrintColorSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrintColorSelected.setText("(selected)");
		
		tablePrintLineColor = new Table(compositePrint, SWT.FULL_SELECTION);
		GridData gd_tablePrintLineColor = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tablePrintLineColor.minimumHeight = 50;
		tablePrintLineColor.setLayoutData(gd_tablePrintLineColor);
		
		TableColumn tblclmnPrintLineColor = new TableColumn(tablePrintLineColor, SWT.NONE);
		tblclmnPrintLineColor.setWidth(193);
		tblclmnPrintLineColor.setText("Line Color");
		tblclmnPrintLineColor.setResizable(false);
		
		TableItem tableItem_13 = new TableItem(tablePrintLineColor, 0);
		tableItem_13.setText("Color 1");
		
		TableItem tableItem_14 = new TableItem(tablePrintLineColor, 0);
		tableItem_14.setText("Color 2");
		
		TableItem tableItem_15 = new TableItem(tablePrintLineColor, 0);
		tableItem_15.setText("Color 3");

	}
}
