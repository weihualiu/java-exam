package cn.lynu.lyq.java_exam.test;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtils;

public class JFreeChartTest1 {

	public static void main(String[] args) throws IOException {
		double[][] data = new double[][] { { 90 , 80 , 77 , 85 } };
		String[] rowKeys = {""};
		String[] columnKeys = { "张三", "李四", "王二", "马六" };
		CategoryDataset dataset = DatasetUtils.createCategoryDataset(rowKeys, columnKeys, data);

		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("SimHei", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);

		JFreeChart chart = ChartFactory.createBarChart("成绩分布图", "姓名", "成绩", dataset, PlotOrientation.VERTICAL, true,
				false, false);
		// String filename = ServletUtilities.saveChartAsPNG(chart, 450, 300,
		// null, session);
		CategoryPlot plot = chart.getCategoryPlot();// 获得图表区域对象
		plot.setRenderer(new CustomRenderer());
		ChartUtils.saveChartAsPNG(new File("d:\\test1.png"), chart, 1000, 600);
	}

}
