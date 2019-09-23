package com.github.alexandrenavarro.springboothateoassample;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class OLink  extends RepresentationModel<OLink> {

    @Builder
    public OLink(@Singular List<Link> initialLinks) {
        super(initialLinks);
    }
}
