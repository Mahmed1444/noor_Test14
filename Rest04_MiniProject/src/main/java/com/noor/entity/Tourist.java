package com.noor.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Tourist_Info")
public class Tourist {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int tid;
    @Column(length = 20)
    @NonNull
    private String name;
    @Column(length = 20)
    @NonNull
    private String city;
    @Column(length = 20)
    @NonNull
    private String packageType;
    @NonNull
    private double budget;

    @JsonCreator
    public Tourist(int tid, @JsonProperty("name") String name, @JsonProperty("city") String city, @JsonProperty("packageType") String packageType,
                   @JsonProperty("budget") double budget) {
        this.tid = tid;
        this.name = name;
        this.city = city;
        this.packageType = packageType;
        this.budget = budget;
    }
}
