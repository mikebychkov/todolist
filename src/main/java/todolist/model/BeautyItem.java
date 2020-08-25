package todolist.model;

import java.util.GregorianCalendar;

public class BeautyItem {
    private Integer id;
    private String desc;
    private String created;
    private String done;

    public BeautyItem(Item item) {
        id = item.getId();
        desc = item.getDesc();
        created = getDate(item.getCreated());
        done = getDate(item.getDone());
    }

    private String getDate(GregorianCalendar gc) {
        String rsl = "";
        if (gc != null) {
            rsl = gc.getTime().toString();
        }
        return rsl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }
}
