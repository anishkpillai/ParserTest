package jsonmodel;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class Widget {

    private String device;
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }


    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<String> site;

    public List<String> getSite() {
        return site;
    }

    public void setSite(List<String> site) {
        this.site = site;
    }


}
