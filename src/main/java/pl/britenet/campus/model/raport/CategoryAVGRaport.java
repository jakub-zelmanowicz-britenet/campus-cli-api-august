package pl.britenet.campus.model.raport;

public class CategoryAVGRaport {

    private final String name;
    private final double avg;

    public CategoryAVGRaport(String name, double avg) {
        this.name = name;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public double getAvg() {
        return avg;
    }
}
