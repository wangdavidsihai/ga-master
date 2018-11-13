package com.scb.ga.interfaces.facade.assembler;

import com.scb.ga.domain.Menu;
import com.scb.ga.interfaces.facade.commondobject.MenuCreateCommand;
import com.scb.ga.interfaces.facade.commondobject.MenuUpdateCommond;
import com.scb.ga.util.BeanUtil;

/**
 * @author David Wang
 *
 */
public class MenuAssembler {

	public static Menu updateCommendToDomain(String id, MenuUpdateCommond updateCommond) {
		Menu menu = new Menu();
		BeanUtil.copeProperties(updateCommond, menu);
		menu.setId(id);
		return menu;
	}

	public static Menu createCommendToDomain(MenuCreateCommand creteCommand) {
		Menu menu = new Menu();
		BeanUtil.copeProperties(creteCommand, menu);
		return menu;
	}
}
