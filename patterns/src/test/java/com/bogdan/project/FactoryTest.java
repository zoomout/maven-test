package com.bogdan.project;

import com.bogdan.project.factory.ShapeFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zoomout on 4/30/16.
 */
public class FactoryTest {
    private final ShapeFactory shapeFactory = new ShapeFactory();

    @Test
    public void drawCircle() {
        assertEquals(shapeFactory.getShape("CIRCLE").draw(), "circle");
    }

    @Test
    public void drawRectangle() {
        assertEquals(shapeFactory.getShape("RECTANGLE").draw(), "rectangle");
    }

    @Test
    public void drawSquare() {
        assertEquals(shapeFactory.getShape("SQUARE").draw(), "square");
    }
}
