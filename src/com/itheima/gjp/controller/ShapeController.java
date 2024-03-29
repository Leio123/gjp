package com.itheima.gjp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;

import com.itheima.gjp.services.LedgerServices;
import com.itheima.gjp.tools.DateUtils;
import com.itheima.gjp.tools.JFreeChartUtils;
import com.itheima.gjp.view.AbstractShapeDialog;

public class ShapeController extends AbstractShapeDialog {

	public ShapeController(JDialog dialog) {
		super(dialog);
		initDialog();
		// TODO Auto-generated constructor stub
	}

	private LedgerServices ledgerServices = new LedgerServices();

	/*
	 * 获取生成的图片路径，路径存储到List集合中
	 * 
	 * 问题？谁生成图片 JFreeChartUtils静态方法Pie() 调用services层方法，获取需要的数据
	 */
	@Override
	public List<String> getImagePaths() {
		List<String> listPath = new ArrayList<String>();
		// 调用services层方法queryTotalMoneyByParent,获取所有支出或者收入的总金额
		double moneyPay = ledgerServices.queryTotalMoneyByParent("支出");
		// 调用调用services层方法querySumMoneyBySort，获取支出或者收入中的每一项的总金额，工资、股票收入
		Map<String, Double> mapPay = ledgerServices.querySumMoneyBySort("支出");
		// 调用JFreeChartUtils工具类中的方法pie生成图片
		String titlePay = "支出占比图(" + moneyPay + " 元)(" + DateUtils.getYear() + " 年)";
		String pathPay = "pay.jpg";
		JFreeChartUtils.pie(titlePay, mapPay, moneyPay, pathPay);
		listPath.add(pathPay);

		// 调用services层方法queryTotalMoneyByParent,获取所有支出或者收入的总金额
		double moneyIn = ledgerServices.queryTotalMoneyByParent("收入");
		// 调用调用services层方法querySumMoneyBySort，获取支出或者收入中的每一项的总金额，服装，交通等等支出
		Map<String, Double> mapIn = ledgerServices.querySumMoneyBySort("收入");
		// 调用JFreeChartUtils工具类中的方法pie生成图片
		String titleIn = "收入占比图(" + moneyIn + " 元)(" + DateUtils.getYear() + " 年)";
		String pathIn = "in.jpg";
		JFreeChartUtils.pie(titleIn, mapIn, moneyIn, pathIn);
		listPath.add(pathIn);
		return listPath;
	}

}
