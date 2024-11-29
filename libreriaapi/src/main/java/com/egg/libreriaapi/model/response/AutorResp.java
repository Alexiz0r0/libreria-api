package com.egg.libreriaapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class AutorResp {
    private String id;
    private String name;
    private Boolean active;
}
