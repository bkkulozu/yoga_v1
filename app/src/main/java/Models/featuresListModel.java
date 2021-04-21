package Models;

public class featuresListModel {

    private String Name;
    private int logo;


    public featuresListModel(String name, int logo) {
        Name = name;
        this.logo = logo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
