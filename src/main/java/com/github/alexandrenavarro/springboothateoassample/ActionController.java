package com.github.alexandrenavarro.springboothateoassample;

import org.springframework.hateoas.Affordance;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping(value = "/actions")
public class ActionController {

    @GetMapping
    public List<Action> getActions() {
        // TODO check how to use CollectionModel
        return List.of(Action.builder()
                .actionId("actionId")
                .actionName("actionName")
                .initialLink(linkTo(methodOn(this.getClass()).getAction(1)).withRel("1"))
                .build());
    }


    @GetMapping("/{id}")
    public Action getAction(@PathVariable Integer id) {
        return Action.builder()
                .actionId("id")
                .actionName("actionName")
                .initialLinks(List.of(linkTo(methodOn(this.getClass()).getAction(id)).withSelfRel(),
                        linkTo(methodOn(this.getClass()).getCancel(id)).withRel("cancel"),
                        linkTo(methodOn(this.getClass()).putUpdate(id)).withRel("update")
                ))
                .build();
    }

    @GetMapping("/{id}/cancel")
    public OLink getCancel(@PathVariable Integer id) {
        return OLink.builder()
                .initialLinks(List.of(linkTo(methodOn(this.getClass()).getCancel(id)).withSelfRel().
                        andAffordance(afford(methodOn(this.getClass()).getCancel(id)))
                        .andAffordance(afford(methodOn(this.getClass()).postCancel(id)))
                        .andAffordance(afford(methodOn(this.getClass()).putCancel(id))),
                        linkTo(methodOn(this.getClass()).getAction(id)).withRel(IanaLinkRelations.ORIGINAL)))
                .build();
    }

    @PostMapping("/{id}/cancel")
    public Action postCancel(@PathVariable Integer id) {
        return Action.builder()
                .actionId("actionId" + id)
                .actionName("postCancel")
                .initialLink(linkTo(methodOn(this.getClass()).postCancel(id)).withSelfRel())
                .build();
    }

    @PutMapping("/{id}/cancel")
    public Action putCancel(@PathVariable Integer id) {
        return Action.builder()
                .actionId("actionId" + id)
                .actionName("putCancel")
                .initialLink(linkTo(methodOn(this.getClass()).putCancel(id)).withSelfRel())
                .build();
    }

    @GetMapping("/{id}/update")
    public OLink getUpdate(@PathVariable Integer id) {
        return OLink.builder()
                .initialLinks(List.of(linkTo(methodOn(this.getClass()).getUpdate(id)).withSelfRel().
                        andAffordance(afford(methodOn(this.getClass()).putUpdate(id))),
                        linkTo(methodOn(this.getClass()).getAction(id)).withRel(IanaLinkRelations.ORIGINAL)))
                .build();
    }

    @PutMapping("/{id}/update")
    public Action putUpdate(@PathVariable Integer id) {
        return Action.builder()
                .actionId("actionId" + id)
                .actionName("update")
                .initialLink(linkTo(methodOn(this.getClass()).putUpdate(id)).withSelfRel())
                .build();
    }
}
