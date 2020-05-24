package com.project.holyvacation.dto;

import lombok.Data;

@Data
public class UserDTO {
   private String firstName;
   private String lastName;
   private String email;

   public UserDTO(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
}
