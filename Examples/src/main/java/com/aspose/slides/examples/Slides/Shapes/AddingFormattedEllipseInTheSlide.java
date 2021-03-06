package com.aspose.slides.examples.Slides.Shapes;

import java.awt.Color;

import com.aspose.slides.FillType;
import com.aspose.slides.IShape;
import com.aspose.slides.ISlide;
import com.aspose.slides.Presentation;
import com.aspose.slides.PresetColor;
import com.aspose.slides.SaveFormat;
import com.aspose.slides.ShapeType;
import com.aspose.slides.examples.Utils;

public class AddingFormattedEllipseInTheSlide {

	public static void main(String[] args) {
	//ExStart:AddingFormattedEllipseInTheSlide


		// The path to the documents directory.
		String dataDir = Utils.getDataDir(AddingFormattedEllipseInTheSlide.class);

		// Instantiate Presentation class that represents the PPTX
		Presentation pres = new Presentation();

		// Get the first slide
		ISlide sld = pres.getSlides().get_Item(0);

		// Add AutoShape of ellipse type
		IShape shp = sld.getShapes().addAutoShape(ShapeType.Ellipse, 50, 150, 150, 50);

		// Apply some formatting to ellipse shape
		shp.getFillFormat().setFillType(FillType.Solid);
		shp.getFillFormat().getSolidFillColor().setColor(new Color(PresetColor.Chocolate));

		// Apply some formatting to the line of Ellipse
		shp.getLineFormat().getFillFormat().setFillType(FillType.Solid);
		shp.getLineFormat().getFillFormat().getSolidFillColor().setColor(Color.BLACK);
		shp.getLineFormat().setWidth(5);

		// Write the PPTX file to disk
		pres.save(dataDir + "EllipseShp1.pptx", SaveFormat.Pptx);
	//ExEnd:AddingFormattedEllipseInTheSlide

	}

}
