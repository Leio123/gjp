package com.itheima.gjp.controller;

import com.itheima.gjp.view.AbstractMainFrame;

public class MainFrameContrller extends AbstractMainFrame {

	/*重写主窗体类的抽象对象
	 * 打开账务管理对话框
	 * */

	@Override
	public void ledgerMng() {
		//创建账务管理对话框的子类对象
		new LedgerMngController(this).setVisible(true);

	}
	/*重写主窗体类的抽象对象
	 * 打开分类管理对话框
	 * */
	@Override
	public void sortMng() {
		//创建分类对话框的子类对象
		new SortMngController(this).setVisible(true);
	}

}
