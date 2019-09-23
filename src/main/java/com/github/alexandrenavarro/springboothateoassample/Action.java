package com.github.alexandrenavarro.springboothateoassample;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class Action extends RepresentationModel<Action> {
    private String actionId;
    private String actionName;

    @Builder
    public Action(String actionId, String actionName, @Singular List<Link> initialLinks) {
        super(initialLinks);
        this.actionId = actionId;
        this.actionName = actionName;
    }
}
