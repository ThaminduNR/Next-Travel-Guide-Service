package lk.nexttravel.guideService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDto {

    private String guideId;
    private String guideName;
    private String address;
    private Integer age;
    private String gender;
    private String contactNo;
    private byte[] guideImg;
    private byte[] guideIdImg;
    private String experience;
    private double dayValue;


    public GuideDto(String guideName, String address, Integer age, String gender, String contactNo, byte[] guideImg, byte[] guideIdImg, String experience, double dayValue) {
        this.guideName = guideName;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.contactNo = contactNo;
        this.guideImg = guideImg;
        this.guideIdImg = guideIdImg;
        this.experience = experience;
        this.dayValue = dayValue;
    }




}
