import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jsonmodel.Property;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestParser {

    public static ObjectMapper mapper = new ObjectMapper();
    public static Property property;

    List <String> widgets;

    @BeforeClass
    public static void readJSON() {
        try {
            property = mapper.readValue(new File("src/test/resources/template.json"),Property.class);
        }
        catch (JsonMappingException e) {
            System.out.println("Issue parsing JSON");
        }
        catch (IOException e) {
            System.out.println("Please check the template.json exists");
        }
        catch (Exception e) {
            System.out.println("Cannot perform the parsing: "+e.getMessage());
        }

    }

   @Test
   public void testMobileDeviceWidgets() {
       widgets = getWidgets("DEVICE", "mobile");
       System.out.println("Matching Mobile Widgets: " + widgets);
   }

   @Test
   public void testDesktopDeviceWidgets() {

       widgets = getWidgets("DEVICE", "desktop");
       System.out.println("Matching Desktop Widgets: " + widgets);
   }

    @Test
    public void testAllDeviceWidgets() {

        widgets = getWidgets("DEVICE", "all");
        System.out.println("Matching for all Device Widgets: " + widgets);
    }

    @Test
    public void testSitePerthNowWidgets() {

        widgets = getWidgets("SITE", "perthnow");
        System.out.println("Matching 'perthnow' Widgets: " + widgets);
    }

    @Test
    public void testSiteAustralianWidgets() {

        widgets = getWidgets("SITE", "theaustralian");
        System.out.println("Matching 'theaustralian' Widgets: " + widgets);
    }

    @Test
    public void testAllSiteWidgets() {

        widgets = getWidgets("SITE","all");
        System.out.println("Matching 'all' site Widgets: "+widgets);
   }

    private  ArrayList<String> getWidgets(String siteOrDevice, String filterBy) {

        ArrayList<String> widgets = new ArrayList<String>();

        property.any().entrySet().stream().forEach(x -> {
            if(siteOrDevice.equalsIgnoreCase("DEVICE")) {
                if (x.getValue().getDevice().equalsIgnoreCase("all") || x.getValue().getDevice().equalsIgnoreCase(filterBy)) {
                    widgets.add(x.getKey());
                }
            }
            else if(siteOrDevice.equalsIgnoreCase("SITE")) {
                if(x.getValue().getSite().stream().anyMatch(y -> y.equalsIgnoreCase("all"))|| x.getValue().getSite().contains(filterBy)) {
                    widgets.add(x.getKey());
                }
            }
        });

        return widgets;
    }

}

