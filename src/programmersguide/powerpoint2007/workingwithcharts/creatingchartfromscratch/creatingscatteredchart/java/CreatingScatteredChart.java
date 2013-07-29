/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Slides. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.powerpoint2007.workingwithcharts.creatingchartfromscratch.creatingscatteredchart.java;

import com.aspose.slides.*;

public class CreatingScatteredChart
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/powerpoint2007/workingwithcharts/creatingchartfromscratch/creatingscatteredchart/data/";

        //Instantiate PresentationEx class that represents PPTX file
        PresentationEx pres = new PresentationEx();

        //Access first slide
        SlideEx sld = pres.getSlides().get_Item(0);

        // Add chart with default data
        ChartEx chart = sld.getShapes().addChart(ChartTypeEx.ClusteredCylinder, 0, 0, 500, 500);

        //Setting chart Title
        chart.getChartTitle().getText().setText("Sample Title");
        chart.getChartTitle().getText().setCenterText(true);
        chart.getChartTitle().setHeight(20f);
        chart.hasTitle(true);

        //Set first series to Show Values
        chart.getChartData().getSeries().get_Item(0).getLabels().setShowValue(true);

        //Setting the index of chart data sheet
        int defaultWorksheetIndex = 0;

        //Getting the chart data worksheet
        ChartDataCellFactory fact = chart.getChartData().getChartDataCellFactory();

        //Set first series to Show Values
        chart.getChartData().getSeries().get_Item(0).getLabels().setShowValue(true);

        //Delete default generated series and categories
        chart.getChartData().getSeries().clear();
        chart.getChartData().getCategories().clear();

        //Adding new series
        chart.getChartData().getSeries().add(fact.getCell(defaultWorksheetIndex, 0, 1, "Series 1"), chart.getType());
        chart.getChartData().getSeries().add(fact.getCell(defaultWorksheetIndex, 0, 2, "Series 2"), chart.getType());
        chart.getChartData().getSeries().add(fact.getCell(defaultWorksheetIndex, 0, 3, "Series 3"), chart.getType());

        //Adding new categories
        chart.getChartData().getCategories().add(fact.getCell(defaultWorksheetIndex, 1, 0, "Caetegoty 1"));
        chart.getChartData().getCategories().add(fact.getCell(defaultWorksheetIndex, 2, 0, "Caetegoty 2"));
        chart.getChartData().getCategories().add(fact.getCell(defaultWorksheetIndex, 3, 0, "Caetegoty 3"));

        //Take first chart series
        ChartSeriesEx series = chart.getChartData().getSeries().get_Item(0);

        //Now populating series data
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 1, 1, 90));
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 2, 1, 123));
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 3, 1, 44));

        //Take second chart series
        series = chart.getChartData().getSeries().get_Item(1);

        //Now populating series data
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 1, 2, 23));
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 2, 2, 67));
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 3, 2, 99));

        //Take 3rd chart series
        series = chart.getChartData().getSeries().get_Item(2);

        //Now populating series data
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 1, 3, 20));
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 2, 3, 50));
        series.getValues().add(fact.getCell(defaultWorksheetIndex, 3, 3, 30));

        // Save presentation with chart
        pres.write(dataDir + "AsposeSeriesChart.pptx");

        // Status
        System.out.println("Chart created successfully.");
    }
}




