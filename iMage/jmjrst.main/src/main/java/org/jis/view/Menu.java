/*
 * Copyright 2007 Johannes Geppert 
 * 
 * Licensed under the GPL, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License.
 * 
 * You may obtain a copy of the License at
 * http://www.fsf.org/licensing/licenses/gpl.txt 
 * 
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on 
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 */
package org.jis.view;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import org.iMage.plugins.PluginForJmjrst;
import org.iMage.plugins.PluginManagement;
import org.jis.Main;
import org.jis.listner.MenuListner;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 *         <p>
 *         This is Menu of the GUI
 *         </p>
 */
public class Menu extends JMenuBar {
	private static final long serialVersionUID = 1232107393895691717L;

	public JMenuItem gener;
	public JMenuItem zippen;
	public JMenuItem gallerie;
	public JMenuItem exit;
	public JMenuItem set_quality;
	public JMenuItem info;
	public JMenuItem look_windows;
	public JMenuItem look_windows_classic;
	public JMenuItem look_nimbus;
	public JMenuItem look_metal;
	public JMenuItem look_motif;
	public JMenuItem look_gtk;
	public JMenuItem update_check;
	public ArrayList<JMenuItem> plugins;

	/**
	 * @param m a reference to the Main class
	 */
	public Menu(Main m) {
		super();
		JMenu datei = new JMenu(m.mes.getString("Menu.0"));
		JMenu option = new JMenu(m.mes.getString("Menu.1"));
		JMenu optionen_look = new JMenu(m.mes.getString("Menu.2"));
		JMenu about = new JMenu(m.mes.getString("Menu.3"));
		JMenu startPlugIn = new JMenu(m.mes.getString("Menu.StartPlugIn"));
		JMenu configurePlugIn = new JMenu(m.mes.getString("Menu.ConfigurePlugIn"));

		gener = new JMenuItem(m.mes.getString("Menu.4"));
		URL url = ClassLoader.getSystemResource("icons/media-playback-start.png");
		gener.setIcon(new ImageIcon(url));

		url = ClassLoader.getSystemResource("icons/preferences-desktop-theme.png");
		optionen_look.setIcon(new ImageIcon(url));

		zippen = new JMenuItem(m.mes.getString("Menu.13"));
		url = ClassLoader.getSystemResource("icons/package-x-generic.png");
		zippen.setIcon(new ImageIcon(url));

		gallerie = new JMenuItem(m.mes.getString("Menu.14"));
		url = ClassLoader.getSystemResource("icons/text-html.png");
		gallerie.setIcon(new ImageIcon(url));

		exit = new JMenuItem(m.mes.getString("Menu.5"));
		url = ClassLoader.getSystemResource("icons/system-log-out.png");
		exit.setIcon(new ImageIcon(url));

		set_quality = new JMenuItem(m.mes.getString("Menu.6"));
		url = ClassLoader.getSystemResource("icons/preferences-system.png");
		set_quality.setIcon(new ImageIcon(url));

		info = new JMenuItem(m.mes.getString("Menu.7"));
		url = ClassLoader.getSystemResource("icons/help-browser.png");
		info.setIcon(new ImageIcon(url));

		update_check = new JMenuItem(m.mes.getString("Menu.15"));
		url = ClassLoader.getSystemResource("icons/system-software-update.png");
		update_check.setIcon(new ImageIcon(url));

		look_windows = new JMenuItem(m.mes.getString("Menu.8"));
		look_windows_classic = new JMenuItem(m.mes.getString("Menu.9"));
		look_nimbus = new JMenuItem(m.mes.getString("Menu.16"));
		look_metal = new JMenuItem(m.mes.getString("Menu.10"));
		look_motif = new JMenuItem(m.mes.getString("Menu.11"));
		look_gtk = new JMenuItem(m.mes.getString("Menu.12"));

		gener.setEnabled(false);
		zippen.setEnabled(false);
		gallerie.setEnabled(false);

		MenuListner al = new MenuListner(m, this);
		addPluginsToMenus(startPlugIn, configurePlugIn, m);

		datei.add(gener);
		datei.add(zippen);
		datei.add(gallerie);
		datei.addSeparator();
		datei.add(exit);
		option.add(optionen_look);
		option.add(set_quality);
		option.addSeparator();
		option.add(startPlugIn);
		option.add(configurePlugIn);
		option.addSeparator();
		option.add(update_check);
		about.add(info);
		this.add(datei);
		this.add(option);
		this.add(about);

		exit.addActionListener(al);
		gener.addActionListener(al);
		zippen.addActionListener(al);
		gallerie.addActionListener(al);
		set_quality.addActionListener(al);
		info.addActionListener(al);
		look_windows.addActionListener(al);
		look_windows_classic.addActionListener(al);
		look_nimbus.addActionListener(al);
		look_metal.addActionListener(al);
		look_motif.addActionListener(al);
		look_gtk.addActionListener(al);
		update_check.addActionListener(al);

		UIManager.LookAndFeelInfo uii[] = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < uii.length; i++) {
			if (uii[i].toString().substring(uii[i].toString().lastIndexOf(" ") + 1, uii[i].toString().lastIndexOf("]")) //$NON-NLS-1$ //$NON-NLS-2$
					.equalsIgnoreCase("com.sun.java.swing.plaf.windows.WindowsLookAndFeel")) //$NON-NLS-1$
				optionen_look.add(look_windows);
			if (uii[i].toString().substring(uii[i].toString().lastIndexOf(" ") + 1, uii[i].toString().lastIndexOf("]")) //$NON-NLS-1$ //$NON-NLS-2$
					.equalsIgnoreCase("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel")) //$NON-NLS-1$
				optionen_look.add(look_windows_classic);
			if (uii[i].toString().substring(uii[i].toString().lastIndexOf(" ") + 1, uii[i].toString().lastIndexOf("]")) //$NON-NLS-1$ //$NON-NLS-2$
					.equalsIgnoreCase("com.sun.java.swing.plaf.motif.MotifLookAndFeel")) //$NON-NLS-1$
				optionen_look.add(look_motif);
			if (uii[i].toString().substring(uii[i].toString().lastIndexOf(" ") + 1, uii[i].toString().lastIndexOf("]")) //$NON-NLS-1$ //$NON-NLS-2$
					.equalsIgnoreCase("javax.swing.plaf.metal.MetalLookAndFeel")) //$NON-NLS-1$
				optionen_look.add(look_metal);
			if (uii[i].toString().substring(uii[i].toString().lastIndexOf(" ") + 1, uii[i].toString().lastIndexOf("]")) //$NON-NLS-1$ //$NON-NLS-2$
					.equalsIgnoreCase("com.sun.java.swing.plaf.gtk.GTKLookAndFeel")) //$NON-NLS-1$
				optionen_look.add(look_gtk);
			if (uii[i].toString().substring(uii[i].toString().lastIndexOf(" ") + 1, uii[i].toString().lastIndexOf("]")) //$NON-NLS-1$ //$NON-NLS-2$
					.equalsIgnoreCase("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel")) //$NON-NLS-1$
				optionen_look.add(look_nimbus);
		}
	}

	private void addPluginsToMenus(JMenu start, JMenu configure, Main main) {
		for (PluginForJmjrst plugin : PluginManagement.getPlugins()) {
			plugin.init(main);
			JMenuItem itemRun = new JMenuItem(plugin.getName());
			JMenuItem itemConfig = new JMenuItem(plugin.getName());
			itemRun.addActionListener(actionEvent -> plugin.run());
			start.add(itemRun);
			if (plugin.isConfigurable()) {
				itemConfig.addActionListener(actionEvent -> plugin.configure());
				configure.add(itemConfig);
			}
		}
	}

}
