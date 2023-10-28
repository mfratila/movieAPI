package com.mfratila.movies.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document(collection = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    private ObjectId roleId;
    private String authority;

    public Role(String role) {
        this.authority = role;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public String setAuthority(String authority) {
        return authority;
    }
}
