package com.bogdan.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;
import java.util.Map;

/**
 * Created by zoomout on 12/22/16.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalDTO {
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        ExternalDTO externalDTO = (ExternalDTO) o;

        return new EqualsBuilder().append(getName(), externalDTO.getName())
          .append(getAge(), externalDTO.getAge()).append(
            getInternalDTO(), externalDTO.getInternalDTO())
          .append(getInternalDTOsList(), externalDTO.getInternalDTOsList())
          .append(getInternalDTOsMap(), externalDTO.getInternalDTOsMap()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getName()).append(getAge()).append(getInternalDTO())
          .append(getInternalDTOsList()).append(getInternalDTOsMap()).toHashCode();
    }

    private String name;
    private Integer age;
    private InternalDTO internalDTO;
    private List<InternalDTO> internalDTOsList;

    public Map<String, InternalDTO> getInternalDTOsMap() {
        return internalDTOsMap;
    }

    public ExternalDTO setInternalDTOsMap(Map<String, InternalDTO> internalDTOsMap) {
        this.internalDTOsMap = internalDTOsMap;
        return this;
    }

    private Map<String, InternalDTO> internalDTOsMap;

    public String getName() {
        return name;
    }

    public ExternalDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public ExternalDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public InternalDTO getInternalDTO() {
        return internalDTO;
    }

    public ExternalDTO setInternalDTO(InternalDTO internalDTO) {
        this.internalDTO = internalDTO;
        return this;
    }

    public List<InternalDTO> getInternalDTOsList() {
        return internalDTOsList;
    }

    public ExternalDTO setInternalDTOsList(List<InternalDTO> internalDTOsList) {
        this.internalDTOsList = internalDTOsList;
        return this;
    }

    @Override
    public String toString() {
        return "ExternalDTO{" + "name='" + name + '\'' + ", age=" + age + ", internalDTO=" + internalDTO
          + ", internalDTOsList=" + internalDTOsList + ", internalDTOsMap=" + internalDTOsMap + '}';
    }
}



