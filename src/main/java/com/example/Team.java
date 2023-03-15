package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public record Team(@Id @GeneratedValue Long id, String name, String stadium) { }
