package com.parser.widget;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parser.widget.jsonmodel.Property;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WidgetParser {

    private Property property;
    private ObjectMapper mapper = new ObjectMapper();

    public WidgetParser() {
        property = new Property();

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



    public List<String> getWidgets(String siteOrDevice, String filterBy) {

        List<String> widgets = new ArrayList<String>();

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
