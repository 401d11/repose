package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Stretch type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Stretches")
public final class Stretch implements Model {
  public static final QueryField ID = field("Stretch", "id");
  public static final QueryField NAME = field("Stretch", "name");
  public static final QueryField LENGTH = field("Stretch", "length");
  public static final QueryField SETS = field("Stretch", "sets");
  public static final QueryField REPS = field("Stretch", "reps");
  public static final QueryField DESCRIPTION = field("Stretch", "description");
  public static final QueryField IMAGE_KEY = field("Stretch", "imageKey");
  public static final QueryField MUSCLE_GROUP = field("Stretch", "muscleGroup");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="Int", isRequired = true) Integer length;
  private final @ModelField(targetType="Int") Integer sets;
  private final @ModelField(targetType="Int") Integer reps;
  private final @ModelField(targetType="String") String description;
  private final @ModelField(targetType="String") String imageKey;
  private final @ModelField(targetType="String") String muscleGroup;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public Integer getLength() {
      return length;
  }
  
  public Integer getSets() {
      return sets;
  }
  
  public Integer getReps() {
      return reps;
  }
  
  public String getDescription() {
      return description;
  }
  
  public String getImageKey() {
      return imageKey;
  }
  
  public String getMuscleGroup() {
      return muscleGroup;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Stretch(String id, String name, Integer length, Integer sets, Integer reps, String description, String imageKey, String muscleGroup) {
    this.id = id;
    this.name = name;
    this.length = length;
    this.sets = sets;
    this.reps = reps;
    this.description = description;
    this.imageKey = imageKey;
    this.muscleGroup = muscleGroup;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Stretch stretch = (Stretch) obj;
      return ObjectsCompat.equals(getId(), stretch.getId()) &&
              ObjectsCompat.equals(getName(), stretch.getName()) &&
              ObjectsCompat.equals(getLength(), stretch.getLength()) &&
              ObjectsCompat.equals(getSets(), stretch.getSets()) &&
              ObjectsCompat.equals(getReps(), stretch.getReps()) &&
              ObjectsCompat.equals(getDescription(), stretch.getDescription()) &&
              ObjectsCompat.equals(getImageKey(), stretch.getImageKey()) &&
              ObjectsCompat.equals(getMuscleGroup(), stretch.getMuscleGroup()) &&
              ObjectsCompat.equals(getCreatedAt(), stretch.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), stretch.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getLength())
      .append(getSets())
      .append(getReps())
      .append(getDescription())
      .append(getImageKey())
      .append(getMuscleGroup())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Stretch {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("length=" + String.valueOf(getLength()) + ", ")
      .append("sets=" + String.valueOf(getSets()) + ", ")
      .append("reps=" + String.valueOf(getReps()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("imageKey=" + String.valueOf(getImageKey()) + ", ")
      .append("muscleGroup=" + String.valueOf(getMuscleGroup()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Stretch justId(String id) {
    return new Stretch(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      length,
      sets,
      reps,
      description,
      imageKey,
      muscleGroup);
  }
  public interface NameStep {
    LengthStep name(String name);
  }
  

  public interface LengthStep {
    BuildStep length(Integer length);
  }
  

  public interface BuildStep {
    Stretch build();
    BuildStep id(String id);
    BuildStep sets(Integer sets);
    BuildStep reps(Integer reps);
    BuildStep description(String description);
    BuildStep imageKey(String imageKey);
    BuildStep muscleGroup(String muscleGroup);
  }
  

  public static class Builder implements NameStep, LengthStep, BuildStep {
    private String id;
    private String name;
    private Integer length;
    private Integer sets;
    private Integer reps;
    private String description;
    private String imageKey;
    private String muscleGroup;
    @Override
     public Stretch build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Stretch(
          id,
          name,
          length,
          sets,
          reps,
          description,
          imageKey,
          muscleGroup);
    }
    
    @Override
     public LengthStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep length(Integer length) {
        Objects.requireNonNull(length);
        this.length = length;
        return this;
    }
    
    @Override
     public BuildStep sets(Integer sets) {
        this.sets = sets;
        return this;
    }
    
    @Override
     public BuildStep reps(Integer reps) {
        this.reps = reps;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep imageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }
    
    @Override
     public BuildStep muscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, Integer length, Integer sets, Integer reps, String description, String imageKey, String muscleGroup) {
      super.id(id);
      super.name(name)
        .length(length)
        .sets(sets)
        .reps(reps)
        .description(description)
        .imageKey(imageKey)
        .muscleGroup(muscleGroup);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder length(Integer length) {
      return (CopyOfBuilder) super.length(length);
    }
    
    @Override
     public CopyOfBuilder sets(Integer sets) {
      return (CopyOfBuilder) super.sets(sets);
    }
    
    @Override
     public CopyOfBuilder reps(Integer reps) {
      return (CopyOfBuilder) super.reps(reps);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder imageKey(String imageKey) {
      return (CopyOfBuilder) super.imageKey(imageKey);
    }
    
    @Override
     public CopyOfBuilder muscleGroup(String muscleGroup) {
      return (CopyOfBuilder) super.muscleGroup(muscleGroup);
    }
  }
  
}
