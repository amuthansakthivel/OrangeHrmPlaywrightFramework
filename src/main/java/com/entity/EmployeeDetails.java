package com.entity;

import lombok.Data;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
public class EmployeeDetails {
  private String firstName;
  private String lastName;
  private String middleName;
  private int employeeId;

  @PodamStringValue(strValue = "/src/test/resources/images/browserstack.jpeg")
  private String profilePicturePath;
}