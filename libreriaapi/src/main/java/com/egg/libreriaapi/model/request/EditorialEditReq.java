package com.egg.libreriaapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EditorialEditReq {
    private String id;
    private String name;
    private Boolean active;
}
