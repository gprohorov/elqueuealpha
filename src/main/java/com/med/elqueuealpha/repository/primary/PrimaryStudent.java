package com.med.elqueuealpha.repository.primary;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "first_mongo")
public class PrimaryStudent {

    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "PrimaryModel{" + "id='" + id + '\'' + ", value='" + value + '\''
                + '}';
    }
}
