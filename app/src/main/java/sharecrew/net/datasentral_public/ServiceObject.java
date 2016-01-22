package sharecrew.net.datasentral_public;

/**
 * Created by baljk on 22.01.2016.
 */
public class ServiceObject {

    private String title, desc, price;
    private int icon;

    public ServiceObject(String title, String desc, String price, int icon){
        this.title  = title;
        this.desc   = desc;
        this.price  = price;
        this.icon   = icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public int getIcon() {
        return icon;
    }
}
