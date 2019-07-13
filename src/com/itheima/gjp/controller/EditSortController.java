package com.itheima.gjp.controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.itheima.gjp.domain.Sort;
import com.itheima.gjp.services.SortService;
import com.itheima.gjp.view.AbstractOperationSortDialog;
/*
 * 编辑分类的对话框
 * */
public class EditSortController extends AbstractOperationSortDialog {
	private Sort sort;//两个方法，一个成员变量
	public EditSortController(JDialog dialog,Sort sort) {
		super(dialog);
		titleLabel.setText("编辑分类");
		super.setTitle("编辑分类");
		
		this.sort=sort;
		//获取Sort对象中的数据，填充到对话框中
		//Sort对象中，封装的分类填充到下拉菜单中
		//setSelectedItem，将菜单中已有的项目，作为默认项出现
		parentBox.setSelectedItem(sort.getParent());
		snameTxt.setText(sort.getSname());
		sdescArea.setText(sort.getSdesc());
	}
	//点击编辑按钮，调用方法
	@Override
	public void confirm() {
		//获取分类下拉菜单
		String parent=parentBox.getSelectedItem().toString();
		//获取分类名称
		String sname=snameTxt.getText().trim();
		//获取分类描述
		String sdesc=sdescArea.getText();
		//此处数据是否符合要求，和添加分类的验证方法相同。
		if(parent.equals("=请选择=")) {
			JOptionPane.showMessageDialog(this, "请选择分类");
			return;
		}
		if(sname==null || sname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入分类名称");
			return;
		}
		//获取到的数据封装成Sort对象
		sort.setSname(sname);
		sort.setParent(parent);
		sort.setSdesc(sdesc);
		//调用services层内容，传递Sort对象，进行修改
		//需要调用service层的Sortservice方法editSort()传递Sort对象
		//创建service层的SortService类的对象
		SortService sortService=new SortService();
		//调用方法editSort传递封装好的Sort对象
		sortService.editSort(sort);
		//提示用户编辑分类成功
		JOptionPane.showConfirmDialog(this,"编辑分类成功","操作成功",JOptionPane.PLAIN_MESSAGE);
		//关闭自己的对话框
		this.dispose();
	}

}
