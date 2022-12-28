package com.simbirsoft.cmsproject.entity;

import com.simbirsoft.cmsproject.entity.enums.TaskStatusEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private TaskStatusEnum taskStatus;
    private Long idUserCreator;
    private Long idUserPerformer;
    private Long idRelease;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id) && name.equals(task.name) && Objects.equals(description, task.description) && taskStatus == task.taskStatus && Objects.equals(idUserCreator, task.idUserCreator) && Objects.equals(idUserPerformer, task.idUserPerformer) && Objects.equals(idRelease, task.idRelease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }

}
