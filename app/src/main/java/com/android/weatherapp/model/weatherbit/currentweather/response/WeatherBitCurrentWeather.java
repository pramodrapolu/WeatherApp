
package com.android.weatherapp.model.weatherbit.currentweather.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "count"
})
public class WeatherBitCurrentWeather {

    @JsonProperty("data")
    private List<Data> data = null;

    @JsonProperty("count")
    private int count;

    @JsonProperty("data")
    public List<Data> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Data> data) {
        this.data = data;
    }

    @JsonProperty("count")
    public int getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(int count) {
        this.count = count;
    }

}
