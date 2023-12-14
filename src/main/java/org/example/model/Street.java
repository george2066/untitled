package org.example.model;

//<OBJECT
// ID="1745891"
// OBJECTID="1418203"
// OBJECTGUID="17ef3c93-1607-4424-a403-95fd5f5587af"
// CHANGEID="3872344"
// NAME="Хатанзейского"
// TYPENAME="ул"
// LEVEL="8"
// OPERTYPEID="1"
// PREVID="0"
// NEXTID="0"
// UPDATEDATE="2018-07-16"
// STARTDATE="1900-01-01"
// ENDDATE="2079-06-06"
// ISACTUAL="1"
// ISACTIVE="1" />

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Street extends City {
    private long id;
    private long objectId;
    private String objectGUId;
    private long changeId;
    private String name;
    private String typeName;
    private int level;
    private long operTypeId;
    private int prevId;
    private int nextId;
    private String updateDate;
    private String startDate;
    private String endDate;
    private int isActual;
    private int isActive;
}
