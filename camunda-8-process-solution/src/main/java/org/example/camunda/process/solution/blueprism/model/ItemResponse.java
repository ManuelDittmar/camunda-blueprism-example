/*
 * Blue Prism API
 * The Blue Prism API provides a series of predefined capabilities that can be used by custom solutions to interact with Blue Prism programmatically using a REST API.   Blue Prism agreements can be found on the Blue Prism portal: https://portal.blueprism.com/agreements   # Authentication  <!-- ReDoc-Inject: <security-definitions> -->
 *
 * The version of the OpenAPI document: 7.0.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.example.camunda.process.solution.blueprism.model;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

/**
 * Contains details of a work queue item including the data.
 */
@ApiModel(description = "Contains details of a work queue item including the data.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-11-24T09:41:18.453343+01:00[Europe/Berlin]")
public class ItemResponse {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_PRIORITY = "priority";
  @SerializedName(SERIALIZED_NAME_PRIORITY)
  private Integer priority;

  public static final String SERIALIZED_NAME_IDENT = "ident";
  @SerializedName(SERIALIZED_NAME_IDENT)
  private Integer ident;

  /**
   * The current state of the item
   */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    NONE("None"),

    PENDING("Pending"),

    LOCKED("Locked"),

    DEFERRED("Deferred"),

    COMPLETED("Completed"),

    EXCEPTIONED("Exceptioned");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StateEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StateEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private StateEnum state;

  public static final String SERIALIZED_NAME_KEY_VALUE = "keyValue";
  @SerializedName(SERIALIZED_NAME_KEY_VALUE)
  private String keyValue;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private String status;

  public static final String SERIALIZED_NAME_TAGS = "tags";
  @SerializedName(SERIALIZED_NAME_TAGS)
  private List<String> tags = null;

  public static final String SERIALIZED_NAME_ATTEMPT_NUMBER = "attemptNumber";
  @SerializedName(SERIALIZED_NAME_ATTEMPT_NUMBER)
  private Integer attemptNumber;

  public static final String SERIALIZED_NAME_LOADED_DATE = "loadedDate";
  @SerializedName(SERIALIZED_NAME_LOADED_DATE)
  private String loadedDate;

  public static final String SERIALIZED_NAME_DEFERRED_DATE = "deferredDate";
  @SerializedName(SERIALIZED_NAME_DEFERRED_DATE)
  private String deferredDate;

  public static final String SERIALIZED_NAME_LOCKED_DATE = "lockedDate";
  @SerializedName(SERIALIZED_NAME_LOCKED_DATE)
  private String lockedDate;

  public static final String SERIALIZED_NAME_COMPLETED_DATE = "completedDate";
  @SerializedName(SERIALIZED_NAME_COMPLETED_DATE)
  private String completedDate;

  public static final String SERIALIZED_NAME_EXCEPTIONED_DATE = "exceptionedDate";
  @SerializedName(SERIALIZED_NAME_EXCEPTIONED_DATE)
  private String exceptionedDate;

  public static final String SERIALIZED_NAME_EXCEPTION_REASON = "exceptionReason";
  @SerializedName(SERIALIZED_NAME_EXCEPTION_REASON)
  private String exceptionReason;

  public static final String SERIALIZED_NAME_LAST_UPDATED = "lastUpdated";
  @SerializedName(SERIALIZED_NAME_LAST_UPDATED)
  private String lastUpdated;

  public static final String SERIALIZED_NAME_WORK_TIME_IN_SECONDS = "workTimeInSeconds";
  @SerializedName(SERIALIZED_NAME_WORK_TIME_IN_SECONDS)
  private Integer workTimeInSeconds;

  public static final String SERIALIZED_NAME_ATTEMPT_WORK_TIME_IN_SECONDS = "attemptWorkTimeInSeconds";
  @SerializedName(SERIALIZED_NAME_ATTEMPT_WORK_TIME_IN_SECONDS)
  private Integer attemptWorkTimeInSeconds;

  public static final String SERIALIZED_NAME_RESOURCE = "resource";
  @SerializedName(SERIALIZED_NAME_RESOURCE)
  private String resource;

  public static final String SERIALIZED_NAME_DATA = "data";
  @SerializedName(SERIALIZED_NAME_DATA)
  private BpCollectionData data;

  public ItemResponse() {
  }

  public ItemResponse id(UUID id) {

    this.id = id;
    return this;
  }

   /**
   * The ID of the item
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the item")

  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public ItemResponse priority(Integer priority) {

    this.priority = priority;
    return this;
  }

   /**
   * The priority value assigned to the item
   * @return priority
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The priority value assigned to the item")

  public Integer getPriority() {
    return priority;
  }


  public void setPriority(Integer priority) {
    this.priority = priority;
  }


  public ItemResponse ident(Integer ident) {

    this.ident = ident;
    return this;
  }

   /**
   * The database-specific intentity of the item
   * @return ident
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The database-specific intentity of the item")

  public Integer getIdent() {
    return ident;
  }


  public void setIdent(Integer ident) {
    this.ident = ident;
  }


  public ItemResponse state(StateEnum state) {

    this.state = state;
    return this;
  }

   /**
   * The current state of the item
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The current state of the item")

  public StateEnum getState() {
    return state;
  }


  public void setState(StateEnum state) {
    this.state = state;
  }


  public ItemResponse keyValue(String keyValue) {

    this.keyValue = keyValue;
    return this;
  }

   /**
   * The value of the key field
   * @return keyValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The value of the key field")

  public String getKeyValue() {
    return keyValue;
  }


  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }


  public ItemResponse status(String status) {

    this.status = status;
    return this;
  }

   /**
   * The user-supplied status value
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The user-supplied status value")

  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }


  public ItemResponse tags(List<String> tags) {

    this.tags = tags;
    return this;
  }

  public ItemResponse addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * A collection of tags assigned to the item
   * @return tags
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A collection of tags assigned to the item")

  public List<String> getTags() {
    return tags;
  }


  public void setTags(List<String> tags) {
    this.tags = tags;
  }


  public ItemResponse attemptNumber(Integer attemptNumber) {

    this.attemptNumber = attemptNumber;
    return this;
  }

   /**
   * The number of the attempt next time this item is worked
   * minimum: 1
   * @return attemptNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of the attempt next time this item is worked")

  public Integer getAttemptNumber() {
    return attemptNumber;
  }


  public void setAttemptNumber(Integer attemptNumber) {
    this.attemptNumber = attemptNumber;
  }


  public ItemResponse loadedDate(String loadedDate) {

    this.loadedDate = loadedDate;
    return this;
  }

   /**
   * The time and date that the item was loaded into the system
   * @return loadedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time and date that the item was loaded into the system")

  public String getLoadedDate() {
    return loadedDate;
  }


  public void setLoadedDate(String loadedDate) {
    this.loadedDate = loadedDate;
  }


  public ItemResponse deferredDate(String deferredDate) {

    this.deferredDate = deferredDate;
    return this;
  }

   /**
   * The earliest time and date that this item is deferred until
   * @return deferredDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The earliest time and date that this item is deferred until")

  public String getDeferredDate() {
    return deferredDate;
  }


  public void setDeferredDate(String deferredDate) {
    this.deferredDate = deferredDate;
  }


  public ItemResponse lockedDate(String lockedDate) {

    this.lockedDate = lockedDate;
    return this;
  }

   /**
   * The time and date that this item was locked; or the minimum date-time value if not locked
   * @return lockedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time and date that this item was locked; or the minimum date-time value if not locked")

  public String getLockedDate() {
    return lockedDate;
  }


  public void setLockedDate(String lockedDate) {
    this.lockedDate = lockedDate;
  }


  public ItemResponse completedDate(String completedDate) {

    this.completedDate = completedDate;
    return this;
  }

   /**
   * The time and date that this item was completed; or the minimum date-time value if not completed
   * @return completedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time and date that this item was completed; or the minimum date-time value if not completed")

  public String getCompletedDate() {
    return completedDate;
  }


  public void setCompletedDate(String completedDate) {
    this.completedDate = completedDate;
  }


  public ItemResponse exceptionedDate(String exceptionedDate) {

    this.exceptionedDate = exceptionedDate;
    return this;
  }

   /**
   * The time and date that this item was marked as exceptioned; or the minimum date-time value if not exceptioned
   * @return exceptionedDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time and date that this item was marked as exceptioned; or the minimum date-time value if not exceptioned")

  public String getExceptionedDate() {
    return exceptionedDate;
  }


  public void setExceptionedDate(String exceptionedDate) {
    this.exceptionedDate = exceptionedDate;
  }


  public ItemResponse exceptionReason(String exceptionReason) {

    this.exceptionReason = exceptionReason;
    return this;
  }

   /**
   * The error message which caused the exception, if any
   * @return exceptionReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The error message which caused the exception, if any")

  public String getExceptionReason() {
    return exceptionReason;
  }


  public void setExceptionReason(String exceptionReason) {
    this.exceptionReason = exceptionReason;
  }


  public ItemResponse lastUpdated(String lastUpdated) {

    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * The time and date that this item was last updated
   * @return lastUpdated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The time and date that this item was last updated")

  public String getLastUpdated() {
    return lastUpdated;
  }


  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public ItemResponse workTimeInSeconds(Integer workTimeInSeconds) {

    this.workTimeInSeconds = workTimeInSeconds;
    return this;
  }

   /**
   * The number of seconds that this item has been worked on so far (including any previous attempts)
   * @return workTimeInSeconds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of seconds that this item has been worked on so far (including any previous attempts)")

  public Integer getWorkTimeInSeconds() {
    return workTimeInSeconds;
  }


  public void setWorkTimeInSeconds(Integer workTimeInSeconds) {
    this.workTimeInSeconds = workTimeInSeconds;
  }


  public ItemResponse attemptWorkTimeInSeconds(Integer attemptWorkTimeInSeconds) {

    this.attemptWorkTimeInSeconds = attemptWorkTimeInSeconds;
    return this;
  }

   /**
   * The number of seconds that this item has been worked on so far in this attempt
   * @return attemptWorkTimeInSeconds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of seconds that this item has been worked on so far in this attempt")

  public Integer getAttemptWorkTimeInSeconds() {
    return attemptWorkTimeInSeconds;
  }


  public void setAttemptWorkTimeInSeconds(Integer attemptWorkTimeInSeconds) {
    this.attemptWorkTimeInSeconds = attemptWorkTimeInSeconds;
  }


  public ItemResponse resource(String resource) {

    this.resource = resource;
    return this;
  }

   /**
   * The name of the resource
   * @return resource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the resource")

  public String getResource() {
    return resource;
  }


  public void setResource(String resource) {
    this.resource = resource;
  }


  public ItemResponse data(BpCollectionData data) {

    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public BpCollectionData getData() {
    return data;
  }


  public void setData(BpCollectionData data) {
    this.data = data;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemResponse itemResponse = (ItemResponse) o;
    return Objects.equals(this.id, itemResponse.id) &&
        Objects.equals(this.priority, itemResponse.priority) &&
        Objects.equals(this.ident, itemResponse.ident) &&
        Objects.equals(this.state, itemResponse.state) &&
        Objects.equals(this.keyValue, itemResponse.keyValue) &&
        Objects.equals(this.status, itemResponse.status) &&
        Objects.equals(this.tags, itemResponse.tags) &&
        Objects.equals(this.attemptNumber, itemResponse.attemptNumber) &&
        Objects.equals(this.loadedDate, itemResponse.loadedDate) &&
        Objects.equals(this.deferredDate, itemResponse.deferredDate) &&
        Objects.equals(this.lockedDate, itemResponse.lockedDate) &&
        Objects.equals(this.completedDate, itemResponse.completedDate) &&
        Objects.equals(this.exceptionedDate, itemResponse.exceptionedDate) &&
        Objects.equals(this.exceptionReason, itemResponse.exceptionReason) &&
        Objects.equals(this.lastUpdated, itemResponse.lastUpdated) &&
        Objects.equals(this.workTimeInSeconds, itemResponse.workTimeInSeconds) &&
        Objects.equals(this.attemptWorkTimeInSeconds, itemResponse.attemptWorkTimeInSeconds) &&
        Objects.equals(this.resource, itemResponse.resource) &&
        Objects.equals(this.data, itemResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, priority, ident, state, keyValue, status, tags, attemptNumber, loadedDate, deferredDate, lockedDate, completedDate, exceptionedDate, exceptionReason, lastUpdated, workTimeInSeconds, attemptWorkTimeInSeconds, resource, data);
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("priority");
    openapiFields.add("ident");
    openapiFields.add("state");
    openapiFields.add("keyValue");
    openapiFields.add("status");
    openapiFields.add("tags");
    openapiFields.add("attemptNumber");
    openapiFields.add("loadedDate");
    openapiFields.add("deferredDate");
    openapiFields.add("lockedDate");
    openapiFields.add("completedDate");
    openapiFields.add("exceptionedDate");
    openapiFields.add("exceptionReason");
    openapiFields.add("lastUpdated");
    openapiFields.add("workTimeInSeconds");
    openapiFields.add("attemptWorkTimeInSeconds");
    openapiFields.add("resource");
    openapiFields.add("data");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to WorkQueueItem
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ItemResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in WorkQueueItem is not found in the empty JSON string", ItemResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ItemResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `WorkQueueItem` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("state") != null && !jsonObj.get("state").isJsonNull()) && !jsonObj.get("state").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state").toString()));
      }
      if ((jsonObj.get("keyValue") != null && !jsonObj.get("keyValue").isJsonNull()) && !jsonObj.get("keyValue").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `keyValue` to be a primitive type in the JSON string but got `%s`", jsonObj.get("keyValue").toString()));
      }
      if ((jsonObj.get("status") != null && !jsonObj.get("status").isJsonNull()) && !jsonObj.get("status").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `status` to be a primitive type in the JSON string but got `%s`", jsonObj.get("status").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("tags") != null && !jsonObj.get("tags").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `tags` to be an array in the JSON string but got `%s`", jsonObj.get("tags").toString()));
      }
      if ((jsonObj.get("exceptionReason") != null && !jsonObj.get("exceptionReason").isJsonNull()) && !jsonObj.get("exceptionReason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `exceptionReason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("exceptionReason").toString()));
      }
      if ((jsonObj.get("resource") != null && !jsonObj.get("resource").isJsonNull()) && !jsonObj.get("resource").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `resource` to be a primitive type in the JSON string but got `%s`", jsonObj.get("resource").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ItemResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'WorkQueueItem' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ItemResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ItemResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<ItemResponse>() {
           @Override
           public void write(JsonWriter out, ItemResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ItemResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

  @Override
  public String toString() {
    return "WorkQueueItem{" +
            "id=" + id +
            ", priority=" + priority +
            ", ident=" + ident +
            ", state=" + state +
            ", keyValue='" + keyValue + '\'' +
            ", status='" + status + '\'' +
            ", tags=" + tags +
            ", attemptNumber=" + attemptNumber +
            ", loadedDate='" + loadedDate + '\'' +
            ", deferredDate='" + deferredDate + '\'' +
            ", lockedDate='" + lockedDate + '\'' +
            ", completedDate='" + completedDate + '\'' +
            ", exceptionedDate='" + exceptionedDate + '\'' +
            ", exceptionReason='" + exceptionReason + '\'' +
            ", lastUpdated='" + lastUpdated + '\'' +
            ", workTimeInSeconds=" + workTimeInSeconds +
            ", attemptWorkTimeInSeconds=" + attemptWorkTimeInSeconds +
            ", resource='" + resource + '\'' +
            ", data=" + data +
            '}';
  }
}

