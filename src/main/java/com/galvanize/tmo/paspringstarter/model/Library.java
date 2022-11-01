package com.galvanize.tmo.paspringstarter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    List<Book> books;
}
