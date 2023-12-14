package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends City {
    private long id;
    private long objectId;
    private long parentObjId;
    private long changeId;
    private long nextId;
    private String updateDate;
    private String startDate;
    private String endDate;
    private int isActive;
}
