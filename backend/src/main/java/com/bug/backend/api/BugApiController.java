package com.bug.backend.api;


import java.util.Optional;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-02T12:34:37.943601+02:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.bugTracker.base-path:/v1}")
public class BugApiController implements BugApi {

  private final BugApiDelegate delegate;

  public BugApiController(@Autowired(required = false) BugApiDelegate delegate) {
    this.delegate = Optional.ofNullable(delegate).orElse(new BugApiDelegate() {
    });
  }

  @Override
  public BugApiDelegate getDelegate() {
    return delegate;
  }

}
