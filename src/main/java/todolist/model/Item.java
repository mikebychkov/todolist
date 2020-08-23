package todolist.model;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="description")
    private String desc;
    private GregorianCalendar created;
    private GregorianCalendar done;

    public Item() {
    }

    public Item(String desc) {
        this.desc = desc;
    }

    public Item(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
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

    public GregorianCalendar getCreated() {
        return created;
    }

    public void setCreated(GregorianCalendar created) {
        this.created = created;
    }

    public GregorianCalendar getDone() {
        return done;
    }

    public void setDone(GregorianCalendar done) {
        this.done = done;
    }
}
