package de.tudresden.inf.gsvgplott.ui;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.tudresden.inf.gsvgplott.data.style.AreaStyle;
import de.tudresden.inf.gsvgplott.data.style.palettes.ColorPalette;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.util.ResourceBundle;

public class AreaStyleToolbox extends Dialog {
	private ResourceBundle DICT = ResourceBundle.getBundle("de.tudresden.inf.gsvgplott.ui.util.messages"); //$NON-NLS-1$

	protected Object result;
	protected Shell shlToolbox;
	private Table tablePrintBgColor;
	
	/**
	 * Location the window should open
	 */
	private Point openingLocation = null;
	
	private Table tableScreenBgColor;
	private CLabel lblScreenColorSelected;
	private CLabel lblPrintColorSelected;

	/**
	 * Data Exchange Objects
	 */
	private AreaStyle screenAreaStyle;
	private AreaStyle printAreaStyle;
	
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public AreaStyleToolbox(Shell parent, int style, AreaStyle oldScreenAreaStyle, AreaStyle oldPrintAreaStyle) {
		super(parent, SWT.BORDER | SWT.CLOSE);
		setText(DICT.getString("AreaStyleToolbox.this.text")); //$NON-NLS-1$
		
		// set referenced object
		screenAreaStyle = oldScreenAreaStyle;
		printAreaStyle = oldPrintAreaStyle;
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
		shlToolbox.setText(DICT.getString("AreaStyleToolbox.shlToolbox.text")); //$NON-NLS-1$
		shlToolbox.setSize(230, 319);
		shlToolbox.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		CTabFolder tabFolder = new CTabFolder(shlToolbox, SWT.BORDER);
		tabFolder.setBorderVisible(false);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmScreen = new CTabItem(tabFolder, SWT.NONE);
		tbtmScreen.setText(DICT.getString("AreaStyleToolbox.tbtmScreen.text")); //$NON-NLS-1$
		
		Composite compositeScreen = new Composite(tabFolder, SWT.NONE);
		tbtmScreen.setControl(compositeScreen);
		compositeScreen.setLayout(new GridLayout(2, false));
		
		CLabel lblScreenColor = new CLabel(compositeScreen, SWT.NONE);
		lblScreenColor.setText(DICT.getString("AreaStyleToolbox.lblScreenColor.text")); //$NON-NLS-1$
		
		lblScreenColorSelected = new CLabel(compositeScreen, SWT.NONE);
		lblScreenColorSelected.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblScreenColorSelected.setText(DICT.getString("AreaStyleToolbox.lblScreenColorSelected.text")); //$NON-NLS-1$
		
		tableScreenBgColor = new Table(compositeScreen, SWT.FULL_SELECTION);
		tableScreenBgColor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem selectedItem = tableScreenBgColor.getSelection()[0];
				lblScreenColorSelected.setText(selectedItem.getText());
				lblScreenColorSelected.setBackground(selectedItem.getImage());
				
				Color newColor = new Color(selectedItem.getImage().getImageData().getPixel(1, 1));
				screenAreaStyle.setColor(newColor);
			}
		});
		GridData gd_tableScreenBgColor = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_tableScreenBgColor.minimumHeight = 50;
		tableScreenBgColor.setLayoutData(gd_tableScreenBgColor);
		
		TableColumn tblclmnScreenBgColor = new TableColumn(tableScreenBgColor, SWT.NONE);
		tblclmnScreenBgColor.setWidth(193);
		tblclmnScreenBgColor.setText(DICT.getString("AreaStyleToolbox.tblclmnScreenBgColor.text")); //$NON-NLS-1$
		tblclmnScreenBgColor.setResizable(false);
		
		TableItem tableItemScreenColor1 = new TableItem(tableScreenBgColor, SWT.NONE);
		tableItemScreenColor1.setText(DICT.getString("AreaStyleToolbox.tableItemScreenColor1.text(java.lang.String)")); //$NON-NLS-1$
		
		TableItem tableItemScreenColor2 = new TableItem(tableScreenBgColor, 0);
		tableItemScreenColor2.setText(DICT.getString("AreaStyleToolbox.tableItemScreenColor2.text(java.lang.String)")); //$NON-NLS-1$
		
		TableItem tableItemScreenColor3 = new TableItem(tableScreenBgColor, 0);
		tableItemScreenColor3.setText(DICT.getString("AreaStyleToolbox.tableItemScreenColor3.text(java.lang.String)")); //$NON-NLS-1$
		
		CTabItem tbtmPrint = new CTabItem(tabFolder, SWT.NONE);
		tbtmPrint.setText(DICT.getString("AreaStyleToolbox.tbtmPrint.text")); //$NON-NLS-1$
		
		Composite compositePrint = new Composite(tabFolder, SWT.NONE);
		tbtmPrint.setControl(compositePrint);
		compositePrint.setLayout(new GridLayout(2, false));
		
		CLabel lblPrintColor = new CLabel(compositePrint, SWT.NONE);
		lblPrintColor.setText(DICT.getString("AreaStyleToolbox.lblPrintColor.text")); //$NON-NLS-1$
		
		lblPrintColorSelected = new CLabel(compositePrint, SWT.NONE);
		lblPrintColorSelected.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblPrintColorSelected.setText(DICT.getString("AreaStyleToolbox.lblPrintColorSelected.text")); //$NON-NLS-1$
		
		tablePrintBgColor = new Table(compositePrint, SWT.FULL_SELECTION);
		tablePrintBgColor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem selectedItem = tablePrintBgColor.getSelection()[0];
				lblPrintColorSelected.setText(selectedItem.getText());
				lblPrintColorSelected.setBackground(selectedItem.getImage());
				
				Color newColor = new Color(selectedItem.getImage().getImageData().getPixel(1, 1));
				printAreaStyle.setColor(newColor);
			}
		});
		tablePrintBgColor.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		TableColumn tblclmnPrintBgColor = new TableColumn(tablePrintBgColor, SWT.NONE);
		tblclmnPrintBgColor.setWidth(193);
		tblclmnPrintBgColor.setText(DICT.getString("AreaStyleToolbox.tblclmnPrintBgColor.text")); //$NON-NLS-1$
		tblclmnPrintBgColor.setResizable(false);
		
		TableItem tableItem = new TableItem(tablePrintBgColor, 0);
		tableItem.setText(DICT.getString("AreaStyleToolbox.tableItem.text(java.lang.String)")); //$NON-NLS-1$
		
		TableItem tableItem_1 = new TableItem(tablePrintBgColor, 0);
		tableItem_1.setText(DICT.getString("AreaStyleToolbox.tableItem_1.text(java.lang.String)")); //$NON-NLS-1$
		
		TableItem tableItem_2 = new TableItem(tablePrintBgColor, 0);
		tableItem_2.setText(DICT.getString("AreaStyleToolbox.tableItem_2.text(java.lang.String)")); //$NON-NLS-1$
		
		fillColors();
		initiateStyle();

	}
	
	private void fillColors() {
		this.tableScreenBgColor.removeAll();
		this.tablePrintBgColor.removeAll();
		
		Map<String, Color> palette = ColorPalette.getPalette();
		for(String key : ColorPalette.getOrderedPaletteKeys()) {
			Color c = palette.get(key);
			
			TableItem item1 = new TableItem(tableScreenBgColor, SWT.NONE);
			TableItem item2 = new TableItem(tablePrintBgColor, SWT.NONE);
			
			Image icon = new Image(getParent().getDisplay(), 16, 16);
			
			GC gc = new GC(icon);
			org.eclipse.swt.graphics.Color newcolor = new org.eclipse.swt.graphics.Color(this.getParent().getDisplay(), c.getRed(), c.getGreen(), c.getBlue());
			gc.setBackground(newcolor);
			gc.setForeground(newcolor);
			gc.fillRectangle(0, 0, 16, 16);
			gc.dispose();
			
			item1.setImage(icon);
			item2.setImage(icon);
			
			String name = key.toUpperCase().substring(0, 1);
			if(key.length() > 1) {
				name = name + key.toLowerCase().substring(1);
			}
			item1.setText(name);
			item2.setText(name);
		}
	}
	
	/**
	 * Loads data from referenced object and shows that in UI
	 */
	private void initiateStyle() {
		// read colors
		Color screen = screenAreaStyle.getColor();
		Color print = printAreaStyle.getColor();
		
		// generate color icons
		Image iconScreen = new Image(getParent().getDisplay(), 16, 16);
		GC gc1 = new GC(iconScreen);
		org.eclipse.swt.graphics.Color newcolor1 = new org.eclipse.swt.graphics.Color(this.getParent().getDisplay(), screen.getRed(), screen.getGreen(), screen.getBlue());
		gc1.setBackground(newcolor1);
		gc1.setForeground(newcolor1);
		gc1.fillRectangle(0, 0, 16, 16);
		gc1.dispose();
		iconScreen.setBackground(newcolor1);
		
		Image iconPrint = new Image(getParent().getDisplay(), 16, 16);
		GC gc2 = new GC(iconPrint);
		org.eclipse.swt.graphics.Color newcolor2 = new org.eclipse.swt.graphics.Color(this.getParent().getDisplay(), print.getRed(), print.getGreen(), print.getBlue());
		gc2.setBackground(newcolor2);
		gc2.setForeground(newcolor2);
		gc2.fillRectangle(0, 0, 16, 16);
		gc2.dispose();
		iconPrint.setBackground(newcolor2);
		
		// set color icons in form
		lblScreenColorSelected.setText("(r" + Integer.toString(screen.getRed()) + ", g" + Integer.toString(screen.getGreen()) + ", b" + Integer.toString(screen.getBlue()) + ")");
		lblScreenColorSelected.setBackground(iconScreen);
		
		lblPrintColorSelected.setText("(r" + Integer.toString(print.getRed()) + ", g" + Integer.toString(print.getGreen()) + ", b" + Integer.toString(print.getBlue()) + ")");
		lblPrintColorSelected.setBackground(iconPrint);
	}
	
	/**
	 * Returns Area Styles with keys "screen" and "print"
	 * @return
	 */
	public Map<String, AreaStyle> getNewStyles() {
		Map<String, AreaStyle> result = new HashMap<String, AreaStyle>();
		result.put("screen", screenAreaStyle);
		result.put("print", printAreaStyle);
		return result;
	}
	
	
}
