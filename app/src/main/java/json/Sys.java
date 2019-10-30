package json;

public class Sys {
    private double id;
    private String country;
    private long sunrise;
    private long sunset;

    public Sys(double id, String country, long sunrise, long sunset) {
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Sys() {
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}
