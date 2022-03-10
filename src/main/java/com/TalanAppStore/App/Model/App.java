package com.TalanAppStore.App.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Name cannot be empty or null")
    private String name;

    private String description;
    private String gitRepo;
    private String archieveUrl;

    @Lob
    private byte[] archieve;

    private String imageUrl;
    //dockerfile
    //service
    @ManyToMany
    @JoinTable(
            name = "app_developers",
            joinColumns = @JoinColumn(name = "app_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id"))
    //Set<Developer> developers;
    private List<Developer> developers = new ArrayList<>();

}
