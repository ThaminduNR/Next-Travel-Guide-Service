package lk.nexttravel.guideService.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Guide {
    @Id
    private String guideId;
    private String guideName;
    private String address;
    private Integer age;
    private String gender;
    private String contactNo;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    private byte[] guideImg;
    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    private byte[] guideIdImg;
    private String experience;
    private double dayValue;
}
