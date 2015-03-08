package de.tudresden.inf.gsvgplott.ui;

import java.awt.Color;
import java.util.Map;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;

import com.explodingpixels.macwidgets.HudWindow;

import de.tudresden.inf.gsvgplott.data.style.palettes.ColorPalette;

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

public class GeneralStyleToolbox extends Dialog {

	protected Object result;
	protected Shell shlToolbox;
	private Table tableScreenBgColor;
	private Table tablePrintBgColor;
	
	/**
	 * Location the window should open
	 */
	private Point openingLocation = null;
	private CLabel lblPrintFontSelected;
	private CLabel lblPrintColorSelected;
	private CLabel lblScreenFontSelected;
	private CLabel lblScreenColorSelected;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public GeneralStyleToolbox(Shell parent, int style) {
		super(parent, SWT.BORDER | SWT.CLOSE);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlToolbox.open();
		shlToolbox.layout();
		Display display = getParent().getDisplay();
		if(openingLocation != null) {
			shlToolbox.setLocation(openingLocation.x, openingLocation.y);
		}
		while (!shlToolbox.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	/**
	 * Specify the location the dialog should open
	 * @param pt new location
	 */
	public void setOpeningLocation(Point pt) {
		openingLocation = pt;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlToolbox = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.TOOL);
		shlToolbox.setText("General Style");
		shlToolbox.setSize(209, 255);
		shlToolbox.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CTabFolder tabFolder = new CTabFolder(shlToolbox, SWT.BORDER);
		tabFolder.setBorderVisible(false);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmScreen = new CTabItem(tabFolder, SWT.NONE);
		tbtmScreen.setText("Screen");
		
		Composite compositeScreen = new Composite(tabFolder, SWT.NONE);
		tbtmScreen.setControl(compositeScreen);
		compositeScreen.setLayout(new GridLayout(2, false));
		
		CLabel lblScreenFont = new CLabel(compositeScreen, SWT.NONE);
		lblScreenFont.setText("Font");
		
		Button btnScreenFont = new Button(compositeScreen, SWT.NONE);
		btnScreenFont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				FontDialog fd = new FontDialog(shlToolbox, SWT.NONE);
		        
				fd.setText("Select Font");
		        fd.setRGB(new RGB(0, 0, 255));
		        
		        FontData defaultFont = new FontData("Courier", 10, SWT.BOLD);
		        FontData[] defaultFonts = {defaultFont};
		        fd.setFontList(defaultFonts);
		        
		        FontData newFont = fd.open();
		        if (newFont == null)
		          return;
		        
		        lblScreenFontSelected.setFont(new Font(getParent().getDisplay(), newFont));
		        lblScreenFontSelected.setForeground(new org.eclipse.swt.graphics.Color(getParent().getDisplay(), fd.getRGB()));
		        lblScreenFontSelected.setText(newFont.getName() + ", " + newFont.getHeight());
			}
		});
		btnScreenFont.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnScreenFont.setText("...");
		
		lblScreenFontSelected = new CLabel(compositeScreen, SWT.NONE);
		lblScreenFontSelected.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		lblScreenFontSelected.setText("(selected)");
		
		CLabel lblScreenColor = new CLabel(compositeScreen, SWT.NONE);
		lblScreenColor.setText("Background Color");
		
		lblScreenColorSelected = new CLabel(compositeScreen, SWT.NONE);
		lblScreenColorSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblScreenColorSelected.setText("(selected)");
		
		tableScreenBgColor = new Table(compositeScreen, SWT.FULL_SELECTION);
		tableScreenBgColor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem selectedItem = tableScreenBgColor.getSelection()[0];
				lblScreenColorSelected.setText(selectedItem.getText());
				lblScreenColorSelected.setBackground(selectedItem.getImage());
			}
		});
		GridData gd_tableScreenBgColor = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tableScreenBgColor.minimumHeight = 50;
		tableScreenBgColor.setLayoutData(gd_tableScreenBgColor);
		
		TableColumn tblclmnScreenBgColor = new TableColumn(tableScreenBgColor, SWT.NONE);
		tblclmnScreenBgColor.setWidth(193);
		tblclmnScreenBgColor.setText("Line Color");
		tblclmnScreenBgColor.setResizable(false);
		
		TableItem tableItemScreenColor1 = new TableItem(tableScreenBgColor, SWT.NONE);
		tableItemScreenColor1.setText("Color 1");
		
		TableItem tableItemScreenColor2 = new TableItem(tableScreenBgColor, 0);
		tableItemScreenColor2.setText("Color 2");
		
		TableItem tableItemScreenColor3 = new TableItem(tableScreenBgColor, 0);
		tableItemScreenColor3.setText("Color 3");
		
		CTabItem tbtmPrint = new CTabItem(tabFolder, SWT.NONE);
		tbtmPrint.setText("Print");
		
		Composite compositePrint = new Composite(tabFolder, SWT.NONE);
		tbtmPrint.setControl(compositePrint);
		compositePrint.setLayout(new GridLayout(2, false));
		
		CLabel lblPrintFont = new CLabel(compositePrint, SWT.NONE);
		lblPrintFont.setText("Font");
		
		Button btnPrintFont = new Button(compositePrint, SWT.NONE);
		btnPrintFont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				FontDialog fd = new FontDialog(shlToolbox, SWT.NONE);
		        
				fd.setText("Select Font");
		        fd.setRGB(new RGB(0, 0, 255));
		        
		        FontData defaultFont = new FontData("Courier", 10, SWT.BOLD);
		        FontData[] defaultFonts = {defaultFont};
		        fd.setFontList(defaultFonts);
		        
		        FontData newFont = fd.open();
		        if (newFont == null)
		          return;
		        
		        lblPrintFontSelected.setFont(new Font(getParent().getDisplay(), newFont));
		        lblPrintFontSelected.setForeground(new org.eclipse.swt.graphics.Color(getParent().getDisplay(), fd.getRGB()));
		        lblPrintFontSelected.setText(newFont.getName() + ", " + newFont.getHeight());
			}
		});
		btnPrintFont.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnPrintFont.setText("...");
		
		lblPrintFontSelected = new CLabel(compositePrint, SWT.NONE);
		lblPrintFontSelected.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblPrintFontSelected.setText("(selected)");
		
		CLabel lblPrintColor = new CLabel(compositePrint, SWT.NONE);
		lblPrintColor.setText("Background Color");
		
		lblPrintColorSelected = new CLabel(compositePrint, SWT.NONE);
		lblPrintColorSelected.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPrintColorSelected.setText("(selected)");
		
		tablePrintBgColor = new Table(compositePrint, SWT.FULL_SELECTION);
		tablePrintBgColor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem selectedItem = tablePrintBgColor.getSelection()[0];
				lblPrintColorSelected.setText(selectedItem.getText());
				lblPrintColorSelected.setBackground(selectedItem.getImage());
			}
		});
		tablePrintBgColor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TableColumn tblclmnPrintBgColor = new TableColumn(tablePrintBgColor, SWT.NONE);
		tblclmnPrintBgColor.setWidth(193);
		tblclmnPrintBgColor.setText("Line Color");
		tblclmnPrintBgColor.setResizable(false);
		
		TableItem tableItem = new TableItem(tablePrintBgColor, 0);
		tableItem.setText("Color 1");
		
		TableItem tableItem_1 = new TableItem(tablePrintBgColor, 0);
		tableItem_1.setText("Color 2");
		
		TableItem tableItem_2 = new TableItem(tablePrintBgColor, 0);
		tableItem_2.setText("Color 3");
		
		fillColors();

	}
	
	private void fillColors() {
		this.tableScreenBgColor.removeAll();
		this.tablePrintBgColor.removeAll();
		
		Map<String, Color> palette = ColorPalette.getPalette();
		for(Map.Entry<String, Color> entry : palette.entrySet()) {
			TableItem item1 = new TableItem(tableScreenBgColor, SWT.NONE);
			TableItem item2 = new TableItem(tablePrintBgColor, SWT.NONE);
			
			Image icon = new Image(getParent().getDisplay(), 16, 16);
			
			GC gc = new GC(icon);
			org.eclipse.swt.graphics.Color newcolor = new org.eclipse.swt.graphics.Color(this.getParent().getDisplay(), entry.getValue().getRed(), entry.getValue().getGreen(), entry.getValue().getBlue());
			gc.setBackground(newcolor);
			gc.setForeground(newcolor);
			gc.fillRectangle(0, 0, 16, 16);
			gc.dispose();
			
			item1.setImage(icon);
			item2.setImage(icon);
			
			String name = entry.getKey().toUpperCase().substring(0, 1);
			if(entry.getKey().length() > 1) {
				name = name + entry.getKey().toLowerCase().substring(1);
			}
			item1.setText(name);
			item2.setText(name);
		}
	}
}
