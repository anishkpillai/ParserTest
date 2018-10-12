import com.parser.widget.WidgetParser;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestParser {


    List<String> widgets;
    WidgetParser parser;

    @Before
    public void setup() {
        parser = new WidgetParser();
    }

    @Test
    public void testMobileDeviceWidgets() {
        widgets = parser.getWidgets("DEVICE", "mobile");
        System.out.println("Matching Mobile Widgets: " + widgets);
    }

    @Test
    public void testDesktopDeviceWidgets() {

        widgets = parser.getWidgets("DEVICE", "desktop");
        System.out.println("Matching Desktop Widgets: " + widgets);
    }

    @Test
    public void testAllDeviceWidgets() {

        widgets = parser.getWidgets("DEVICE", "all");
        System.out.println("Matching for all Device Widgets: " + widgets);
    }

    @Test
    public void testSitePerthNowWidgets() {

        widgets = parser.getWidgets("SITE", "perthnow");
        System.out.println("Matching 'perthnow' Widgets: " + widgets);
    }

    @Test
    public void testSiteAustralianWidgets() {

        widgets = parser.getWidgets("SITE", "theaustralian");
        System.out.println("Matching 'theaustralian' Widgets: " + widgets);
    }

    @Test
    public void testAllSiteWidgets() {

        widgets = parser.getWidgets("SITE", "all");
        System.out.println("Matching 'all' site Widgets: " + widgets);
    }


}

