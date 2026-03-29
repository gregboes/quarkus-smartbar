package org.smartbar.backoffice.tables;

import jakarta.persistence.Entity;
import org.smartbar.backoffice.BaseEntity;

@Entity
@jakarta.persistence.Table(name = "bo_table")
public class Table extends BaseEntity {

    private String name;
    private Integer seatCount;
    private Boolean active;

    public Table(){};

    public Table(String name, Integer seatCount, Boolean active) {
        this.name = name;
        this.seatCount = seatCount;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
