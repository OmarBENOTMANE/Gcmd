package org.backend.gdc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum typePaiementEnum {

    conptant(1)
    ,credit(0);

    private int value;
}
