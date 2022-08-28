package com.bug.backend.api;

import com.bug.backend.dto.BugDTO;
import com.bug.backend.dto.HistoryDTO;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * A delegate to be called by the {@link BugApiController}}. Implement this interface with a
 * {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-02T12:34:37.943601+02:00[Europe/Berlin]")
public interface BugApiDelegate {

  default Optional<NativeWebRequest> getRequest() {
    return Optional.empty();
  }

  /**
   * POST /bug : Create a new bug
   *
   * @param bugBody A JSON object containing new bug&#39;s information (required)
   * @return Bug created (status code 201) or Invalid input supplied (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#createBug
   */
  default ResponseEntity<BugDTO> createBug(BugDTO bugBody) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * DELETE /bug/{bugId} : delete a bug
   *
   * @param bugId The bug id name to be deleted (required)
   * @return successful delete (status code 204) or Invalid input supplied (status code 400) or Bug
   * not found (status code 404)
   * @see BugApi#deleteBug
   */
  default ResponseEntity<Void> deleteBug(Long bugId) {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug/assignee/{assigneeName} : Find bugs by assignee name
   *
   * @param assigneeName The assignee name to be searched (required)
   * @return successful operation (status code 200) or Invalid input (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#getBugByAssignee
   */
  default ResponseEntity<List<BugDTO>> getBugByAssignee(String assigneeName) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug/{bugId} : Find bugs by bug id
   *
   * @param bugId The bug id name to be searched (required)
   * @return successful operation (status code 200) or Invalid input (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#getBugById
   */
  default ResponseEntity<BugDTO> getBugById(Long bugId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug/reporter/{reporterName} : Find bugs by reporter name
   *
   * @param reporterName The reporter name to be searched (required)
   * @return successful operation (status code 200) or Invalid input (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#getBugByReporter
   */
  default ResponseEntity<List<BugDTO>> getBugByReporter(String reporterName) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug/state/{state} : Find bugs by state
   *
   * @param state The state name to be searched (required)
   * @return successful operation (status code 200) or Invalid input (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#getBugByState
   */
  default ResponseEntity<List<BugDTO>> getBugByState(String state) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug/topic/{topic} : Find bugs by topic
   *
   * @param topic The topic name to be searched (required)
   * @return successful operation (status code 200) or Invalid input (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#getBugByTopic
   */
  default ResponseEntity<List<BugDTO>> getBugByTopic(String topic) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug/history/{bugId} : Find bug histories
   *
   * @param bugId The bugId to be searched in the histories (required)
   * @return successful operation (status code 200) or Invalid input (status code 400) or Bug not
   * found (status code 404)
   * @see BugApi#getBugHistory
   */
  default ResponseEntity<List<HistoryDTO>> getBugHistory(Long bugId) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"newValue\" : \"newValue\", \"bug\" : { \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }, \"oldValue\" : \"oldValue\", \"updated\" : \"2000-01-23T04:56:07.000+00:00\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * GET /bug : list bugs
   *
   * @return Input accepted for consuming by another processor (status code 200) or Invalid input
   * supplied (status code 400) or Bug not found (status code 404)
   * @see BugApi#listBugs
   */
  default ResponseEntity<List<BugDTO>> listBugs() {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

  /**
   * PUT /bug : Update a bug
   *
   * @param bugBody A JSON object containing new bug&#39;s information (required)
   * @return Item updated (status code 202) or Invalid input supplied (status code 400)
   * @see BugApi#updateBug
   */
  default ResponseEntity<BugDTO> updateBug(BugDTO bugBody) {
    getRequest().ifPresent(request -> {
      for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
        if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
          String exampleString = "{ \"bugId\" : 1, \"created\" : \"2022-07-27T08:00:00Z\", \"description\" : \"some description related to the bug\", \"topic\" : \"a topic\", \"assignees\" : [ { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" } ], \"reporter\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"assignee\" : { \"fullName\" : \"John Smith\", \"email\" : \"joe@example.com\" }, \"state\" : \"NEW\", \"updated\" : \"2022-07-27T08:00:00Z\" }";
          ApiUtil.setExampleResponse(request, "application/json", exampleString);
          break;
        }
      }
    });
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

  }

}
