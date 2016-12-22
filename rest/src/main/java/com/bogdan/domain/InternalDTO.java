package com.bogdan.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by zoomout on 12/22/16.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalDTO {
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        InternalDTO internalDTO = (InternalDTO) o;

        return new EqualsBuilder().append(getIntName(), internalDTO.getIntName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getIntName()).toHashCode();
    }

    public String getIntName() {
        return intName;
    }

    public InternalDTO setIntName(String intName) {
        this.intName = intName;
        return this;
    }

    private String intName;

    @Override
    public String toString() {
        return "InternalDTO{" + "intName='" + intName + '\'' + '}';
    }
}
