package jsonmodel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class Property {

    private Map<String, Widget> widget = new HashMap<String, Widget>();

    @JsonAnyGetter
    public Map<String, Widget> any() {
        return widget;
    }

    @JsonAnySetter
    public void set(String name, Widget value) {
        widget.put(name, value);
    }


}
