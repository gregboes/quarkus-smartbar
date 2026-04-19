package org.smartbar.backoffice.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.smartbar.backoffice.BaseEntity;
import org.smartbar.backoffice.model.ApiTable;

@Entity
@jakarta.persistence.Table(name = "bo_table", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Table extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private Integer seatCount;

    @NotNull
    private Boolean active;

    public Table(){};

    public Table(String name, Integer seatCount, Boolean active) {
        this.name = name;
        this.seatCount = seatCount;
        this.active = active;
    }

    public Table(ApiTable apiTable) {
        this.name = apiTable.getName();
        this.seatCount = apiTable.getSeatCount();
        this.active = apiTable.getActive();
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
