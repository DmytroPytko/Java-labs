package com.dimon.DTO.impl;

import com.dimon.DTO.DTO;
import com.dimon.domain.Replacement;
import com.dimon.exceptions.NoSuchReplacementException;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class ReplacementDTO extends DTO<Replacement> {
    public ReplacementDTO(Replacement replacement, Link link) throws NoSuchReplacementException {
        super(replacement, link);
    }

    public Long getReplacementId() {
        return getEntity().getId();
    }

    public String getNameOfReplacement() {
        return getEntity().getNameOfReplacement();
    }

    public String getSurnameOfReplacement() {
        return getEntity().getSurnameOfReplacement();
    }
}
